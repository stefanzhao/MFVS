package mfvs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ModifyDialog extends JFrame implements ActionListener  {

    private JPanel jp1,jp2,jp3,jp4,jp5;

    private JLabel lbMsg=new JLabel("Username：");
    private JLabel lbAccount=new JLabel(Conf.account);


    private JLabel lbPassword=new JLabel("Please enter your password  ");
    private JPasswordField pfPassword=new JPasswordField(Conf.password,20);

    private JLabel lbPassword2=new JLabel("Please confirm your password");
    private JPasswordField pfPassword2=new JPasswordField(Conf.password,20);

    private JButton btModify=new JButton("Modify");
    private JButton btExit=new JButton("Exit");


    public ModifyDialog(JFrame frm) {

        this.setTitle("change password");
        this.setSize(500, 450);
        this.setLocation(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);


        this.setLayout(new GridLayout(5,1,20,8));

        jp5 = new JPanel();
        jp5.setOpaque(false);
        this.add(jp5);

        jp1 = new JPanel();
        jp1.add(lbMsg);
        jp1.add(lbAccount);
        lbMsg.setFont(new java.awt.Font("Dialog",   1,   20));
        lbAccount.setFont(new java.awt.Font("Dialog",   1,   20));
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
        jp4.add(btModify);
        jp4.add(btExit);
        jp4.setOpaque(false);
        this.add(jp4);




        btModify.addActionListener(this);
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btModify) {
            String password1=new String(pfPassword.getPassword());
            String password2=new String(pfPassword2.getPassword());
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"The passwords you entered do not match.");
                return;
            }

            Conf.password=password1;
            FileOpe.updateCustomer(Conf.account,password1,Conf.name,Conf.role);
            JOptionPane.showMessageDialog(this,"Successfully modified");
        }
        else {
            this.dispose();
        }
    }
}

