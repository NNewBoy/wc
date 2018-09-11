import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("输入命令：");
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        String[] filearr = in.split("\\s");
        String filename = filearr[filearr.length-1];
        Pattern pattern = Pattern.compile("\\-[cwlsa]");
        Matcher matcher = pattern.matcher(in);
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
                    break;
                case "-a":
                    new Increasedfunction().a(filename);
                    break;
                default:
                    System.out.println("命令输入错误");
            }
        }

    }
}
