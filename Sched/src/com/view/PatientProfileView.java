package com.view;

import com.view.patientview.PatientMainScreenView;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientProfileView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldEmail;
	private JTextField textFieldGender;
	private JTextField textFieldBloodGroup;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblEmailAddress;
	private JLabel lblGender;
	private JLabel lblBloodGroup;
	private JLabel lblHistory;
	private JLabel lblNewLabel;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientProfileView frame = new PatientProfileView();
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
	public PatientProfileView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(55, 35, 113, 14);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(219, 32, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(55, 77, 136, 14);
		contentPane.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(219, 74, 86, 20);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAddress.setBounds(55, 121, 154, 14);
		contentPane.add(lblEmailAddress);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(219, 118, 86, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(55, 168, 136, 14);
		contentPane.add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setBounds(219, 165, 86, 20);
		contentPane.add(textFieldGender);
		textFieldGender.setColumns(10);
		
		lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloodGroup.setBounds(55, 211, 136, 14);
		contentPane.add(lblBloodGroup);
		
		textFieldBloodGroup = new JTextField();
		textFieldBloodGroup.setBounds(219, 208, 86, 20);
		contentPane.add(textFieldBloodGroup);
		textFieldBloodGroup.setColumns(10);
		
		lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHistory.setBounds(55, 256, 113, 14);
		contentPane.add(lblHistory);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(179, 256, 46, 14);
		contentPane.add(lblNewLabel);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientMainScreenView frame = new PatientMainScreenView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 277, 89, 23);
		contentPane.add(btnBack);
	}
	public void setBackButtonBehavior(ActionListener listener){
		btnBack.addActionListener(listener);
	}
	public String getTxtEmail() {
		return textFieldEmail.getText();
	}
	public String getTxtName() {
		return textFieldName.getText();
	}
	public String getTxtAge() {
		return textFieldAge.getText();
	}
	public String getTxtGender() {
		return textFieldGender.getText();
	}
	public String getTxtBloodGroup() {
		return textFieldBloodGroup.getText();
	}
}
