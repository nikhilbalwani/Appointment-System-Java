package com.view.doctorview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SetScheduleView extends JFrame {

	private JPanel contentPane;
	private JCheckBox slot8am;
	private JCheckBox slot830am;
	private JCheckBox slot9am;
	private JCheckBox slot930am;
	private JCheckBox slot10am;
	private JCheckBox slot1030am;
	private JCheckBox slot11am;
	private JCheckBox slot1130am;
	private JCheckBox slot12pm;
	private JCheckBox slot1230pm;
	private JCheckBox slot1pm;
	private JCheckBox slot130pm;
	private JCheckBox slot2pm;
	private JCheckBox slot230pm;
	private JCheckBox slot3pm;
	private JCheckBox slot330pm;
	private JCheckBox slot4pm;
	private JCheckBox slot6pm;
	private JCheckBox slot5pm;
	private JCheckBox slot7pm;
	private JCheckBox slot430pm;
	private JCheckBox slot630pm;
	private JCheckBox slot530pm;
	private JCheckBox slot730pm;
	private JButton btnSaveAndExit;
	private JRadioButton rdbtnSetForWeek;
	private JRadioButton rdbtnEveryday;
	private JLabel label;
	private ButtonGroup btnGrp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetScheduleView frame = new SetScheduleView();
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
	public SetScheduleView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		slot8am = new JCheckBox("8:00 8:30 AM");
		slot8am.setBounds(6, 7, 128, 23);
		contentPane.add(slot8am);
		
		slot830am = new JCheckBox("8:30 9:00 AM");
		slot830am.setBounds(140, 7, 122, 23);
		contentPane.add(slot830am);
		
		slot9am = new JCheckBox("9:00 9:30 AM");
		slot9am.setBounds(264, 7, 119, 23);
		contentPane.add(slot9am);
		
		slot930am = new JCheckBox("9:30 10:00 AM");
		slot930am.setBounds(385, 7, 118, 23);
		contentPane.add(slot930am);
		
		slot10am = new JCheckBox("10:00 10:30 AM");
		slot10am.setBounds(6, 36, 128, 23);
		contentPane.add(slot10am);
		
		slot1030am = new JCheckBox("10:30 11:00 AM");
		slot1030am.setBounds(140, 36, 122, 23);
		contentPane.add(slot1030am);
		
		slot11am = new JCheckBox("11:00 11:30 AM");
		slot11am.setBounds(264, 36, 119, 23);
		contentPane.add(slot11am);
		
		slot1130am = new JCheckBox("11:30 12:00 PM");
		slot1130am.setBounds(385, 33, 118, 23);
		contentPane.add(slot1130am);
		
	    slot12pm = new JCheckBox("12:00 12:30 PM");
		slot12pm.setBounds(6, 62, 128, 23);
		contentPane.add(slot12pm);
		
		slot1230pm = new JCheckBox("12:30 1:00 PM");
		slot1230pm.setBounds(140, 62, 122, 23);
		contentPane.add(slot1230pm);
		
		slot1pm = new JCheckBox("1:00 1:30 PM");
		slot1pm.setBounds(264, 62, 119, 23);
		contentPane.add(slot1pm);
		
		slot130pm = new JCheckBox("1:30 2:00 PM");
		slot130pm.setBounds(385, 62, 118, 23);
		contentPane.add(slot130pm);
		
		slot2pm = new JCheckBox("2:00 2:30 PM");
		slot2pm.setBounds(6, 88, 128, 23);
		contentPane.add(slot2pm);
		
		slot230pm = new JCheckBox("2:30 3:00 PM");
		slot230pm.setBounds(140, 88, 122, 23);
		contentPane.add(slot230pm);
		
		slot3pm = new JCheckBox("3:00 3:30 PM");
		slot3pm.setBounds(264, 88, 119, 23);
		contentPane.add(slot3pm);
		
		slot330pm = new JCheckBox("3:30 4:00 PM");
		slot330pm.setBounds(385, 88, 118, 23);
		contentPane.add(slot330pm);
		
		slot4pm = new JCheckBox("4:00 4:30 PM");
		slot4pm.setBounds(6, 114, 128, 23);
		contentPane.add(slot4pm);
		
		slot6pm = new JCheckBox("6:00 6:30 PM");
		slot6pm.setBounds(6, 140, 128, 23);
		contentPane.add(slot6pm);
		
		slot5pm = new JCheckBox("5:00 5:30 PM");
		slot5pm.setBounds(264, 114, 119, 23);
		contentPane.add(slot5pm);
		
		slot7pm = new JCheckBox("7:00 7:30 PM");
		slot7pm.setBounds(264, 140, 119, 23);
		contentPane.add(slot7pm);
		
		slot430pm = new JCheckBox("4:30 5:00 PM");
		slot430pm.setBounds(140, 114, 122, 23);
		contentPane.add(slot430pm);
		
		slot630pm = new JCheckBox("6:30 7:00 PM");
		slot630pm.setBounds(140, 140, 122, 23);
		contentPane.add(slot630pm);
		
		slot530pm = new JCheckBox("5:30 6:00 PM");
		slot530pm.setBounds(385, 114, 118, 23);
		contentPane.add(slot530pm);
		
		slot730pm = new JCheckBox("7:30 8:00 PM");
		slot730pm.setBounds(385, 140, 118, 23);
		contentPane.add(slot730pm);
		
		btnSaveAndExit = new JButton("Save and Exit");
		btnSaveAndExit.setBackground(Color.WHITE);
		/*btnSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorMainScreenView frame = new DoctorMainScreenView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnSaveAndExit.setBounds(191, 228, 116, 23);
		contentPane.add(btnSaveAndExit);
		
		rdbtnSetForWeek = new JRadioButton("Week Days");
		rdbtnSetForWeek.setBounds(22, 197, 159, 23);
		contentPane.add(rdbtnSetForWeek);
		
		rdbtnEveryday = new JRadioButton("Everyday");
		rdbtnEveryday.setBounds(313, 197, 139, 23);
		contentPane.add(rdbtnEveryday);
		
		btnGrp = new ButtonGroup();
		btnGrp.add(rdbtnEveryday);
		btnGrp.add(rdbtnSetForWeek);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_35134850-vintage-background-with-retro-alarm-clock-on-table-10-30-am-good-time-of-coffee-for-healthy-stock-photo.jpg"));
		label.setBounds(0, 7, 543, 281);
		contentPane.add(label);
	}
	
	public boolean getRadiobtnEveryday() {
		return rdbtnEveryday.isSelected();
	}
	public boolean getRadiobtnWeekDays() {
		return rdbtnSetForWeek.isSelected();
	}
	public void setSaveButtonBehavior(ActionListener listener){
		btnSaveAndExit.addActionListener(listener);
	}
	public LocalTime[] getSlots() {
		ArrayList <LocalTime> slots = new ArrayList<>();
		
		if (slot8am.isSelected()) {
                    System.out.println("selected!");
			slots.add(LocalTime.of(8, 0));
		}
		
		if (slot830am.isSelected()) {
			slots.add(LocalTime.of(8, 30));
		}
		
		if (slot9am.isSelected()) {
			slots.add(LocalTime.of(9, 0));
		}
		
		if (slot930am.isSelected()) {
			slots.add(LocalTime.of(9, 30));
		}
		
		if (slot10am.isSelected()) {
			slots.add(LocalTime.of(10, 0));
		}
		

		if (slot1030am.isSelected()) {
			slots.add(LocalTime.of(10, 30));
		}
		
		if (slot11am.isSelected()) {
			slots.add(LocalTime.of(11, 0));
		}

		if (slot1130am.isSelected()) {
			slots.add(LocalTime.of(11, 30));
		}

		if (slot12pm.isSelected()) {
			slots.add(LocalTime.of(12, 0));
		}
		
		if (slot1230pm.isSelected()) {
			slots.add(LocalTime.of(12, 30));
		}
		
		if (slot1pm.isSelected()) {
			slots.add(LocalTime.of(13, 0));
		}
		
		if (slot130pm.isSelected()) {
			slots.add(LocalTime.of(13, 30));
		}
		
		if (slot2pm.isSelected()) {
			slots.add(LocalTime.of(14, 0));
		}
		
		if (slot230pm.isSelected()) {
			slots.add(LocalTime.of(14, 30));
		}
		
		if (slot3pm.isSelected()) {
			slots.add(LocalTime.of(15, 0));
		}
		
		if (slot330pm.isSelected()) {
			slots.add(LocalTime.of(15, 30));
		}
		
		if (slot4pm.isSelected()) {
			slots.add(LocalTime.of(16, 0));
		}
		
		if (slot430pm.isSelected()) {
			slots.add(LocalTime.of(16, 30));
		}
		
		if (slot5pm.isSelected()) {
			slots.add(LocalTime.of(17, 0));
		}
		
		if (slot530pm.isSelected()) {
			slots.add(LocalTime.of(17, 30));
		}
		
		if (slot6pm.isSelected()) {
			slots.add(LocalTime.of(18, 0));
		}
		
		if (slot630pm.isSelected()) {
			slots.add(LocalTime.of(18, 30));
		}
		
		if (slot7pm.isSelected()) {
			slots.add(LocalTime.of(19, 0));
		}
		
		if (slot730pm.isSelected()) {
			slots.add(LocalTime.of(19, 30));
		}
		
		
		return slots.toArray(new LocalTime[slots.size()]);
	}
}
