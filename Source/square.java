class Square{
    private final double side;
    public Square(){
        this.side = 10.0;
    }
    public Square(double side){
        this.side = side;
    }
    public void SquareDetails(){
        System.out.println("Square: side = " + this.side + ", area = " + (this.side * this.side) + ", perimeter = " + (4 * this.side));
    }
}
class Client{
    public static void main(String[] argv){
        Square s1 = new Square();
        s1.SquareDetails();
        Square s2 = new Square(15.5);
        s2.SquareDetails();
    }
}