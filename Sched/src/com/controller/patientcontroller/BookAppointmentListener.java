/** 
* BookAppointmentListener.java
* Created on 10 May, 2017
*/ 

package com.controller.patientcontroller; 

import com.model.slot.Slot;
import com.view.patientview.BookAppointmentButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class BookAppointmentListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GregorianCalendar now = new GregorianCalendar();
        
        Slot[] slots = ((BookAppointmentButton) e.getSource()).getDoctor().getSlots(now.get(Calendar.DAY_OF_WEEK));
        
        System.out.println(slots.length);
        
        System.out.println("Booking...");
    }
}
