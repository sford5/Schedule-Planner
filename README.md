# Schedule-Planner
## Overview
I am Steven Ford. I am a Junior here at JSU and am a Computer Science major with an Information Assurance concentration. This schedule planner project takes a CSV file that contains MCIS courses here at JSU and implements them into a simple schedule planner registration cart. The program does not allow registration for classes that have conflicting class times with one another or that do not exist in the CSV file. This was the first project in my CS 232 course. This program is implemented in Java and is made up of four classes. These are: 

- **CS232Project1.java**
- **Course.java**
- **TraditionalCourse.java**
- **WebCourse.java**

### CS232Project1.java
This is the main class that deals with the logic of the program and implements the three course classes. This class also opens opens the CSV file for use with the program. At the start of the class, I create five **ArrayLists**. They consist of the data ArrayList of type Course, the trial schedule ArrayList of type Course, a temporary ArrayList, temp, of type String, a temporary ArrayList, temp2 of type Course, and finally ArrayList, keys, of type Integer. I also created a String called line and a HashMap, temporarycourse with (key, value) pairs of (Integer, Course). Within a try block
