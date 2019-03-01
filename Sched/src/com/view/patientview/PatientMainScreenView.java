package com.view.patientview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class PatientMainScreenView extends JFrame {

	private JPanel contentPane;
	private JButton btnBookAppointment;
	private AbstractButton btnReminder;
	private JButton btnMyProfile;
	private JButton btnBack;
	private JLabel label;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientMainScreenView frame = new PatientMainScreenView();
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
	public PatientMainScreenView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBookAppointment = new JButton("");
		/*btnBookAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAppointmentFirstView frame = new BookAppointmentFirstView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnBookAppointment.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_doctor_appointment-512.png"));
		btnBookAppointment.setBounds(151, 87, 106, 113);
		contentPane.add(btnBookAppointment);
		
		btnReminder = new JButton("");
		/*btnReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReminderView frame = new ReminderView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnReminder.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_reminder.png"));
		btnReminder.setBounds(25, 87, 96, 113);
		contentPane.add(btnReminder);
		
		btnMyProfile = new JButton("");
		/*btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientProfileView frame = new PatientProfileView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnMyProfile.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_no_photo.png"));
		btnMyProfile.setBounds(300, 87, 106, 113);
		contentPane.add(btnMyProfile);
		
		btnBack = new JButton("Log Out");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		/*btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignInView frame = new SignInView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnBack.setBounds(303, 251, 89, 23);
		contentPane.add(btnBack);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nihar\\Desktop\\rsz_1sched-logo-horizontal-color (1).png"));
		label.setBounds(95, 27, 240, 35);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_11531916-closeup-of-rough-blue-background--stock-photo.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 308);
		contentPane.add(lblNewLabel);
	}
	public void setBookAppointmentButtonBehavior(ActionListener listener){
		btnBookAppointment.addActionListener(listener);
	}
	public void setReminderButtonBehavior(ActionListener listener){
		btnReminder.addActionListener(listener);
	}
	public void setMyProfileButtonBehavior(ActionListener listener){
		btnMyProfile.addActionListener(listener);
	}
	public void setBackButtonBehavior(ActionListener listener){
		btnBack.addActionListener(listener);
	}
}
