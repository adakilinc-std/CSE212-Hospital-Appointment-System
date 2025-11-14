
import java.util.Scanner;

public class HospitalSystem {
	private Appointment[] appointmentArray = new Appointment[10];
	private Patient[] patientArray = new Patient[10];
	private Doctor[] doctorArray = new Doctor[10];
	
	Scanner input = new Scanner(System.in);
	
	public void addDoctor() {
		if(Doctor.getDoctorCount() >= 10) {
			System.out.println("Doctor list is full!");
			return;
		}
		
		System.out.println("Enter doctor name:");
		String name = input.nextLine();
		System.out.println("Enter department:");
		String department = input.nextLine();
		System.out.println("Enter doctor ID:");
		int id = input.nextInt();
		input.nextLine();
		
		Doctor newDoctor = new Doctor(name, department, id);
		doctorArray[Doctor.getDoctorCount() - 1] = newDoctor;
		
		System.out.println("A new doctor has been added succesfully.");
		System.out.println("Total number of doctors in the hospital: " + Doctor.getDoctorCount());
	}
	
	public void addPatient() {
		if(Patient.getPatientCount() >= 10) {
			System.out.println("Patient list is full!");
			return;
		}
		
		System.out.println("Enter patient name:");
		String name = input.nextLine();
		System.out.println("Enter patient ID:");
		int id = input.nextInt();
		input.nextLine();
		
		Patient newPatient = new Patient(name, id);
		patientArray[Patient.getPatientCount() - 1] = newPatient;
		
		System.out.println("A new patient has been added succesfully.");
		System.out.println("Total number of patients in the hospital: " + Patient.getPatientCount());
	}
	
	public void createAppointment() {
		System.out.println("Enter patient ID:");
		int patientId = input.nextInt();
		System.out.println("Enter doctor ID:");
		int doctorId = input.nextInt();
		
		Patient foundPatient = null;
		for(int i = 0; i < Patient.getPatientCount(); i++) {
			if(patientArray[i].getPatientId() == patientId) {
				foundPatient = patientArray[i];
				break;
			}
		}
		
		if(foundPatient == null) {
			System.out.println("There is no patient with that ID.");
			return;
		}
		
		Doctor foundDoctor = null;
		for(int i = 0; i < Doctor.getDoctorCount(); i++) {
			if(doctorArray[i].getDoctorId() == doctorId) {
				foundDoctor = doctorArray[i];
				break;
			}
		}
		
		if(foundDoctor == null) {
			System.out.println("There is no doctor with that ID.");
			return;
		}
		
		System.out.println("Enter appointment year (YYYY):");
		int year = input.nextInt();
		System.out.println("Enter appointment month (MM):");
		int month = input.nextInt();
		System.out.println("Enter appointment day (DD):");
		int day = input.nextInt();
		
		MyDate date = new MyDate(day, month, year);
		
		Appointment newAppointment = new Appointment(foundPatient, foundDoctor, date);
		
		appointmentArray[Appointment.getAppointmentCount() - 1] = newAppointment;
		
		System.out.println("\nAppointment successfully created for patient " + foundPatient.getPatientName() + " with "
		        			+ foundDoctor.getDoctorName() + " (" + foundDoctor.getDepartment() + ") on " + date.toString());
	}
	
	public void displayAllAppointments() {
		if(Appointment.getAppointmentCount() == 0) {
			System.out.println("No appointments found.");
            return;
		}
		else {
			System.out.println("Scheduled Appointments:");
			
			for(int i = 0; i < Appointment.getAppointmentCount(); i++) {
				System.out.println(appointmentArray[i].getInfo());
			}
		}
	}
		
}

