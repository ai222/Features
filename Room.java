package javaapplication1;

import java.util.*;

public class Room {
    Server s_arr;
    Client []c_arr;
    public void Room(int nclients){
        s_arr=new Server(3340);
        c_arr=new Client[nclients];
    }
    public void runRoom(Server s, Client c, int ind){
        c.equals(c);
        Scanner in=new Scanner(System.in);
        System.out.print("Enter Message to broadcast");
        String buffer=in.next();
        System.out.print("Client Received message "+buffer+"\n");
    }
}
