package entity;

public interface UserFactoryInterface {
    /** Requires: password is valid. */
    User create(String name, String username, String password);
}
