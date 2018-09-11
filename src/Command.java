import java.util.*;
import java.util.regex.Matcher;

public class Command {
    void command(String input,String filename,Matcher matcher){
        try {
            Boolean s = false;
            List<String> commands = new ArrayList<>();
            while (matcher.find()) {
                String command = matcher.group();
                if (command.equals("-s")) {
                    s = true;
                } else
                    commands.add(command);
            }
            if (s) {
                new Directory().readDirectory(filename, input);
            } else {
                System.out.println("文件：" + filename);
                for (String command1 : commands) {
                    switch (command1) {
                        case "-c":
                            new Basicfunction().c(filename);
                            break;
                        case "-w":
                            new Basicfunction().w(filename);
                            break;
                        case "-l":
                            new Basicfunction().l(filename);
                            break;
                        case "-a":
                            new Increasedfunction().a(filename);
                            break;
                        default:
                            System.out.println("命令输入错误");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("输入路径出错");
        }
    }
}
