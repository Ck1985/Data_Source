package networkStreams.urlConnection;

import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class URLConnectionDemo {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java URLConnection url");
            return;
        }
        URL url = null;
        URLConnection urlc = null;
        InputStream input = null;
        try {
            url = new URL(args[0]);
            urlc = url.openConnection();
            input = urlc.getInputStream();
            for (int i = input.read(); i != -1; i = input.read()) {
                System.out.write(i);
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
