import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Directory {
    void readDirectory(String filename , String input) throws IOException {
        Pattern pattern = Pattern.compile("\\-[cwla]");
        Matcher matcher = pattern.matcher(input);
        File filedirectory = new File(filename);
        File[] files = filedirectory.listFiles();
        for (File file : files){
            if (file.isDirectory())
                readDirectory(file.getPath(),input);
            else
                new Command().command(input,file.getPath(),matcher);
        }
    }
}
