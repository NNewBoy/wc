import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Directory {
    void readDirectory(String filename , String input) {
        Pattern pattern = Pattern.compile("\\-[cwla]");
        Matcher matcher = pattern.matcher(input);
        File filedirectory = new File(filename);
        File[] files = filedirectory.listFiles();
        for (File file : files) {
            //遍历路径里的文件夹
            if (file.isDirectory()) {
                readDirectory(file.getPath(),input);
            } else {
                //实现-c -w -l -a 命令
                new Command().command(input,file.getPath(),matcher);
            }
        }
    }
}
