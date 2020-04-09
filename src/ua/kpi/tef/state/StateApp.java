package ua.kpi.tef.state;

public class StateApp {
    public static void main(String[] args) {
        Station df = new RadioDF();
        Radio radio = new Radio();
        radio.setStation(df);
        for (int i=0; i<10; i++){
            radio.nextStation();
            radio.play();
        }

        Humann human = new Humann();
        human.setState(new Work());
        for(int i=0; i<10; i++) {
            human.doSomething();
        }
    }
}

//State
interface Station{
    void play();
}

class Radio7 implements Station{
    @Override
    public void play() {
        System.out.println("Radio7...");
    }
}

class RadioDF implements Station{
    @Override
    public void play() {
        System.out.println("RadioDF...");
    }
}

class RadioFM implements Station{
    @Override
    public void play() {
        System.out.println("RadioFM...");
    }
}

//Context
class Radio{
    Station station;

    public void setStation(Station st) {
        station = st;
    }
    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDF());
        }
        else if (station instanceof RadioDF){
            setStation(new RadioFM());
        }
        else if(station instanceof RadioFM){
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}

//Context
class Humann{
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething(){
        state.doSomething(this);
    }
}

//State
interface Activity{
    void doSomething(Humann context);
}

class Work implements Activity{
    public void doSomething(Humann context){
        System.out.println("Working...");
        context.setState(new Weekend());
    }
}

class Weekend implements Activity{
    private int count=0;
    public void doSomething(Humann context){
        if(count<3){
            System.out.println("Have rest...Zzzz");
            count++;
        }
        else{
            context.setState(new Work());
        }
    }

}