package com.view.signin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Component;

public class SignInView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JLabel lblUserId;
	private JButton btnSignIn;
	private Component lblNewToSched;
	private JButton btnSignUp;
	private JLabel lblSched;
	private JButton btnForgotPassword;
	private JRadioButton rdbtnDoctor;
	private JRadioButton rdbtnPatient;
	private JLabel lblNewLabel;
	private ButtonGroup btnGrp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInView frame = new SignInView();
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
	public SignInView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(117, 82, 118, 14);
		contentPane.add(lblPassword);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(258, 54, 86, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblUserId = new JLabel("Email ID");
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUserId.setBounds(117, 57, 101, 14);
		contentPane.add(lblUserId);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setBackground(new Color(230, 230, 250));
		btnSignIn.setForeground(new Color(0, 0, 0));
		/*btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});*/
		btnSignIn.setBounds(170, 107, 89, 23);
		contentPane.add(btnSignIn);
		
		lblNewToSched = new JLabel("New to Sched ?");
		lblNewToSched.setForeground(new Color(255, 255, 224));
		lblNewToSched.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewToSched.setBounds(117, 204, 101, 14);
		contentPane.add(lblNewToSched);
		
		btnSignUp = new JButton("Sign Up");
		/*btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUpView frame = new SignUpView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnSignUp.setBounds(228, 200, 116, 23);
		contentPane.add(btnSignUp);
		
		lblSched = new JLabel("");
		lblSched.setIcon(new ImageIcon("C:\\Users\\Nihar\\Desktop\\rsz_1sched-logo-horizontal-color (1).png"));
		lblSched.setFont(new Font("Goudy Old Style", Font.BOLD, 17));
		lblSched.setBounds(85, 11, 259, 32);
		contentPane.add(lblSched);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 79, 86, 20);
		contentPane.add(passwordField);
		
		btnForgotPassword = new JButton("Forgot password");
		btnForgotPassword.setBackground(new Color(230, 230, 250));
		btnForgotPassword.setBounds(141, 141, 157, 23);
		contentPane.add(btnForgotPassword);
		
		rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setBackground(new Color(230, 230, 250));
		rdbtnDoctor.setBounds(100, 171, 118, 23);
		contentPane.add(rdbtnDoctor);
		
		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBackground(new Color(230, 230, 250));
		rdbtnPatient.setBounds(224, 171, 120, 23);
		contentPane.add(rdbtnPatient);
		/*
		public void mousePressed(MouseEvent e) {
		if(rdbtnDoctor.isSelected())
			rdbtnPatient.setEnabled(false);
		else if(rdbtnPatient.isSelected())
			rdbtnDoctor.setEnabled(false);
		}
		*/
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_11531916-closeup-of-rough-blue-background--stock-photo.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
		
		btnGrp = new ButtonGroup();
		btnGrp.add(rdbtnDoctor);
		btnGrp.add(rdbtnPatient);
	}
	public void setSignInButtonBehavior(ActionListener listener){
		btnSignIn.addActionListener(listener);
	}
	public void setSignUpButtonBehavior(ActionListener listener){
		btnSignUp.addActionListener(listener);
	}
	public String getTxtEmail() {
		return textFieldEmail.getText();
	}
	public String getTxtPassWord() {
		return passwordField.getText();
	}
	
	public boolean getRadiobtnDoctor() {
		return rdbtnDoctor.isSelected();
	}
	
	public boolean getRadiobtnPatient() {
		return rdbtnPatient.isSelected();
	}
}
