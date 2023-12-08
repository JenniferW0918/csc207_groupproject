package entity;

/**
 * The Business class represents a business entity with attributes such as id, name, address, operational status,
 * URL, and reviews. Instances of this class are immutable once initialized. It provides methods to access these
 * attributes and a toString() method for creating a string representation of the business.
 *
 * @author banke, audrey
 * @version 1.0
 */
public class Business {
    /**
     * The unique identifier of the business.
     */
    private final String id;

    /**
     * The name of the business.
     */
    private final String name;

    /**
     * The address of the business.
     */
    private final String address;

    /**
     * The operational status of the business (open or closed).
     */
    private final boolean is_closed;

    /**
     * The URL of the business.
     */
    private final String url;

    /**
     * The reviews associated with the business.
     */
    private final String reviews;

    /**
     * Constructs a Business object with the specified attributes.
     *
     * @param id        The unique identifier of the business.
     * @param name      The name of the business.
     * @param address   The address of the business.
     * @param is_closed The operational status of the business (open or closed).
     * @param url       The URL of the business.
     * @param reviews   The reviews associated with the business.
     */
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
