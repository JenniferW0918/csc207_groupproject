package entity;


public class Business {
    private final String name;
    private final String address;
    private final boolean is_closed;

    public Business(String name, String address, boolean is_closed) {
        this.name = name;
        this.address = address;
        this.is_closed = is_closed;
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

    public String toString() {
        if (is_closed) {
            return "Name: " + name + "\nAddress: " + address + "\nOpen: " + "No" + "\n";
        }
        else {
            return "Name: " + name + "\nAddress: " + address + "\nOpen: " + "Yes" + "\n";
        }
    }
}
