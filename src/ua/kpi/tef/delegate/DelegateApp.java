package ua.kpi.tef.delegate;

public class DelegateApp {
    public static void main(String[] args) {
       A a = new A();
       a.f();
       Painter painter = new Painter();
       painter.setGraphics(new Triangle());
       painter.draw();

        painter.setGraphics(new Square());
        painter.draw();
    }
}

class A{
    void f(){
        System.out.println("f()");
    }
    /*
    *
    *
    *
    *
    */
}

class B{
    A a = new A();
    void f(){
        a.f();
    }
}

interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    public void draw() {
        System.out.println("Draw a triangle");
    }
}

class Square implements Graphics{
    public void draw(){
        System.out.println("Draw a square");
    }
}

class Circle implements Graphics{
    public void draw(){
        System.out.println("Draw a circle");
    }
}

class Painter{
  Graphics graphics;
  void setGraphics(Graphics g){
      graphics = g;
  }

  void draw(){
      graphics.draw();
  }
}