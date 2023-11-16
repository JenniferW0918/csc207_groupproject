package interface_adapter.add_business;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddBusinessAccountViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String USERNAME_LABEL = "Choose your business username";

    public static final String NAME_LABEL = "Enter your business' name";
    public static final String PASSWORD_LABEL = "Choose a password";

    public static final String ADDRESS_LABEL = "Enter your business' address";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private AddBusinessAccountState state = new AddBusinessAccountState();

    public AddBusinessAccountViewModel() {
        super("sign up");
    }

    public void setState(AddBusinessAccountState state) {
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

    public AddBusinessAccountState getState() {
        return state;
    }
}

