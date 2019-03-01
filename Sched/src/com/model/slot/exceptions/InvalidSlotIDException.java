package com.model.slot.exceptions;

/**
 *
 * @author Nikhil Balwani (1641070)
 */
public class InvalidSlotIDException extends Exception {

    /**
     * Constructs an instance of <code>InvalidSlotIDException</code> with the
     * specified detail message.
     *
     * @param slotID the slot ID.
     */
    public InvalidSlotIDException(int slotID) {
        super("The slot ID " + slotID + " is invalid and does not exist. ");
    }
}
