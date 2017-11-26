	import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
	
	public class Main {
	
		private static String message1 = "\nAir Traffic Control System"
				+ "\nA list of Commands is shown below! Type one of the commonds to proceed"
				+ "\n********************************************************************** ";
		
		private static String cmd1 = "entering"
				+ "\n__________________________";
		private static String cmd2 = "leaving"
				+ "\n__________________________";
		private static String cmd3 = "show"
				+ "\n__________________________";
		private static String cmd4 = "display"
				+ "\n__________________________";
		private static String cmd5 = "quit"
				+ "\n__________________________";
		public static Aircraft airCraft = new Aircraft();
		public static LinkedList1<String []> ll1 = new LinkedList1<String []>(); ;
		
		
		public static String input(){
			Scanner scanner  = new Scanner (System.in);
			System.out.println(message1 + "\n\n" +cmd1+ "\n\n" +cmd2+ "\n\n" +cmd3+ "\n\n" +cmd4+ "\n\n" +cmd5); 
			String command = scanner.nextLine();
			String line =command;
			return line;
		}
		
		public static void commandControl(){
			String command = input();
			String line= "";
			while (line != null){
				switch (command){
				case "entering" : 
					enter();
					command = input();
					break;
				case "e" : 
					enter();
					command = input();
					break;
				case "leaving":
					leave();
					command = input();
					break;
				case "l":
					leave();
					command = input();
					break;
				case "show":
					show();
					command = input();
					break;
				case "s":
					show();
					command = input();
					break;

				case"display":
					display();
					command = input();
					break;
				case"d":
					display();
					command = input();
					break;
				case"quit":
					quit();
					command = input();
					break;
				case"q":
					quit();
					command = input();
					break;
				}
			
			}
		}

		public static void enter(){
			Scanner scanner = new Scanner (System.in);
			System.out.println("iD:");
			int iD = new Integer(scanner.nextLine());
			airCraft.setiD(iD);
			System.out.println("Altitude:");
			int altitude = new Integer(scanner.nextLine());
			airCraft.setAltitude(altitude);
			System.out.println("speed:");
			int speed = new Integer(scanner.nextLine());
			airCraft.setSpeed(speed);
			System.out.println("name:");
			String name = scanner.nextLine();
			airCraft.setName(name);
			String[] data = new String[4];
			data[0] = airCraft.getName();
			data[1] = airCraft.getiD() +"";
			data[2] = airCraft.getAltitude() +"";
			data[3] = airCraft.getSpeed() +"";
			
			ll1.add(data);
			
		}
		public static void leave(){
			Scanner scanner = new Scanner (System.in);
			System.out.println("name:");
			String name = scanner.nextLine();
			ll1.remove(name);
			System.out.println("\n" + name +" has been removed!");
		}
		public static void show(){
			Scanner scanner = new Scanner (System.in);
			System.out.println("name:");
			String name = scanner.nextLine();
			String[] array =  ll1.get(name);
			if( array ==null){
				System.out.println("The aircraft has been removed, or has never entered this airspace");
				System.out.println("__________________________________________________________________");
				return;
			}
			System.out.println("Name: " + array[0]);
			System.out.println("______________________________");
			System.out.println("iD: " + array[1]);
			System.out.println("______________________________");
			System.out.println("Altitude: " + array[2] + " ft");
			System.out.println("______________________________");
			System.out.println("Speed: " + array[3] +" m/s");
			System.out.println("______________________________");
			
		}
		public static void display(){
			ll1.displayAll();
			
			/*
			for (int i=0; i<arryL.size(); i++){
				String[] toOpen = (String[]) arryL.get(i);
				System.out.println("name" + toOpen[0]);
				System.out.println("iD" + toOpen[1]);
				System.out.println("altitude" + toOpen[2]);
				System.out.println("speed" + toOpen[3]);
			*/	
			
		}
		public static void quit(){
			System.out.print("The program is about to terminate:");
			System.console();
			
			ll1.clear();
			System.exit(0);
		}
	
	
		public static void main(String [] args){
			
			
			commandControl();
		}
	}
