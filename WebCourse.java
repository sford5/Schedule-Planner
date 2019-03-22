package cs232project1;
//this class creates web courses for registration
import java.util.Formatter;
public class WebCourse extends Course {
    public WebCourse(String coursename, int crnnumber, String coursenumber, int sectionnumber, int credithours, String instructor, String type){
        super(coursename, crnnumber, coursenumber, sectionnumber, credithours, instructor, type);
    }
    
    //method for printing the courses to the screen
    @Override
    public String toString() {
        String w = "#" + super.getCrnnumber() + ": " + super.getCoursenumber() + "-" + String.format("%03d", super.getSectionnumber()) + " " + "(" + super.getCoursename() + "), " + super.getInstructor() + ", " + super.getType();
        return w;
    }
    //method to determine whether two registered courses conflict with one another
    @Override
    public boolean conflictsWith(Course c) {
        return false;
    }
}
