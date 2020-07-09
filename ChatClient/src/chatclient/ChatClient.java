/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Hp
 */
public class ChatClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Socket s=new Socket("127.0.0.1",4000);
            InputStream in= s.getInputStream();
            OutputStream os=s.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            BufferedReader sbr= new BufferedReader(new InputStreamReader(in));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                String msg=br.readLine();
                pw.println(msg);
                pw.flush();
                String sm=sbr.readLine();
                System.out.println("Server :"+sm);
                
            }
                    
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
