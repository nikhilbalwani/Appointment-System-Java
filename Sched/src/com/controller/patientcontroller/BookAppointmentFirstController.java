/** 
* BookAppointmentFirstController.java
* Created on 9 May, 2017
*/ 

package com.controller.patientcontroller;

import com.model.user.patient.Patient;
import com.view.patientview.BookAppointmentFirstView;
import com.view.patientview.BookAppointmentWithDoctorsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class BookAppointmentFirstController {
    
    private BookAppointmentFirstView bookAppointmentFirstView;
    
    public BookAppointmentFirstController(Patient p) {
        bookAppointmentFirstView = new BookAppointmentFirstView();
        bookAppointmentFirstView.setVisible(true);
        
        bookAppointmentFirstView.setPhysicianButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookAppointmentWithDoctorsView bookAppointmentWithDoctorsView = new BookAppointmentWithDoctorsView(new BookAppointmentListener(), p.getDoctors("Physician"));
                bookAppointmentWithDoctorsView.setVisible(true);
                
                bookAppointmentFirstView.dispose();
            }
        });
    }
    
    public static void main(String[] args) {
        Patient p = new Patient(0, "Nick", "Naresh", "Balwani", "L701", new GregorianCalendar(), "99998", "nikhilbalwani1998@gmail.com", "123", true, "B+");
        BookAppointmentFirstController b = new BookAppointmentFirstController(p);
    }
}
