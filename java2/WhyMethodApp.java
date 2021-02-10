import java.io.FileWriter;
import java.io.IOException;

public class WhyMethodApp {
    public static void main(String[] args) throws IOException {
        System.out.println(twoTimes("a", "-"));

        FileWriter fw = new FileWriter("output.txt");

        fw.write(twoTimes("a", "*"));
        
        fw.close();

        // Email.send("junhwanyun@junhwanyun.com" "two times a", "twoTimes("a", "&"));
    }

    public static String twoTimes(String str, String dlmtr) {
        String res = "";

        res += dlmtr + "\n";
        res += str + "\n";
        res += str + "\n";
        
        return res;
    }
}