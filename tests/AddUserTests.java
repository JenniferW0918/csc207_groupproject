import app.Main;
import app.AddUserUseCaseFactory;
import entity.User;
import entity.UserFactory;
import entity.UserFactoryInterface;
import view.AddUserView;
import view.SearchNameView;
import view.SignUpView;
import interface_adapter.add_user.*;
import use_case.add_user.*;

import static app.Main.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

/* Things to test:
    - Buttons are present:
 */