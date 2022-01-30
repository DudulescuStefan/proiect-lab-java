import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {
    private JFrame Owner;
    private JPanel mainpanel;
    private JLabel numelabel;
    private JLabel prenumelabel;
    private JLabel passwordlabel;
    private JTextField numefield;
    private JTextField prenumefield;
    private JTextField usernamefield;
    private JPasswordField passfield;
    private JButton registerButton;
    private JButton loginButton;

    public RegisterForm(JFrame Owner) {this.Owner=Owner;
Owner.setSize(new Dimension(500,500));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {if(e.getSource()==registerButton){

                int validator = Application.getInstance().register(numefield.getText(), new String(prenumefield.getText()),usernamefield.getText(),new String( passfield.getPassword()));

                if(validator == 0){
                    JOptionPane.showMessageDialog(null,"Date incorecte!");
                }
                else
                    if(validator == 1){
                    JOptionPane.showMessageDialog(null,"Contul exista deja");
                }
                    else
                        if(validator == 2 || validator == 3){
                                numefield.setText("");
                                prenumefield.setText("");
                                usernamefield.setText("");
                                passfield.setText("");
                }
            }

            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            mainpanel.setVisible(false);
            Owner.setContentPane(new LoginForm(Owner).getMainPanel());
            }
        });
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

