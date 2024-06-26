/*import java.util.Scanner;//it's a class of java.util package that allows you to read
                         //input from different sources in Java programs.
import java.time.LocalDate;//its a package of java.time that represents a date without
                           //time information (year, month, and day).
public class VechicleFareSystem {
	//I use static method to access the variable from another without creating an instance.
	// This is the 2D array I use this to store the data of the passenger and Driver.
	static String Route[][] = new String[50][5];
	static String Driver[][] = new String[3][6];
	static int LimitRoute = 1;// I use this to count the list of the passenger.
	static LocalDate DT = LocalDate.now();//This is the object of the LocalDate class
	static Scanner input = new Scanner(System.in);//This is the object of the Scanner class
	public static void main(String[] args) {
		// This is the main method of my program.
		System.out.println("\n***************************************************");
		System.out.println("*               VEHICLE FARE SYSTEM               *");
        System.out.println("*                                                 *");
        System.out.println("***************************************************");

	    DriverInfo();//This is the DriverInfo method used to print the information of the driver
		System.out.println("Let's Gooo!!!");//When the program is end this message will print.
	}
	// This is the menu botton to choose the user.
	public static void Menu() {
		System.out.println("\n***********************MENU************************");
		System.out.println(" _________________________________________________ ");
		System.out.println("|                      MENU                       |");
		System.out.println("|_________________________________________________|");
		System.out.println("|            0. EXIT THE PROGRAM                  |");
		System.out.println("|            1. LIST OF THE FARE/ROUTE            |");
		System.out.println("|            2. LIST OF PASSENGER                 |");
		System.out.println("|            3. INFORMATION OF DRIVER             |");
		System.out.println("|            4. NEW PASSENGER                     |");
		System.out.println("|            5. SEARCHING  PASSENGER              |");
		System.out.println("|_________________________________________________|");
		System.out.print("\nEnter to Select your option: ");
		char select = input.next().charAt(0);
		// This is the condition to print what user choose.
		switch (select) {
			case '0':// if the user select "0" the program will end.
				return;
			case '1':// if the user select "1" the program will go to ListFare Method.
				ListFare();
				break;
			case '2':// if the user select "1" the program will go to ListPassenger Method.
				ListPassenger();
				break;
			case '3':// if the user select "1" the program will go to ListFare Method.
				DriverInformation();
				break;
			case'4':// if the user select "1" the program will go to NewPassenger Method.
				NewPassenger();
				break;
			case '5':
			    Search();//if the user select "5" the program will go to Search Method.
			    break;
			default:
			    System.out.println("\n\t\tINVALID INPUT");
				Menu();// if the user selects none of the choices the program will return to the Menu Method.
				break;
	     }
	}
	// This is the ListPassenger Method to print the list of the passenger who want
	// to rides.
	public static void ListPassenger() {
		if (LimitRoute == 1) {
			System.out.println("\n*******************LIST OF PASSENGER*****************");
			System.out.println("\n\t\t    NO BOOKING :( ");
		} else {
			// This is for loop used to print the passenger information store in the array.
			for (int i = 1; i < LimitRoute; i++) {
				Passenger(i);
			}
		}
		Menu();
	}
	// This is the NewPassenger Method to add who wants to ride,
	// the user input there name to know who is the passenger
	// in vehicle just incase in the emergency, and also user
	// input there destination to know diin siya mahawas and
	// how many people na kaupod san user and also the fare of the user.
	public static void NewPassenger() {
		try{//I use exception to maintain my error, even its error the program will not stop running.
		System.out.println("\n********************NEW PASSENGER******************");
		System.out.print("  Enter your Name          : ");
		Route[LimitRoute][0] = input.next();
		Route[LimitRoute][1] = input.next();
		System.out.print("  Enter your Destination   : ");
		Route[LimitRoute][2] = input.next();
		System.out.print("  Enter number of Passenger: ");
		Route[LimitRoute][3] = input.next();
		System.out.print("  Enter your Fare          : ");
		Route[LimitRoute][4] = input.next();
		System.out.print("\n*******************LIST OF PASSENGER*****************");
		Passenger(LimitRoute);
		LimitRoute++;
		 } catch (Exception e) {
		            System.out.println("\n\t\tINVALID KEYWORD");//This is the message that will
		                                                       //display if the user input is error.
        }
        Menu();
	}
  //This is the Search Method use to search the passenger if they are on the rides.
  public static void Search() {
      System.out.print("Search name: ");
      String name = input.next();
      String names = input.next();
      boolean found = false;
    // This is for loop use to find what the user is looking for that is stored in the array.
      for (int i = 1; i < LimitRoute; i++) {
          if (name.equalsIgnoreCase(Route[i][0])&&names.equalsIgnoreCase(Route[i][1])) {
              System.out.println("PASSENGER FOUND\nDetails:");
              Passenger(i);
              found = true;
              break; // Stop searching once name is found.
            }
       }
       if (!found) {
          System.out.println("NOT IN THE LIST");
          ListPassenger();
      }

      Menu(); // Go back to the main menu after searching.
  }
	// This is the Passenger Method to see the information of the passenger,
	// it also indicate the date when they book, and also the plate number
	// and ticket ID to easly identify the vehicle. And the fare of the passenger
	// is automatically calculate depend to the passenger number and
	// the system automatically give the change fare of the passenger.
	public static void Passenger(int LimitRoute) {
		System.out.println();
		String Destination = Route[LimitRoute][2];
		System.out.println(" _________________________________________________ ");
		System.out.println("|                    PASSENGER                    |");
		System.out.println("|_________________________________________________|");
		System.out.println("  DATE               : " + DT  );
		System.out.println("  PLATE NO           : " + Driver[0][5]);
		System.out.println("  TICKET ID          : " + LimitRoute);
		System.out.println("  PASSENGER NAME     : " + Route[LimitRoute][0].toUpperCase()+" "+Route[LimitRoute][1].toUpperCase());
		System.out.println("  PASSNGER MONEY     : " + Route[LimitRoute][4]);

		int fare = 0;
		if (Destination.equalsIgnoreCase("MAGSAYSAY")) {
			fare = 10;
		} else if (Destination.equalsIgnoreCase("NAVARRO")) {
			fare = 20;
		} else if (Destination.equalsIgnoreCase("NIJAGA")) {
			fare = 15;
		} else if (Destination.equalsIgnoreCase("GOMEZ")) {
			fare = 25;
		} else if (Destination.equalsIgnoreCase("UMBRIA")) {
			fare = 30;
		} else {
			System.out.println("\nTHE ROUTE YOU ENTERED IS NOT AVAILABLE\nPLEASE CHECK THE LIST OF THE ROUTE");
		    ListFare();
		}
		System.out.println("  "+Route[LimitRoute][2].toUpperCase() + " FARE     : " + fare);
		int passtotal = Integer.parseInt(Route[LimitRoute][3]);
		fare = fare * passtotal;
		System.out.println("  PASSENGER TOTAL "+passtotal+"  : " + fare);
		int Fare = Integer.parseInt(Route[LimitRoute][4]);
		int change = 0;
		if (Destination.equalsIgnoreCase("MAGSAYSAY")) {
			change = Fare - fare;
		} else if (Destination.equalsIgnoreCase("NAVARRO")) {
			change = Fare - fare;
		} else if (Destination.equalsIgnoreCase("NIJAGA")) {
			change = Fare - fare;
		} else if (Destination.equalsIgnoreCase("GOMEZ")) {
			change = Fare - fare;
		} else if (Destination.equalsIgnoreCase("UMBRIA")) {
			change = Fare - fare;
		} else {
			System.out.println("PLEASE CHECK THE LIST OF THE FARE");
		}
		if (Fare < fare) {
			System.out.println("  FARE IS NOT ENOUGH : " + change);
		} else {
			System.out.println("  CHANGE FARE        : " + change);
		}
    System.out.println("___________________________________________________ ");


	}
   //This is the DriverInformation method to fill up the information of the driver.
	public static void DriverInformation() {

		System.out.println("\n****************DRIVER'S INFORMATION***************");
		System.out.println(" _________________________________________________ ");
		System.out.println("|                DRIVER INFORMATION               |");
		System.out.println("|_________________________________________________|");
		System.out.println("  NAME      : "+ Driver[0][0].toUpperCase() +" "+Driver[0][1].toUpperCase());
		if(Integer.parseInt(Driver[0][2])>=65||Integer.parseInt(Driver[0][2])<=17){
		System.out.println("  YOUR AGE IS NOT ALLOWED TO DRIVE");
		DriverInfo();
		}else{
		System.out.println("  AGE       : "+ Integer.parseInt(Driver[0][2]));
	    }
	    if(Driver[0][3].equalsIgnoreCase("Male")||
	     Driver[0][3].equalsIgnoreCase("Famale")||
	          Driver[0][3].equalsIgnoreCase("M")||
	          Driver[0][3].equalsIgnoreCase("F")){
		System.out.println("  SEX       : "+ Driver[0][3].toUpperCase());
	    }else{
	    System.out.println("\n\t\tINVALID INPUT ");
	    DriverInfo();
		}
		System.out.println("  ADDRESS   : "+ Driver[0][4].toUpperCase()+ " CALBAYOG,CITY" );
		System.out.println("  PLATE NO  : "+ Driver[0][5]  );
		System.out.println("___________________________________________________");
		Menu();
	}
   //This is the ListFare method to display the available route and fare of the vehicle.
	public static void ListFare() {
		System.out.println("\n*****************LIST OF THE ROUTE*****************");
		System.out.println(" _________________________________________________ ");
		System.out.println("|          ROUTE           |        FARE          |");
		System.out.println("|__________________________|______________________| ");
		System.out.println("|  MAGSAYSAY               |         10           |");
		System.out.println("|  NAVARRO                 |         20           |");
		System.out.println("|  NIJAGA                  |         15           |");
		System.out.println("|  GOMEZ                   |         25           |");
		System.out.println("|  UMBRIA                  |         30           |");
		System.out.println("|__________________________|______________________|");
		Menu();
	}
	//This is the DriverInfo method this method is use to print the information of the driver.
	public static void DriverInfo() {
		try{//I use exception to maintain my error, even its error the program will not stop running.
		System.out.println("\n****************DRIVER'S INFORMATION***************");
		System.out.print("  Enter your Name       : ");
		Driver[0][0] = input.next();
		Driver[0][1] = input.next();
		System.out.print("  Enter your Age        : ");
	    Driver[0][2] = input.next();
		System.out.print("  Enter your Sex        : ");
		Driver[0][3] = input.next();
		System.out.print("  Enter your Address    : ");
		Driver[0][4] = input.next();
		System.out.print("  Plate Number          : ");
		Driver[0][5] = input.next();
        DriverInformation();
        }catch(Exception e){
	           System.out.println("\n\t\tINVALID KEYWORD");//This is the message that will
		                                                  //display if the user input is error.
	    DriverInfo();
       }
	}
 }*/
 import java.util.Scanner;//it's a class of java.util package that allows you to read
                          //input from different sources in Java programs.
 import java.time.LocalDate;//its a package of java.time that represents a date without
                            //time information (year, month, and day).
 public class VechicleFareSystem {
 	//I use static method to access the variable from another without creating an instance.
 	// This is the 2D array I use this to store the data of the passenger and Driver.
 	static String Route[][] = new String[50][5];
 	static String Driver[][] = new String[3][6];
 	static int LimitRoute = 1;// I use this to count the list of the passenger.
 	static LocalDate DT = LocalDate.now();//This is the object of the LocalDate class
 	static Scanner input = new Scanner(System.in);//This is the object of the Scanner class
 	public static void main(String[] args) {
 		// This is the main method of my program.
 		System.out.println("\n***************************************************");
 		System.out.println("*               VEHICLE FARE SYSTEM               *");
         System.out.println("*                                                 *");
         System.out.println("***************************************************");

 	    DriverInfo();//This is the DriverInfo method used to print the information of the driver
 		System.out.println("Let's Gooo!!!");//When the program is end this message will print.
 	}
 	// This is the menu botton to choose the user.
 	public static void Menu() {
 		System.out.println("\n***********************MENU************************");
 		System.out.println(" _________________________________________________ ");
 		System.out.println("|                      MENU                       |");
 		System.out.println("|_________________________________________________|");
 		System.out.println("|            0. EXIT THE PROGRAM                  |");
 		System.out.println("|            1. LIST OF THE FARE/ROUTE            |");
 		System.out.println("|            2. LIST OF PASSENGER                 |");
 		System.out.println("|            3. INFORMATION OF DRIVER             |");
 		System.out.println("|            4. NEW PASSENGER                     |");
 		System.out.println("|            5. SEARCHING  PASSENGER              |");
 		System.out.println("|_________________________________________________|");
 		System.out.print("\nEnter to Select your option: ");
 		char select = input.next().charAt(0);
 		// This is the condition to print what user choose.
 		switch (select) {
 			case '0':// if the user select "0" the program will end.
 				return;
 			case '1':// if the user select "1" the program will go to ListFare Method.
 				ListFare();
 				break;
 			case '2':// if the user select "1" the program will go to ListPassenger Method.
 				ListPassenger();
 				break;
 			case '3':// if the user select "1" the program will go to ListFare Method.
 				DriverInformation();
 				break;
 			case'4':// if the user select "1" the program will go to NewPassenger Method.
 				NewPassenger();
 				break;
 			case '5':
 			    Search();//if the user select "5" the program will go to Search Method.
 			    break;
 			default:
 			    System.out.println("\n\t\tINVALID INPUT");
 				Menu();// if the user selects none of the choices the program will return to the Menu Method.
 				break;
 	     }
 	}
 	// This is the ListPassenger Method to print the list of the passenger who want
 	// to rides.
 	public static void ListPassenger() {
 		if (LimitRoute == 1) {
 			System.out.println("\n*******************LIST OF PASSENGER*****************");
 			System.out.println("\n\t\t    NO BOOKING :( ");
 		} else {
 			// This is for loop used to print the passenger information store in the array.
 			for (int i = 1; i < LimitRoute; i++) {
 				Passenger(i);
 			}
 		}
 		Menu();
 	}
 	// This is the NewPassenger Method to add who wants to ride,
 	// the user input there name to know who is the passenger
 	// in vehicle just incase in the emergency, and also user
 	// input there destination to know diin siya mahawas and
 	// how many people na kaupod san user and also the fare of the user.
 	public static void NewPassenger() {
 		try{//I use exception to maintain my error, even its error the program will not stop running.
 		System.out.println("\n********************NEW PASSENGER******************");
 		System.out.print("  Enter your Name          : ");
 		Route[LimitRoute][0] = input.next();
 		Route[LimitRoute][1] = input.next();
 		System.out.print("  Enter your Destination   : ");
 		Route[LimitRoute][2] = input.next();
 		System.out.print("  Enter number of Passenger: ");
 		Route[LimitRoute][3] = input.next();
 		System.out.print("  Enter your Fare          : ");
 		Route[LimitRoute][4] = input.next();
 		System.out.print("\n*******************LIST OF PASSENGER*****************");
 		Passenger(LimitRoute);
 		LimitRoute++;
 		 } catch (Exception e) {
 		            System.out.println("\n\t\tINVALID KEYWORD");//This is the message that will
 		                                                       //display if the user input is error.
         }
         Menu();
 	}
   //This is the Search Method use to search the passenger if they are on the rides.
   public static void Search() {
       System.out.print("Search name: ");
       String name = input.next();
       String names = input.next();
       boolean found = false;
     // This is for loop use to find what the user is looking for that is stored in the array.
       for (int i = 1; i < LimitRoute; i++) {
           if (name.equalsIgnoreCase(Route[i][0])&&names.equalsIgnoreCase(Route[i][1])) {
               System.out.println("PASSENGER FOUND\nDetails:");
               Passenger(i);
               found = true;
               break; // Stop searching once name is found.
             }
        }
        if (!found) {
           System.out.println("NOT IN THE LIST");
           ListPassenger();
       }

       Menu(); // Go back to the main menu after searching.
   }
 	// This is the Passenger Method to see the information of the passenger,
 	// it also indicate the date when they book, and also the plate number
 	// and ticket ID to easly identify the vehicle. And the fare of the passenger
 	// is automatically calculate depend to the passenger number and
 	// the system automatically give the change fare of the passenger.
 	public static void Passenger(int LimitRoute) {
 		System.out.println();
 		String Destination = Route[LimitRoute][2];
 		System.out.println(" _________________________________________________ ");
 		System.out.println("|                    PASSENGER                    |");
 		System.out.println("|_________________________________________________|");
 		System.out.println("  DATE               : " + DT  );
 		System.out.println("  PLATE NO           : " + Driver[0][5]);
 		System.out.println("  TICKET ID          : " + LimitRoute);
 		System.out.println("  PASSENGER NAME     : " + Route[LimitRoute][0].toUpperCase()+" "+Route[LimitRoute][1].toUpperCase());
 		System.out.println("  PASSNGER MONEY     : " + Route[LimitRoute][4]);

 		int fare = 0;
 		if (Destination.equalsIgnoreCase("MAGSAYSAY")) {
 			fare = 10;
 		} else if (Destination.equalsIgnoreCase("NAVARRO")) {
 			fare = 20;
 		} else if (Destination.equalsIgnoreCase("NIJAGA")) {
 			fare = 15;
 		} else if (Destination.equalsIgnoreCase("GOMEZ")) {
 			fare = 25;
 		} else if (Destination.equalsIgnoreCase("UMBRIA")) {
 			fare = 30;
 		} else {
 			System.out.println("\nTHE ROUTE YOU ENTERED IS NOT AVAILABLE\nPLEASE CHECK THE LIST OF THE ROUTE");
 		    ListFare();
 		}
 		System.out.println("  "+Route[LimitRoute][2].toUpperCase() + " FARE     : " + fare);
 		int passtotal = Integer.parseInt(Route[LimitRoute][3]);
 		fare = fare * passtotal;
 		System.out.println("  PASSENGER TOTAL "+passtotal+"  : " + fare);
 		int Fare = Integer.parseInt(Route[LimitRoute][4]);
 		int change = 0;
 		if (Destination.equalsIgnoreCase("MAGSAYSAY")) {
 			change = Fare - fare;
 		} else if (Destination.equalsIgnoreCase("NAVARRO")) {
 			change = Fare - fare;
 		} else if (Destination.equalsIgnoreCase("NIJAGA")) {
 			change = Fare - fare;
 		} else if (Destination.equalsIgnoreCase("GOMEZ")) {
 			change = Fare - fare;
 		} else if (Destination.equalsIgnoreCase("UMBRIA")) {
 			change = Fare - fare;
 		} else {
 			System.out.println("PLEASE CHECK THE LIST OF THE FARE");
 		}
 		if (Fare < fare) {
 			System.out.println("  FARE IS NOT ENOUGH : " + change);
 		} else {
 			System.out.println("  CHANGE FARE        : " + change);
 		}
     System.out.println("___________________________________________________ ");


 	}
    //This is the DriverInformation method to fill up the information of the driver.
 	public static void DriverInformation() {

 		System.out.println("\n****************DRIVER'S INFORMATION***************");
 		System.out.println(" _________________________________________________ ");
 		System.out.println("|                DRIVER INFORMATION               |");
 		System.out.println("|_________________________________________________|");
 		System.out.println("  NAME      : "+ Driver[0][0].toUpperCase() +" "+Driver[0][1].toUpperCase());
 		if(Integer.parseInt(Driver[0][2])>=65||Integer.parseInt(Driver[0][2])<=17){
 		System.out.println("  YOUR AGE IS NOT ALLOWED TO DRIVE");
 		DriverInfo();
 		}else{
 		System.out.println("  AGE       : "+ Integer.parseInt(Driver[0][2]));
 	    }
 	    if(Driver[0][3].equalsIgnoreCase("Male")||
 	     Driver[0][3].equalsIgnoreCase("Famale")||
 	          Driver[0][3].equalsIgnoreCase("M")||
 	          Driver[0][3].equalsIgnoreCase("F")){
 		System.out.println("  SEX       : "+ Driver[0][3].toUpperCase());
 	    }else{
 	    System.out.println("\n\t\tINVALID INPUT ");
 	    DriverInfo();
 		}
 		System.out.println("  ADDRESS   : "+ Driver[0][4].toUpperCase()+ " CALBAYOG,CITY" );
 		System.out.println("  PLATE NO  : "+ Driver[0][5]  );
 		System.out.println("___________________________________________________");
 		Menu();
 	}
    //This is the ListFare method to display the available route and fare of the vehicle.
 	public static void ListFare() {
 		System.out.println("\n*****************LIST OF THE ROUTE*****************");
 		System.out.println(" _________________________________________________ ");
 		System.out.println("|          ROUTE           |        FARE          |");
 		System.out.println("|__________________________|______________________| ");
 		System.out.println("|  MAGSAYSAY               |         10           |");
 		System.out.println("|  NAVARRO                 |         20           |");
 		System.out.println("|  NIJAGA                  |         15           |");
 		System.out.println("|  GOMEZ                   |         25           |");
 		System.out.println("|  UMBRIA                  |         30           |");
 		System.out.println("|__________________________|______________________|");
 		Menu();
 	}
 	//This is the DriverInfo method this method is use to print the information of the driver.
 	public static void DriverInfo() {
 		try{//I use exception to maintain my error, even its error the program will not stop running.
 		System.out.println("\n****************DRIVER'S INFORMATION***************");
 		System.out.print("  Enter your Name       : ");
 		Driver[0][0] = input.next();
 		Driver[0][1] = input.next();
 		System.out.print("  Enter your Age        : ");
 	    Driver[0][2] = input.next();
 		System.out.print("  Enter your Sex        : ");
 		Driver[0][3] = input.next();
 		System.out.print("  Enter your Address    : ");
 		Driver[0][4] = input.next();
 		System.out.print("  Plate Number          : ");
 		Driver[0][5] = input.next();
         DriverInformation();
         }catch(Exception e){
 	           System.out.println("\n\t\tINVALID KEYWORD");//This is the message that will
 		                                                  //display if the user input is error.
 	    DriverInfo();
        }
 	}
 }