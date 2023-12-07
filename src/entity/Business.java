package entity;


public class Business {
    private final String id;
    private final String name;
    private final String address;
    private final boolean is_closed;
    private final String url;
    private final String reviews;

    public Business(String id, String name, String address, boolean is_closed, String url, String reviews) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.is_closed = is_closed;
        this.url = url;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
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

    public String getUrl() {
        return url;
    }

    public String getReviews() {
        return reviews;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\n";
    }
}
