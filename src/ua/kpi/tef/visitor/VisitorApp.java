package ua.kpi.tef.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        //Element body = new BodyElement();
        //Element engine = new EngineElement();
        //Visitor hooligan = new HooliganVisitor();
        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());

        //body.accept(hooligan);
        //engine.accept(hooligan);
    }
}

interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

class WheelElement implements Element{
    String name;
    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  void accept(Visitor visitor){
        visitor.visit(this);
    }
}

class CarElement implements Element{
    Element[] elements;
     public CarElement(){
         this.elements = new Element[]{new WheelElement("переднее левое "), new WheelElement("заднее левое "),
         new WheelElement("переднее правое "), new WheelElement("заднее правое "), new BodyElement(), new EngineElement()};}
     public void accept(Visitor visitor){
         for(Element elem : elements){
             elem.accept(visitor);
         }
         visitor.visit(this);
     }
}

class HooliganVisitor implements Visitor{
    public void visit(WheelElement wheel){
        System.out.println("Пнул "+wheel.getName()+ "колесо");
    }
    public void visit(EngineElement engine){
        System.out.println("Завёл двигатель");
    }

    public void visit(BodyElement body){
        System.out.println("Постучал по корпусу");
    }
    public void visit(CarElement car){
        System.out.println("Покурил внутри машины");
    }
}

class MechanicVisitor implements Visitor{
    public void visit(WheelElement wheel){
        System.out.println("Подкачал "+wheel.getName()+ "колесо");
    }
    public void visit(EngineElement engine){
        System.out.println("Проверил двигатель");
    }

    public void visit(BodyElement body){
        System.out.println("Отполировал кузов");
    }
    public void visit(CarElement car){
        System.out.println("Проверил внешнй вид автомобиля");
    }
}

interface Element{
    void accept(Visitor visitor);
}

class EngineElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}