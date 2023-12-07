package interface_adapter.signin;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


public class SignInViewModel extends ViewModel {


    public final String TITLE_LABEL = "Signin View";
    public final String USERNAME_LABEL = "enter your username";
    public final String PASSWORD_LABEL = "enter your password";


    public static final String SIGNIN_BUTTON_LABEL = "Signin";


    private SignInState state = new SignInState();


    public SignInViewModel() {
        super("signin");
    }


    public void setState(SignInState state) {
        this.state = state;
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public SignInState getState() {
        return state;
    }
}
