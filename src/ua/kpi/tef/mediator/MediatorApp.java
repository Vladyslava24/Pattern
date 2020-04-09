package ua.kpi.tef.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        /*User1 admin = new Admin(chat);
        User1 u1 = new SimpleUser(chat);
        User1 u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMessage("Hello, I'm User");
        admin.sendMessage("Admin went to the chat");*/

        User1 admin = new Admin(chat, "Ivan Ivanych");
        User1 u1 = new SimpleUser(chat, "Vova");
        User1 u2 = new SimpleUser(chat,"Sasha");
        User1 u3 = new SimpleUser(chat,"Sergiy");

        u2.setEnable(false);
        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        admin.sendMessage("Hello!");
    }
}

/*interface User1{
    abstract void sendMessage(String message);
    abstract void getMessage(String message);
}*/

abstract class User1{
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable(){return isEnable;}

    public void setEnable(boolean isEnable){this.isEnable = isEnable; }

    public User1(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Admin extends User1{
     public Admin(Chat chat, String name){super(chat, name);}

     public void getMessage(String message){
         System.out.println("Admin " + getName()+ " gets message '" + message + "'");
     }
}

class SimpleUser extends User1{
    public SimpleUser(Chat chat, String name){super(chat, name);}

    public void getMessage(String message){
        System.out.println("User " + getName()+ " gets message '" + message + "'");
    }
}



/*class Admin implements User1{
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }
    public void getMessage(String message){
        System.out.println("Admin gets message '"+message+"'");
    }
}

class SimpleUser implements User1{
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }
    public void getMessage(String message){
        System.out.println("User gets message '"+message+"'");
    }
}

class TextChat implements Chat{
    User1 admin;
    List<User1> users= new ArrayList<>();

    public void setAdmin(User1 admin){
        this.admin = admin;
    }

    public void addUser(User1 u){
        users.add(u);
    }

    public void sendMessage(String message, User1 user){
        for (User1 u : users){
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}*/

interface Chat{
    void sendMessage(String message, User1 user);
}

class TextChat implements Chat{
    User1 admin;
    List<User1> users = new ArrayList<>();

    public void setAdmin(User1 admin){
        if(admin != null && admin instanceof Admin){
            this.admin = admin;
        }
        else{
            throw new RuntimeException("Not enaugh rules");
        }
    }

    public void addUser(User1 u){
        if(admin == null){
            throw new RuntimeException("There is'nt admin in the chat");
        }

        if(u instanceof SimpleUser){
            users.add(u);
        }
        else{
            throw new RuntimeException("Admin cannot go to another chat");
        }
    }

    public void sendMessage(String message, User1 user){
        if(user instanceof Admin){
            for(User1 u : users){
                u.getMessage(user.getName()+ ": "+message);
            }
        }
        if(user instanceof SimpleUser){
            for(User1 u : users){
                if(u != user && u.isEnable())
                    u.getMessage(user.getName()+ ": "+message);
            }
            if(admin.isEnable()) {
                admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
}



