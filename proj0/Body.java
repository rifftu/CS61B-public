public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                    double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double calcForceExertedBy(Body b) {
        double g = 6.67e-11;
        double rsq = Math.pow(calcDistance(b), 2);
        return (g * mass * b.mass / rsq);
    }

    public double calcForceExertedByX(Body b) {
        double f = calcForceExertedBy(b);
        double dx = b.xxPos - xxPos;
        double r = calcDistance(b);
        return (f * dx / r);
    }
    public double calcForceExertedByY(Body b) {
        double f = calcForceExertedBy(b);
        double dy = b.yyPos - yyPos;
        double r = calcDistance(b);
        return (f * dy / r);
    }
    
    public double calcNetForceExertedByX(Body[] allBodys) {
        double total = 0;
        for (Body element : allBodys) {
            if (this.equals(element) == false) {
                total = total + calcForceExertedByX(element);
            }
        }
        return total;
    }
    public double calcNetForceExertedByY(Body[] allBodys) {
        double total = 0;
        for (Body element : allBodys) {
            if (this.equals(element) == false) {
                total = total + calcForceExertedByY(element);
            }
        }
        return total;
    }

    public void update(double dt, double xforce, double yforce) {
        double ax = xforce / this.mass;
        double ay = yforce / this.mass;
        this.xxVel = this.xxVel + (ax * dt);
        this.yyVel = this.yyVel + (ay * dt);
        this.xxPos = this.xxPos + (this.xxVel * dt);
        this.yyPos = this.yyPos + (this.yyVel * dt);
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + this.imgFileName);
    }

}