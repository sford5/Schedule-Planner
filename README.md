# Schedule-Planner
## Overview
I am Steven Ford. I am a Junior here at JSU and am a Computer Science major with an Information Assurance concentration. This schedule planner project takes a CSV file that contains MCIS courses here at JSU and implements them into a simple schedule planner registration cart. The program does not allow registration for classes that have conflicting class times with one another or that do not exist in the CSV file. This was the first project in my CS 232 course. This program is implemented in Java and is made up of four classes. These are: 

- **CS232Project1.java**
- **Course.java**
- **TraditionalCourse.java**
- **WebCourse.java**

### CS232Project1.java
This is the main class that deals with the logic of the program and implements the three course classes. This class also opens the CSV file for use with the program. At the start of the class, I created five ArrayLists. They consist of the **data** ArrayList of type **Course**, the **'trialschedule'** ArrayList of type **Course**, a temporary ArrayList, **temp**, of type String, a temporary ArrayList, **temp2** of type **Course**, and finally ArrayList, **keys**, of type Integer. I also created a String called **line** and a HashMap, **temporarycourse** with (key, value) pairs of (Integer, Course). Within a try block, I opened the connection to the CSV file with:

```
 Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
```
After successful connection, I loop through all of the lines of the CSV file and parse them into the **temp** ArrayList by the tab characters. If the **temp** ArrayList size is greater than 7, create a TraditionalCourse object. If it is not made up of 7 elements, create a WebCourse object. I then add the courses to the **data** ArrayList. Next, I closed the connection to the CSV with:

```
in.close();
```
I created an Integer called **choice** and initialized it to 0. I also created a String for **coursenumber** and an Integer for **crnnumber**. I used a Scanner, **scan**. While the **choice** does not equal 4, I created a counter, **counter**, to 0. I also print out the menu of choices to the screen. Choice 1 is for searching courses, choice 2 is registering for courses, choice 3 is viewing the trial schedule, and choice 4 is to quit the program which breaks out of the while loop. I used the **scan** Scanner to obtain the user's choice and place in the **choice** Integer. The program adds a course to the **trialschedule** only if it does not conflict with the time of another course in the trial schedule. It then increments the **counter** showing that **trialschedule** contains a course.

### Course.java
This is the abstract super class for courses. The fields are String **coursename**, int **crnnumber**, String **coursenumber**, int **sectionnumber**, int **credithours**, String **instructor**, and String **type**. The String **type** is used to determine whether the class is a traditional type class or a web course. I then initialize a **Course** object with the constructor. Next I use setters and getters for the fields. Lastly, I have an abstract boolean method **conflictsWith** that takes a **Course** object as an argument. This method is used to determine if classes in the schedule conflict with one another on their class times.

### TraditionalCourse.java
This class extends the parent **Course** class. This class is a traditional class that meets in a room specific times and days of the week. Besides the normal **Course** fields, **TraditionalCourse** has a String field **room**, String **days**, LocalTime **start**, and LocalTime **stop** for the building and room number, days the class meets, and start and stop times for the class. It has getter methods for the start and stop times and the days and rooms. This class also has a **toString()** method for formatting the course in a readable way for printing to the screen. Lastly, it implements the **conflictsWith** method.

### WebCourse.java
This class also extends the parent **Course** class. This class only implements the fields from the parent **Course** class and has its own **toString()** method for printing it to the screen. This class also uses the **conflictsWith** method that always returns false since the web classes do not meet at specific times or days since it is hosted online.

            
