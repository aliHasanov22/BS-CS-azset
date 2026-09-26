public class Main{
    public static void main(String[] args) {
        Homework1 program = new Homework1("Java Programming", 3, "English", "Main Campus");
        System.out.println(program.getDisplayName());
        System.out.println(program.toString());
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