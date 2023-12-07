package use_case.first_view;

import use_case.first_view.FirstViewOutputData;

public interface FirstViewOutputBoundary {
    void prepareSuccessSignInView(FirstViewOutputData user);

    void prepareSuccessSignUpView(FirstViewOutputData user);}