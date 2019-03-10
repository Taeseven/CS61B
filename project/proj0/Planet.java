public class Planet {
    /**parameters */
    private final double G = 6.67e-11;
    public double xxPos; //Its current x position.
    public double yyPos; //Its current x position.
    public double xxVel; //Its current velocity in the x direction.
    public double yyVel; //Its current velocity in the y direction.
    public double mass; //Its mass.
    public String imgFileName; //The name of the file that corresponds to the image that depicts the planet .

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
                xxPos = xP;
                yyPos = yP;
                xxVel = xV;
                yyVel = yV;
                mass = m;
                imgFileName = img;
              }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    
    /**Calcualte the distance between two Planet.
     * 
     * @param p obeject of Planet
     * @return double distance
     */
    public double calcDistance(Planet p) {
        /** using Math.pow, which will result in slower code */
        return (Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + 
                (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos)));
    }

    /**
     * describing the force exerted on this planet by the given planet
     * @param p obeject of Planet
     * @return double forces
     */
    public double calcForceExertedBy(Planet p) {
        return ((G * this.mass * p.mass) / Math.pow(this.calcDistance(p), 2));
    }

    /**
     * describe the force exerted in the X direction.
     * @param p obeject of Planet
     * @return double forces in X direction
     */
    public double calcForceExertedByX(Planet p) {
        double Fx = calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);

        return (Fx * dx / r);
    }

    /**
     * describe the force exerted in the Y direction.
     * @param p obeject of Planet
     * @return double forces in Y direction
     */
    public double calcForceExertedByY(Planet p) {
        double Fy = calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);

        return (Fy * dy / r);
    }

    /**
     * calculate the net X force exerted by all planets
     * @param p Array of current Plannet
     * @return double net forces in X direction
     */
    public double calcNetForceExertedByX(Planet[] P) {
        int i = 0;
        double Fx = 0.0;
        while (i < P.length) {
            if (!this.equals(P[i])) {
                Fx += this.calcForceExertedByX(P[i]);
            }  
            i += 1;
        }
        return Fx;
    }

    /**
     * calculate the net Y force exerted by all planets
     * @param p Array of current Plannet
     * @return double net forces in Y direction
     */
    public double calcNetForceExertedByY(Planet[] P) {
        int i = 0;
        double Fy = 0.0;
        while (i < P.length) {
            if (!this.equals(P[i])) {
                Fy += this.calcForceExertedByY(P[i]);
            }
            i += 1;
        }
        return Fy;
    }

    /**
     * calculate the new position and velocity for a Planet.
     * @param dt time period
     * @param Fx force in X direction
     * @param Fy force in Y direction
     */
    public void update(double dt, double Fx, double Fy) {
        // calculate the acceleration.
        double Ax = Fx / this.mass;
        double Ay = Fy / this.mass;

        // calculate the new velocity.
        this.xxVel += dt * Ax;
        this.yyVel += dt * Ay;

        // calculate the new position.
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        String path = "/images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, path);
    }

}