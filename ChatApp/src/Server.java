



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
     public static final String ANSI_CYAN = "\u001B[36m";
    public static void main(String[] args)
    {
    	
        try{
            while(true)
            {
                ServerSocket serverSocket=null;
                try{
                    int port ;
                    if(args.length == 0)
                         port  = 4446;
                    else
                     port = Integer.parseInt(args[0]);

                    serverSocket = new ServerSocket(port);
                }catch(IOException ex)
                {
                    System.out.println("Could'nt set up server connection");


                }
                Socket socket = null;
                InputStream in = null;
                OutputStream out = null;
                try{
                    socket = serverSocket.accept();
                    in = socket.getInputStream();

                   // out = new FileOutputStream("output.txt");
                    byte[] bytes = new byte[16*1024];

                    int count;

                    while (in.read(bytes) > 0) {
                       // out.write(bytes, 0, count);
                    	System.out.print(ANSI_YELLOW+"\nDeepak > "+ANSI_CYAN);
                        System.out.write(bytes);
                        System.out.println();
                        System.out.print(ANSI_RED+"Dingu > "+ANSI_CYAN);
                       

                    }

                    //out.close();
                    in.close();
                    socket.close();
                    serverSocket.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }



    }
}
