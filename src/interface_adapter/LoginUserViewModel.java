package interface_adapter;

import interface_adapter.LoginUserState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginUserViewModel extends ViewModel {

    public final String TITLE_LABEL = "Log In";
    public final String USERNAME_LABEL = "Enter Username";
    public final String PASSWORD_LABEL = "Enter Password";

    public final String LOGIN_BUTTON_LABEL = "Log In";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private LoginUserState state = new LoginUserState();

    public LoginUserViewModel() {
        super("log in");
    }

    public void setState(LoginUserState state) {
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

    public LoginUserState getState() {
        return state;
    }
}

