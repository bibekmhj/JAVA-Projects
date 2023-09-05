package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{

    JTextField ssn, empno;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");


        JLabel additionalDetails = new JLabel("Page2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCategory[] = {"null", "< 150,000", "< 250,000", "< 500,000", "Upto 1,000,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100,290,200,30);
        add(gender);


        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100,315,200,30);
        add(email);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post Graduate", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address = new JLabel("SSN:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100,440,200,30);
        add(address);

        ssn = new JTextField();
        ssn.setFont(new Font("Raleway", Font.BOLD, 14));
        ssn.setBounds(300, 440, 400,30);
        add(ssn);

        JLabel city = new JLabel("Employee No.:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100,490,200,30);
        add(city);

        empno = new JTextField();
        empno.setFont(new Font("Raleway", Font.BOLD, 14));
        empno.setBounds(300, 490, 400,30);
        add(empno);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setForeground(Color.black);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setForeground(Color.black);
        add(sno);


        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setForeground(Color.black);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setForeground(Color.black);
        add(eno);


        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String)  category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String)  occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String sssn = ssn.getText();
        String sempno = empno.getText();


        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+sssn+"', '"+sempno+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

            //Signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception ex){
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {
        new SignupTwo("");
    }

}