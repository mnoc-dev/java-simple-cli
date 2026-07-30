import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;
import java.lang.System;

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

			String[] ret = command.split(" ", 5);
			String cmdInput = ret[0];
			int length = ret.length;

			LocalDate date = LocalDate.now(); // Create a date object
			LocalDateTime time = LocalDateTime.now();

			String username = System.getProperty("user.name");
			String userhome = System.getProperty("user.home");

			String os = System.getProperty("os.name");
			String osv = System.getProperty("os.version");


			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			}
			else if(command.equals("date")){
				output = date.toString();
				//output = LocalDate.now().toString();   it's a chain but not so readable for others
			}
			else if(command.equals("time")){
				output = time.toString(); 
			}
			else if(command.equals("username")){
				output = username.toString();
			}
			else if(command.equals("userhome")){
				output = userhome.toString();
			}
			else if(command.equals("os")){
				output = String.format ("%s(%s)", os, osv);
			}
			else if(cmdInput.equals("printenv")){
				if(length > 1){
					String argument = ret[1];

					String printenv = System.getenv(argument);
					output = printenv;
				
				
					if(printenv == null){
					output = " ";
					}
				}
			}
			else if (cmdInput.equals("echo")){
				
				String argument = ret[1];
				String path = ret[2];

				if(argument.equals("date")){
					output = date.toString();
				}

				if(argument.equals("time")){
					output = time.toString();
				}

				if(argument.equals("userhome")){
					output = userhome.toString();
				}

				if(argument.equals("os")){
					output = String.format ("%s(%s)", os, osv);
				}

				if(argument.equals("printenv")){
					if(length > 1){
					String printenv = System.getenv(argument);
					output = path;
					if(printenv == null){
					}
					}

				}


			}else {
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

