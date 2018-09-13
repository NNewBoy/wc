import java.util.*;
import java.util.regex.Matcher;

public class Command {
    void command(String input,String filename,Matcher matcher) {
        try {
            Boolean s = false;
            List<String> commands = new ArrayList<>();
            while (matcher.find()) {
                //将接收到的命令存入动态数组中
                String command = matcher.group();
                //判断是否接收到-s
                if (command.equals("-s")) {
                    s = true;
                } else {
                    commands.add(command);
                }
            }
            //实现-s命令
            if (s) {
                new Directory().readDirectory(filename, input);
            } else {
                //实现其他命令
                System.out.println("文件：" + filename);
                for (String command1: commands) {
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
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("输入路径出错");
        }
    }
}
