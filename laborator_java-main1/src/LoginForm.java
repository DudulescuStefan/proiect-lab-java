import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    public LoginForm(JFrame owner) {

        this.owner = owner;
        owner.setSize(new Dimension(300, 300));
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnLogin) {
                    try {
                        Application.getInstance().login(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
                        JOptionPane.showMessageDialog(null, "Login successfully!");
                        mainPanel.setVisible(false);
                        if (Application.getInstance().currentUser.menuStrategy.getAccountType() == UserAccountType.TEACHER) {
                            owner.setContentPane(new TeacherForm().getPanel1());

                        } else if (Application.getInstance().currentUser.menuStrategy.getAccountType() == UserAccountType.STUDENT) {
                            owner.setContentPane(new StudentForm(owner, Application.getInstance().currentUser).getPanel4());
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                owner.setContentPane(new RegisterForm(owner).getMainpanel());
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton registerButton;
    private JFrame owner;
}
