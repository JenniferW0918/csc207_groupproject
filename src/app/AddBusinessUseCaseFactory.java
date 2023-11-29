package app;

import entity.BusinessAccountFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessAccountController;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.signup.AddBusinessAccountPresenter;
import use_case.add_business.AddBusinessAccountDataAccessInterface;
import use_case.add_business.AddBusinessAccountInputBoundary;
import use_case.add_business.AddBusinessAccountInteractor;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import view.AddBusinessAccountView;

import javax.swing.*;
import java.io.IOException;

public class AddBusinessUseCaseFactory {
    private AddBusinessUseCaseFactory() {}

    public static AddBusinessAccountView create(
            ViewManagerModel viewManagerModel, SearchNameViewModel searchNameViewModel,
            AddBusinessAccountViewModel addBusinessAccountViewModel,
            AddBusinessAccountDataAccessInterface businessDataAccessObject) {

        try {
            AddBusinessAccountController addBusinessAccountController = createBusinessAccountSignupUseCase(
                    viewManagerModel, addBusinessAccountViewModel, searchNameViewModel, businessDataAccessObject);
            return new AddBusinessAccountView(addBusinessAccountController, addBusinessAccountViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static AddBusinessAccountController createBusinessAccountSignupUseCase(ViewManagerModel viewManagerModel,
                                                                       AddBusinessAccountViewModel addBusinessAccountViewModel,
                                                                       SearchNameViewModel searchNameViewModel,
                                                                       AddBusinessAccountDataAccessInterface businessDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddBusinessAccountOutputBoundary addBusinessAccountOutputBoundary = new AddBusinessAccountPresenter(
                viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);

        BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();

        AddBusinessAccountInputBoundary addBusinessInteractor = new AddBusinessAccountInteractor(
                businessDataAccessObject, addBusinessAccountOutputBoundary, businessAccountFactory);

        return new AddBusinessAccountController(addBusinessInteractor);
    }
}
