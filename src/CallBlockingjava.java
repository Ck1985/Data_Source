import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class CallBlockingjava {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println("Calling the blocking method");
        int n = System.in.read();
        System.out.println("Blocking method is finished");
    }
}
