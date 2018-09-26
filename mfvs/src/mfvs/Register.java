package mfvs;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Register extends JFrame implements ActionListener {

    private JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7;
    private JLabel lbsignup=new JLabel("Sign up");
    private JLabel lbAccount=new JLabel("Please enter your username    ");
    private JTextField tfAccount=new JTextField(20);
    private JLabel lbPassword=new JLabel("Please enter your password    ");
    private JPasswordField pfPassword=new JPasswordField(20);
    private JLabel lbPassword2=new JLabel("Please confirm your password  ");
    private JPasswordField pfPassword2=new JPasswordField(20);
    private JLabel lbName=new JLabel("Please enter your nickname    ");
    private JTextField tfName=new JTextField(20);
    private JLabel lbRole=new JLabel("Please choose your identity          ");
    private JComboBox cbRole=new JComboBox();
    private JButton btLogin = new JButton("Sign in");
    private JButton btRegister = new JButton("Sign up");
    private JButton btExit = new JButton(" Exit ");


    public Register() {

        this.setTitle("Sign up");
        this.setSize(500, 450);
        this.setLocation(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);


        this.setLayout(new GridLayout(7,1,20,5));

        jp7 = new JPanel();
        jp7.add(lbsignup);
        jp7.setOpaque(false);
        lbsignup.setFont(new java.awt.Font("Dialog",   3,   25));
        this.add(jp7);

        jp1 = new JPanel();
        jp1.add(lbAccount);
        jp1.add(tfAccount);
        jp1.setOpaque(false);
        this.add(jp1);

        jp2 = new JPanel();
        jp2.add(lbPassword);
        jp2.add(pfPassword);
        jp2.setOpaque(false);
        this.add(jp2);

        jp3 = new JPanel();
        jp3.add(lbPassword2);
        jp3.add(pfPassword2);
        jp3.setOpaque(false);
        this.add(jp3);

        jp4 = new JPanel();
        jp4.add(lbName);
        jp4.add(tfName);
        jp4.setOpaque(false);
        this.add(jp4);

        jp5 = new JPanel();
        jp5.add(lbRole);
        jp5.add(cbRole);
        cbRole.addItem("Customer");
        cbRole.addItem("Owner");
        jp5.setOpaque(false);
        this.add(jp5);

        jp6 = new JPanel();
        jp6.add(btLogin);
        jp6.add(btRegister);
        jp6.add(btExit);
        jp6.setOpaque(false);
        this.add(jp6);


        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRegister) {
            String password1=new String(pfPassword.getPassword());
            String password2=new String(pfPassword2.getPassword());
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"The passwords you entered do not match");
                return;
            }
            String account=tfAccount.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account!=null) {
                JOptionPane.showMessageDialog(this,"Username has already registered");
                return;
            }
            String name=tfName.getText();
            String role=(String)cbRole.getSelectedItem();
            FileOpe.updateCustomer(account,password1,name,role);
            JOptionPane.showMessageDialog(this,"registration success");
        }
        else if(e.getSource()==btLogin) {
            this.dispose();
            new Login();
        }
        else {
            JOptionPane.showMessageDialog(this,"Thank you");
            System.exit(0);
        }
    }
}

