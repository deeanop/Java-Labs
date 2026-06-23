class Drawer{
    private final double length;
    private final double width;
    private final double height;
    public Drawer(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public String typeDrawerDetails(){
        return "Drawer: length = " + this.length + ", width = " + this.width + ", height = " + this.height;
    }
}
class Desk{
    private final Drawer drawer1, drawer2;
    private final double length, width, height;
    public Desk(Drawer drawer1, Drawer drawer2, double length, double width, double height){
        this.drawer1 = drawer1;
        this.drawer2 = drawer2;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public String typeDeskDetails(){
        return "Desk: first drawer details: " + this.drawer1.typeDrawerDetails() + ", second drawer details: " + this.drawer2.typeDrawerDetails() + ", length = " + this.length + ", width = " + this.width + ", height = " + this.height;
    }
}
class Client{
    public static void main(String[] argv){
        Drawer d1 = new Drawer(30.5, 20.7, 10.3);
        Drawer d2 = new Drawer(40.3, 30.6, 8.6);
        String firstDrawerDetails = d1.typeDrawerDetails();
        String secondDrawerDetails = d2.typeDrawerDetails();
        Desk d = new Desk(d1, d2, 50.6, 50.4, 100.2);
        String deskDetails = d.typeDeskDetails();
        System.out.println(firstDrawerDetails);
        System.out.println(secondDrawerDetails);
        System.out.println(deskDetails);
    }
}