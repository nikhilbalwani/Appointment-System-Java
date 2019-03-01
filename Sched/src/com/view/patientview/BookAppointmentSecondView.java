package com.view.patientview;

import com.model.slot.Slot;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class BookAppointmentSecondView extends JFrame {

	private JPanel contentPane;
	private JRadioButton slot8am;
	private JRadioButton slot830am;
	private JRadioButton slot9am;
	private JRadioButton slot930am;
	private JRadioButton slot10am;
	private JRadioButton slot1030am;
	private JRadioButton slot1230pm;
	private JRadioButton slot230pm;
	private JRadioButton slot430pm;
	private JRadioButton slot630pm;
	private JRadioButton slot11am;
	private JRadioButton slot1pm;
	private JRadioButton slot3pm;
	private JRadioButton slot5pm;
	private JRadioButton slot7pm;
	private JRadioButton slot12pm;
	private JRadioButton slot2pm;
	private JRadioButton slot4pm;
	private JRadioButton slot6pm;
	private JRadioButton slot1130am;
	private JRadioButton slot130pm;
	private JRadioButton slot330pm;
	private JRadioButton slot530pm;
	private JRadioButton slot730pm;
	private JButton btnBook;
	private JButton btnBack;
        
        private static boolean testSlot(String testSlot, Slot[] slots) {
            boolean flag = false;
            
            for (Slot s : slots) {

                if (s.getStartTime().equals(testSlot))
                    flag = true;
            }
            return flag;
        }

	/**
	 * Create the frame.
	 */
	public BookAppointmentSecondView(Slot[] slots) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		slot8am = new JRadioButton("8 to 8:30 AM");
		slot8am.setBounds(6, 7, 124, 23);
                if (!testSlot("8:00 AM", slots))
                    slot8am.setVisible(false);
		contentPane.add(slot8am);
                
		slot830am = new JRadioButton("8:30 to 9 AM");
		slot830am.setBounds(140, 7, 116, 23);
                if (!testSlot("8:30 AM", slots))
                    slot830am.setVisible(false);
		contentPane.add(slot830am);
		
		slot9am = new JRadioButton("9 to 9:30 AM");
		slot9am.setBounds(269, 7, 116, 23);
                if (!testSlot("9:00 AM", slots))
                    slot9am.setVisible(false);
		contentPane.add(slot9am);
		
		slot930am = new JRadioButton("9:30 to 10 AM");
		slot930am.setBounds(405, 7, 118, 23);
                slot930am.setVisible(false);
                if (!testSlot("9:30 AM", slots))
                    slot930am.setVisible(false);
		contentPane.add(slot930am);
		
		slot10am = new JRadioButton("10 to 10:30 AM");
		slot10am.setBounds(6, 42, 124, 23);
                if (!testSlot("10:00 AM", slots))
                    slot10am.setVisible(false);
		contentPane.add(slot10am);
		
		slot1030am = new JRadioButton("10:30 to 11 AM");
		slot1030am.setBounds(140, 42, 116, 23);
                if (!testSlot("10:30 AM", slots))
                    slot1030am.setVisible(false);
		contentPane.add(slot1030am);
		
		slot1230pm = new JRadioButton("12:30 to 1 PM");
		slot1230pm.setBounds(140, 80, 116, 23);
                if (!testSlot("12:30 PM", slots))
                    slot1230pm.setVisible(false);
		contentPane.add(slot1230pm);
		
		slot230pm = new JRadioButton("2:30 to 3 PM");
		slot230pm.setBounds(140, 116, 116, 23);
                if (!testSlot("2:30 PM", slots))
                    slot230pm.setVisible(false);
		contentPane.add(slot230pm);
		
		slot430pm = new JRadioButton("4:30 to 5 PM");
		slot430pm.setBounds(140, 155, 116, 23);
                if (!testSlot("4:30 PM", slots))
                    slot430pm.setVisible(false);
		contentPane.add(slot430pm);
		
		slot630pm = new JRadioButton("6:30 to 7 PM");
		slot630pm.setBounds(140, 188, 116, 23);
                if (!testSlot("6:30 PM", slots))
                    slot630pm.setVisible(false);
		contentPane.add(slot630pm);
		
		slot11am = new JRadioButton("11 to 11:30 AM");
		slot11am.setBounds(269, 42, 116, 23);
                if (!testSlot("11:00 AM", slots))
                    slot11am.setVisible(false);
		contentPane.add(slot11am);
		
		slot1pm = new JRadioButton("1 to 1:30 PM");
		slot1pm.setBounds(269, 80, 116, 23);
                if (!testSlot("1:00 PM", slots))
                    slot1pm.setVisible(false);
		contentPane.add(slot1pm);
		
		slot3pm = new JRadioButton("3 to 3:30 PM");
		slot3pm.setBounds(269, 116, 116, 23);
                if (!testSlot("3:00 PM", slots))
                    slot3pm.setVisible(false);
		contentPane.add(slot3pm);
		
		slot5pm = new JRadioButton("5 to 5:30 PM");
		slot5pm.setBounds(269, 155, 116, 23);
                if (!testSlot("5:00 PM", slots))
                    slot5pm.setVisible(false);
		contentPane.add(slot5pm);
		
		slot7pm = new JRadioButton("7 to 7:30 PM");
		slot7pm.setBounds(269, 188, 116, 23);
                if (!testSlot("7:00 PM", slots))
                    slot7pm.setVisible(false);
		contentPane.add(slot7pm);
		
		slot12pm = new JRadioButton("12 to 12:30 PM");
		slot12pm.setBounds(6, 80, 116, 23);
                if (!testSlot("12:00 PM", slots))
                    slot12pm.setVisible(false);
		contentPane.add(slot12pm);
		
		slot2pm = new JRadioButton("2 to 2:30 PM");
		slot2pm.setBounds(6, 116, 116, 23);
                if (!testSlot("2:00 PM", slots))
                    slot2pm.setVisible(false);
		contentPane.add(slot2pm);
		
		slot4pm = new JRadioButton("4 to 4:30 PM");
		slot4pm.setBounds(6, 155, 116, 23);
                if (!testSlot("4:00 PM", slots))
                    slot4pm.setVisible(false);
		contentPane.add(slot4pm);
		
		slot6pm = new JRadioButton("6 to 6:30 PM");
		slot6pm.setBounds(6, 188, 116, 23);
                if (!testSlot("6:00 PM", slots))
                    slot6pm.setVisible(false);
		contentPane.add(slot6pm);
		
		slot1130am = new JRadioButton("11:30 to 12 PM");
		slot1130am.setBounds(405, 42, 118, 23);
                if (!testSlot("11:30 PM", slots))
                    slot1130am.setVisible(false);
		contentPane.add(slot1130am);
		
		slot130pm = new JRadioButton("1:30 to 2 PM");
		slot130pm.setBounds(407, 80, 116, 23);
                if (!testSlot("1:30 PM", slots))
                    slot130pm.setVisible(false);
		contentPane.add(slot130pm);
		
		slot330pm = new JRadioButton("3:30 to 4 PM");
		slot330pm.setBounds(407, 116, 116, 23);
                if (!testSlot("3:30 PM", slots))
                    slot330pm.setVisible(false);
		contentPane.add(slot330pm);
		
		slot530pm = new JRadioButton("5:30 to 6 PM");
		slot530pm.setBounds(405, 155, 116, 23);
                if (!testSlot("5:30 PM", slots))
                    slot530pm.setVisible(false);
		contentPane.add(slot530pm);
		
		slot730pm = new JRadioButton("7:30 to 8 PM");
		slot730pm.setBounds(407, 188, 116, 23);
                if (!testSlot("7:30 PM", slots))
                    slot730pm.setVisible(false);
		contentPane.add(slot730pm);
		
		btnBook = new JButton("Book");
		btnBook.setBounds(208, 237, 89, 23);
		contentPane.add(btnBook);
	}
	public void setBookButtonBehavior(ActionListener listener){
		btnBook.addActionListener(listener);
	}
	public LocalTime[] getSlots() {
		ArrayList <LocalTime> slots = new ArrayList<>();
		
		if (slot8am.isSelected()) {
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
