package ua.kpi.tef.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square1();
        Shape square2 = new Square1();
        Shape triangle1 = new Triangle1();

        Shape square3 = new Square1();
        Shape circle1 = new Circle1();
        Shape circle2 = new Circle1();
        Shape circle3 = new Circle1();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(new Triangle1());

        composite.draw();
    }
}

interface Shape{
    void draw();
}

class Square1 implements Shape{
    public void draw(){
        System.out.println("Hello, I'm Square");
    }
}

class Triangle1 implements Shape{
    public void draw(){
        System.out.println("Hello, I'm Triangle");
    }
}

class Circle1 implements Shape{
    public void draw(){
        System.out.println("Hello, I'm Circle");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();
    public void addComponent(Shape component){
        components.add(component);
    }

    public void removeComponent(Shape component){
        components.remove(component);
    }

    public void draw(){
        for(Shape component: components){
            component.draw();
        }
    }
}