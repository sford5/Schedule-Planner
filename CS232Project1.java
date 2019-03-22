package cs232project1;
//main class which opens the CSV class list file and implements the course classes for the schedule system
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.HashMap;

public class CS232Project1 {

    public static void main(String[] args) {
        
        String line;
        ArrayList<Course> data = new ArrayList<>(); 
        ArrayList<Course> trialschedule = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<Course> temp2 = new ArrayList<>();
        ArrayList<Integer> keys = new ArrayList<>();
        HashMap<Integer, Course> temporarycourse = new HashMap<>();
       
     
        
        try {
            

            Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
            
            
            
            while ( in.hasNextLine() ) {
                
                
                
                line = in.nextLine();
                
                
                
                temp = new ArrayList(Arrays.asList(line.split("\t")));
                if (temp.size() > 7) {
                    String coursename = temp.get(0);
                    int crnnumber = Integer.parseInt(temp.get(1));
                    String coursenumber = temp.get(2);
                    int sectionnumber = Integer.parseInt(temp.get(3));
                    int credithours = Integer.parseInt(temp.get(4));
                    LocalTime start = LocalTime.parse(temp.get(5));
                    LocalTime stop = LocalTime.parse(temp.get(6));
                    String days = temp.get(7);
                    String room = temp.get(8);
                    String type = temp.get(9);
                    String instructor = temp.get(10);
                    TraditionalCourse tc = new TraditionalCourse(coursename, crnnumber, coursenumber, sectionnumber, credithours, start, stop, days, room, type, instructor);
                    data.add(tc);
               } 
                
                else {
                    String coursename = temp.get(0);
                    int crnnumber = Integer.parseInt(temp.get(1));
                    String coursenumber = temp.get(2);
                    int sectionnumber = Integer.parseInt(temp.get(3));
                    int credithours = Integer.parseInt(temp.get(4));
                    String type = temp.get(5);
                    String instructor = temp.get(6);
                    WebCourse wc = new WebCourse(coursename, crnnumber, coursenumber, sectionnumber, credithours, type, instructor);
                    data.add(wc);
                }
                
                

            }
            
           
            in.close();

         
            int choice = 0;
            String coursenumber;
            int crnnumber;
            Scanner scan = new Scanner(System.in);
            
            while (choice != 4) {
                
                int counter = 0;
                System.out.println("");
                System.out.println("1) Search Courses");
                System.out.println("2) Register for Course");
                System.out.println("3) View Trial Schedule");
                System.out.println("4) Quit");
                System.out.println("");
                System.out.print("Your choice? ");
                choice = scan.nextInt();
                scan.nextLine();
                if (choice == 1) {
                    System.out.print("Enter course number in the format SSNNN (for example, CS201): ");
                    coursenumber = scan.nextLine();
                    for (Course c : data){
                        if (c.getCoursenumber().replaceAll("\\s","").equals(coursenumber.toUpperCase())) { 
                            System.out.println(c);
                            
                        }
                    }
                    
                    
                
                }
                
                for (Course c : data) {
                    temp2.add(c);
                    keys.add(c.getCrnnumber());
                    for (int i = 0; i < keys.size(); i++) {
                        temporarycourse.put(keys.get(i), temp2.get(i));
                    }
                    
                    
                }
                
                if (choice == 2) {
                    System.out.print("Enter CRN number: ");
                    crnnumber = scan.nextInt();
                    
                    if (trialschedule.size() > 0) {
                        
                    
                        if (temporarycourse.get(crnnumber).conflictsWith(trialschedule.get(counter))) {
                            System.out.println("ERROR: Either the course was not found, or it conflicts with your current schedule!");
                        
                        }
                        else {
                            System.out.println("Course added successfully!");
                            trialschedule.add(temporarycourse.get(crnnumber));
                        
                            counter++;
                        }
                    }
                    
                    while (trialschedule.isEmpty()) {
                        if (temporarycourse.containsKey(crnnumber)) {
                            trialschedule.add(temporarycourse.get(crnnumber));
                            System.out.println("Course added successfully!");
                            
                        }
                        else {
                            System.out.println("ERROR: Either the course was not found, or it conflicts with your current schedule!");
                            
                        }
                        
                        
                    }
                        
                }    
                    
                
                if (choice == 3) {
                    for (int i = 0; i < trialschedule.size(); i++) {
                        System.out.println(trialschedule.get(i));
                        
                    }
                    
                    
                }
                
            }
            
                
            
            if (choice == 4) {
                System.out.println("");
                System.out.println("Thanks for using the Student Registration System!");
            }
            
            
            
            
        }
        
        catch (Exception e) {
            
            System.err.println(e.toString());
            
        }
    }
    
}
