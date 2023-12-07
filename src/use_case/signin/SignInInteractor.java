package use_case.signin;

import data_access.Accounts;
import entity.BusinessAccount;
import entity.User;


public class SignInInteractor implements SignInInputBoundary {
    final Accounts dataAccessObject;
    final SignInOutputBoundary signInPresenter;

    public SignInInteractor(Accounts dataAccessObject, SignInOutputBoundary signInOutputBoundary) {
        this.dataAccessObject = dataAccessObject;
        this.signInPresenter = signInOutputBoundary;
    }

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

