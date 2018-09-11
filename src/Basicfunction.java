import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basicfunction{

    private String s1 = null,s2 = null;
    private int ccount = 0,wcount = 0,lcount = 0;

    private void read(String filename) throws IOException{
        BufferedReader brin = new BufferedReader(new FileReader(filename));
        while ((s1=brin.readLine())!=null){
            ccount += s1.length();
            s1 = s1 + " ";
            s2 += s1;
            lcount ++;
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(s1);
            while (matcher.find())
                wcount++;
        }
        brin.close();
    }

    public void c(String filename) throws IOException{
        read(filename);
        System.out.println("字符数："+ccount);
    }

    public void w(String filename) throws IOException{
        read(filename);
        System.out.println("词的数目："+wcount);
    }

    public void l(String filename) throws IOException{
        read(filename);
        System.out.println("行数："+lcount);
    }
}
