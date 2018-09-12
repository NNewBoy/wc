import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandTest extends TestCase {
    String output(String input , String filename) {
        Pattern pattern = Pattern.compile("\\-[cwlsa]");
        Matcher matcher = pattern.matcher(input);
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);//不打印到控制台
        Command command = new Command();
        command.command(input,filename,matcher);
        String message = baoStream.toString();
        return message;
    }
    @Test
    public void testCommand() {
        assertEquals("文件：D:\\test\\test1\\2.txt\r\n" +
                "字符数：1\r\n" +
                "词的数目：1\r\n" +
                "行数：1\r\n" +
                "空行数：0\r\n" +
                "代码行数：1\r\n" +
                "注释行数：0\r\n",output("-s -c -w -l -a D:/test/test1","D:/test/test1"));
        assertEquals("文件：D:/test/test1\r\n"+
                "输入路径出错\r\n" +
                "输入路径出错\r\n" +
                "输入路径出错\r\n" +
                "输入路径出错\r\n",output("-c -w -l -a D:/test/test1","D:/test/test1"));
        assertEquals("输入路径出错\r\n"
                ,output("-s -c -w -l -a D:/test/test1/1.txt","D:/test/test1/1.txt"));
        assertEquals("文件：D:/test/test1/1.txt\r\n"
                ,output("-q D:/test/test1/1.txt","D:/test/test1/1.txt"));
        assertEquals("文件：D:/test/代码文档.txt\r\n" +
                "空行数：1\r\n" +
                "代码行数：3\r\n" +
                "注释行数：3\r\n",output("-a D:/test/代码文档.txt","D:/test/代码文档.txt"));
    }
}