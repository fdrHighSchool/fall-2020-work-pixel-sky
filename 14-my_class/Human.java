public class Human {
    private double height;
    private double weight;
    private int age;
    private String gender;

    public Human(double height, double weight, int age, String gender){
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }
    
    public boolean isAdult(){
        return this.age >= 18;
    }

    public double BMI(){
        return weight / Math.pow(height, 2);
    }

    @Override
    public String toString(){
        return String.format("A %d years old %s.", this.age, this.gender);
    }
}
