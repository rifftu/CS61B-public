public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int numberOfPlanets = in.readInt();
        in.readDouble();
        Body[] bodylist = new Body[numberOfPlanets];
        for(int i = 0; i < numberOfPlanets; i++) {
            bodylist[i] = new Body(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return bodylist;
    }
    
    public static void main(String[] args){
        double time = 0;
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];
        double radius = readRadius(filename);        
        Body[] bodies = readBodies(filename);

        String background = "images/starfield.jpg";

        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);

        while (time <= T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for(int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for(int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, background, radius * 2, radius * 2);
            for(Body planet : bodies) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time = time + dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                            bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
}   


    }

}