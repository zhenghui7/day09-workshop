package sg.edu.nus.iss.app.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerApp 
{
    public static void main( String[] args ) throws IOException
    {

        Random random = new Random();
        Integer randomNumber = random.nextInt(100);

        Integer myGuess = 0;

        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();

        InputStream is = s.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        OutputStream os = s.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        String msgRecv = "";

        while (!msgRecv.equals("quit")) {

            msgRecv = dis.readUTF();

            if (msgRecv.contains("guess")) {
                myGuess = Integer.parseInt(msgRecv.substring(6));
            }


            if (myGuess < randomNumber) {
                dos.writeUTF("Your guess is lower");
            } else if (myGuess > randomNumber) {
                dos.writeUTF("Your guess is higher.");
            } else {
                dos.writeUTF("You guessed it right!");
            }
            dos.flush();
            
        }

        dos.close();
        bos.close();
        os.close();

        dis.close();
        bis.close();
        is.close();

        // System.out.printf("secret number: %d\n", randomNumber);
        
        
    }
}
