package Chap3;

public class TestPrimitive {
    public static void main(String[] args) {
        int x = 24;
//        byte b = x;
        byte b = (byte) x;

        byte a = 1;
        int y = a;
        System.out.println(x);
        System.out.println(y);
    }
}
