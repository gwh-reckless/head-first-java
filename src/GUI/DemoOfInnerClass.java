/**
 * Purpose: demo of the inner class
 */
public class DemoOfInnerClass {
  public static void main(String[] args) {
    MyOuter outerObj = new MyOuter();

    // This is how you create a inner class out of the outer class
    MyOuter.MyInner innerObj = outerObj.new MyInner();
    innerObj.getX();

    // This is how you assign a inner class object to your outer class(obj) instance
    // vairable
    outerObj.inner = outerObj.new MyInner();
    // do stuff do two things:
    // 1. call go : assign 42 to x of outerObj
    // 2. print the x value
    outerObj.doStuff();

    innerObj.getX();

  }
}

class MyOuter {
  private int x;
  // MyInner inner = new MyInner();
  MyInner inner;

  public void doStuff() {
    inner.go();
    System.out.println("MyOuter-doStuff x:" + x);
  }

  class MyInner {
    void go() {
      x = 42;
    }

    void getX() {
      System.out.println("Inner x:" + x);
    }
  }
}
