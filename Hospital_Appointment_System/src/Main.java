import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HospitalSystem system = new HospitalSystem();
		
		Scanner input = new Scanner(System.in);
		
		int userChoice;
		
		//MAIN DASHBOARD (ALWAYS WORKS EXCEPT PRESS 4)
		do {
			System.out.printf("------------------HOSPITAL APPOINTMENT SYSTEM------------------");
			System.out.println("\n1. Add a new doctor");
			System.out.println("2. Add a new patient");
			System.out.println("3. Create an appointment");
			System.out.println("4. Display all appointments");
			System.out.println("5. Exit");
			System.out.printf("Enter your choice: ");
			
			userChoice = input.nextInt();
			input.nextLine();  //For clean the buffer
			
			Menu option = Menu.MenuOption(userChoice);
			
			if(option == null) {
				System.out.println("Invalid choice!. Try again.");
				continue;
			}
			
			switch(option) {
				case ADD_DOCTOR:
					system.addDoctor();
					break;
				case ADD_PATIENT:
					system.addPatient();
					break;
				case CREATE_APPOINTMENT:
					system.createAppointment();
					break;
				case DISPLAY_APPOINTMENTS:
					system.displayAllAppointments();
					break;
				case EXIT:
					System.out.println("Goodbye!");
					return;
			}
					
		} while(userChoice != 5);
	}

}
