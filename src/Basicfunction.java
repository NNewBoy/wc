import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basicfunction {
    private String s1;
    private String s2;
    private int ccount;
    private int wcount;
    private int lcount;

    private void read(String filename) throws IOException {
            BufferedReader brin = new BufferedReader(new FileReader(filename));
            while ((s1=brin.readLine())!=null) {
                ccount += s1.length();//统计字符数
                s1 = s1 + " ";
                s2 += s1;
                lcount ++;//统计行数
                Pattern pattern = Pattern.compile("\\w+");
                Matcher matcher = pattern.matcher(s1);
                while (matcher.find()) {
                    wcount++;//统计词数
                }
            }
            brin.close();
    }

    public void c(String filename) {
        try {
            read(filename);
            System.out.println("字符数："+ccount);
        } catch (Exception e) {
            System.out.println("输入路径出错");
        }
    }

    public void w(String filename) {
        try {
            read(filename);
            System.out.println("词的数目："+wcount);
        } catch (Exception e) {
            System.out.println("输入路径出错");
        }
    }

    public void l(String filename) {
        try {
            read(filename);
            System.out.println("行数："+lcount);
        } catch (Exception e) {
            System.out.println("输入路径出错");
        }
    }
}
