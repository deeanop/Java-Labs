class Car{
    private double fuelLevel;
    private int kilometers;
    public Car(double fuelLevel, int kilometers){
        this.fuelLevel = fuelLevel;
        this.kilometers = kilometers;
    }
    public double consume(int distance){
        double consumedFuel = distance * 10;
        this.kilometers += distance;
        return consumedFuel;
    }
    public double getFuelLevel(){
        return this.fuelLevel;
    }
    public void setFuelLevel(double fuelLevel){
        this.fuelLevel = fuelLevel;
    }
    public int getKilometers(){
        return this.kilometers;
    }
}
class Client{
    public static void main(String[] argv){
        Car c = new Car(200, 2000);
        int i=1;
        while(c.getFuelLevel() > 0){
            double consumedFuel = c.getFuelLevel() - c.consume(i * 2);
            c.setFuelLevel(consumedFuel);
            System.out.println("Level of fuel: " + c.getFuelLevel() + " and distance: " + c.getKilometers());
            i++;
        }
    }
}
