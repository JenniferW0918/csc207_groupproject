package entity;

public interface BusinessAccountFactoryInterface {
    BusinessAccount create(String username, String name, String password, String address, Category categories);
}
