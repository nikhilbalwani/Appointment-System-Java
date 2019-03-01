package com.view.patientview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PatientSignUpView extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldFirstName;
    private JPasswordField passwordFieldSet;
    private JTextField textFieldEmail;
    JComboBox comboBoxDay = new JComboBox();
    private JPasswordField passwordFieldConfirm;
    private JTextField textFieldAddress;
    private JTextField textFieldPhoneNumber;
    private JLabel lblEnterFirstName;
    private JLabel lblEnterAge;
    private JLabel lblSetPassword;
    private JButton btnSignUp;
    private JLabel lblEmail;
    private JLabel lblGender;
    private JLabel lblSched;
    private JComboBox comboBoxGender;
    private JLabel lblBloodGroup;
    private JButton btnBack;
    private JComboBox comboBoxYear;
    private JComboBox comboBoxMonth;
    private JLabel lblConfirmPassword;
    private JLabel lblAddress;
    private JLabel lblPhoneNumber;
    private JComboBox comboBoxBloodGroup;
    private JTextField textFieldLastName;
    private JTextField textFieldMiddleName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PatientSignUpView frame = new PatientSignUpView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PatientSignUpView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 490, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblEnterFirstName = new JLabel("First Name");
        lblEnterFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEnterFirstName.setBounds(61, 53, 130, 14);
        contentPane.add(lblEnterFirstName);

        textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(238, 50, 86, 20);
        contentPane.add(textFieldFirstName);
        textFieldFirstName.setColumns(10);

        lblEnterAge = new JLabel("Enter Age");
        lblEnterAge.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEnterAge.setBounds(61, 164, 149, 14);
        contentPane.add(lblEnterAge);

        lblSetPassword = new JLabel("Set Password");
        lblSetPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSetPassword.setBounds(61, 192, 149, 14);
        contentPane.add(lblSetPassword);

        passwordFieldSet = new JPasswordField();
        passwordFieldSet.setBounds(238, 189, 86, 20);
        contentPane.add(passwordFieldSet);

        btnSignUp = new JButton("Sign Up");
        /*btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatientMainScreenView frame = new PatientMainScreenView();
				frame.setVisible(true);
				dispose();
			}
		});*/
        btnSignUp.setBounds(163, 427, 103, 23);
        contentPane.add(btnSignUp);

        lblEmail = new JLabel("Email Address");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmail.setForeground(new Color(0, 0, 0));
        lblEmail.setBounds(61, 253, 130, 14);
        contentPane.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(238, 250, 86, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        lblGender = new JLabel("Gender");
        lblGender.setBackground(Color.WHITE);
        lblGender.setForeground(Color.BLACK);
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGender.setBounds(61, 281, 149, 14);
        contentPane.add(lblGender);

        lblSched = new JLabel("");
        lblSched.setIcon(new ImageIcon("C:\\Users\\Nihar\\Desktop\\rsz_1sched-logo-horizontal-color (1).png"));
        lblSched.setFont(new Font("Lucida Handwriting", Font.BOLD, 29));
        lblSched.setBounds(82, 1, 236, 41);
        contentPane.add(lblSched);

        comboBoxGender = new JComboBox();
        comboBoxGender.addItem("Male");
        comboBoxGender.addItem("Female");

        comboBoxGender.setBounds(238, 275, 86, 20);
        contentPane.add(comboBoxGender);

        lblBloodGroup = new JLabel("Blood group");
        lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBloodGroup.setForeground(Color.BLACK);
        lblBloodGroup.setBounds(61, 309, 130, 14);
        contentPane.add(lblBloodGroup);

        comboBoxBloodGroup = new JComboBox();
        comboBoxBloodGroup.addItem("A+");
        comboBoxBloodGroup.addItem("A-");
        comboBoxBloodGroup.addItem("B+");
        comboBoxBloodGroup.addItem("B-");
        comboBoxBloodGroup.addItem("AB+");
        comboBoxBloodGroup.addItem("AB-");
        comboBoxBloodGroup.addItem("O+");
        comboBoxBloodGroup.addItem("O-");
        comboBoxBloodGroup.setBounds(238, 306, 59, 20);
        contentPane.add(comboBoxBloodGroup);

        btnBack = new JButton("Back");
        /*btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpView frame = new SignUpView();
				frame.setVisible(true);
				dispose();
			}
		});*/
        btnBack.setBounds(20, 427, 103, 23);
        contentPane.add(btnBack);

        comboBoxYear = new JComboBox();

        GregorianCalendar now = new GregorianCalendar();

        comboBoxYear.setBounds(238, 161, 80, 20);
        for (int i = 1950; i < now.get(Calendar.YEAR) - 18; i++) {
            comboBoxYear.addItem(i);
        }

        contentPane.add(comboBoxYear);

        comboBoxMonth = new JComboBox();
        comboBoxMonth.setBounds(324, 161, 86, 20);
        comboBoxMonth.addItem("January");
        comboBoxMonth.addItem("February");
        comboBoxMonth.addItem("March");
        comboBoxMonth.addItem("April");
        comboBoxMonth.addItem("May");
        comboBoxMonth.addItem("June");
        comboBoxMonth.addItem("July");
        comboBoxMonth.addItem("August");
        comboBoxMonth.addItem("September");
        comboBoxMonth.addItem("October");
        comboBoxMonth.addItem("November");
        comboBoxMonth.addItem("December");

        comboBoxMonth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Object item = event.getItem();

                    String stringItemSelected = comboBoxMonth.getSelectedItem().toString();

                    if (stringItemSelected.equals("January") || stringItemSelected.equals("March") || stringItemSelected.equals("May") || stringItemSelected.equals("July") || stringItemSelected.equals("August") || stringItemSelected.equals("October") || stringItemSelected.equals("October")) {
                        comboBoxDay.removeAllItems();
                        for (int i = 1; i <= 31; i++) {
                            comboBoxDay.addItem(i);
                        }
                    } else if (stringItemSelected.equals("February")) {
                        comboBoxDay.removeAllItems();
                        for (int i = 1; i <= 28; i++) {
                            comboBoxDay.addItem(i);
                        }
                    } else {
                        comboBoxDay.removeAllItems();
                        for (int i = 1; i <= 30; i++) {
                            comboBoxDay.addItem(i);
                        }
                    }
                }
            }
        });

        contentPane.add(comboBoxMonth);

        comboBoxDay.setBounds(419, 161, 55, 20);
        contentPane.add(comboBoxDay);

        lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblConfirmPassword.setBounds(61, 220, 149, 14);
        contentPane.add(lblConfirmPassword);

        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setBounds(238, 217, 86, 20);
        contentPane.add(passwordFieldConfirm);

        lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAddress.setBounds(61, 364, 130, 14);
        contentPane.add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(238, 337, 172, 41);
        contentPane.add(textFieldAddress);
        textFieldAddress.setColumns(10);

        lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPhoneNumber.setBounds(61, 389, 130, 14);
        contentPane.add(lblPhoneNumber);

        textFieldPhoneNumber = new JTextField();
        textFieldPhoneNumber.setBounds(238, 386, 86, 20);
        contentPane.add(textFieldPhoneNumber);
        textFieldPhoneNumber.setColumns(10);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblLastName.setBounds(61, 123, 130, 14);
        contentPane.add(lblLastName);

        JLabel lblMiddleName = new JLabel("Middle Name");
        lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMiddleName.setBounds(61, 84, 130, 14);
        contentPane.add(lblMiddleName);

        textFieldLastName = new JTextField();
        textFieldLastName.setBounds(238, 120, 86, 20);
        contentPane.add(textFieldLastName);
        textFieldLastName.setColumns(10);

        textFieldMiddleName = new JTextField();
        textFieldMiddleName.setBounds(238, 81, 86, 20);
        contentPane.add(textFieldMiddleName);
        textFieldMiddleName.setColumns(10);

        /*JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_1logo.png"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);*/
    }

    public void setBackButtonBehavior(ActionListener listener) {
        btnBack.addActionListener(listener);
    }

    public void setSignUpButtonBehavior(ActionListener listener) {
        btnSignUp.addActionListener(listener);
    }

    public String getTxtEmail() {
        return textFieldEmail.getText();
    }

    public String getFName() {
        return textFieldFirstName.getText();
    }

    public String getMName() {
        return textFieldMiddleName.getText();
    }

    public String getLName() {
        return textFieldLastName.getText();
    }

    public String getTxtPhoneNumber() {
        return textFieldPhoneNumber.getText();
    }

    public String getTxtAddress() {
        return textFieldAddress.getText();
    }

    public String getTxtSetPassWord() {
        return passwordFieldSet.getText();
    }

    public char[] getTxtConfirmPassWord() {
        return passwordFieldConfirm.getPassword();
    }

    public int getYear() {
        return Integer.parseInt(comboBoxYear.getSelectedItem().toString());
    }

    public int getMonth() {
        String month = comboBoxMonth.getSelectedItem().toString();
        
        if (month.equals("January"))
            return 1;
        
        if (month.equals("Februrary"))
            return 2;
        
        if (month.equals("March"))
            return 3;
        
        if (month.equals("April"))
            return 4;
        
        if (month.equals("May"))
            return 5;
        
        if (month.equals("June"))
            return 6;
        
        if (month.equals("July"))
            return 7;
        
        if (month.equals("August"))
            return 8;
        
        if (month.equals("September"))
            return 9;
        
        if (month.equals("October"))
            return 10;
        
        if (month.equals("November"))
            return 11;
        
        if (month.equals("December"))
            return 12;
        
        return 0;
    }

    public int getDay() {
        return Integer.parseInt(comboBoxDay.getSelectedItem().toString());
    }

    public String getCombobxGender() {
        return comboBoxGender.getSelectedItem().toString();
    }

    public String getCombobxBloodGroup() {
        return comboBoxBloodGroup.getSelectedItem().toString();
    }
}
