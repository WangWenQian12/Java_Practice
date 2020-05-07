package about_files;

import java.io.File;

//"E:\\code\\JavaSE\\IDEA\\课堂代码\\test_11_19"


//递归展开所有目录里的文件
public class ListDir {
    public static void listDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listDir(file);
            } else {
                System.out.println(file.getAbsolutePath() + ": " + file.length());
            }
        }
    }
    public static void main(String[] args) {
        listDir(new File("E:\\code"));
    }
}
