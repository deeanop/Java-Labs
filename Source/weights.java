abstract class GeneralWeight{
    protected int capacity;
    public GeneralWeight(int capacity){
        this.capacity = capacity;
    }
    public abstract int getCapacity();
}
class SimpleWeight extends GeneralWeight{
    public SimpleWeight(int capacity){
        super(capacity);
    }
    @Override
    public String toString(){
        return "SimpleWeight: " + this.getCapacity() + "\n";
    }
    @Override
    public int getCapacity(){
        return this.capacity;
    }
}
class DoubleWeight extends GeneralWeight{
    private final GeneralWeight[] weights = new GeneralWeight[2];
    public DoubleWeight(GeneralWeight weight1, GeneralWeight weight2){
        super(weight1.getCapacity() + weight2.getCapacity());
        this.weights[0] = weight1;
        this.weights[1] = weight2;
    }
    public void setWeight1(int weight){
        this.weights[0].capacity = weight;
    }
    public void setWeight2(int weight){
        this.weights[1].capacity = weight;
    }
    @Override
    public String toString(){
        return "DoubleWeight: " + this.getCapacity() + " (" + this.weights[0].toString() + ", " + this.weights[1].toString() + ")\n";
    }
    @Override
    public int getCapacity(){
        return this.weights[0].getCapacity() + this.weights[1].getCapacity();
    }
}
class MultipleWeight extends GeneralWeight{
    private final GeneralWeight[] weights;
    public MultipleWeight(GeneralWeight[] weights){
        super(computeTotalCapacity(weights));
        this.weights = weights;
    }
    private static int computeTotalCapacity(GeneralWeight[] weights){
        int totalCapacity = 0;
        for(GeneralWeight weight: weights){
            totalCapacity += weight.getCapacity();
        }
        return totalCapacity;
    }
    @Override
    public String toString(){
        String result = "MultipleWeight: " + this.getCapacity() + " (";
        for(int i=0; i<this.weights.length; i++){
            if(i < this.weights.length - 1)
               result += this.weights[i].toString() + ", ";
            else
                result += this.weights[i].toString() + ")\n";
        }
        return result;
    }
    @Override
    public int getCapacity(){
        int sumOfCapacities = 0;
        for(GeneralWeight weight: weights)
            sumOfCapacities += weight.getCapacity();
        return sumOfCapacities;
    }
}
class WeightsCollection{
    private final GeneralWeight[] weights;
    private int currentSize = 0;
    public WeightsCollection(GeneralWeight[] weights){
        this.weights = weights;
    }
    public void addWeight(GeneralWeight weight){
        if (this.currentSize >= this.weights.length) {
        System.out.println("The maximum limit has been reached!");
        return;
        }
        if (this.currentSize < this.weights.length) {
            this.weights[this.currentSize] = weight; 
            this.currentSize++;                      
        } else {
            System.out.println("The array is full.");
        }
    }
    public double averageWeight(){
        int sumOfWeights = 0;
        for(int i=0; i<this.currentSize; i++){
            sumOfWeights += weights[i].getCapacity();
        }
        return (double)sumOfWeights / this.currentSize;
    }
    @Override 
    public String toString(){
        String result = "WeightsCollection: ";
        for(int i=0; i<this.currentSize; i++)
             result += weights[i].toString();
        return result;
    }
}
class Client{
    public static void main(String[] argv){
        GeneralWeight[] weights = new GeneralWeight[100];
        WeightsCollection w = new WeightsCollection(weights);
        GeneralWeight w1 = new SimpleWeight(100);
        GeneralWeight w2 = new SimpleWeight(200);
        GeneralWeight w3 = new SimpleWeight(130);
        GeneralWeight w4 = new SimpleWeight(210);
        GeneralWeight w5 = new DoubleWeight(w1, w2);
        GeneralWeight w6 = new SimpleWeight(240);
        GeneralWeight w7 = new MultipleWeight(new GeneralWeight[] {w3, w5, w6});
        w.addWeight(w4);
        w.addWeight(w5);
        w.addWeight(w7);
        System.out.println(w.toString());
        System.out.println("The mean capacity: " + w.averageWeight());
    }
}