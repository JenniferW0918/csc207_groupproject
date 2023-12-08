package use_case.first_view;

import use_case.first_view.FirstViewInputData;

/**
 * The FirstViewInputBoundary interface defines the boundary for the input of the First View use case.
 * Classes implementing this interface are responsible for executing the First View use case based on the provided input data.
 *
 * This interface declares a single method: execute. Implementing classes are expected to define the behavior for
 * processing the input data and triggering the execution of the First View use case.
 *
 * Implementing classes serve as intermediaries between the user interface or external systems and the business logic
 * (interactor) for initiating actions related to the First View.
 *
 * @author audrey
 * @version 1.0
 */
public interface FirstViewInputBoundary {

    /**
     * Executes the First View use case based on the provided FirstViewInputData.
     *
     * @param firstViewInputData The input data for the First View use case.
     */
    void execute(FirstViewInputData firstViewInputData);
}
