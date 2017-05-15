package fileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class WritingFileDemo {
    public static void main(String[] args) throws IOException {
        File[] roots = File.listRoots();
        File users = new File(roots[0], "Users");
        File anony = new File(users, "anony");
        File java = new File(anony, "java");
        File javalog = new File(java, "javalog.txt");

        FileOutputStream fos_1 = new FileOutputStream(javalog);
        FileOutputStream fos_2 = new FileOutputStream(javalog, true);
    }
}
