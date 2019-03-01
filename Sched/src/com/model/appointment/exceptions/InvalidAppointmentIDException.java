package com.model.appointment.exceptions;

/**
 *
 * @author Nikhil Balwani (1641070)
 */
public class InvalidAppointmentIDException extends Exception {

    /**
     * Constructs an instance of <code>InvalidAppointmentIDException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidAppointmentIDException(int appointmentID) {
        super("The appointment ID: " + appointmentID + " is invalid. ");
    }
}
