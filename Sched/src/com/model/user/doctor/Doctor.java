/**
 * Doctor.java
 * Created on 6 May, 2017
 */
package com.model.user.doctor;

import com.model.appointment.AppointmentStorageUtility;
import com.model.appointment.exceptions.InvalidAppointmentIDException;
import com.model.slot.Slot;
import com.model.slot.SlotStorageUtility;
import com.model.slot.exceptions.InvalidSlotStartTimeException;
import com.model.user.User;
import com.model.user.doctor.clinic.Clinic;
import com.model.user.doctor.clinic.ClinicStorageUtility;
import java.util.GregorianCalendar;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;

/**
 *
 * @version $Revision: 1.0.0 $
 * @author Nikhil Balwani (1641070)
 */
public class Doctor extends User {

    /**
     * Unique identification number of the doctor, automatically generated.
     */
    private int doctorID;

    /**
     * Amount of experience in number of years.
     */
    private int workExperience;

    /**
     * Field in which the doctor specializes.
     */
    private String specialization;

    public Doctor(String fName, String mName, String lName, String address, GregorianCalendar dateOfBirth, String phoneNumber, String emailID, String password, boolean gender, String bloodGroup, int workExperience, String specialization) {
        super(fName, mName, lName, address, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup);
        this.workExperience = workExperience;
        this.specialization = specialization;

        DoctorStorageUtility storage = null;

        try {
            storage = new DoctorStorageUtility();
            this.doctorID = storage.getNextID();

            storage.add(this);                                                  // Storing this doctor
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            if (storage != null) {
                storage.close();
            }
        }
    }

    public Doctor(int doctorID, String fName, String mName, String lName, String address, GregorianCalendar dateOfBirth, String phoneNumber, String emailID, String password, boolean gender, String bloodGroup, int workExperience, String specialization) {
        super(fName, mName, lName, address, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup);
        this.doctorID = doctorID;
        this.workExperience = workExperience;
        this.specialization = specialization;
    }

    // Getters
    public int getDoctorID() {
        return doctorID;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String getSpecialization() {
        return specialization;
    }

    /**
     * Gets the slots available on a particular Day Of Week.
     *
     * @param dayOfWeek The day of week. (1 - 7)
     * @return Array of slots available on the specified dayOfWeek.
     */
    public Slot[] getSlots(int dayOfWeek) {
        SlotStorageUtility storage = null;
        Slot[] slots = null;

        try {
            storage = new SlotStorageUtility();
            slots = storage.getSlots(doctorID, dayOfWeek);
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            if (storage != null) {
                storage.close();
            }
        }

        return slots;
    }

    public void addSlot(int dayOfWeek, LocalTime startTime) {
        new Slot(dayOfWeek, startTime, this.doctorID);
    }
    
    // Returns true if the appointment completion was successful
    public boolean completeAppointment(int appointmentID) {
        AppointmentStorageUtility storage = null;

        try {
            storage = new AppointmentStorageUtility();

            storage.completeAppointment(appointmentID);
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        } finally {
            if (storage != null) {
                storage.close();
            }
        }
    }
    
    // Returns true if appointment cancellation was successful
    public boolean cancelAppointment(int appointmentID) {
        AppointmentStorageUtility storage = null;

        try {
            storage = new AppointmentStorageUtility();

            storage.completeAppointment(appointmentID);
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        } finally {
            if (storage != null) {
                storage.close();
            }
        }
    }

    /**
     *
     * @param emailID
     * @param password
     * @return null for unsuccessful login, else the instance of doctor..
     */
    public static Doctor login(String emailID, String password) {
        DoctorStorageUtility storage = null;

        try {
            storage = new DoctorStorageUtility();

            return storage.login(emailID, password);
        } catch (SQLException err) {
            err.printStackTrace();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            if (storage != null) {
                storage.close();
            }
        }

        return null;
    }

    public Clinic getClinic() {
        ClinicStorageUtility s = null;

        try {
            s = new ClinicStorageUtility();

            return s.getClinic(this.doctorID);
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            s.close();
        }

        return null;
    }

    public static void main(String[] args) {
        Doctor d = new Doctor("Jay", "Naresh", "Balwani", "Sarjan", new GregorianCalendar(2002, 8, 27), "9998986081", "nikhilbalwani1998@gmail.com", "cheesy123", true, "B+", 4, "BA");
        Doctor d2 = new Doctor("Rajendra", "P", "Oza", "Sarjan Medic", new GregorianCalendar(2002, 8, 27), "9998986083", "rajendra1998@gmail.com", "cheesy124", true, "B+", 10, "BA");
    }
}
