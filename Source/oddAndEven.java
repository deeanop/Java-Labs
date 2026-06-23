class Number{
    static int evenSum;
    public static void main(String[] argv){
        evenSum = 0;
        for(int i = 1; i <= 100; i++){
            if(i%2 == 0)
                evenSum += i;
            else
                System.out.println(i);
        }
        System.out.println(evenSum);
    }
}