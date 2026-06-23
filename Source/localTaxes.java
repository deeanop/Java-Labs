abstract class Property{
    protected String address;
    protected double surface;
    public Property(String address, double surface){
        this.address = address;
        this.surface = surface;
    }
    public abstract double price();
}
class Building extends Property{
    public Building(String address, double surface){
        super(address, surface);
    }
    @Override
    public double price(){
        return 500 * this.surface;
    }
    @Override
    public String toString(){
        return "Building(address = " + this.address + "; surface = " + this.surface + ")";
    }
}
class Land extends Property{
    private int localityRank;
    public Land(String address, double surface, int localityRank){
        super(address, surface);
        this.localityRank = localityRank;
    }
    @Override
    public double price(){
        return 350 * this.surface / this.localityRank;
    }
    @Override
    public String toString(){
        return "Land(address = " + this.address + "; surface = " + this.surface + "; localityRank = " + this.localityRank + ")";
    }
}
class Owner{
    private String name;
    private Property[] properties;
    public Owner(String name, Property[] properties){
        this.name = name;
        this.properties = properties;
    }
    public double payTaxes(){
        double sum = 0;
        for(Property p : properties){
            if(p instanceof Building){
                Building b = (Building) p;
                sum += b.price();
            }
            else if(p instanceof Land){
                Land l = (Land) p;
                sum += l.price();
            }
        }
        return sum;
    }
    public void getFlyer(){
        System.out.println("TaxPayer: " +  this.name);
        System.out.println("Properties: ");
        for(Property p : properties){
            System.out.println(p.toString());
        }
        System.out.println("Total cost: " + this.payTaxes());
    }
}
class Client{
    public static void main(String[] argv){
        Property p1 = new Building("Strada Vasile Parvan, nr 2, Timisoara, Timis", 20);
        Property p2 = new Land("Strada I.L. Caragiale, nr 10, Resita, Caras-Severin", 10, 1);
        Property p3 = new Building("Strada Rodnei, nr 2, Resita, Caras-Severin", 300);
        Property p4 = new Land("Strada Fericirii, nr 19, Deta, Timis", 1500, 3);
        Owner o = new Owner("Ion Popescu", new Property[]{p1, p2, p3, p4});
        o.getFlyer();
    }
}