import java.util.*;
import java.util.Scanner;

public class HospitalSystem {
	private ArrayList<Appointment> appointmentArray = new ArrayList<>();
	private ArrayList<Patient> patientArray = new ArrayList<>();
	private ArrayList<Doctor> doctorArray = new ArrayList<>();
	private ArrayList<LabTest> labArray = new ArrayList<>();
	
	Scanner input = new Scanner(System.in);
	
	//-------------------Functions-------------------
	
	private Patient findPatientById(int patientId) {
		for(Patient patient : patientArray) {
			if(patient.getPatientId() == patientId) {
				return patient;
			}
		}
		return null;
	}
	
	private Doctor findDoctorById(int doctorId) {
		for(Doctor doctor : doctorArray) {
			if(doctor.getDoctorId() == doctorId) {
				return doctor;
			}
		}
		return null;
	}
	
	private LabTest findLabTestByCode(String labCode) {
		for(LabTest labTest : labArray) {
			if(labTest.getLabCode().equals(labCode)) {
				return labTest;
			}
		}
		return null;
	}
	
	private String getDoctorTypeString(Doctor doctor) {
		if(doctor instanceof Surgeon) 
			return "Surgeon";
		if(doctor instanceof Specialist)
			return "Specialist";
		if(doctor instanceof GeneralPractitioner)
			return "General Practitioner";
		return "Unknown";
	}
	
	//--------------------------MENU---------------------------
	
	//--------------------1.Add a new Doctor-------------------
	
		public void addDoctor() {
	        System.out.println("Please enter the type of doctor you would like to create:");
	        System.out.println("1. General Practitioner");
	        System.out.println("2. Surgeon");
	        System.out.println("3. Specialist");

	        int typeChoice = input.nextInt();
	        input.nextLine(); 

	        System.out.println("Enter doctor name:");
	        String doctorName = input.nextLine();

	        System.out.println("Enter department:");
	        String department = input.nextLine();

	        System.out.println("Enter doctor ID:");
	        int doctorId = input.nextInt();
	        input.nextLine();

	        Doctor newDoctor = null;

	        switch (typeChoice) {
	            case 1:
	                newDoctor = new GeneralPractitioner(doctorName, department, doctorId);
	                break;
	            case 2:
	                newDoctor = new Surgeon(doctorName, department, doctorId);
	                break;
	            case 3:
	                newDoctor = new Specialist(doctorName, department, doctorId);
	                break;
	            default:
	                System.out.println("Invalid doctor type!");
	                return;
	        }

	        doctorArray.add(newDoctor);

	        System.out.println("Doctor added successfully!");
	    }
	
	//-------------------2.Add a new Patient-------------------
	
	public void addPatient() {
		System.out.println("Enter patient name:");
		String name = input.nextLine();
		System.out.println("Enter patient ID:");
		int id = input.nextInt();
		input.nextLine();
		
		Patient newPatient = new Patient(name, id);
		patientArray.add(newPatient);
		
		System.out.println("Patient added succesfully.");
	}
	
	//-------------------3.Add a new Lab Test------------------
	
	public void addNewLabTest() {
        System.out.println("Enter lab test name:");
        String labTestName = input.nextLine();

        System.out.println("Enter lab test code:");
        String labCode = input.nextLine();

        LabTest labtest = new LabTest(labTestName, labCode);
        labArray.add(labtest);

        System.out.println("New lab test type added to the database.");
    }

	
	
	//-------------------4.Book an Appointment-----------------

	public void bookAppointment() {
        System.out.println("Please enter your patient ID number:");
        int patientId = input.nextInt();
        input.nextLine();

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("There is no patient with that ID.");
            return;
        }

