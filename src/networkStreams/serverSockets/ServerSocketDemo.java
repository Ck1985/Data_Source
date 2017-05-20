package networkStreams.serverSockets;

import java.io.*;
import java.net.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class ServerSocketDemo {
    public static void main(String[] args){
        try {
            ServerSocket socket = new ServerSocket(80);
            ServerSocket socket2 = new ServerSocket(0);
            int numPort = socket2.getLocalPort();
            //System.out.println(numPort);

            ServerSocket socket3 = new ServerSocket(2345);
            while (true) {
                Socket ss = socket3.accept();
                OutputStream output = ss.getOutputStream();
                //Sending data to client
                ss.close();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
