package networkStreams.URLs;

import java.io.*;
import java.net.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class URLTyper {
    public static void constructorOneArg() {
         URL url = null;
         try {
             url = new URL("http://engineering.nyu.edu/life/studentactivities");
         } catch (MalformedURLException ex) {
             System.err.println(ex);
         }
    }
    public static void constructorThreeArgs() {
        URL url = null;
        try {
            url = new URL("http","engineering.nyu.edu","life/studentactivities");
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
    public static void constructorFourArgs() {
        URL url = null;
        try {
            url = new URL("http","java.sun.com",80,"index.html");
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
    public static void constructorTwoArgs() {
        URL url = null, url2 = null;
        try {
            url = new URL("http://www.gnu.org");
            url2 = new URL(url,"licenses/fdl-1.3.html");
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
    public static void main(String[] args) {
        /*constructorOneArg();
        constructorThreeArgs();
        constructorFourArgs();
        constructorTwoArgs();*/

        if (args.length < 1) {
            System.out.println("Usage: java URLTyper url");
            return;
        }
        URL url = null;
        InputStream input = null;
        try {
            url = new URL(args[0]);
            input = url.openStream();
            for (int c = input.read(); c != -1; c = input.read()) {
                System.out.write(c);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
    }
}
