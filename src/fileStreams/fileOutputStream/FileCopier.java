package fileStreams.fileOutputStream;

import fileStreams.fileInputStream.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FileCopier {
    public static void copy(String inFile, String outFile) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(inFile);
            fos = new FileOutputStream(outFile);
            StreamCopier.copy(fis, fos);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException exception){

                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {

                }
            }
        }
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: copy file");
            return;
        } else {
            try {
                copy(args[0], args[1]);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
