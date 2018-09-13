import junit.framework.TestCase;
import org.junit.Test;
import java.io.*;

public class MainTest extends TestCase {
    @Test
    public void testMain() throws IOException {
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        System.setOut(cacheStream);//不打印到控制台
        new Main().input("-s -c -w -l -a D:/test/test1/1.txt");
        String message = baoStream.toString();
        assertEquals("输入路径出错\r\n",message);
    }
}