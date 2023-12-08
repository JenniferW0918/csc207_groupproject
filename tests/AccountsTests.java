import app.Main;
import data_access.Accounts;
import entity.*;

import java.util.ArrayList;

/** Tests for Accounts class with some BusinessAccounts and User*/
public class AccountsTests {

    /**Test that Accounts stores business objects appropriately*/
    @org.junit.Test
    public void testBusinessStorage(){
        Accounts accounts = new Accounts();
        BusinessAccount businessAccount = new BusinessAccount(
                "test", "test", "test", "test",
                "test");
        accounts.saveBusiness(businessAccount);
        assert(accounts.businessExistsByUsername("test"));
        assert(!accounts.businessExistsByUsername("not test"));
    }

    /**Test that Accounts does not store duplicate businesses*/
    @org.junit.Test
    public void testDuplicateBusinessStorage(){
        Accounts accounts = new Accounts();
        BusinessAccount businessAccount = new BusinessAccount(
                "test", "test", "test", "test",
                "test");
        accounts.saveBusiness(businessAccount);

        assert(accounts.businessExistsByUsername("test")); // test that the business has been added

        // Add the same business again
        BusinessAccount businessAccount2 = new BusinessAccount(
                "test", "test", "test", "test",
                "test");
        accounts.saveBusiness(businessAccount2);

        ArrayList<BusinessAccount> businessAccounts = accounts.getBusinessAccounts();
        assert(businessAccounts.size() == 1); // test that the business has not been added again
    }

    /**Test that Accounts stores user objects appropriately*/
    @org.junit.Test
    public void testUserStorage(){
        Accounts accounts = new Accounts();
        User users = new User("test", "test", "test");
        accounts.saveUser(users);
        assert(accounts.userExistsByUsername("test"));
        assert(!accounts.userExistsByUsername("not test"));
    }

    /**Test that Accounts does not store duplicate users*/
    @org.junit.Test
    public void testDuplicateUser(){
        Accounts accounts = new Accounts();

        User user1 = new User("test", "test", "test");
        accounts.saveUser(user1);
        assert(accounts.userExistsByUsername("test"));

        User users2 = new User("test", "test", "test");
        accounts.saveUser(users2);

        ArrayList<User> userAccounts = accounts.getUsers();
        assert(userAccounts.size() == 1);
    }

    /**Test that Accounts can validate when a business accounts exists*/
    @org.junit.Test
    public void checkBusinessDoesNotExists(){
        Accounts accounts = new Accounts();
        BusinessAccount businessAccount = new BusinessAccount(
                "test", "test", "test", "test",
                "test");
        // Not saving business
        assert(!accounts.businessExistsByUsername("test"));
    }

    /**Test that Accounts can validate when a user accounts exists*/
    @org.junit.Test
    public void checkUserDoesNotExists(){
        Accounts accounts = new Accounts();
        User users = new User("test", "test", "test");
        // Not saving user
        assert(!accounts.userExistsByUsername("test"));
    }

    /**Test that BusinessAccounts instantiation*/
    @org.junit.Test
    public void testBusinessAccounts(){
        BusinessAccount businessAccount = new BusinessAccount(
                "username", "name", "password", "address",
                "category");
        assert(businessAccount.getUsername().equals("username"));
        assert(businessAccount.getName().equals("name"));
        assert(businessAccount.getPassword().equals("password"));
        assert(businessAccount.getAddress().equals("address"));
        assert(businessAccount.getCategory().equals("category"));
    }

    /**Test that User instantiation*/
    @org.junit.Test
    public void testUserAccounts(){
        User user = new User("name", "username", "password");
        assert(user.getName().equals("name"));
        assert(user.getUsername().equals("username"));
        assert(user.getPassword().equals("password"));
    }

    /** Test that the user factory creates users appropriately*/
    @org.junit.Test
    public void testUserCreation(){
        UserFactory userFactory = new UserFactory();
        User createdUser = userFactory.create("name", "username", "password");
        assert(createdUser != null);
    }

    /** Test that the business factory creates businesses appropriately*/
    @org.junit.Test
    public void testBusinessCreation(){
        BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();
        BusinessAccount createdBusiness = businessAccountFactory.create("name", "username", "password", "address", "categories");
        assert(createdBusiness != null);
    }

    /** Test that Accounts stores users appropriately*/
    @org.junit.Test
    public void testAccountsUsersList(){
        Accounts accounts = new Accounts();
        User user = new User("name", "username", "password");
        accounts.saveUser(user);
        assert(accounts.getUsers().size() == 1);

        User user1 = new User("name1", "username1", "password1");
        accounts.saveUser(user1);
        assert(accounts.getUsers().size() == 2);

        assert(accounts.getUsers().contains(user));
        assert(accounts.getUsers().contains(user1));
    }

}

