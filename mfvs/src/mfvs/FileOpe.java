package mfvs;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class FileOpe {
    private static String fileName = "D:\\MFVS\\mfvs\\src\\user.inc";
    private static Properties pps;
    static {
        pps=new Properties();
        FileReader reader=null;
        try {
            reader= new FileReader(fileName);
            pps.load(reader);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"File operation is abnormal");
            System.out.println(ex.toString());
            System.exit(0);
        }
        finally {
            try {
                reader.close();
            }
            catch (Exception ex) {}
        }
    }
    private static void listInfo() {
        PrintStream ps=null;
        try {
            ps=new PrintStream(fileName);
            pps.list(ps);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"File operation is abnormal");
            System.exit(0);
        }
        finally {
            try {
                ps.close();
            }
            catch (Exception ex) {}
        }
    }
    public static void getInfoByAccount(String account) {
        String cusInfo=pps.getProperty(account);
        if(cusInfo!=null) {
            String[] infos=cusInfo.split("#");
            Conf.account=account;
            Conf.password=infos[0];
            Conf.name=infos[1];
            Conf.role=infos[2];
        }
    }
    public static void updateCustomer(String account,String password,
                                      String name,String role) {
        pps.setProperty(account,password+"#"+name+"#"+ role);
        listInfo();
    }
}

