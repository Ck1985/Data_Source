package fileInputStream;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FileTyper {
    public static void typeFile(String filename) throws IOException {
        FileInputStream input = new FileInputStream(filename);
        try {
            StreamCopier.copy(input, System.out);
        } finally {
            input.close();
        }
    }
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: file typer");
            return;
        }
        typeFile(args[0]);
    }
}
