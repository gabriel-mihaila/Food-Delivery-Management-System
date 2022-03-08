package presentationLayer;

import businessLayer.DeliveryService;
import javax.swing.*;
import java.awt.*;

public class ViewLogin extends Component {
    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private DeliveryService service;

    public ViewLogin(DeliveryService service)
    {
        this.service = service;
        new LoginController(this);
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public DeliveryService getService() {
        return service;
    }

}
