package ua.kpi.tef.factory_method;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {
      WatchMaker maker = new DigitalWatchMaker();
      Watch watch = maker.createWatch();
      watch.showTime();

      WatchMaker maker1 = getMakerByName("Rome");
      Watch watch1 = maker1.createWatch();
      watch1.showTime();
    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if(maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("Wrong production watch line: "+maker);
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime(){
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    public void showTime(){
        System.out.println("VII-XX");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new RomeWatch();
    }
}