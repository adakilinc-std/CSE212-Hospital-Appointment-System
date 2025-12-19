
public class ExternalOrder extends LabOrder{
	private double base = 10000.0;
	
	public ExternalOrder(String labCode, String labTestName, MyDate orderDate, Patient forPatient) {
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
        return "A " + getLabTestName() + " (Code# " + getLabCode() + ") is ordered from an external laboratory for " + 
               getPatient().getPatientName() + " that costs " + String.format("%.2f", calculateContribution()) + " TRY";
    }
}
