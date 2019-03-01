package com.view.doctorview;

import com.model.user.doctor.Doctor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorMainScreenView extends JFrame {

	private JPanel contentPane;
	private JButton btnViewAppointments;
	private JButton btnSetSchedule;
	private JButton btnLogOut;
	private JButton btnEditSchedule;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorMainScreenView frame = new DoctorMainScreenView();
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
	public DoctorMainScreenView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnViewAppointments = new JButton("View Appointments");
		btnViewAppointments.setBounds(144, 117, 167, 23);
		contentPane.add(btnViewAppointments);
		
		btnSetSchedule = new JButton("Set Schedule");
		/*btnSetSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetScheduleView frame = new SetScheduleView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnSetSchedule.setBounds(144, 83, 167, 23);
		contentPane.add(btnSetSchedule);
		
		btnLogOut = new JButton("Log Out");
		/*btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignInView frame = new SignInView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnLogOut.setBounds(178, 227, 89, 23);
		contentPane.add(btnLogOut);
		
		btnEditSchedule = new JButton("Edit Schedule");
		/*btnEditSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetScheduleView frame = new SetScheduleView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnEditSchedule.setBounds(144, 49, 167, 23);
		contentPane.add(btnEditSchedule);
	} 
	public void setEditScheduleButtonBehavior(ActionListener listener){
		btnEditSchedule.addActionListener(listener);
	}
	public void setSetScheduleButtonBehavior(ActionListener listener){
		btnSetSchedule.addActionListener(listener);
	}
	public void setViewAppointmentsButtonBehavior(ActionListener listener){
		btnViewAppointments.addActionListener(listener);
	}
	public void setLogOutButtonBehavior(ActionListener listener){
		btnLogOut.addActionListener(listener);
	}
}
