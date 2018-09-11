import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {
    void command(String input,String filename,Matcher matcher) throws IOException {
        int i = 0;
        System.out.println("文件："+filename);
        while (matcher.find()) {

            String command = matcher.group();
            switch (command){
                case "-c":
                    new Basicfunction().c(filename);
                    break;
                case "-w":
                    new Basicfunction().w(filename);
                    break;
                case "-l":
                    new Basicfunction().l(filename);
                    break;
                case "-s":
                    new Directory().readDirectory(filename,input);
                    break;
                case "-a":
                    new Increasedfunction().a(filename);
                    break;
                default:
                    System.out.println("命令输入错误");
            }
            i++;
        }

    }
}
