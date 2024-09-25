package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;



    Login(){

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(50,40,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(50,80,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(160,40,150,30);
        textField.setFont(new Font("Tahoma",Font.BOLD,16));
        textField.setBackground(new Color(209, 200, 173));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(160,80,150,30);
        jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(209,200,173));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/hospital1.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(350,340,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(360,-40,400,300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        add(b2);


        getContentPane().setBackground(new Color(138,138,145));
        setSize(750,300 );
        setLocation(400,270 );
        setLayout(null);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
                conn c = new conn();
                String user = textField.getText();
                String Pass  = jPasswordField.getText();

                String q = "select* from login where ID = '"+user+"' and  PW = '"+Pass+"'";
                ResultSet resultSet =  c.statement.executeQuery(q);

                if (resultSet.next()){
                    new Reception();
                    setVisible(false);

                }else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            } catch (SQLException E) {
                E.printStackTrace();

            }

        }else {
            System.exit(10);

        }

    }
}
