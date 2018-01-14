/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatapplication.networking;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AliAkbar
 */
public class MessageTransmit extends Thread{
    
    String message,hostname;
    int port;
    private Socket s;
    public MessageTransmit(){
        
    }
    
    public MessageTransmit(String message,String hostname,int port){
        this.message=message;
        this.hostname=hostname;
        this.port=port;
    }

    @Override
    public void run() {
        
    try{
            s =new Socket(hostname,port);
            
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmit.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Sendfile(message);
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void Sendfile(String file) throws IOException
       {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            
            while (fis.read(buffer) > 0) {
                dos.write(buffer);
            }
            
            fis.close();
            dos.close();
        }
       
       
       }
      
 
