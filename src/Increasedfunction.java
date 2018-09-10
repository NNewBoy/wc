import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Increasedfunction {
    private String s1 = null;
    private int emptyLine = 0,codeLine = 0,explainLine = 0,lineCount = 0,emptyCharCount = 0,displayCharCount = 0;

    private void read(String filename) throws IOException {
        BufferedReader brin = new BufferedReader(new FileReader(filename));
        while ((s1=brin.readLine())!=null){
            Pattern pattern1 = Pattern.compile("\\S\\W");
            Matcher matcher1 = pattern1.matcher(s1);
            while (matcher1.find()) {
                emptyCharCount++;
            }
            Pattern pattern2 = Pattern.compile("\\w");
            Matcher matcher2 = pattern2.matcher(s1);
            while (matcher2.find()) {
                displayCharCount++;
            }
            if (s1.equals("\\s+")||emptyCharCount<=1)
                emptyLine++;
        }
        brin.close();
    }
}
