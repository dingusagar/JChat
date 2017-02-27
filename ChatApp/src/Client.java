

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException
    {
        Socket socket = null;
        int port;
        if(args.length == 0)
            port  = 4448;
        else
            port = Integer.parseInt(args[0]);
        socket = new Socket("192.168.43.33", port);

        File file = new File("/home/dingu/Desktop/input.txt");
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
            System.out.write(bytes);
        }



        out.close();
        in.close();
        socket.close();
    }

}
