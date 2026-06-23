class Point{
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double distanceFromPoint(Point p){
        return Math.sqrt(Math.pow(this.getX() - p.getX(), 2) + Math.pow(this.getY() - p.getY(), 2));
    }
    public double distanceFromOrigin(){
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
    }
    @Override
    public String toString(){
        return "Point(" + this.getX() + "; " + this.getY() + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Point))
            return false;
        Point p = (Point) obj;
        return this.getX() == p.getX() && this.getY() == p.getY();
    }
}
class ColouredPoint extends Point{
    private String colour;
    public ColouredPoint(double x, double y, String colour){
        super(x, y);
        this.colour = colour;
    }
    public String getColour(){
        return this.colour;
    }
    public void setColor(String colour){
        this.colour = colour;
    }
    @Override
    public String toString(){
        return "ColouredPoint(" + this.getX() + "; " + this.getY() + "; " + this.getColour() + ")";
    }
    public double distanceFromPoint(ColouredPoint cp){
        return Math.sqrt(Math.pow(this.getX() - cp.getX(), 2) + Math.pow(this.getY() - cp.getY(), 2));
    }
    @Override
    public double distanceFromOrigin(){
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ColouredPoint))
            return false;
        ColouredPoint cp = (ColouredPoint) obj;
        return this.getX() == cp.getX() && this.getY() == cp.getY() && this.getColour().equals(cp.getColour());
    }
}
class Client{
    public static void main(String[] argv){
        Point p1 = new Point(1, 2);
        System.out.println(p1.toString());
        Point pTest = new Point(5.4, 1.2);
        System.out.println(p1.distanceFromPoint(pTest));
        System.out.println(p1.distanceFromOrigin());
        Point p2 = new Point(1, 2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(pTest));
        ColouredPoint cp1 = new ColouredPoint(1, 2, "red");
        System.out.println(cp1.toString());
        ColouredPoint cpTest = new ColouredPoint(5.4, 1.9, "blue");
        System.out.println(cp1.distanceFromPoint(pTest));
        System.out.println(cp1.distanceFromOrigin());
        ColouredPoint cp2 = new ColouredPoint(1, 2, "red");
        System.out.println(cp1.equals(cp2));
        System.out.println(cp1.equals(cpTest));
    }
}