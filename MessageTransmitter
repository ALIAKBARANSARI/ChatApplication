/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatapplication.networking;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AliAkbar
 */
public class MessageTransmitter extends Thread{
    String message,hostname;
    int port;
    int flg=0;
    private Socket s;
    public MessageTransmitter(){
        
    }
    
    public MessageTransmitter(String message,String hostname,int port){
        this.message=message;
        this.hostname=hostname;
        this.port=port;
      
    }

    @Override
    public void run() {
        
       
        try {
            s =new Socket(hostname,port);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.write(message.getBytes());
            dos.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    
}
