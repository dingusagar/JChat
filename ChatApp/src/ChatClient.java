import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;



public class ChatClient {
       public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
     public static final String ANSI_WHITE = "\u001B[37m";
     public static final String ANSI_CYAN = "\u001B[36m";
    public static void main(String[] args) 
    {
     
        Socket socket = null;
        String IP = "192.168.43.33"; 
        Scanner sc = new Scanner(System.in);
        int port;
        boolean flag = false;
        if(args.length == 0)
            port  = 4447;
        else
            port = Integer.parseInt(args[0]);
        System.out.println("Connecting to " +IP+" ...");

        while(!flag){
            try{
            socket = new Socket(IP, port);
            flag =true;
            }catch(Exception e)
            {
                continue;
            }
        }
        

        try{



        String msg;
        System.out.print(ANSI_RED+"Dingu > "+ANSI_CYAN);
        msg = sc.nextLine();
        while(!msg.equals("exit"))
        {
            
        OutputStream out = socket.getOutputStream();
           out.write(msg.getBytes());
          
           
            msg = sc.nextLine();

        }


        try{
        socket.close();
        }catch(IOException h)
        {
            System.out.println(h.toString());
        }

    }catch(Exception e)
    {
        System.out.println(e.toString());
    }

    }

}


