
public class HospitalOrder extends LabOrder{
	private double base = 500.0;
	
	public HospitalOrder(String labCode, String labTestName, MyDate orderDate, Patient forPatient) {
        super(labCode, labTestName, orderDate, forPatient);
    }
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Override
    public double calculateContribution() {
        return base;
    }
	
	@Override
    public String info() {
        return "A " + getLabTestName() + " (Code# " + getLabCode() + ") is ordered within the hospital for " + 
               getPatient().getPatientName() + " that costs " + String.format("%.2f", calculateContribution()) + " TRY";
    }
}
