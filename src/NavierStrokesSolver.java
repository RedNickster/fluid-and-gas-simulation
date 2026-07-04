

// https://en.wikipedia.org/wiki/Navier%E2%80%93Stokes_equations

public class NavierStrokesSolver {

    // Variables
    final static int gridSize = 80;
    final static double gridSize_INVERSE = (double) 1 / gridSize;
    final static int SIZE = (gridSize + 2) * (gridSize + 2);
    double[] u = new double[SIZE]; // Flow velocity x
    double[] v = new double[SIZE]; // Flow velocity y
    double[] uPrev = new double[SIZE]; // Flow velocity of previous x
    double[] vPrev = new double[SIZE]; // Flow velocity of previous y
    double[] dense = new double[SIZE]; // Mass density
    double[] densePrev = new double[SIZE]; // Previous mass density

    /**
     * Gets called for each tick (10 millisecond intevals)
     *
     * @param dt Steps each second
     * @param viscousity Viscousity of the liquid/gas
     * @param diffusionRate Diffusion rate // How quickly the liquid/gas fades out by itself
     */
    void tick (double dt, double viscousity, double diffusionRate) {
        // Data gotten from gui class

        // Update Velocity
        // Passing current velocities (u,v), previous velocities (uPrev,vPrev), viscousity
        // and timeStep (dt)
        velocityStep(u, v, uPrev, vPrev, viscousity, dt);

        // Update density
        // Passing current density (dense), previous density (densePrev), and the current
        // velocity fields (u,v,diffusionRate,dt)
        densetiStep(dense, densePrev, u, v, diffusionRate, dt);

    }

    /**
     * TODO: Lav javadoc og forklar hvad der sker i denne metode´
     *
     * @param u Flow velocity of x axis
     * @param v Flow velocity of y axis
     * @param uPrev Flow velocity of previous x
     * @param vPrev Flow velocity of previous y
     * @param viscousity
     * @param dt timeStep / Steps each second
     */
    void velocityStep(double[] u,  double[] v, double[] uPrev, double[] vPrev, double viscousity, double dt) {
        // Make 2D array into 1D vectors and add that force to the liquid/gas
        addSource(u, uPrev, dt);
        addSource(v, vPrev, dt);
        swap(uPrev, u);



    }

    /**
     * // TODO: Skriv javadoc!!!
     *
     * @param direction
     * @param prev
     * @param timeStep
     */
    void addSource(double[] direction, double[] prev, double timeStep) {
        int i, size = (gridSize + 2) * (gridSize + 2);
        for (i = 0; i < size; i++)
            direction[i] += timeStep * prev[i];
    }

    /**
     * Swaps the data from the two double arrays. We swap to save performance instead of copying
     *
     * @param x double array 1
     * @param y double array 1
     */
    void swap(double[] x, double[] y) {
        double[] temp = new double[SIZE];
        System.arraycopy(x, 0, temp, 0, SIZE);
        System.arraycopy(y, 0, x, 0, SIZE);
        System.arraycopy(temp, 0, y, 0, SIZE);
    }

    void densetiStep(double[] dense, double[] densePrev, double[] u, double[] v, double diffusionRate, double dt) {
        
    }
}