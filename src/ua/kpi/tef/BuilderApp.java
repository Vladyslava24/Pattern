package ua.kpi.tef;

public class BuilderApp {
    public static void main(String[] args) {
     /*   Car1 car = new CarBuilder()
                .buildMake("Mercedes")
                .buildMake(Transmission.MANUAL)
                .buildMake(200)
                .build();
        System.out.println(car);*/
     Director director = new Director();
     director.setBuilder(new SubaruBuilder());
     Car1 car = director.BuildCar();
     System.out.println(car);
    }
}

enum Transmission{
    MANUAL, AUTO
}

class Car1{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder{
    Car1 car;
    void createCar(){
        car = new Car1();
    }

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car1 getCar(){return car;}
}

class FordMondeoBuilder extends CarBuilder{
    void buildMake(){car.setMake("Ford Mondeo");}
    void buildTransmission(){car.setTransmission(Transmission.AUTO);}
    void buildMaxSpeed(){car.setMaxSpeed(200);}
}

class SubaruBuilder extends CarBuilder{
    void buildMake(){car.setMake("Subaru");}
    void buildTransmission(){car.setTransmission(Transmission.MANUAL);}
    void buildMaxSpeed(){car.setMaxSpeed(320);}
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b){
        builder = b;
    }

    Car1 BuildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car1 car = builder.getCar();
        return car;
    }
}
/*class CarBuilder{
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s = 120;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }

    CarBuilder buildMake(Transmission t){
        this.t = t;
        return this;
    }

    CarBuilder buildMake(int s){
        this.s = s;
        return this;
    }

    Car1 build(){
        Car1 car1 = new Car1();
        car1.setMake(m);
        car1.setTransmission(t);
        car1.setMaxSpeed(s);
        return car1;
    }*/
//}