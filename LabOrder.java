
public abstract class LabOrder implements Billable {
	private String labCode;
	private MyDate orderDate;
	private Patient forPatient;
	private String labTestName;
	
	public LabOrder(String labCode, String labTestName, MyDate orderDate, Patient forPatient) {
        this.labCode = labCode;
        this.labTestName = labTestName;
        this.orderDate = orderDate;
        this.forPatient = forPatient;
    }
	
	public String getLabCode() {
        return labCode;
    }

    public MyDate getOrderDate() {
        return orderDate;
    }

    public Patient getPatient() {
        return forPatient;
    }
    
    public String getLabTestName() {
        return labTestName;
    }
	
}
