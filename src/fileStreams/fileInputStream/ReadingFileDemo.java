package fileStreams.fileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.*;
/**
 * Created by anonymous.vn1985@gmail.com
 */
public class ReadingFileDemo {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        File dir1 = new File(roots[0], "Users");
        File dir2 = new File(dir1, "anony");
        File dir3 = new File(dir2, "Documents");
        File child = new File(dir3, "Directory_Data\\Example_4.java");
        System.out.println(Arrays.toString(roots));
        try {
            FileInputStream fis = new FileInputStream(child);
            //FileInputStream fis = new FileInputStream("C:\\Users\\anony\\Documents\\Directory_Data\\Example_4.java");
            for (int n = fis.read(); n != -1; n = fis.read()) {
                System.out.write(n);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File is not found");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
