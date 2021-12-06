package UseJavaAPI;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();

        // add to ArrayList
        String a = new String("woooo");
        myList.add(a);

        String b = new String("hoooo");
        myList.add(b);

        // get ArrayList's size
        int theSize = myList.size();

        // access to ArrayList by index
        Object o = myList.get(1);

        // remove item in ArrayList by index
        // myList.remove(1);

        String c = new String("hoooo");
        //checkout if some object is in ArrayList, check by using equals()
        boolean isIn = myList.contains(c);
        System.out.println(isIn);

        System.out.println("------------");

        for (String s : myList) {
            System.out.println(s);
        }

    }
}
