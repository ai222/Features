package javaapplication1;


import java.net.*; 
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class Client 
{
    private Socket sock            = null; 
    private DataInputStream  fin   = null; 
    private DataOutputStream out   = null;
    private void client_run(){
        String buffer = "";
        while (!buffer.equals("Quit")){ 
            try{ 
                buffer = fin.readLine();
                out.writeUTF(buffer);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try{ 
            fin.close(); 
            out.close(); 
            sock.close(); 
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Client(String address, int port){
        try{
            sock = new Socket(address, port);
            System.out.print("Connected with server\n");
            fin  = new DataInputStream(System.in);
            out  = new DataOutputStream(sock.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        client_run();
    }
    public static void main(String args[]){
        Client c = new Client("127.0.0.1", 3430);
    }
} 