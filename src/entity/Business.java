package entity;

import java.util.Map;


public class Business {
    private final String name;
    private final String address;
    private final boolean is_closed;

    public Business(String name, String address, boolean is_closed) {
        this.name = name;
        this.address = address;
        this.is_closed = true;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public boolean is_Closed() {
        return is_closed;
    }
}
