import javax.swing.*;
import java.io.*;

public class Basicfunction{

    String s1 = null,s2 = null;
    int ccount = 0,wcount = 0,lcount = 0;

    public void read(String filename) throws IOException{
        BufferedReader brin = new BufferedReader(new FileReader(filename));
        while ((s1=brin.readLine())!=null){
            ccount += s1.length();
            s1 = s1 + " ";
            s2 += s1;
            lcount ++;
            s1 = s1.replaceAll("[^a-zA-Z]"," ");
            String[] sarr = s1.split("\\s+");
            wcount += sarr.length;
        }
        brin.close();
    }
    public int c(String filename){
        read(filename);
        return ccount;
    }

}
