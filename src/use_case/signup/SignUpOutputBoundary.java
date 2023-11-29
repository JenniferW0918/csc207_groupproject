package use_case.signup;

public interface SignUpOutputBoundary {
    void prepareSuccessUserView(SignUpOutputData user);

    void prepareSuccessBusinessView(SignUpOutputData user);
