package ua.kpi.tef;

import java.util.*;

public class FlyWeightApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape1> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));

        Random rand = new Random();
        for(Shape1 shape : shapes){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x, y);
        }
    }
}

//Flyweight
interface Shape1{
    void draw(int x, int y);
}

//Point Flyweight
class Point implements Shape1{
    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+" "+y+") : draw point");
    }
}

//Circle Flyweight
class Circle_ implements Shape1{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+" "+y+") : draw circle with radious "+r);
    }
}

//Square Flyweight
class Square_ implements Shape1{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+" "+y+") : draw square with side "+a);
    }
}

class ShapeFactory{
    private static final Map<String, Shape1> shapes = new HashMap<>();
    public Shape1 getShape(String shapeName){

        Shape1 shape = shapes.get(shapeName);
        if(shape == null){
            switch(shapeName){
                case "circle":
                    shape = new Circle_();
                    break;
                case "point":
                    shape = new Point();
                    break;
                case "square":
                    shape = new Square_();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}