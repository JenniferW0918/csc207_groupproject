package use_case.first_view;


/**
 * The FirstViewOutputBoundary interface defines the boundary for presenting success views related to the First View use case.
 * Implementing classes are responsible for preparing and presenting views based on the provided output data.
 *
 * This interface declares two methods: prepareSuccessSignInView and prepareSuccessSignUpView.
 * Implementing classes are expected to define the behavior for presenting success views for sign-in and sign-up actions.
 *
 * Implementing classes serve as intermediaries between the business logic (interactor) and the user interface or external systems
 * for displaying success views in response to the First View use case execution.
 *
 * @author audrey
 * @version 1.0
 */
public interface FirstViewOutputBoundary {

    /**
     * Prepares and presents a success view for the sign-in action based on the provided FirstViewOutputData.
     *
     * @param user The output data representing the result of the First View sign-in action.
     */
    void prepareSuccessSignInView(FirstViewOutputData user);

    /**
     * Prepares and presents a success view for the sign-up action based on the provided FirstViewOutputData.
     *
     * @param user The output data representing the result of the First View sign-up action.
     */
    void prepareSuccessSignUpView(FirstViewOutputData user);}