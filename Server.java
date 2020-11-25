package javaapplication1;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class Server{
    private DataInputStream fin    = null;
    private ServerSocket    serv   = null;
    private Socket          sock   = null;
    private void run_serv(){
        String buffer = "";
        while(!buffer.equals("Quit")){
            try{ 
                buffer = fin.readUTF(); 
                System.out.println(buffer);
            } 
            catch(IOException i){ 
                System.out.println(i); 
            }
        }
        System.out.print("Closing client connection\n");
    }
    public Server(int sock_port){
        try{
            serv = new ServerSocket(sock_port);
            System.out.print("Server Running\n");
            System.out.print("Waiting for Client...\n");
            sock = serv.accept();
            System.out.print("Client arrived\n");
            fin = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
            run_serv();
            sock.close(); 
            fin.close(); 
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int flip(int X){
        Random rand = new Random();
        return rand.nextInt(X);
    }
    public String roll(){
        Random rand = new Random();
        int ch=rand.nextInt(2);
        if(ch==0){
            return "Head";
        }
        else{
            return "Tail";
        }
    }
    public static void main(String args[]){ 
        Server s = new Server(3430);
    } 
}
