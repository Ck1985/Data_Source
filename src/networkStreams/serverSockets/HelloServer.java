package networkStreams.serverSockets;

import java.io.*;
import java.net.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class HelloServer {
    public static void main(String[] args) throws IOException{
        int port = 2345;
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            try {
                Socket s = ss.accept();
                String response = "Hello " + s.getInetAddress() + " on port " +
                        s.getPort() + "\r\n";
                response += "This is " + s.getLocalAddress() + " on port " +
                        s.getLocalPort() + "\r\n";
                OutputStream out = s.getOutputStream();
                out.write(response.getBytes("US-ASCII"));
                out.flush();
                s.close();
            } catch (IOException e) {
                System.err.println();
            }
        }
    }
}
