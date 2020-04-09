package ua.kpi.tef.decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new RightBrackerDecorator(new LeftBrackerDecorator(new Printer("Hello"))));
        printer.print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;
    public Printer(String value){
        this.value = value;
    }
    public void print(){
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface{
    PrinterInterface component;
    public Decorator(PrinterInterface component) {
        this.component = component;
    }

}

class QuotesDecorator extends Decorator{
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }
    public void print(){
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBrackerDecorator extends Decorator{
    public LeftBrackerDecorator(PrinterInterface component) {
        super(component);
    }
    public void print(){
        System.out.print("[");
        component.print();
    }
}

class RightBrackerDecorator extends Decorator{
    public RightBrackerDecorator(PrinterInterface component) {
        super(component);
    }
    public void print(){
        component.print();
        System.out.print("]");
    }
}