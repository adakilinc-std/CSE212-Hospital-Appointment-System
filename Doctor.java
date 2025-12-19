import java.util.*;

public abstract class Doctor implements Billable, Comparable<Doctor>{
	private String doctorName;
	private String department;
	private int doctorId;
	private static int doctorCount = 0;
	
	protected ArrayList<Appointment> bookedAppointments = new ArrayList<>();
	protected ArrayList<LabOrder> orderedLabTests = new ArrayList<>();
	
	protected int maxAppointmentsPerPatient;
	protected int maxLabsPerPatient;
	
	public Doctor(String doctorName, String department, int doctorId) {
		this.doctorName = doctorName;
		this.department = department;
		this.doctorId = doctorId;
		doctorCount++;
	}
	
	public Doctor() {
		doctorCount++;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String name) {
		this.doctorName = name;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(int id) {
		this.doctorId = id;
	}

	public static int getDoctorCount() {
		return doctorCount;
	}
	
	public int getBookedAppointmentCount() {
		return bookedAppointments.size();
	}
	
	public int getOrderedLabTestCount() {
		return orderedLabTests.size();
	}
	
	public Appointment[] getBookedAppointments() { 
		return bookedAppointments.toArray(new Appointment[0]); 
	}
	
	public LabOrder[] getOrderedLabTests() { 
		return orderedLabTests.toArray(new LabOrder[0]); 
	}
	
	public boolean addAppointment(Appointment appointment) {
		if(appointment == null)
			return false;
		
		Patient patient = appointment.getPatient();
		int patientId = patient.getPatientId();
		
		int countForThisPatient = 0;
		
		for(Appointment existing : bookedAppointments) {
			if(existing.getPatient().getPatientId() == patientId) {
				countForThisPatient++;
			}
		}
		
		if(countForThisPatient >= maxAppointmentsPerPatient) {
			System.out.println("The doctor's appointment quota is full");
			return false;
		}
		
		bookedAppointments.add(appointment);
		return true;
	}
	
	public boolean addLab(LabOrder labOrder) {
		Patient patient = labOrder.getPatient();
		int patientId = patient.getPatientId();
		int countForThisPatient = 0;
		
		for(LabOrder existing : orderedLabTests) {
			if(existing.getPatient().getPatientId() == patientId) {
				countForThisPatient++;
			}
		}
		
		if(countForThisPatient >= maxLabsPerPatient) {
			System.out.println("The doctor's lab order quota is full");
			return false;
		}
		
		orderedLabTests.add(labOrder);
		return true;
	}
	
	public boolean cancelAppointment(int patientId, String dateString) {
		Iterator <Appointment> iterator = bookedAppointments.iterator();
		boolean isCancelled = false;
		
		while(iterator.hasNext()) {
			Appointment iteratorAppointment = iterator.next();
			
			if(iteratorAppointment.getPatient().getPatientId() == patientId && iteratorAppointment.getAppointmentDate().toString().equals(dateString)) {
				iterator.remove();
				isCancelled = true;
				break;
			}
		}
		return isCancelled;
	}
	
	public boolean cancelLabOrder(int patientId, String labCode) {
		Iterator<LabOrder> iterator = orderedLabTests.iterator();
		boolean isCancelled = false;
		
		while(iterator.hasNext()) {
			LabOrder iteratorLabTest = iterator.next();
			
			if(iteratorLabTest.getPatient().getPatientId() == patientId && iteratorLabTest.getLabCode() == labCode) {
				iterator.remove();
				isCancelled = true;
				break;
			}
		}
		return isCancelled;
	}
	
	@Override
	public abstract double calculateContribution();
	
	@Override
	public String info() {
        return "Doctor with id number " + doctorId + " named " + doctorName + 
               " from department " + department + " will contribute " + 
               String.format("%.2f", calculateContribution()) + " TRY";
    }
	
	@Override
	public int compareTo(Doctor other) {
		return Double.compare(other.calculateContribution(), this.calculateContribution());
	}
	
}
