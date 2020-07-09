/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(4000);
            Socket s= ss.accept();
            InputStream in=s.getInputStream();
            OutputStream os=s.getOutputStream();
            BufferedReader cbr = new BufferedReader(new InputStreamReader(in));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(os);
            while(true)
            {
                String cm = cbr.readLine();
                System.out.println("Client :"+cm);
                String sm = br.readLine();
                pw.println(sm);
                pw.flush();
            }
        } catch (IOException ex) {
            //Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
