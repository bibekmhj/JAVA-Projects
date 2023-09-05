package quizpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;
    Login(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading = new JLabel("Quiz Time!");
        heading.setBounds(790,60,300,45);
        heading.setFont(new Font("SERIF", Font.BOLD, 40));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(820,150,300,20);
        name.setFont(new Font("SERIF", Font.BOLD, 18));
        name.setForeground(new Color(30,144,254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        rules = new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setForeground(new Color(30,144,254));
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setForeground(new Color(30,144,254));
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(150,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules){
            String name = tfname.getText();

            setVisible(false);
            new Rules(name);
        } else {
            setVisible(false);
        }
    }
}
