import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Increasedfunction {
    private int emptyLine = 0,codeLine = 0,explainLine = 0,lineCount = 0;

    //通过正则表达式匹配指定字符
    private int match(String regex , String sentence) {
        int i = 0;
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher1 = pattern1.matcher(sentence);
        while (matcher1.find()) {
            i++;
        }
        return i;
    }

    private void read(String filename) throws IOException {
        //空字符数
        int emptyCount;
        //各种标点符号数
        int emptyCharCount;
        //词数
        int displayCharCount;
        //单行注释符"//"
        int explainCount1;
        //多行注释开始"/*"
        int explainCount2;
        //多行注释结束"*/"
        int explainCount3;
        //含有注释符"/*"的代码行
        int explainCount4;
        //含有注释符"//"的代码行
        int explainCount5;
        String s1;
        Boolean explainValue = false;
        BufferedReader brin = new BufferedReader(new FileReader(filename));
        while ((s1=brin.readLine())!=null) {
            emptyCount = match("\\s",s1);
            emptyCharCount = match("\\S\\W",s1);
            displayCharCount = match("\\w",s1);
            explainCount1 = match("\\/\\/",s1);
            explainCount2 = match("\\/\\*",s1);
            explainCount3 = match("\\*\\/",s1);
            explainCount4 = match("\\S{2,}.*\\/\\*",s1);
            explainCount5 = match("\\S{2,}.*\\/\\/",s1);
            if (explainCount2 != 0) {
                //多行注释开始，判断是注释行还是代码行
                explainValue = true;
                if (explainCount4 != 0) {
                    explainLine--;
                    codeLine++;
                }
            } else if (explainCount3 != 0) {
                //多行注释结束
                explainValue = false;
                explainLine++;
            } else if (explainCount1 != 0) {
                //含单行注释，判断是注释行还是代码行
                if (explainCount5 != 0) {
                    codeLine++;
                } else {
                    explainLine++;
                }
            } else if (!explainValue && displayCharCount == 0 && (emptyCount != 0 || emptyCharCount <= 1)) {
                //空行情况
                emptyLine++;
            } else if (!explainValue) {
                //剩下的是代码行
                codeLine++;
            }
            if (explainValue) {
                //多行注释，超过两行的情况
                explainLine++;
            }
            if (explainCount2 != 0 && explainCount3 != 0) {
                //多行注释只有一行的情况
                explainLine--;
            }
        }
        brin.close();
    }

    public void a(String filename) {
        try {
            read(filename);
            System.out.println("空行数："+emptyLine);
            System.out.println("代码行数："+codeLine);
            System.out.println("注释行数："+explainLine);
        } catch (Exception e) {
            System.out.println("输入路径出错");
        }
    }
}
