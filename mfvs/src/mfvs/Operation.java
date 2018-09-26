package mfvs;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Operation extends JFrame implements ActionListener {

    private JMenuBar mb = new JMenuBar();
    private JMenu menuFile = new JMenu( Conf.name);
    private JMenuItem mItemQuery = new JMenuItem("Show details");
    private JMenuItem mItemModify = new JMenuItem("change password");
    private JMenuItem mItemExit = new JMenuItem("Exit");

    public Operation() {

        this.setTitle("MFVS");
        this.setBounds(700, 400, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        menuFile.add(mItemQuery);
        menuFile.add(mItemModify);
        menuFile.add(mItemExit);

        mb.add(menuFile);

        this.add(mb,BorderLayout.NORTH);
        mItemQuery.addActionListener(this);
        mItemModify.addActionListener(this);
        mItemExit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== mItemQuery) {
            String message="Your details are:\n";
            message+="username："+Conf.account+"\n";
            message+="nickname："+Conf.name+"\n";
            message+="role："+Conf.role+"\n";
            JOptionPane.showMessageDialog(this,message);
        }
        else if(e.getSource()==mItemModify) {
            new ModifyDialog(this);
        }
        else {
            JOptionPane.showMessageDialog(this,"Thank you for using MFVS");
            System.exit(0);
        }
    }
}

