public class Foo {
  public static void main(String[] args) {
        MyOuter outerObj = new MyOuter();
        MyOuter.MyInner innerObj = outerObj.new MyInner();
  }
}

class MyOuter {
  private int x;
  // MyInner inner = new MyInner();
  MyInner inner;
  public void doStuff(){
    inner.go();
  }

  class MyInner {
    void go(){
      x = 42;
    }
  }
}
