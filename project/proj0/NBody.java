public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();
        
        return R;
    }

    public static  Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[N];

        for(int i = 0; i < N; i++) {
            planets[i] = new Planet(in.readDouble(), 
                                    in.readDouble(),
                                    in.readDouble(),
                                    in.readDouble(),
                                    in.readDouble(),
                                    in.readString()
            );
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double R = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int N = planets.length;

        // Draw picture
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-R, R);

        for (int t = 0; t <= T; t += dt) {
            double[] xForces = new double[N];
            double[] yForces = new double[N];
            for (int i = 0; i < N; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < N; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "/images/starfield.jpg");

            for(int i = 0; i < planets.length; i++) {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        } 

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < N; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }


}