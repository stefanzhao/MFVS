package mfvs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login  extends JFrame implements ActionListener {

    private JPanel jp1,jp2,jp3,jp4;

    private Icon logoIcon= new ImageIcon("D:\\MFVS\\mfvs\\src\\images.png");
    private JLabel lblogo=new JLabel(logoIcon);
    private JLabel lbAccount = new JLabel("Username");
    private JTextField tfAccount = new JTextField(20);
    private JLabel lbPassword = new JLabel("Password");
    private JPasswordField pfPassword = new JPasswordField(20);
    private JButton btLogin = new JButton("Sign in");
    private JButton btRegister = new JButton("Sign up");
    private JButton btExit = new JButton(" Exit ");

    public Login() {


        this.setTitle("MFVS");
        this.setSize(450, 300);
        this.setLocation(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);


        this.setLayout(new GridLayout(4,1,20,3));

        jp1 = new JPanel();
        jp1.setOpaque(false);
        jp1.add(lblogo);
        this.add(jp1);

        jp2 = new JPanel();
        jp2.setOpaque(false);
        jp2.add(lbAccount);
        jp2.add(tfAccount);

        this.add(jp2);

        jp3 = new JPanel();
        jp3.setOpaque(false);
        jp3.add(lbPassword);
        jp3.add(pfPassword);

        this.add(jp3);


        jp4 = new JPanel();
        jp4.setOpaque(false);
        jp4.add(btLogin);
        jp4.add(btRegister);
        jp4.add(btExit);
        this.add(jp4);

        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLogin) {
            String account = tfAccount.getText();
            String password = new String(pfPassword.getPassword());
            FileOpe.getInfoByAccount(account);
            if (Conf.account == null || !Conf.password.equals(password)) {
                JOptionPane.showMessageDialog(this, "Login failed");
                return;
            }
            JOptionPane.showMessageDialog(this, "Welcome to MFVS");
            this.dispose();
            new Operation();
        } else if (e.getSource() == btRegister) {
            this.dispose();
            new Register();
        } else {
            JOptionPane.showMessageDialog(this, "Thank you for using MFVS");
            System.exit(0);
        }
    }
}
