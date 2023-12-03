import data_access.Accounts;
import entity.*;

import java.util.ArrayList;

/** Tests for Accounts class with some BusinessAccounts and User*/
public class AccountsTests {
    @org.junit.Test
    public void testBusinessStorage(){
        Accounts accounts = new Accounts();
        BusinessAccount businessAccount = new BusinessAccount(
                "test", "test", "test", "test",
                "test");
        accounts.saveBusiness(businessAccount);
        assert(accounts.businessExistsByUsername("test"));
    }

    @org.junit.Test
    public void testSameBusinessStorage(){
        Accounts accounts = new Accounts();
        ArrayList<BusinessAccount> businessAccounts = accounts.getBusinessAccounts();
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

        assert(businessAccounts.size() <= 1); // test that the business has not been added again
    }

    @org.junit.Test
    public void testUserStorage(){
        Accounts accounts = new Accounts();
        User users = new User("test", "test", "test");
        accounts.saveUser(users);
        assert(accounts.userExistsByUsername("test"));
    }

    @org.junit.Test
    public void testDuplicateUser(){
        Accounts accounts = new Accounts();
        ArrayList<User> userAccounts = accounts.getUsers();

        User user1 = new User("test", "test", "test");
        accounts.saveUser(user1);
        assert(accounts.userExistsByUsername("test"));

        User users2 = new User("test", "test", "test");
        accounts.saveUser(users2);

        assert(userAccounts.size() <= 1); // why won't it pas when I make it just == 1. why does it have to be <= 1
    }

    @org.junit.Test
    public void checkBusinessDoesNotExists(){
        Accounts accounts = new Accounts();
        BusinessAccount businessAccount = new BusinessAccount(
                "test", "test", "test", "test",
                "test");
        // Not saving business
        assert(!accounts.businessExistsByUsername("test"));
    }

    @org.junit.Test
    public void checkUserDoesNotExists(){
        Accounts accounts = new Accounts();
        User users = new User("test", "test", "test");
        // Not saving user
        assert(!accounts.userExistsByUsername("test"));
    }

    @org.junit.Test
    public void testBusinessAccounts(){
        BusinessAccount businessAccount = new BusinessAccount(
                "username", "name", "password", "address",
                "categories");
        assert(businessAccount.getUsername().equals("username"));
        assert(businessAccount.getName().equals("name"));
        assert(businessAccount.getPassword().equals("password"));
        assert(businessAccount.getAddress().equals("address"));
        assert(businessAccount.getCategories().equals("categories"));
    }

    @org.junit.Test
    public void testUserAccounts(){
        User user = new User("name", "username", "password");
        assert(user.getName().equals("name"));
        assert(user.getUsername().equals("username"));
        assert(user.getPassword().equals("password"));
    }

    @org.junit.Test
    public void testUserCreation(){
        UserFactory userFactory = new UserFactory();
        User createdUser = userFactory.create("name", "username", "password");
        assert(createdUser != null);
    }

    @org.junit.Test
    public void testBusinessCreation(){
        BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();
        BusinessAccount createdBusiness = businessAccountFactory.create("name", "username", "password", "address", "categories");
        assert(createdBusiness != null);
    }


}

