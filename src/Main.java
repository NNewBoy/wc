import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("----------------------命令格式----------------------");
        System.out.println("-c [文件路径]  \\返回字符数");
        System.out.println("-w [文件路径]  \\返回词的数目");
        System.out.println("-l [文件路径]  \\返回行数");
        System.out.println("-a [文件路径]  \\返回空行、代码行、注释行的数目");
        System.out.println("-s -c/w/l/a [目录路径]  \\递归处理目录下符合条件的文件");
        System.out.println("----------------------------------------------------");
        System.out.print("输入命令：");
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        String[] filearr = in.split("\\s");
        String filename = filearr[filearr.length-1];
        Pattern pattern = Pattern.compile("\\-[cwlsa]");
        Matcher matcher = pattern.matcher(in);
        new Command().command(in,filename,matcher);
    }
}
