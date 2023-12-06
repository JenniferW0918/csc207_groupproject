package use_case.signin;

import data_access.Accounts;
import entity.BusinessAccount;
import entity.User;


public class SignInInteractor implements SignInInputBoundary { // attempting push
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


        if (!dataAccessObject.userExistsByUsername(username) || !dataAccessObject.businessExistsByUsername(username)) {
            signInPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            // need to go through array list of either Users or BusinessAccounts, find user or businessAccounts with the
            // username and then get the password and assign it to either userpwd or businesspwd - OR put getUser and
            // getBusinessAccount methods in Account


            // then check userpwd or businesspwd against the inputed password
            String userpwd = dataAccessObject.getUser(username).getPassword();
            String businesspwd = dataAccessObject.getBusinessAccount(username).getPassword();
            if (!password.equals(userpwd) && !password.equals(businesspwd)) {
                signInPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
                if (password.equals(userpwd)) {


                    User user = dataAccessObject.getUser(signInInputData.getUsername());
                    SignInOutputData signInOutputData = new SignInOutputData(user.getName(), false);
                    signInPresenter.prepareSuccessView(signInOutputData);
                }
                else {
                    BusinessAccount business = dataAccessObject.getBusinessAccount(signInInputData.getUsername());
                    SignInOutputData signInOutputData = new SignInOutputData(business.getName(), false);
                    signInPresenter.prepareSuccessView(signInOutputData);
                }
            }
        }
    }
}

