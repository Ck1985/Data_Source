package fileStreams.fileViewer_Part1;

import java.io.*;
import fileStreams.fileInputStream.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FileDumper {
    private static final int ASC = 0;
    private static final int DEC = 1;
    private static final int HEX = 2;
    public static void dumpAscii(String filename) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            StreamCopier.copy(fis,System.out);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
    public static void dumpDecimal(String filename) throws IOException {
        FileInputStream fis = null;
        byte[] buffer = new byte[16];
        boolean end = false;
        try {
            fis = new FileInputStream(filename);
            while (!end) {
                int bytesRead = 0;
                while (bytesRead < buffer.length) {
                    int r = fis.read(buffer, bytesRead, buffer.length - bytesRead);
                    if (r == -1) {
                        end = true;
                        break;
                    }
                    bytesRead = bytesRead + r;
                }

                for (int i = 0; i < buffer.length; i++) {
                    int dec = buffer[i];
                    if (dec < 0) {
                        dec = dec + 256;
                    }
                    if (dec < 10) {
                        System.out.print("00" + dec + " ");
                    } else if (dec < 100) {
                        System.out.print("0" + dec + " ");
                    } else {
                        System.out.print(dec + " ");
                    }
                }
                System.out.println();
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
    public static void dumpHex(String filename) throws IOException {
        FileInputStream fis = null;
        boolean end = false;
        byte[] buffer = new byte[24];
        try {
            fis = new FileInputStream(filename);
            while (!end) {
                int bytesRead = 0;
                while (bytesRead < buffer.length) {
                    int r = fis.read(buffer, bytesRead, buffer.length - bytesRead);
                    if (r == -1) {
                        end = true;
                        break;
                    }
                    bytesRead += r;
                }
                for (int i = 0; i < buffer.length; i++) {
                    int hex = buffer[i];
                    if (hex < 0) {
                        hex = hex + 256;
                    }
                    if (hex >= 16) {
                        System.out.print(Integer.toHexString(hex) + " ");
                    } else {
                         System.out.print("0" + Integer.toHexString(hex) + " ");
                    }
                }
                System.out.println();
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: Please, input the command follow this form: \n" +
                               "java FileDumper [-adh] file1 file2 ....");
            return;
        }
        int firstArg = 0;
        int mode = ASC;
        if (args[0].startsWith("-")) {
            firstArg = 1;
            if (args[0].equals("-d")) {
                mode = DEC;
            } else if (args[0].equals("-h")) {
                mode = HEX;
            }
        } else {
            System.out.println("Usage: Please, input the command follow this form: \n" +
                    "java FileDumper [-adh] file1 file2 ....");
            return;
        }
        for (int i = firstArg; i < args.length; i++) {
            try {
                if (mode == ASC) {
                    dumpAscii(args[i]);
                } else if (mode == DEC) {
                    dumpDecimal(args[i]);
                } else {
                    dumpHex(args[i]);
                }
            } catch (IOException e) {
                System.err.println("Couldn't read from " + args[i] + "e.getMessage(): " + e.getMessage());
            }
            if (i < args.length - 1) {
                System.out.println("\r\n--------------------------------------\r\n");
            }
        }
    }
}
