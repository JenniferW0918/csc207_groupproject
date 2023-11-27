package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SignUpViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Choose an Account";
    public static final String USER_BUTTON_LABEL = "Create User";
    public static final String BUSINESS_BUTTON_LABEL = "Create Business";

    private SignUpState state = new SignUpState();

    public SignUpViewModel() {

        super("sign up");
    }

    public void setState(SignUpState state) {

        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {

        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SignUpState getState() {

        return state;
    }
}
