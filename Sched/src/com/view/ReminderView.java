package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;

public class ReminderView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMedicineName;
	private JTextField textFieldDosage;
	private JLabel lblSetYourMedicine;
	private JLabel lblAddYourMedicine;
	private JLabel lblMedicineName;
	private JLabel label;
	private JLabel lblDosage;
	private JLabel lblTimings;
	private JComboBox comboBoxMorning;
	private JComboBox comboBoxAfternoon;
	private JComboBox comboBoxNight;
	private JLabel lblMorning;
	private Container lblAfternoon;
	private JLabel lblNight;
	private JLabel lblDaysPerWeek;
	private JCheckBox chckbxMonday;
	private JCheckBox chckbxTeusday;
	private JCheckBox chckbxWesnesday;
	private JCheckBox chckbxThursday;
	private JCheckBox chckbxFriday;
	private JCheckBox chckbxSaturday;
	private JCheckBox chckbxSunday;
	private JButton btnSaveChanges;
	private JLabel lblNewLabel;
	private JButton btnAddAnother;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReminderView frame = new ReminderView();
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
	public ReminderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSetYourMedicine = new JLabel("Set your medicine reminder :");
		lblSetYourMedicine.setFont(new Font("Segoe Script", Font.BOLD, 19));
		lblSetYourMedicine.setBounds(60, 11, 313, 29);
		contentPane.add(lblSetYourMedicine);
		
		lblAddYourMedicine = new JLabel("Add your medicine :");
		lblAddYourMedicine.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAddYourMedicine.setBounds(26, 51, 162, 21);
		contentPane.add(lblAddYourMedicine);
		
		lblMedicineName = new JLabel("Medicine Name:");
		lblMedicineName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMedicineName.setBounds(88, 98, 150, 14);
		contentPane.add(lblMedicineName);
		
		textFieldMedicineName = new JTextField();
		textFieldMedicineName.setBounds(269, 95, 104, 21);
		contentPane.add(textFieldMedicineName);
		textFieldMedicineName.setColumns(10);
		
		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(88, 158, 139, 14);
		contentPane.add(label);
		
		lblDosage = new JLabel("Dosage:");
		lblDosage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDosage.setBounds(88, 126, 150, 14);
		contentPane.add(lblDosage);
		
		lblTimings = new JLabel("Timings");
		lblTimings.setBounds(88, 158, 104, 14);
		contentPane.add(lblTimings);
		
		textFieldDosage = new JTextField();
		textFieldDosage.setColumns(10);
		textFieldDosage.setBounds(269, 123, 104, 21);
		contentPane.add(textFieldDosage);
		
		comboBoxMorning = new JComboBox();
		comboBoxMorning.setBounds(237, 158, 63, 20);
		comboBoxMorning.addItem("XXXXX");
		comboBoxMorning.addItem("6:00 am");
		comboBoxMorning.addItem("6:30 am");
		comboBoxMorning.addItem("7:00 am");
		comboBoxMorning.addItem("7:30 am");
		comboBoxMorning.addItem("8:00 am");
		comboBoxMorning.addItem("8:30 am");
		comboBoxMorning.addItem("9:00 am");
		comboBoxMorning.addItem("9:30 am");
		comboBoxMorning.addItem("10:00 am");
		comboBoxMorning.addItem("10:30 am");
		comboBoxMorning.addItem("11:00 am");
		comboBoxMorning.addItem("11:30 am");
				
		contentPane.add(comboBoxMorning);
		
		comboBoxAfternoon = new JComboBox();
		comboBoxAfternoon.setBounds(310, 158, 63, 20);
		comboBoxAfternoon.addItem("XXXXX");
		comboBoxAfternoon.addItem("12:00 pm");
		comboBoxAfternoon.addItem("12:30 pm");
		comboBoxAfternoon.addItem("1:00 pm");
		comboBoxAfternoon.addItem("1:30 pm");
		comboBoxAfternoon.addItem("2:00 pm");
		comboBoxAfternoon.addItem("2:30 pm");
		comboBoxAfternoon.addItem("3:00 pm");
		comboBoxAfternoon.addItem("3:30 pm");
		comboBoxAfternoon.addItem("4:00 pm");
		comboBoxAfternoon.addItem("4:30 pm");
		comboBoxAfternoon.addItem("5:00 pm");
		comboBoxAfternoon.addItem("5:30 pm");
		
		contentPane.add(comboBoxAfternoon);
		
		comboBoxNight = new JComboBox();
		comboBoxNight.setBounds(383, 158, 82, 20);
		comboBoxNight.addItem("XXXXX");
		comboBoxNight.addItem("6:00 pm");
		comboBoxNight.addItem("6:30 pm");
		comboBoxNight.addItem("7:00 pm");
		comboBoxNight.addItem("7:30 pm");
		comboBoxNight.addItem("8:00 pm");
		
		comboBoxNight.addItem("8:30 pm");
		comboBoxNight.addItem("9:00 pm");
		comboBoxNight.addItem("9:30 pm");
		comboBoxNight.addItem("10:00 pm");
		comboBoxNight.addItem("10:30 pm");
		comboBoxNight.addItem("11:00 pm");
		comboBoxNight.addItem("11:30 pm");
		comboBoxNight.addItem("12:00 am");
		comboBoxNight.addItem("12:30 am");
		contentPane.add(comboBoxNight);
		
		lblMorning = new JLabel("morning");
		lblMorning.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMorning.setBounds(237, 178, 67, 14);
		contentPane.add(lblMorning);
		
		lblAfternoon = new JLabel("afternoon");
		lblAfternoon.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAfternoon.setBounds(314, 178, 75, 14);
		contentPane.add(lblAfternoon);
		
		lblNight = new JLabel("night");
		lblNight.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNight.setForeground(new Color(0, 0, 0));
		lblNight.setBounds(393, 178, 82, 14);
		contentPane.add(lblNight);
		
		lblDaysPerWeek = new JLabel("Days per week:");
		lblDaysPerWeek.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDaysPerWeek.setBounds(75, 212, 140, 14);
		contentPane.add(lblDaysPerWeek);
		
		chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(206, 208, 97, 23);
		contentPane.add(chckbxMonday);
		
		chckbxTeusday = new JCheckBox("Tuesday");
		chckbxTeusday.setBounds(206, 234, 97, 23);
		contentPane.add(chckbxTeusday);
		
		chckbxWesnesday = new JCheckBox("Wednesday");
		chckbxWesnesday.setBounds(207, 260, 97, 23);
		contentPane.add(chckbxWesnesday);
		
		chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(206, 286, 97, 23);
		contentPane.add(chckbxThursday);
		
		chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(319, 210, 97, 23);
		contentPane.add(chckbxFriday);
		
		chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(319, 234, 97, 23);
		contentPane.add(chckbxSaturday);
		
		chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(319, 260, 97, 23);
		contentPane.add(chckbxSunday);
		
		btnAddAnother = new JButton("Add another reminder");
		/*btnAddAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReminderView frame = new ReminderView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnAddAnother.setBounds(223, 328, 242, 23);
		contentPane.add(btnAddAnother);
		
		btnSaveChanges = new JButton("Save your changes");
		/*btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientMainScreenView frame = new PatientMainScreenView();
				frame.setVisible(true);
				dispose();
			}
		});*/
		btnSaveChanges.setBounds(223, 362, 242, 23);
		contentPane.add(btnSaveChanges);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nihar\\Downloads\\rsz_shutterstock_medicine_tablets.jpg"));
		lblNewLabel.setBounds(10, 0, 521, 399);
		contentPane.add(lblNewLabel);
	}
	public void setAddAnotherButtonBehavior(ActionListener listener){
		btnAddAnother.addActionListener(listener);
	}
	public void setSaveChangesButtonBehavior(ActionListener listener){
		btnSaveChanges.addActionListener(listener);
	}
	public boolean getCheckbxMonday(){
		return chckbxMonday.isSelected();
	}
	public boolean getCheckbxTuesday(){
		return chckbxTeusday.isSelected();
	}
	public String getTextFieldMedicineName() {
		return textFieldMedicineName.getText();
	}
	
	public String getTextFieldDosage() {
		return textFieldDosage.getText();
	}
	
	public boolean getCheckbxWednesday(){
		return chckbxWesnesday.isSelected();
	}
	public boolean getCheckbxThursday(){
		return chckbxThursday.isSelected();
	}
	public boolean getCheckbxFriday(){
		return chckbxFriday.isSelected();
	}
	public boolean getCheckbxSaturday(){
		return chckbxSaturday.isSelected();
	}
	public boolean getCheckbxSunday(){
		return chckbxSunday.isSelected();
	}
	
	public LocalTime getMorningTimings() {
		
		String selectedItemString = comboBoxMorning.getSelectedItem().toString();
		
		if (selectedItemString.equals("6:00 am"))
			return LocalTime.of(6, 0);

		if (selectedItemString.equals("6:30 am"))
			return LocalTime.of(6, 30);

		if (selectedItemString.equals("7:00 am"))
			return LocalTime.of(7, 0);

		if (selectedItemString.equals("7:30 am"))
			return LocalTime.of(7, 30);

		if (selectedItemString.equals("8:00 am"))
			return LocalTime.of(8, 0);

		if (selectedItemString.equals("8:30 am"))
			return LocalTime.of(8, 30);

		if (selectedItemString.equals("9:00 am"))
			return LocalTime.of(9, 0);

		if (selectedItemString.equals("9:30 am"))
			return LocalTime.of(9, 30);

		if (selectedItemString.equals("10:00 am"))
			return LocalTime.of(10, 0);

		if (selectedItemString.equals("10:30 am"))
			return LocalTime.of(10, 30);

		if (selectedItemString.equals("11:00 am"))
			return LocalTime.of(11, 0);

		if (selectedItemString.equals("11:30 am"))
			return LocalTime.of(11, 30);
		
		return null;
	}
	
	public LocalTime getEveningTimings() {
		
		String selectedItemString = comboBoxMorning.getSelectedItem().toString();
		
		if (selectedItemString.equals("12:00 pm"))
			return LocalTime.of(12, 0);

		if (selectedItemString.equals("12:30 pm"))
			return LocalTime.of(12, 30);

		if (selectedItemString.equals("1:00 pm"))
			return LocalTime.of(13, 0);

		if (selectedItemString.equals("1:30 pm"))
			return LocalTime.of(13, 30);

		if (selectedItemString.equals("2:00 pm"))
			return LocalTime.of(14, 0);

		if (selectedItemString.equals("2:30 pm"))
			return LocalTime.of(14, 30);

		if (selectedItemString.equals("3:00 pm"))
			return LocalTime.of(15, 0);

		if (selectedItemString.equals("3:30 pm"))
			return LocalTime.of(15, 30);

		if (selectedItemString.equals("4:00 pm"))
			return LocalTime.of(16, 0);

		if (selectedItemString.equals("4:30 pm"))
			return LocalTime.of(16, 30);

		if (selectedItemString.equals("5:00 pm"))
			return LocalTime.of(17, 0);

		if (selectedItemString.equals("5:30 pm"))
			return LocalTime.of(17, 30);
		
		return null;
	}