        System.out.println("Search for a Doctor with ID:");
        int doctorId = input.nextInt();
        input.nextLine();

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("There is no doctor with that ID.");
            return;
        }

        System.out.println("Enter an appointment year (YYYY)");
        int year = input.nextInt();
        System.out.println("Enter an appointment month (MM):");
        int month = input.nextInt();
        System.out.println("Enter an appointment day (DD):");
        int day = input.nextInt();
        input.nextLine();

        MyDate date = new MyDate(day, month, year);
        Appointment appointment = new Appointment(patient, doctor, date);

        boolean addedToDoctor = doctor.addAppointment(appointment);
        if (!addedToDoctor) {
            return;
        }

        appointmentArray.add(appointment);

        System.out.println("The appointment with Dr. " + doctor.getDoctorName() + " (" + doctor.getDepartment() + ") is booked for patient " + patient.getPatientName());
    }
	
	
	//------------------5.Cancel an Appointment----------------
	
	public void cancelAppointment() {
		System.out.println("Please enter your patient ID number:");
        int patientId = input.nextInt();
        input.nextLine();

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("There is no patient with that ID.");
            return;
        }

        System.out.println("Search for a Doctor with ID:");
        int doctorId = input.nextInt();
        input.nextLine();

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("There is no doctor with that ID.");
            return;
        }

        System.out.println("Enter appointment date to cancel (DD/MM/YYYY):");
        String dateString = input.nextLine();

        boolean cancelledByDoctor = doctor.cancelAppointment(patientId, dateString);
        
        if (cancelledByDoctor) {
        	appointmentArray.removeIf(a -> a.getPatient().getPatientId() == patientId && a.getDoctor().getDoctorId() == doctorId && a.getAppointmentDate().toString().equals(dateString) );
            
            System.out.println("The appointment for patient " + patient.getPatientName() + 
                               " with Dr. " + doctor.getDoctorName() + " on " + dateString + 
                               " has been cancelled.");
        }
        else {
            System.out.println("Appointment not found for this patient, doctor, and date combination.");
        }
    }
	
	
	//---------------------6.Order a Lab Test------------------
	
	public void orderLabTest() {
        System.out.println("Please enter your patient ID number:");
        int patientId = input.nextInt();
        input.nextLine();

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("There is no patient with that ID.");
            return;
        }

        System.out.println("Search for a Doctor with ID:");
        int doctorId = input.nextInt();
        input.nextLine();

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("There is no doctor with that ID.");
            return;
        }

        System.out.println("Search for a lab test code:");
        String labCode = input.nextLine();
        input.nextLine();

        LabTest catalogTest = findLabTestByCode(labCode);
        if (catalogTest == null) {
            System.out.println("There is no lab test with that code in the catalog.");
            return;
        }
        
        MyDate today = new MyDate(10, 12, 2025);
        
        System.out.println("Enter provider (MediCare/Hospital/External):");
        String provider = input.nextLine();
        provider = provider.toLowerCase();

        LabOrder order = null;
        
        if(provider.equals("hospital")) {
        	order = new HospitalOrder(catalogTest.getLabCode(), catalogTest.getLabTestName(), today, patient);
        }
        else if(provider.equals("medicare")) {
        	order = new MediCareOrder(catalogTest.getLabCode(), catalogTest.getLabTestName(), today, patient);
        }
        else if(provider.equals("external")) {
        	order = new ExternalOrder(catalogTest.getLabCode(), catalogTest.getLabTestName(), today, patient);
        }
        else {
        	System.out.println("Invalid provider type! Please enter MediCare, Hospital, or External.");
            return;
        }
        
        boolean addedToDoctor = doctor.addLab(order);
        
        if (addedToDoctor) {
            System.out.println("The '" + catalogTest.getLabTestName() + 
                               "' (Code# " + catalogTest.getLabCode() + 
                               ") is ordered by " + doctor.getDoctorName() + 
                               " for patient " + patient.getPatientName());
        }
    }

	//------------------7.Cancel Lab Test Order----------------
	
	public void cancelLabOrder() {
        System.out.println("Please enter your patient ID number:");
        int patientId = input.nextInt();
        input.nextLine();

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("There is no patient with that ID.");
            return;
        }

        System.out.println("Search for a Doctor with ID:");
        int doctorId = input.nextInt();
        input.nextLine();

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("There is no doctor with that ID.");
            return;
        }

        System.out.println("Enter lab test code to cancel:");
        String labCode = input.nextLine();
        input.nextLine();
        
        boolean cancelledByDoctor = doctor.cancelLabOrder(patientId, labCode);
        
        if (cancelledByDoctor) {
             LabTest catalogTest = findLabTestByCode(labCode);
             String labTestName = (catalogTest != null) ? catalogTest.getLabTestName() : "Unknown Test";

            System.out.println("The lab test order '" + labTestName + "' (Code: " + labCode + ") for patient " + patient.getPatientName() + " has been removed from Dr. " + doctor.getDoctorName() + "'s orders.");
        } 
        else {
            System.out.println("Lab test order not found for this patient, doctor, and code combination.");
        }
    }
	
	//-------------------8.Display all Accounts----------------
	
	public void displayAllAccounts() {
        System.out.println("\n--- Doctors ---");

        if (doctorArray.isEmpty()) {
            System.out.println("   No doctors in the system.");
        }

        for (Doctor doctor : doctorArray) {

            String type;
            if (doctor instanceof Surgeon) {
                type = "Surgeon";
            } else if (doctor instanceof Specialist) {
                type = "Specialist";
            } else if (doctor instanceof GeneralPractitioner) {
                type = "General Practitioner";
            } else {
                type = "Unknown";
            }

            System.out.println("Doctor: " + doctor.getDoctorName() + " (" + doctor.getDepartment() + ") [Type: " + type + "]");

            System.out.println("   Booked Appointments:");
            if (doctor.getBookedAppointmentCount() == 0) {
                System.out.println("     - (none)");
            } else {
            	for (Appointment a : doctor.getBookedAppointments()) {
                    System.out.println("  - " + a.getPatient().getPatientName() + " - " + a.getAppointmentDate().toString());
                }
            }

            System.out.println("   Ordered Lab Tests:");
            if (doctor.getOrderedLabTestCount() == 0) {
                System.out.println("     - (none)");
            } else {
            	for (LabOrder order : doctor.getOrderedLabTests()) {
                    System.out.println(order.getOrderDate().toString());
                    System.out.println(order.info());
                }
            }
            
            System.out.printf("   Doctor's Activity Summary: \n");
            if(doctor.getBookedAppointmentCount() == 0) {
            	System.out.println("     - (none)");
            }
            else {
            	System.out.println(doctor.info());
                System.out.println();
            }

            System.out.println();
        }
        
        System.out.println("--- Patients ---");
        
        if (patientArray.isEmpty()) {
            System.out.println("   No patient in the system.");
        }
        
        for(Patient patient : patientArray) {
        	System.out.println(patient.getPatientName() + " (ID: " + patient.getPatientId() + ")");
        }
    }
	
	//-------------------9.Display Sorted Stats----------------
	
	public void displaySortedStats() {
	    ArrayList<Doctor> sortedDoctors = new ArrayList<>(doctorArray);
	    Collections.sort(sortedDoctors);
	    
	    System.out.println("[Doctors] Sorted by Contribution (Descending):");
	    
	    int i = 1;
	    for (Doctor doctor : sortedDoctors) {
	        System.out.printf("%d. %s (%s) %.2f TRY\n", i++, doctor.getDoctorName(), getDoctorTypeString(doctor), doctor.calculateContribution());
	    }
	    System.out.println();

	    HashMap<String, LabStats> statsMap = new HashMap<>();
	    
	    for (Doctor doctor : doctorArray) {
	        for (LabOrder order : doctor.getOrderedLabTests()) {
	            double cost = order.calculateContribution();
	            
	            if (order instanceof MediCareOrder) {
	                cost = cost * 0.80;
	            }
	            if (statsMap.containsKey(order.getLabCode())) {
	                LabStats current = statsMap.get(order.getLabCode());
	                current.totalRevenue += cost;
	            } 
	            else {
	                statsMap.put(order.getLabCode(), new LabStats(order.getLabCode(), order.getLabTestName(), cost));
	            }
	        }
	    }

	    ArrayList<LabStats> sortedLabs = new ArrayList<>(statsMap.values());
	    Collections.sort(sortedLabs);
	    
	    System.out.println("[Lab Tests] Sorted by Total Revenue (Ascending):");
	    
	    int j = 1;
	    for (LabStats stats : sortedLabs) {
	        System.out.printf("%d. %s (%s): Total Generated: %.2f TRY\n", j++, stats.labName, stats.labCode, stats.totalRevenue);
	    }
	}
	
}

class LabStats implements Comparable<LabStats> {
	String labCode;
	String labName;
	double totalRevenue;
	
	public LabStats(String labCode, String labName, double totalRevenue) {
		this.labCode = labCode;
		this.labName = labName;
		this.totalRevenue = totalRevenue;
	}
	
	@Override
	public int compareTo(LabStats other) {
		return Double.compare(this.totalRevenue, other.totalRevenue);
	}
}

