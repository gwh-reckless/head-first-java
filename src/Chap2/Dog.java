package Chap2;

public class Dog {
    int size;
    String breed;
    String name;

    void bark() {
        System.out.println("Ruff! Ruff!");
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.size = 40;
        d.bark();
    }
}
