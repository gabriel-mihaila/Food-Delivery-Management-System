package presentationLayer;

import businessLayer.Account;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class LoginController extends Component {

    public LoginController(ViewLogin login) {

        login.getRegisterButton().addActionListener(e -> {
            new Account(login.getUsernameField().getText(), String.valueOf(login.getPasswordField().getPassword()), 0);
            JOptionPane.showMessageDialog(null,"<html><font color=#0000ff>Created account!</font> ","INFO",JOptionPane.INFORMATION_MESSAGE);

        });

        login.getLoginButton().addActionListener(e -> {
            Optional<Account> optAccount = login.getService().getAccounts().stream()
                    .filter(account -> account.getUsername().equals(login.getUsernameField().getText()))
                    .filter(account -> account.getPassword().equals(String.valueOf(login.getPasswordField().getPassword())))
                    .findAny();
            if(optAccount.isEmpty()) {
                JOptionPane.showMessageDialog(this,"<html><font color=#0000ff>That username or password aren't valid!</font> ","INFO",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                Account account = optAccount.get();
                JFrame frame;
                if(account.getType() == 0) {
                    frame = new JFrame("Client");
                    frame.setContentPane(new ViewClient(login.getService(), account.getId()).getClientPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else if(account.getType() == 1) {
                    frame = new JFrame("Administrator");
                    frame.setContentPane(new ViewAdmin(login.getService()).getAdminPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    frame = new JFrame("Employee");
                    frame.setContentPane(new ViewEmployee(login.getService()).getEmployeePanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
                JOptionPane.showMessageDialog(null,"<html><font color=#0000ff>Logged in as " + optAccount.get().getUsername() + "!</font> ","INFO",JOptionPane.INFORMATION_MESSAGE);

            }

        });

    }

}
