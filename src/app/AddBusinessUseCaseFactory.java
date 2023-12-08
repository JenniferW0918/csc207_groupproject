package app;

import data_access.Accounts;
import entity.BusinessAccountFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessAccountController;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.add_business.AddBusinessAccountPresenter;
import use_case.add_business.AddBusinessAccountInputBoundary;
import use_case.add_business.AddBusinessAccountInteractor;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import view.AddBusinessAccountView;

import javax.swing.*;
import java.io.IOException;

/**
 * The {@code AddBusinessUseCaseFactory} class is responsible for creating instances related to the "Add Business"
 * use case. It provides a factory method to create the {@code AddBusinessAccountView} along with its associated
 * controller and presenter.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessUseCaseFactory {
    private AddBusinessUseCaseFactory() {}

    /**
     * Creates an instance of the {@code AddBusinessAccountView} along with its associated controller and presenter.
     *
     * @param viewManagerModel         The model responsible for managing the active view.
     * @param searchNameViewModel      The view model associated with the search name functionality.
     * @param addBusinessAccountViewModel The view model associated with the "Add Business" use case.
     * @param dataAccessObject         The data access object providing access to business-related data.
     * @return The created {@code AddBusinessAccountView}.
     */
    public static AddBusinessAccountView createBusinessView(
            ViewManagerModel viewManagerModel,
            SearchNameViewModel searchNameViewModel,
            AddBusinessAccountViewModel addBusinessAccountViewModel,
            Accounts dataAccessObject) {

        try {
            AddBusinessAccountController addBusinessAccountController = createBusinessAccountSignupUseCase(
                    viewManagerModel, addBusinessAccountViewModel, searchNameViewModel, dataAccessObject);
            return new AddBusinessAccountView(addBusinessAccountController, addBusinessAccountViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "What do we write here?");
        }

        return null;
    }

    /**
     * Creates an instance of the {@code AddBusinessAccountController} to handle the "Add Business" use case.
     *
     * @param viewManagerModel         The model responsible for managing the active view.
     * @param addBusinessAccountViewModel The view model associated with the "Add Business" use case.
     * @param searchNameViewModel      The view model associated with the search name functionality.
     * @param dataAccessObject         The data access object providing access to business-related data.
     * @return The created {@code AddBusinessAccountController}.
     * @throws IOException If an I/O error occurs during the creation of the controller.
     */
    private static AddBusinessAccountController createBusinessAccountSignupUseCase(ViewManagerModel viewManagerModel,
                                                                       AddBusinessAccountViewModel addBusinessAccountViewModel,
                                                                       SearchNameViewModel searchNameViewModel,
                                                                       Accounts dataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddBusinessAccountOutputBoundary addBusinessAccountOutputBoundary = new AddBusinessAccountPresenter(
                viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);

        BusinessAccountFactory businessAccountFactory = new BusinessAccountFactory();

        AddBusinessAccountInputBoundary addBusinessInteractor = new AddBusinessAccountInteractor(
                dataAccessObject, addBusinessAccountOutputBoundary, businessAccountFactory);

        return new AddBusinessAccountController(addBusinessInteractor);
    }
}
