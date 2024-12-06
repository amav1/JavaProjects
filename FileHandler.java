//Adriana Mavila
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileHandler {
    private String choice;

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return this.choice;
    }

    public static void main(String[] args) {
        
        FileHandler fileHandler = new FileHandler();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Main Menu: ");
        System.out.println("1. Create File");
        System.out.println("2. Display File Content");
        System.out.println("3. Search in File");
        System.out.println("4. Delete File");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        
        String userChoice = scanner.nextLine();
        
        fileHandler.setChoice(userChoice);
        
        System.out.println("Selected: " + fileHandler.getChoice());
        
		
        if (userChoice.equals("1")) {
    
            System.out.print("Enter the name of the file: ");
            String filename = scanner.nextLine();

            File newFile = new File(filename);
            try {
                
                if (newFile.createNewFile()) {
                    System.out.println("File created: " + newFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("Something went wrong when creating the file: " + e);
            }
            System.out.println("What would you like to write in " + newFile + " (type 'exit' or press Enter to stop):");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
                String s;
               
                while (true) {
                    s = scanner.nextLine();
                    if (s.equalsIgnoreCase("exit") || s.isEmpty()) {
                        break; 
                    }
                    writer.write(s);
                    writer.newLine(); 
                }
                System.out.println("Content written to the file successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e);
            }
            
            
            System.out.println("Would you like to copy contents from an existing file? Type y or n.");
            String i = scanner.nextLine();
            	
            
            if (i.equals("y")) {
                System.out.println("Enter the name of the file to copy from: ");
                String baseFileName = scanner.nextLine();
                File baseFile = new File(baseFileName);

        
                if (baseFile.exists() && baseFile.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(baseFile));
                         BufferedWriter newWriter = new BufferedWriter(new FileWriter(newFile, true))) {

                        String line;
                        
                        while ((line = reader.readLine()) != null) {
                            newWriter.write(line);
                            newWriter.newLine();
                        }

                        System.out.println("Contents copied successfully from " + baseFileName + " to " + filename);
                    } catch (IOException e) {
                        System.out.println("Error copying contents: " + e);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("The file " + baseFileName + " does not exist or is not a valid file name.");
                    
                }
            }
        }

            
		if(userChoice.equals("2")) {
			System.out.println("Enter the name of the file to display: ");
			String fileNameDisplay = scanner.nextLine();
			File fileDisplay = new File(fileNameDisplay);
			
			if (fileDisplay.exists() && fileDisplay != null && fileDisplay.isFile()){
				try (BufferedReader reader = new BufferedReader(new FileReader(fileDisplay))) {
                    System.out.println("Content of the file " + fileDisplay + ":");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading the file: " + e);
                    e.printStackTrace();
                }
			}else {
				System.out.println("This file does not exist, returning to main screen.");
				
			}
		}if(userChoice.equals("3")) {
			System.out.println("Enter the name of the file to search in: ");
			String fileName = scanner.nextLine();
            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
            	System.out.println("Enter a word you want to search for: ");
            	String fileWord = scanner.nextLine();
            	try (BufferedReader newReader = new BufferedReader(new FileReader(file))) {
                    String line;
                    
                    while ((line = newReader.readLine()) != null) {
                        if (line.contains(fileWord)) {
                            System.out.println("Found " + fileWord + " in: " + line);
                            boolean found = true;
                        if(!found) {
                        	System.out.println("No lines containing " + fileWord + " were found.");
                        }
			
                    } 
                 }
                    
            	}catch(IOException e){
            		System.out.println("Something went wrong. Please try again.");
            		e.printStackTrace();
            	}
            }
			
		}if(userChoice.equals("4")) {
			System.out.println("Which file would you like to delete? Enter it here: ");
			String fileNameDelete = scanner.nextLine();
			File fileDelete = new File(fileNameDelete);
			if(fileDelete.exists() && fileDelete != null && fileDelete.isFile()) {
		            if (fileDelete.delete()) {
		                System.out.println("File deleted successfully.");
		            } else {
		                System.out.println("Failed to delete the file.");
		            }
		        }
		 else {
		   System.out.println("The file already does not exist. Return to main screen.");
		}
	}
    
		
			if(userChoice.equals("5")) {
			System.out.println("Closing program..");
			System.exit(0);
			
			}
			
			scanner.close();
		}
	}
    


