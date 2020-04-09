package ua.kpi.tef.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(25, 760);
        station.setMeasurements(-8, 755);
    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer{
    void handleEvent(int temp, int presser);
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.handleEvent(temperature, pressure);
        }
    }
}

class ConsoleObserver implements Observer{
    public void handleEvent(int temp, int presser){
        System.out.println("The weather changed. Temparature is = "+ temp+". Pressure = "+presser);
    }
}

class FileObserver implements Observer{
    public void handleEvent(int temp, int presser){
        File f;
        try{
            f = File.createTempFile("TempPressure", "txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("The wether changed. Temparature is = "+ temp+". Pressure = "+presser);
            pw.println();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}