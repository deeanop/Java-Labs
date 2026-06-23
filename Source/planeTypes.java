class Plane{
    private String planeID;
    private int totalEnginePower;
    public Plane(String planeID, int totalEnginePower){
        this.planeID = planeID;
        this.totalEnginePower = totalEnginePower;
    }
    public String getPlaneID(){
        return this.planeID;
    }
    public int getTotalEnginePower(){
        return this.totalEnginePower;
    }
    public void takeOff(){
        System.out.println("Plane " + this.planeID + ". Initiating takeoff procedure. Starting engines. Accelerating down the runway. Takig off. Retracting gear. Takeoff complete.");
    }
    public void fly(){
        System.out.println("Plane " + this.planeID + " flying.");
    }
    public void land(){
        System.out.println("Plane " + this.planeID + ". Initiating landing procedure. Enabling airbrakes. Lowering gear. Contacting runway. Decelerating. Stopping engines. Landing complete.");
    }
    @Override
    public String toString(){
        return "Plane(" + this.getPlaneID() + "; " + this.getTotalEnginePower() + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Plane))
            return false;
        Plane p = (Plane) obj;
        return this.getPlaneID().equals(p.getPlaneID()) && this.getTotalEnginePower() == p.getTotalEnginePower();
    }
}
class PassengerPlane extends Plane{
    private int maxPassengers;
    public PassengerPlane(String planeID, int totalEnginePower, int maxPassengers){
        super(planeID, totalEnginePower);
        this.maxPassengers = maxPassengers;
    }
    public int getMaxPassengers(){
        return this.maxPassengers;
    }
    @Override
    public String toString(){
        return "PassengerPlane(" + this.getPlaneID() + "; " + this.getTotalEnginePower() + "; " + this.getMaxPassengers() + ")";    
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof PassengerPlane))
            return false;
        PassengerPlane pp = (PassengerPlane) obj;
        return this.getPlaneID().equals(pp.getPlaneID()) && this.getTotalEnginePower() == pp.getTotalEnginePower() && this.getMaxPassengers() == pp.getMaxPassengers();
    }
}
class Concorde extends PassengerPlane{
    public Concorde(String planeID, int totalEnginePower, int maxPassengers){
        super(planeID, totalEnginePower, maxPassengers);
    }
    public void goSuperSonic(){
        System.out.println("Concorde plane " + this.getPlaneID() + ". Supersonic mode activated.");
    }
    public void goSubSonic(){
        System.out.println("Concorde plane " + this.getPlaneID() + ". Supersonic mode deactivated.");
    }
    @Override
    public String toString(){
        return "Concorde(" + this.getPlaneID() + "; " + this.getTotalEnginePower() + "; " + this.getMaxPassengers() + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Concorde))
            return false;
        Concorde c = (Concorde) obj;
        return this.getPlaneID().equals(c.getPlaneID()) && this.getTotalEnginePower() == c.getTotalEnginePower() && this.getMaxPassengers() == c.getMaxPassengers();
    }
}
class FightPlane extends Plane{
    public FightPlane(String planeID, int totalEnginePower){
        super(planeID, totalEnginePower);
    }
    public void launchMissile(){
        System.out.println("Fight plane " + this.getPlaneID() + ". Initiating missile lanuch procedure. Acquiring target. Launching missile. Breaking away. Missile launch complete.");
    }
    @Override
    public String toString(){
        return "FightPlane(" + this.getPlaneID() + "; " + this.getTotalEnginePower() + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof FightPlane))
            return false;
        FightPlane fp = (FightPlane) obj;
        return this.getPlaneID().equals(fp.getPlaneID()) && this.getTotalEnginePower() == fp.getTotalEnginePower();
    }
}
class Mig extends FightPlane{
    public Mig(String planeID, int totalEnginePower){
        super(planeID, totalEnginePower);
    }
    public void highSpeedGeometry(){
        System.out.println("Mig " + this.getPlaneID() + ". High speed geometry selected.");
    }
    public void normalSpeedGeometry(){
        System.out.println("Mig " + this.getPlaneID() + ". Normal speed geometry selected.");
    }
    @Override
    public String toString(){
        return "Mig(" + this.getPlaneID() + "; " + this.getTotalEnginePower() + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Mig))
            return false;
        Mig m = (Mig) obj;
        return this.getPlaneID().equals(m.getPlaneID()) && this.getTotalEnginePower() == m.getTotalEnginePower();
    }
}
class TomCat extends FightPlane{
    public TomCat(String planeID, int totalEnginePower){
        super(planeID, totalEnginePower);
    }
    public void refuel(){
        System.out.println("TomCat " + this.getPlaneID() + ". Initiating refueling procedure. Locating refueller. Catching up. Refueling. Refueling complete.");
    }
    @Override
    public String toString(){
        return "TomCat(" + this.getPlaneID() + "; " + this.getTotalEnginePower() + ")";   
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof TomCat))
            return false;
        TomCat tm = (TomCat) obj;
        return this.getPlaneID().equals(tm.getPlaneID()) && this.getTotalEnginePower() == tm.getTotalEnginePower();
    }
}
class Client{
    public static void main(String[] argv){
        Plane p1 = new Plane("2391", 10000);
        p1.takeOff();
        p1.fly();
        p1.land();
        System.out.println(p1.toString());
        Plane p2 = new Plane("1298", 12000);
        System.out.println(p2.toString());
        System.out.println(p1.equals(p2));
        Concorde c1 = new Concorde("4321", 15000, 500);
        c1.takeOff();
        c1.fly();
        c1.goSuperSonic();
        c1.fly();
        c1.goSubSonic();
        c1.land();
        System.out.println(c1.toString());
        Concorde c2 = new Concorde("4593", 20000, 750);
        System.out.println(c2.equals(c2));
        System.out.println(c2.toString());
        Mig m1 = new Mig("5100", 100000);
        m1.takeOff();
        m1.fly();
        m1.highSpeedGeometry();
        m1.launchMissile();
        m1.normalSpeedGeometry();
        m1.land();
        System.out.println(m1.toString());
        Mig m2 = new Mig("5100", 100000);
        System.out.println(m1.equals(m2));
        TomCat tm1 = new TomCat("6100", 200000);
        tm1.takeOff();
        tm1.fly();
        tm1.launchMissile();
        tm1.fly();
        tm1.refuel();
        tm1.launchMissile();
        tm1.land();
        System.out.println(tm1.toString());
        TomCat tm2 = new TomCat("6749", 300000);
        System.out.println(tm1.equals(tm2));
    }
}