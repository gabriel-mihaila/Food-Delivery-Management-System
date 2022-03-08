package businessLayer;

import start.Main;

import java.io.Serializable;
import java.util.stream.Stream;

public class Account implements Serializable {
    private static int maxID;
    private int id;
    private String username;
    private String password;
    private int type;

    public Account(String username, String password, int type) {
        id = maxID++;
        this.username = username;
        this.password = password;
        this.type = type;
        this.addAccount();
    }

    public void addAccount(){
        Main.getDeliveryService().addAccount(Stream.of(this));
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

}
