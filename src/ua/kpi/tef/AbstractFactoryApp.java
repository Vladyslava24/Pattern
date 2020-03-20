package ua.kpi.tef;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("RU");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();
        m.click();
        k.print();
        k.println();
        t.track(89, 67);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code " + lang);
        }
    }
}

interface Mouse{
    void click();
    void dblclick();
    void scroll(int direction);
}

interface Keyboard{
    void print();
    void println();
}

interface Touchpad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuMouse implements Mouse {
    public void click() {
        System.out.println("щелчёк мишью");
    }

    public void dblclick() {
        System.out.println("двойной щелчёк мишью");
    }

    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("скрол вверх");
        } else if (direction < 0) {
            System.out.println("скрол вниз");
        } else {
            System.out.println("нет скрола");
        }
    }
}

class RuKeyboard implements Keyboard{
        public void print(){ System.out.print("печать ");}
        public void println(){ System.out.println("напечатать с переносом строки");}
}

class RuTouchpad implements Touchpad{
        public void track(int deltaX, int deltaY){
            int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
            System.out.println("Передвинуться на "+s+"пикселей");
        }
}

class EnMouse implements Mouse{
        public void click(){ System.out.println("Mouse click");}
        public void dblclick(){ System.out.println("Mouse double click");}
        public void scroll(int direction){
          if(direction>0){
             System.out.println("scroll up");
          }
          else if(direction<0){
             System.out.println("scroll down");
        }
          else{
            System.out.println("no scrolling");
        }
    }
}

    class EnKeyboard implements Keyboard{
        public void print(){ System.out.print("print");}
        public void println(){ System.out.println("print line");}
    }

    class EnTouchpad implements Touchpad{
        public void track(int deltaX, int deltaY){
            int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
            System.out.println("Move on "+s+"pixels");
        }
    }

    class EnDeviceFactory implements DeviceFactory{
        public Mouse getMouse(){
            return new EnMouse();
        }
        public Keyboard getKeyboard(){
            return new EnKeyboard();
        }
        public Touchpad getTouchpad(){
            return new EnTouchpad();
        }
    }

    class RuDeviceFactory implements DeviceFactory{
        public Mouse getMouse(){
            return new RuMouse();
        }
        public Keyboard getKeyboard(){
            return new RuKeyboard();
        }
        public Touchpad getTouchpad(){
            return new RuTouchpad();
        }
    }