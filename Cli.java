import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;
import java.lang.System;
import java.lang.String;
import java.io.*;

public class Cli {

    // The main method is the entry point of the program. Rules regarding the main method:
    //     - public: so the JVM can access it from "outside"
    //     - static: so it can be called without creating an object (class scoped)
    //     - void: it doesn't return a value (aka procedure)
    //     - main: the required method name
    //     - String[] args: so it can receive command-line arguments
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String

			String[] ret = command.split(" ", 2);
			String cmdInput = ret[0];
			int length = ret.length;






			if (command.equals("exit") || command.equals("logout")) {
				break; // Forces exit of the while loop
			}
			else if(command.equals("date")){
			
				LocalDate date = LocalDate.now(); // Create a date object
				output = date.toString();
				//output = LocalDate.now().toString();   it's a chain but not so readable for others
			}
			else if(command.equals("time")){
			
				LocalDateTime time = LocalDateTime.now();
				output = time.toString(); 
			}
			else if(command.equals("useraccount")){
			
				String username = System.getProperty("user.name");
				output = username.toString();
			}
			else if(command.equals("userhome")){
	
				String userhome = System.getProperty("user.home");
				output = userhome.toString();
			}
			else if(command.equals("os")){

				String osv = System.getProperty("os.version");
				String os = System.getProperty("os.name");
				output = String.format ("%s(%s)", os, osv);
			}
			else if(cmdInput.equals("printenv")){
					
			
				if(length > 1){
					String argument = ret[1];
					String printenv = System.getenv(argument);
					output = printenv;

				if(argument == null){
					argument = "PATH";
					output = printenv;
					}
				}				
			}
			else if (cmdInput.equals("echo") || cmdInput.equals("print")){
				output = output + " " + ret[1];
				

			}
			else{
				// String concatenation
				output = "Command '" + command + "' not found.";
			} 
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
    }
}


