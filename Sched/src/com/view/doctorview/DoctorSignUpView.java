package com.view.doctorview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorSignUpView extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldFirstName;
    private JTextField textFieldDegree;
    private JTextField textFieldExperience;
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSet;
    JComboBox comboBoxDay = new JComboBox();
    private JPasswordField passwordFieldConfirm;
    private JTextField textFieldClinicAddress;
    private JTextField textFieldClinicNumber;
    private JTextField textFieldClinicName;
    private JTextField textFieldMName;
    private JTextField textFieldLName;
    private JTextField textFieldAddress;
    private JTextField textFieldPhoneNo;
    private JLabel lblSched;
    private JLabel lblName;
    private JLabel lblGender;
    private JComboBox comboBoxGender;
    private JButton btnGetStarted;
    private JComboBox comboBoxYear;
    private JComboBox comboBoxMonth;
    private JButton btnBack;
    private JComboBox comboBoxSpecialization;
    private JComboBox comboBoxBloodGroup;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoctorSignUpView frame = new DoctorSignUpView();
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
    public DoctorSignUpView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblSched = new JLabel("");
        lblSched.setIcon(new ImageIcon("C:\\Users\\Nihar\\Desktop\\rsz_1sched-logo-horizontal-color (1).png"));
        lblSched.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 15));
        lblSched.setBounds(81, 14, 240, 37);
        contentPane.add(lblSched);

        lblName = new JLabel("First Name");
        lblName.setBounds(57, 62, 72, 14);
        contentPane.add(lblName);

        textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(198, 62, 86, 20);
        contentPane.add(textFieldFirstName);
        textFieldFirstName.setColumns(10);

        lblGender = new JLabel("gender");
        lblGender.setBounds(59, 143, 60, 14);
        contentPane.add(lblGender);

        comboBoxGender = new JComboBox();
        comboBoxGender.setBounds(200, 139, 86, 20);
        comboBoxGender.addItem("Gender");
        comboBoxGender.addItem("Male");
        comboBoxGender.addItem("Female");
        contentPane.add(comboBoxGender);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(59, 173, 86, 14);
        contentPane.add(lblAge);

        JLabel lblSpecialization = new JLabel("Specialization");
        lblSpecialization.setBounds(59, 204, 131, 14);
        contentPane.add(lblSpecialization);

        JLabel lblDegree = new JLabel("Degree");
        lblDegree.setBounds(59, 235, 97, 14);
        contentPane.add(lblDegree);

        textFieldDegree = new JTextField();
        textFieldDegree.setBounds(200, 232, 86, 20);
        contentPane.add(textFieldDegree);
        textFieldDegree.setColumns(10);

        JLabel lblExperience = new JLabel("Experience");
        lblExperience.setBounds(59, 266, 131, 14);
        contentPane.add(lblExperience);

        textFieldExperience = new JTextField();
        textFieldExperience.setBounds(200, 263, 86, 20);
        contentPane.add(textFieldExperience);
        textFieldExperience.setColumns(10);

        JLabel lblYears = new JLabel("years");
        lblYears.setBounds(312, 204, 46, 14);
        contentPane.add(lblYears);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(59, 296, 108, 14);
        contentPane.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200, 293, 86, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblSetPassword = new JLabel("Set Password");
        lblSetPassword.setBounds(59, 327, 131, 14);
        contentPane.add(lblSetPassword);

        passwordFieldSet = new JPasswordField();
        passwordFieldSet.setBounds(200, 324, 86, 20);
        contentPane.add(passwordFieldSet);

        btnGetStarted = new JButton("GET STARTED !");
        /*btnGetStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorMainScreenView frame = new DoctorMainScreenView();
				frame.setVisible(true);
				dispose();
			}
		});*/
        btnGetStarted.setBounds(150, 627, 134, 23);
        contentPane.add(btnGetStarted);

        comboBoxYear = new JComboBox();
        comboBoxYear.setBounds(200, 170, 80, 20);
        comboBoxYear.addItem("Year");
        GregorianCalendar now = new GregorianCalendar();

        for (int i = 1950; i < now.get(Calendar.YEAR) - 18; i++) {
            comboBoxYear.addItem(i);
        }

        contentPane.add(comboBoxYear);

        comboBoxMonth = new JComboBox();
        comboBoxMonth.setBounds(287, 170, 87, 20);
        comboBoxMonth.addItem("Month");
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

        comboBoxDay.setBounds(384, 170, 60, 20);
        contentPane.add(comboBoxDay);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(59, 356, 131, 14);
        contentPane.add(lblConfirmPassword);

        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setBounds(200, 355, 86, 20);
        contentPane.add(passwordFieldConfirm);

        btnBack = new JButton("Back");
        /*btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpView frame = new SignUpView();
				frame.setVisible(true);
				dispose();
			}
		});*/
        btnBack.setBounds(10, 627, 89, 23);
        contentPane.add(btnBack);

        comboBoxSpecialization = new JComboBox();
        comboBoxSpecialization.setBounds(200, 201, 102, 20);
        comboBoxSpecialization.addItem("Specialization");
        comboBoxSpecialization.addItem("Physician");
        comboBoxSpecialization.addItem("Surgeon");
        comboBoxSpecialization.addItem("Dentist");
        comboBoxSpecialization.addItem("Orthopedic");
        comboBoxSpecialization.addItem("Other");
        contentPane.add(comboBoxSpecialization);

        JLabel lblClinicAddress = new JLabel("Clinic Address");
        lblClinicAddress.setBounds(59, 387, 131, 14);
        contentPane.add(lblClinicAddress);

        textFieldClinicAddress = new JTextField();
        textFieldClinicAddress.setBounds(198, 386, 165, 38);
        contentPane.add(textFieldClinicAddress);
        textFieldClinicAddress.setColumns(10);

        JLabel lblClinicPhoneNumber = new JLabel("Clinic Phone No");
        lblClinicPhoneNumber.setBounds(59, 433, 131, 14);
        contentPane.add(lblClinicPhoneNumber);

        textFieldClinicNumber = new JTextField();
        textFieldClinicNumber.setBounds(200, 435, 86, 20);
        contentPane.add(textFieldClinicNumber);
        textFieldClinicNumber.setColumns(10);

        JLabel lblClinicName = new JLabel("Clinic Name");
        lblClinicName.setBounds(57, 469, 131, 14);
        contentPane.add(lblClinicName);

        textFieldClinicName = new JTextField();
        textFieldClinicName.setBounds(200, 466, 86, 20);
        contentPane.add(textFieldClinicName);
        textFieldClinicName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(25, 30, 46, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblMiddleName = new JLabel("Middle Name");
        lblMiddleName.setBounds(57, 87, 133, 14);
        contentPane.add(lblMiddleName);

        textFieldMName = new JTextField();
        textFieldMName.setBounds(198, 84, 86, 20);
        contentPane.add(textFieldMName);
        textFieldMName.setColumns(10);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(57, 112, 133, 14);
        contentPane.add(lblLastName);

        textFieldLName = new JTextField();
        textFieldLName.setBounds(198, 108, 86, 20);
        contentPane.add(textFieldLName);
        textFieldLName.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(57, 502, 120, 14);
        contentPane.add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(198, 499, 163, 37);
        contentPane.add(textFieldAddress);
        textFieldAddress.setColumns(10);

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(57, 555, 133, 14);
        contentPane.add(lblPhoneNumber);

        textFieldPhoneNo = new JTextField();
        textFieldPhoneNo.setBounds(200, 552, 86, 20);
        contentPane.add(textFieldPhoneNo);
        textFieldPhoneNo.setColumns(10);

        JLabel lblBloodGroup = new JLabel("Blood Group");
        lblBloodGroup.setBounds(57, 593, 133, 14);
        contentPane.add(lblBloodGroup);

        comboBoxBloodGroup = new JComboBox();
        comboBoxBloodGroup.addItem("Blood Group");
        comboBoxBloodGroup.addItem("A+");
        comboBoxBloodGroup.addItem("A-");
        comboBoxBloodGroup.addItem("B+");
        comboBoxBloodGroup.addItem("B-");
        comboBoxBloodGroup.addItem("AB+");
        comboBoxBloodGroup.addItem("AB-");
        comboBoxBloodGroup.addItem("O+");
        comboBoxBloodGroup.addItem("O-");
        comboBoxBloodGroup.setBounds(198, 596, 86, 20);
        contentPane.add(comboBoxBloodGroup);
        if (!passwordFieldSet.equals(passwordFieldConfirm)) {

        }
    }

    public String getTxtFName() {
        return textFieldFirstName.getText();
    }

    public String getTxtMName() {
        return textFieldMName.getText();
    }

    public String getTxtLName() {
        return textFieldLName.getText();
    }

    public String getTxtDegree() {
        return textFieldDegree.getText();
    }

    public int getTxtExperience() {
        return Integer.parseInt(textFieldExperience.getText());
    }

    public String getTxtEmail() {
        return textFieldEmail.getText();
    }

    public String getTxtClinicAddress() {
        return textFieldClinicAddress.getText();
    }

    public String getTxtClinicName() {
        return textFieldClinicName.getText();
    }

    public String getTxtClinicNumber() {
        return textFieldClinicNumber.getText();
    }

    public String getTxtAddress() {
        return textFieldAddress.getText();
    }

    public String getTxtPhoneNumber() {
        return textFieldPhoneNo.getText();
    }

    public String getPassword() {
        return passwordFieldSet.getText();
    }

    public char[] getTxtConfirmPassWord() {
        return passwordFieldConfirm.getPassword();
    }

    public String getYear() {
        return comboBoxYear.getSelectedItem().toString();
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

    public String getDay() {
        return comboBoxDay.getSelectedItem().toString();
    }

    public String getGender() {
        return comboBoxGender.getSelectedItem().toString();
    }

    public String getBloodGroup() {
        return comboBoxBloodGroup.getSelectedItem().toString();
    }

    public String getSpecialization() {
        return comboBoxSpecialization.getSelectedItem().toString();
    }

    public void setBackButtonBehavior(ActionListener listener) {
        btnBack.addActionListener(listener);
    }

    public void setGetStartedButtonBehavior(ActionListener listener) {
        btnGetStarted.addActionListener(listener);
    }
}
