package com.model.slot.exceptions;

/**
 *
 * @author Nikhil Balwani (1641070)
 */
public class InvalidSlotStartTimeException extends Exception {

    /**
     * Constructs an instance of <code>InvalidSlotStartTimeException</code> 
     * without detailed message.
     */
    public InvalidSlotStartTimeException() {
        super("The slot start time should have number of minutes which is a multiple of 30. " );
    }
}
