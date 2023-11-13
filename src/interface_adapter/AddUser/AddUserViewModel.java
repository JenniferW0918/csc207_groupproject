package interface_adapter.AddUser;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddUserViewModel extends ViewModel {

    public static final String USERNAME_LABEL = "Enter Username";
    public static final String PASSWORD_LABEL = "Enter Password";
    public static final String SIGNUP_BUTTON_LABEL = "Create Account";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String TITLE_LABEL = "Create an Account";

    private AddUserState state = new AddUserState();

    public AddUserViewModel() {
        super("Create an Account");
    }

    public void setState(AddUserState state) {
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

    public AddUserState getState() {
        return state;
    }
}