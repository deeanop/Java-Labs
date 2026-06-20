class Motor{
    private int capacity;
    private String type;
    public Motor(int capacity, String type){
        this.capacity = capacity;
        this.type = type;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void typeDetails(){
        System.out.println("Motor Type: " + this.type + ", Capacity: " + this.capacity);
    }
}
class Client{
    public static void main(String[] argv){
        Motor m1 = new Motor(1200, "Diesel");
        Motor m2 = new Motor(3000, "Otto");
        m1.typeDetails();
        m1.setCapacity(1500);
        m1.typeDetails();
        System.out.println(m1.getCapacity());
        m2.typeDetails();
        m2.setType("Diesel");
        m2.typeDetails();
    }
}