package use_case.first_view;


public class FirstViewInteractor implements FirstViewInputBoundary {
    final FirstViewOutputBoundary present;

    public FirstViewInteractor(FirstViewOutputBoundary firstViewOutputBoundary) {
        this.present = firstViewOutputBoundary;
    }

    @Override
    public void execute(FirstViewInputData firstViewInputData) {
        if (firstViewInputData.getSigninOrSignup() == "signin") {
            present.prepareSuccessSignInView(new FirstViewOutputData("signin"));
        } else {
            present.prepareSuccessSignUpView(new FirstViewOutputData("signup"));
        }
    }
}