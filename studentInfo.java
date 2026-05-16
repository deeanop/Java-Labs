class Student{
    private String name;
    private int age;
    private double grade;
    public Student(String name, int age, double grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }
    public int getAge(int threshold){
        if(age > threshold){
            return age;
        }
        else{
            return -1;
        }
    }
    public double getGrade(int minimum, int maximum){
        if(grade >= minimum && grade <= maximum){
            return grade;
        }
        else{
            return -1;
        }
    }
    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }
    }
    public void setGrade(float grade){
        if(grade > 0 && grade <= 10){
            this.grade = grade;
        }
    }
}
class Client{
    public static void main(String[] args){
        Student student1 = new Student("Eduard", 20, 9.75);
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge(20));
        System.out.println("Grade: " + student1.getGrade(5, 10));
        student1.setAge(21);
        System.out.println("New age: " + student1.getAge(20));
    }
}

