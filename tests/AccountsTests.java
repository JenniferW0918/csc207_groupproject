import app.Main;
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
        assert(!accounts.businessExistsByUsername("not test"));
    }

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

    @org.junit.Test
    public void testUserStorage(){
        Accounts accounts = new Accounts();
        User users = new User("test", "test", "test");
        accounts.saveUser(users);
        assert(accounts.userExistsByUsername("test"));
        assert(!accounts.userExistsByUsername("not test"));
    }

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
                "category");
        assert(businessAccount.getUsername().equals("username"));
        assert(businessAccount.getName().equals("name"));
        assert(businessAccount.getPassword().equals("password"));
        assert(businessAccount.getAddress().equals("address"));
        assert(businessAccount.getCategory().equals("category"));
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

