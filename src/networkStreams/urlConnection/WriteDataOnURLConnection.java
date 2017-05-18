package networkStreams.urlConnection;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class MailClient {
    private URL url = null;
    private URLConnection urlc = null;
    OutputStream output = null;
    public void writeToURLConnection(String mailAddress) {
        try {
            url = new URL("mailto:" + mailAddress);
            urlc = url.openConnection();
            urlc.setDoOutput(true);
            urlc.connect();
            output = urlc.getOutputStream();
            for (int i = System.in.read(); i != -1; i = System.in.read()) {
                output.write(i);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
    }
}
public class WriteDataOnURLConnection {
    public static void checkArgsExist(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java MailClient url");
            return;
        }
    }
    public static void main(String[] args) {
        MailClient mail = new MailClient();
        mail.writeToURLConnection("anonymous.vn1985@gmail.com");
    }
}
