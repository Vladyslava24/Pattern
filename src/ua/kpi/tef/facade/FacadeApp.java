package ua.kpi.tef.facade;

public class FacadeApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer{
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();
    void copy(){
        power.on();
        dvd.unload();
        hdd.copyFromDVD(dvd);
    }
}

class Power{
    public void on(){
        System.out.println("Power on");
    }
    public void off(){
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        System.out.println("Dik is loaded");
        data = true;
    }

    void unload() {
        System.out.println("Disk is unloaded");
        data = false;
    }
}

class HDD{
     void copyFromDVD(DVDRom dvd){
         if(dvd.hasData()){
             System.out.println("Copy data from disk");
         }else{
             System.out.println("Put disk with data");
          }
     }
}

