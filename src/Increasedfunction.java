import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Increasedfunction {
    private int emptyLine = 0,codeLine = 0,explainLine = 0,lineCount = 0;

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
        int emptyCount;
        int emptyCharCount;
        int displayCharCount;
        int explainCount1;
        int explainCount2;
        int explainCount3;
        int explainCount4;
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
                explainValue = true;
                if (explainCount4 != 0) {
                    explainLine--;
                    codeLine++;
                }
            } else if (explainCount3 != 0) {
                explainValue = false;
                explainLine++;
            } else if (explainCount1 != 0) {
                if (explainCount5 != 0) {
                    codeLine++;
                } else {
                    explainLine++;
                }
            } else if (!explainValue && displayCharCount == 0 && (emptyCount != 0 || emptyCharCount <= 1)) {
                emptyLine++;
            } else if (!explainValue) {
                codeLine++;
            }
            if (explainValue) {
                explainLine++;
            }
            if (explainCount2 != 0 && explainCount3 != 0) {
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
