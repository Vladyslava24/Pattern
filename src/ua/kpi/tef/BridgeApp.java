package ua.kpi.tef;

public class BridgeApp {
    public static void main(String[] args) {
        Car c = new Hatchack(new Skoda());
        c.showDetails();
    }
}

abstract class Car{
    Make make;
    public Car(Make m){make = m;}
    abstract void showType();
    void showDetails() {
        showType();
        make.setMake();
    }
}

class Sedan extends Car{
    public Sedan(Make m){super(m);}
    void showType(){
        System.out.println("Sedan");
    }
}

class Hatchack extends Car{
    public Hatchack(Make m){super(m);}
    void showType(){
        System.out.println("Hatchback");
    }
}

interface Make{
    void setMake();
}

class Kia implements Make{
    public void setMake(){System.out.println("Kia");}
}

class Skoda implements Make{
    public void setMake(){System.out.println("Skoda");}
}