public LocalTime getNightTimings() {
		
		String selectedItemString = comboBoxMorning.getSelectedItem().toString();
		
		if (selectedItemString.equals("6:00 pm"))
			return LocalTime.of(18, 0);

		if (selectedItemString.equals("6:30 pm"))
			return LocalTime.of(18, 30);

		if (selectedItemString.equals("7:00 pm"))
			return LocalTime.of(19, 0);

		if (selectedItemString.equals("7:30 pm"))
			return LocalTime.of(19, 30);

		if (selectedItemString.equals("8:00 pm"))
			return LocalTime.of(20, 0);

		if (selectedItemString.equals("8:30 pm"))
			return LocalTime.of(20, 30);

		if (selectedItemString.equals("9:00 pm"))
			return LocalTime.of(21, 0);

		if (selectedItemString.equals("9:30 pm"))
			return LocalTime.of(21, 30);

		if (selectedItemString.equals("10:00 pm"))
			return LocalTime.of(22, 0);

		if (selectedItemString.equals("10:30 pm"))
			return LocalTime.of(22, 30);

		if (selectedItemString.equals("11:00 pm"))
			return LocalTime.of(23, 0);

		if (selectedItemString.equals("11:30 pm"))
			return LocalTime.of(23, 30);

		if (selectedItemString.equals("12:00 am"))
			return LocalTime.of(24, 0);

		if (selectedItemString.equals("12:30 am"))
			return LocalTime.of(0, 30);
		return null;
	}

}
