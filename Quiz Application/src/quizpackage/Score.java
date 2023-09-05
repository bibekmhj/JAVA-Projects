package quizpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,200,300,350);
        add(image);

        JLabel heading = new JLabel("Thank you " +name+ " for playing Quiz Time");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Raleway", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " +score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Raleway", Font.PLAIN, 26));
        add(lblscore);

        JButton submit =new JButton("Play Again");
        submit.setBounds(380,270,120,30);
        submit.setForeground(new Color(30,144,255));
        submit.addActionListener(this);
        add(submit);

        setBounds(400, 150,750,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
}
