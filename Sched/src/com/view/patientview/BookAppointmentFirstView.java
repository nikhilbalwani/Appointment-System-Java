package com.view.patientview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class BookAppointmentFirstView extends JFrame {

	private JPanel contentPane;
	private JLabel lblWhichDoctorAre;
	private JButton btnPhysician;
	private JButton btnSurgeon;
	private JButton btnDentist;
	private JButton btnOrthopedic;
	private JButton btnOther;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAppointmentFirstView frame = new BookAppointmentFirstView();
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
	public BookAppointmentFirstView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWhichDoctorAre = new JLabel("Which doctor are you looking for ?");
		lblWhichDoctorAre.setForeground(new Color(0, 0, 0));
		lblWhichDoctorAre.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblWhichDoctorAre.setBounds(88, 0, 290, 32);
		contentPane.add(lblWhichDoctorAre);
		
		btnPhysician = new JButton("Physician");
		btnPhysician.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPhysician.setBounds(161, 85, 133, 23);
		contentPane.add(btnPhysician);
		
		btnSurgeon = new JButton("Surgeon");
		btnSurgeon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSurgeon.setBounds(161, 119, 133, 23);
		contentPane.add(btnSurgeon);
		
		btnDentist = new JButton("Dentist");
		btnDentist.setFont(new Font("Tahoma", Font.BOLD, 11));
		/*btnDentist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnDentist.setBounds(161, 153, 133, 23);
		contentPane.add(btnDentist);
		
		btnOrthopedic = new JButton("Orthopedic");
		btnOrthopedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrthopedic.setBounds(161, 185, 133, 23);
		contentPane.add(btnOrthopedic);
		
		btnOther = new JButton("Other");
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOther.setBounds(161, 219, 133, 23);
		contentPane.add(btnOther);
		
		btnBack = new JButton("Back");
		/*btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientMainScreenView frame = new PatientMainScreenView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnBack.setBounds(23, 254, 96, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_me7398105-animated-character-doctor-says-green-background-hd-a0025.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 288);
		contentPane.add(lblNewLabel);
	}
	public void setPhysicianButtonBehavior(ActionListener listener){
		btnPhysician.addActionListener(listener);
	}
	public void setSurgeonButtonBehavior(ActionListener listener){
		btnSurgeon.addActionListener(listener);
	}
	public void setDentistButtonBehavior(ActionListener listener){
		btnDentist.addActionListener(listener);
	}
	public void setOrthopedicButtonBehavior(ActionListener listener){
		btnOrthopedic.addActionListener(listener);
	}
	public void setOtherButtonBehavior(ActionListener listener){
		btnOther.addActionListener(listener);
	}
	public void setBackButtonBehavior(ActionListener listener){
		btnBack.addActionListener(listener);
	}

}
