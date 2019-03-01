/**
 * BookAppointmentButton.java
 * Created on 10 May, 2017
 */
package com.view.patientview;

import com.model.user.doctor.Doctor;
import javax.swing.JButton;

/**
 *
 * @version $Revision: 1.0.0 $
 * @author Nikhil Balwani (1641070)
 */
public class BookAppointmentButton extends JButton {

    private Doctor owner;
    
    public BookAppointmentButton(Doctor doctor, String name) {
        super(name);
        owner = doctor;
    }

    public Doctor getDoctor() {                                         // Returns doctor for which the button was clicked
        return owner;
    }
}
