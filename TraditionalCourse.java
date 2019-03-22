package cs232project1;
//This class provides methods for creating a traditional classroom course and registering for the course.
import java.time.LocalTime;
import java.util.Formatter;
public class TraditionalCourse extends Course {
    private String room;
    private String days;
    private LocalTime start;
    private LocalTime stop;
    
    //constructor
    public TraditionalCourse(String coursename, int crnnumber, String coursenumber, int sectionnumber, int credithours, LocalTime start, LocalTime stop, String days, String room, String type, String instructor){
        super(coursename, crnnumber, coursenumber, sectionnumber, credithours, instructor, type);
        this.start = start;
        this.stop = stop;
        this.days = days;
        this.room = room;
    }
    //setters & getters
   public LocalTime getStart() {
       return start;
   }
   public LocalTime getStop() {
       return stop;
   }
   public String getDays() {
       return days;
   }
   public String getRoom() {
       return room;
   }
   //method for printing the courses to the screen
    @Override
   public String toString() {
       String t = "#" + super.getCrnnumber() + ": " + super.getCoursenumber() + "-" + String.format("%03d", super.getSectionnumber()) + " " + "(" + super.getCoursename() + "), " + super.getInstructor() + ", " + super.getType() + ", " + getStart() + " - " + getStop() + ", " + getDays() + ", " + getRoom();
       return t;
   }
   //method to determine whether two registered courses conflict with one another
    @Override
   public boolean conflictsWith(Course c) {
       LocalTime start = getStart();
       LocalTime stop = getStop();
       return(start.isBefore(((TraditionalCourse) c).getStart()) && stop.isAfter(((TraditionalCourse) c).getStart()) || (start.equals(((TraditionalCourse)c).getStart()) && stop.equals(((TraditionalCourse)c).getStop()) || start.isBefore(((TraditionalCourse)c).getStart()) && stop.isAfter(((TraditionalCourse)c).getStop())));
       
       
    }
}
    
