package com.view.signup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class SignUpView extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogo;
	private Component lblAreYou;
	private JButton btnPatient;
	private JButton btnDoctor;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Nihar\\Desktop\\rsz_1sched-logo-horizontal-color (1).png"));
		lblLogo.setBounds(80, 24, 240, 34);
		contentPane.add(lblLogo);
		
	    lblAreYou = new JLabel("Are You ?");
		lblAreYou.setForeground(new Color(0, 0, 0));
		lblAreYou.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAreYou.setBounds(91, 81, 106, 23);
		contentPane.add(lblAreYou);
		
	    btnDoctor = new JButton("Doctor");
		/*btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorSignUpView frame = new DoctorSignUpView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnDoctor.setBounds(168, 115, 111, 34);
		contentPane.add(btnDoctor);
		
	    btnPatient = new JButton("Patient");
		
		/*btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientSignUpView frame = new PatientSignUpView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnPatient.setBounds(168, 160, 111, 34);
		contentPane.add(btnPatient);
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_11531916-closeup-of-rough-blue-background--stock-photo.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
	public void setPatientButtonBehavior(ActionListener listener){
		btnPatient.addActionListener(listener);
	}
	public void setDoctorButtonBehavior(ActionListener listener){
		btnDoctor.addActionListener(listener);
	}

}
