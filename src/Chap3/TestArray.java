package Chap3;

import Chap2.Dog;

public class TestArray {
    public static void main(String[] args) {
        Dog[] pets;
        pets = new Dog[7];

        pets[0] = new Dog();
        pets[1] = new Dog();

        System.out.println(pets[0]);
    }
}
