import java.util.List;

public class helloworld {

    public static void main(String[] args) {
        List<String> c = List.of("Passed", "Failed");
        int score = 92;
        String status = "";
        if (score >= 91) {
            status = c.get(0);
        } else if (score <= 90 && score > 80) {
            status = c.get(0);
        } else {
            status = c.get(1);
        }

        System.out.println("Status: " + status);
    }
}
