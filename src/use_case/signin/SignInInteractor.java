package use_case.signin;

import data_access.Accounts;
import entity.BusinessAccount;
import entity.User;

/**
 * The SignInInteractor class implements the logic for signing in to the program as either a user or business.
 * It acts as the use case's input boundary and interacts with the data access layer and presentation layer.
 * The interactor validates input data, checks the entered username exists in Accounts, checks the entered password
 * matches the username, and updates the presenter accordingly.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInInteractor implements SignInInputBoundary {

    /**
     * The data access object providing access to user and business account information.
     */
    final Accounts dataAccessObject;

    /**
     * The output boundary for presenting results and errors related to the Sign-In use case.
     */
    final SignInOutputBoundary signInPresenter;


    /**
     * Constructs a new SignInInteractor with the specified data access object and output boundary.
     *
     * @param dataAccessObject The data access object providing access to user and business account information.
     * @param signInOutputBoundary The output boundary for presenting results and errors related to the Sign-In use case.
     */
    public SignInInteractor(Accounts dataAccessObject, SignInOutputBoundary signInOutputBoundary) {
        this.dataAccessObject = dataAccessObject;
        this.signInPresenter = signInOutputBoundary;
    }

    /**
     * Executes the Sign-In use case based on the provided SignInInputData. Validates the provided credentials,
     * checks account existence, and communicates the results through the output boundary.
     *
     * @param signInInputData The input data for the Sign-In use case.
     */
    @Override
    public void execute(SignInInputData signInInputData) {
        String username = signInInputData.getUsername();
        String password = signInInputData.getPassword();

        if (!dataAccessObject.userExistsByUsername(username) && !dataAccessObject.businessExistsByUsername(username)) {
            signInPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String storedPassword;
            boolean isUser = dataAccessObject.userExistsByUsername(username);

            if (isUser) {
                storedPassword = dataAccessObject.getUser(username).getPassword();
            } else {
                storedPassword = dataAccessObject.getBusinessAccount(username).getPassword();
            }

          
            if (!password.equals(storedPassword)) {
                signInPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
                String accountName;
                if (isUser) {
                    User user = dataAccessObject.getUser(signInInputData.getUsername());
                    accountName = user.getName();
                } else {
                    BusinessAccount business = dataAccessObject.getBusinessAccount(signInInputData.getUsername());
                    accountName = business.getName();
                }

                SignInOutputData signInOutputData = new SignInOutputData(accountName, false);
                signInPresenter.prepareSuccessView(signInOutputData);
            }
        }
    }
}

