package interface_adapter.first_view;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignUpState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FirstViewViewModel extends ViewModel { // testing commits

    public static final String TITLE_LABEL = "Signin or Signup";
    public static final String SIGNIN_BUTTON_LABEL = "Signin";
    public static final String SIGNUP_BUTTON_LABEL = "Signup";

    private FirstViewState state = new FirstViewState();

    public FirstViewViewModel() {

        super("first view");
    }

    public void setState(FirstViewState state) {

        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Frist View Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {

        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public FirstViewState getState() {

        return state;
    }
}