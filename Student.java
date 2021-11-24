import java.util.*;
import java.text.*;

public class Student{
   int reg;
   String name;
   GregorianCalendar date;
   short sem;
   float gpa;
   float cgpa;
   
   
   Student(){
     this.reg = 0;
     this.name = "";
     this.date = new GregorianCalendar();
     this.sem = 0;
     this.gpa = 0.0f;
     this.cgpa = 0.0f;
   }
   
   //parameterized constructor to the class
   
   Student(Student s){
    this.reg=s.reg;
    this.name=s.name;
    this.date = s.date;
    this.sem = s.sem;
    this.gpa = s.gpa;
    this.cgpa = s.cgpa;
   }
   
   //Override toString method to display the student record
   
   public String toString(){
     return "Name: "+this.name+"\nReg No.: "+this.reg+"\nJoining Date: "+this.date.get(Calendar.DATE)+"/"+this.date.get(Calendar.MONTH)+"/"+this.date.get(Calendar.YEAR)+"\nSemester: "+this.sem+"\nGPA: "+this.gpa+"\nCGPA: "+this.cgpa;
   }
   
   
   //taking input
   
   public void input(){
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter name:");
     this.name = sc.nextLine();
     System.out.print("Enter Date of Joining (yyyy mm dd): ");
     this.date = new GregorianCalendar(sc.nextInt(),sc.nextInt(),sc.nextInt());
     System.out.print("Enter Semester: ");
     this.sem = sc.nextShort();
     System.out.print("Enter GPA: ");
     this.gpa = sc.nextFloat();
     System.out.print("ENter CGPA: ");
     this.cgpa = sc.nextFloat();
     System.out.println();
   }
   
   //making another class to take multiple inputs
   public class Students{
     Student students[];
     int size;
     
     
    //making an array of class Student
    //array of student records to store minimum of 5 records in it.
     public Students(int s){
       this.size=s;
       this.students=new Student[s];
     }
     
     //taking input for multiple students
     //Input the records 
     public void inputall(){
       int i;
       for(i=0;i<this.size;i++){
        System.out.println("Enter Student "+ (i+1) +" details:");
        students[i] = new Student();
	students[i].input();
	String reg = Integer.toString(students[i].date.get(Calendar.YEAR)%100);
	reg += String.format("%02d", i+1);
	students[i].reg = Integer.parseInt(reg);
       } 
     }
     
     //method to dislay the student inputs
     //display them.
     public void display(){
       int i;
       for(i=0;i<this.size;i++){
	  System.out.println("Student"+" "+(i+1)+":");
	  System.out.println(students[i]);
	  System.out.println();
	}
     }
     
     //method to alphabetically sort the students based on Full name
     public void sort(){
       int i,j;
       for(i=0;i<this.size-1;i++){
        for(j=0;j<this.size-i-1;j++){
          if(students[j].name.charAt(i) > (students[j+1].name.charAt(i))){
            Student temp = students[j];
	    students[j] = students[j+1];
	    students[j+1] = temp;
          }
        }
       }
     }
     
     //method to list all the student names containing a particular sub string
     public void search(char sub){
       int i,j;
       for(i=0;i<this.size;i++){
         String find=students[i].name;
         for(j=0;j<find.length();j++){ 
          if(find.charAt(i)==sub){
             System.out.println(students[i].name);
          }
         }
         
       }
     
     }
     
   }
   
   public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int size;
	System.out.print("Enter number of Student Records:  ");
	size = sc.nextInt();
	if(size < 5){
	   size=5;
	   }
	Student student = new Student();
	Students s = student.new Students(size);
	System.out.println();
	s.inputall();

	System.out.println("Students Details after sorting names alphabetically:");
	s.sort();
	s.display();

	sc.nextLine();
	System.out.print("Enter the substring to be searched in the names: ");
	char str = sc.next().charAt(0);

	System.out.println("The names with substring "+"'"+str+"'"+":");
	s.search(str);
	}
  }

