import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HospitalSystem system = new HospitalSystem();
		
		Scanner input = new Scanner(System.in);
		
		int userChoice;
		
		//-------------------MAIN DASHBOARD-------------------
		do {
			System.out.println("\nHOSPITAL APPOINTMENT MANAGMENT SYSTEM");
			System.out.println("1. Add a new doctor");
			System.out.println("2. Add a new patient");
			System.out.println("3. Add a lab test (catalog)");
			System.out.println("4. Book an appointment");
			System.out.println("5. Cancel an appointment");
			System.out.println("6. Order a lab test");
			System.out.println("7. Cancel a lab test order");
			System.out.println("8. Display all accounts");
			System.out.println("9. Display sorted financial stats");
			System.out.println("0. Exit");
			System.out.printf("Enter your choice: ");
			
			userChoice = input.nextInt();
			input.nextLine();  //For clean the buffer
			
			Menu option = Menu.MenuOption(userChoice);
			
			if(option == null) {
				System.out.println("Invalid choice!. Try again.");
				continue;
			}
			
			switch (option) {
		    case ADD_DOCTOR:
		        system.addDoctor();
		        break;
		    case ADD_PATIENT:
		        system.addPatient();
		        break;
		    case ADD_LABTEST_CATALOG:
		        system.addNewLabTest();
		        break;
		    case BOOK_APPOINTMENT:
		        system.bookAppointment();
		        break;
		    case CANCEL_APPOINTMENT:
		        system.cancelAppointment();
		        break;
		    case ORDER_LABTEST:
		        system.orderLabTest();
		        break;
		    case CANCEL_LABTEST:
		        system.cancelLabOrder();
		        break;
		    case DISPLAY_ALL_ACCOUNTS:
		        system.displayAllAccounts();
		        break;
		    case DISPLAY_SORTED_STATS:
		    	system.displaySortedStats();
		    	break;
		    case EXIT:
		        System.out.println("Goodbye!");
		        return;
			}
					
		} while(userChoice != 0);
	}

}
