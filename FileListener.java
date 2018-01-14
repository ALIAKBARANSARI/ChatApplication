/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatapplication.networking;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AliAkbar
 */
public class FileListerner extends Thread{
    ServerSocket server;
    int port=8877;
    WritableGUI gui;
    public FileListerner(WritableGUI gui,int port) {
       this.port=port;
       this.gui=gui;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public FileListerner(){
        try {
            server=new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        gui.setonline(port);
    }
    @Override
    public void run()
   {
       Socket clientsock;
        try {
            while((clientsock=server.accept())!=null)
            {
                DataInputStream dis = new DataInputStream(clientsock.getInputStream());
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Ali Akbar\\Desktop\\newone.jpg");
		byte[] buffer = new byte[4096];
		
		int filesize = 1512300; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			//System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer, 0, read);
			
		  }
		System.out.println("read " + totalRead + " bytes.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileListerner.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
