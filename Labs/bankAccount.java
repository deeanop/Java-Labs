class bankAccount{
    private double sold;
    private final int limit = 10000;
    public bankAccount(double sold){
        this.sold = sold;
    }
    public void deposit(double amount){
        if((sold + amount) <= limit){
            sold += amount;
            System.out.println("Deposit was successful.");
        }
        else{
            double exceeding = sold + amount - limit;
            sold = limit;
            System.out.println("The amount exceeds the limit. Your rest is " + exceeding);
        }
    }
    public void withdrawal(double amount){
        if(amount <= sold){
            sold -= amount;
            System.out.println("Withdrawal was successfull.");
        }
        else{
            System.out.println("The amount exceeds the sold. ");
        }
    }
    public double getSold(){
        return sold; 
    }
}
class Client{
    public static void main(String[] argv){
        bankAccount account = new bankAccount(5000);
        account.deposit(300);
        System.out.println(account.getSold());
        account.deposit(5000);
        System.out.println(account.getSold());
        account.withdrawal(2000);
        System.out.println(account.getSold());
        account.withdrawal(10000);
        System.out.println(account.getSold());
    }
}
