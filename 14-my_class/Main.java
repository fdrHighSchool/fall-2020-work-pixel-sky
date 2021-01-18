public class Main {
    public static void main(String[] args) {
        Human bob = new Human(1.8, 77, 22, "Male");
        print(bob.getHeight());
        print(bob.getWeight());
        print(bob.BMI());
        print(bob.toString());
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
