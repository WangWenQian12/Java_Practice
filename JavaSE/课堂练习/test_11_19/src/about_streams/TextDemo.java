package about_streams;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TextDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\比特科技\\课程\\JavaWeb\\Java11班\\2019-11-29-文件IO\\测试目录\\测试文件.txt");
        /*
        InputStream is = new FileInputStream(file);
        InputStreamReader isReader = new InputStreamReader(is, "GB18030");
        char[] buf = new char[10];
        int len = isReader.read(buf);
        System.out.println(Arrays.toString(buf));
        */
        /*
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "GB18030")
        );
        reader.readLine();
        */




        InputStream is = new FileInputStream(file);
        Scanner scanner = new Scanner(is);
        System.out.println(scanner.next());
    }
}
