package entity;

public class UserFactory implements UserFactoryInterface {
    @Override
    public User create(String name, String username, String password) {
        return new User(name, username, password);
    }
}

