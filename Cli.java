import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;
import java.lang.System;
import java.lang.String;
<<<<<<< HEAD
import java.util.Map;
import java.io.File;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
=======
import java.io.*;
>>>>>>> b32be76e0a0ec500b3a2ec5204e22b712629b8bf

public class Cli {

        public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String


			String[] ret = command.split(" ", 2);
			String cmdInput = ret[0];
			int length = ret.length;

<<<<<<< HEAD
=======





>>>>>>> b32be76e0a0ec500b3a2ec5204e22b712629b8bf
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

<<<<<<< HEAD
				}
				else{
					Map<String, String> env = System.getenv();
					//String[] paths = envVar.split(";");
					for(String envName : env.keySet()) {
					System.out.format("%s=%s%n%n",
                              			envName,
                              			env.get(envName));

					}
				}
				
=======
				if(argument == null){
					argument = "PATH";
					output = printenv;
					}
				}				
>>>>>>> b32be76e0a0ec500b3a2ec5204e22b712629b8bf
			}
			else if (cmdInput.equals("echo") || cmdInput.equals("print")){
				output = output + " " + ret[1];
				

			}
			else if (cmdInput.equals("ls")){
				if(length > 1){

					String dirName = ret[1];
					File dir = new File(dirName);
					File[] files = dir.listFiles();

					if (files != null || dir.isDirectory()){
						for (File file : files){
							System.out.format("%s%n", file.getName());
						}
					}
					else{
						output = "not a directory.";
					}
				}
				else{
					output = "not a directory.";

				}
			}
			else if (cmdInput.equals("chuck")){
					File chuckFile = new File("chuck.txt");

				try (Scanner fileScanner = new Scanner(chuckFile)) {
				    	List<String> quotes = new ArrayList<>();
					

					while (fileScanner.hasNextLine()) {
				        String line = fileScanner.nextLine();
        				quotes.add(line);
				    }
					fileScanner.close();
					
					Random random = new Random();
					int randomIndex = random.nextInt(quotes.size());
					output = quotes.get(randomIndex);
				
				} catch (FileNotFoundException e) {
				output = "Error: chuck.txt file not found.";
			}
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

