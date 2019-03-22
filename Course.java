package cs232project1;
//super course class; has attributes that all types of courses share
public abstract class Course {
    private String coursename;
    private int crnnumber;
    private String coursenumber;
    private int sectionnumber;
    private int credithours;
    private String instructor;
    private String type;
    //contsructor
    public Course(String coursename, int crnnumber, String coursenumber, int sectionnumber, int credithours, String instructor, String type) {
        this.coursename = coursename;
        this.crnnumber = crnnumber;
        this.coursenumber = coursenumber;
        this.sectionnumber = sectionnumber;
        this.credithours = credithours;
        this.instructor = instructor;
        this.type = type;
    }
    //setters & getters
    public int getCrnnumber() {
        return crnnumber;
    }
    public String getCoursenumber() {
        return coursenumber;
    }
    public String getCoursename() {
        return coursename;
    }
    public String getInstructor() {
        return instructor;
    }
    public String getType() {
        return type;
    }
    public int getSectionnumber() {
        return sectionnumber;
    }
    
    //method to determine whether two registered courses conflict with one another
    public abstract boolean conflictsWith(Course c);

}
