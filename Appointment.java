
public class Appointment {
	private Patient patient;
	private Doctor doctor;
	private MyDate appointmentDate;
	private static int appointmentCount = 0;
	
	public Appointment(Patient patient, Doctor doctor, MyDate appointmentDate) {
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
		appointmentCount++;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public MyDate getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getInfo() {
		return "\nPatient: " + patient.getPatientName() + " (ID: " + patient.getPatientId() + ")\n" +
				"Doctor: " + doctor.getDoctorName() + " (" + doctor.getDepartment() + ")\n" + 
				"Date: " + appointmentDate.toString() + "\n";
	}
	
	public static int getAppointmentCount() {
		return appointmentCount;
	}
}
