
// i didnt use scanner i just used the main method to test the code
public class Main{
    public static void main(String[] args) {
        Homework1 program = new Homework1("Java Programming", 3, "English", "Main Campus");
        System.out.println(program.getDisplayName());
        System.out.println(program.toString());
        Student s1 = new Student("Ali", "Hasanov", "251617010", "Camputer Architecture", "Fundementals of Programming", 1.2, 1.4);
        System.out.println(s1.getaverage());
        s1.honorStudentMessage();
        System.out.println(s1.toString());
        // invalid subject
        s1.updateGrade("Math", 1.0);
        // change subject1 and subject2 grade
        s1.updateGrade("Camputer Architecture", 1.0);
        s1.updateGrade("Fundementals of Programming", 1.0);

        System.out.println(s1.getaverage());
        s1.honorStudentMessage();
        System.out.println(s1.toString());
        // low grades
        s1.updateGrade("Camputer Architecture", 2.4);
        s1.updateGrade("Fundementals of Programming", 2.6);
        System.out.println(s1.getaverage());
        s1.honorStudentMessage();
        System.out.println(s1.toString());
    }
}


class Homework1 {
    //encapsulation
    private String title;
    private int credits;
    private String courseLanguage;
    private String location;
    public Homework1(String title, int credits, String courseLanguage, String location) {
        this.title = title;
        this.credits = credits;
        this.courseLanguage = courseLanguage;
        this.location = location;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getDisplayName() {
        return title + " (at Campus " + location + ")";
    }

    @Override
    public String toString() {
        return "Program{" +"title='" + title + '\'' + ", credits=" + credits + ", courseLanguage='" + courseLanguage + '\'' + ", location='" + location + '\'' +'}';
    } 
}
class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private String subject1;
    private String subject2;
    private double subject1Grade;
    private double  subject2Grade;
    private double average = 0.0; 

    Student(String firstName, String lastName, String studentID, String subject1, String subject2, double subject1grade, double subject2grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject1Grade = subject1grade;
        this.subject2Grade = subject2grade;
        this.average = calculateAverage();
    }
    String getfirstName(){
        return firstName;
    }
    String getlastName() {
        return lastName;
    }
    String getstudentID(){
        return studentID;
    }
    String getsubject1(){
        return subject1;
    }
    String getsubject2(){
        return subject2;
    }
    double getsubject1Grade(){
        return subject1Grade;
    }
    double getsubject2Grade(){
        return subject2Grade;
    }
    double getaverage(){
        return this.average;
    }
    public void setfirstname(String firstname){
        this.firstName = firstname;
    }
    public void setlastname(String lastname){
        this.lastName =lastname;
    }
    public void setstudentid(String studentid){
        this.studentID =studentid;
    }
    public void setsubject1(String subject1){
        this.subject1 =subject1;
    }
    public void setsubject2(String subject2){
        this.subject2 =subject2;
    }
    public void setsub1grade(double sub1grade) {
        this.subject1Grade = sub1grade;
    }
    public void setsub2grade(double sub2grade) {
        this.subject2Grade = sub2grade;
    }

    public void updateGrade(String subject, double newGrade) {
        if (subject.equals(subject1)) {
            this.subject1Grade = newGrade;
        } 
        else if (subject.equals(subject2)) {
            this.subject2Grade = newGrade;
        } 
        else {
            System.out.println("Invalid subject.");
        }
        calculateAverage();
    }
    public double calculateAverage() {
        average = (this.subject1Grade + this.subject2Grade) / 2.0;
        return average;
    }

    public void honorStudentMessage() {
        if (average < 1.5) {
            System.out.println("Excellent performance, honor student!");
        }
        else {
        System.out.println("Keep working hard!");
        }
    }

    @Override
    public String toString() {
        return "Student{" + "firstname: '"+ firstName + '|' + "Lastname: '" + lastName + '|' + "StudentID: '" + studentID + '|' + "Subject1: '" + subject1 + '|' + "Subject2: '" + subject2 + '|' + "Subject1Grade: '" + subject1Grade + '|' + "Subject2Grade: '" + subject2Grade + '|' + "Average: '" + average + '}';
    }



}