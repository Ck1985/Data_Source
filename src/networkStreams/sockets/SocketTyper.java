package networkStreams.sockets;

import java.net.*;
import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class SocketTyper {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java SocketTyper url");
            return;
        }
        try {
            URL url = new URL(args[0]);
            if (!url.getProtocol().equalsIgnoreCase("http")) {
                System.out.println("Sorry, this protocol: " + url.getProtocol() + " is not supported");
                return;
            }
            String host = url.getHost();
            int port = url.getPort();
            String file = url.getFile();
            if (file == null) file = "/";
            if (port <= 0) port = 80;
            Socket socket = null;
            try {
                socket = new Socket(host, port);
                String request = "GET " + file + "HTTP/1.1\r\n" +
                                 "User-Agent: SocketTyper\r\n" +
                                 "Accept: Text/*\r\n" +
                                 "Host: " + host + "\r\n" +
                                 "\r\n";
                        /*"GET " + file + " HTTP/1.1\r\n"
                                + "User-Agent: SocketTyper\r\n"
                                + "Accept: Text/*\r\n" + "Host: " + host + "\r\n"
                        + "\r\n";*/
                byte[] b = request.getBytes("US-ASCII");
                OutputStream output = socket.getOutputStream();
                InputStream input = socket.getInputStream();
                output.write(b);
                output.flush();
                for (int c = input.read(); c != -1; c = input.read()) {
                    System.out.write(c);
                }
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if (socket != null && socket.isConnected()) {
                    try {
                        socket.close();
                    } catch (IOException ex){
                        System.err.println(ex);
                    }
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}
