package udpoperation;
import java.net.*;
/* Project A1: UPD 
Filename: UDPClient.java
Authors: Toni Oluyide, Matt Simon
Instructions: Run this file after the UDPClient.java file,
note: make sure you terminate previous instances if you want to run
the program again.


*/

public class UDPClient {

    //Exception to handle our socketexception issue
    public static void main(String[] args) throws Exception {
    
    //creating socket
    DatagramSocket clientsock = new DatagramSocket();
    //creating IP/Port to connect to server
    InetAddress serveraddress = InetAddress.getLocalHost();
    
    //our test word
    String word = "ESOTERIC";
    System.out.println("Trying to send word :  "+word+"  to IP: "+serveraddress);
    
    //creating a buffer for our word(Sending/Recieving)
    byte[] senddata = new byte [1025];
    byte[] rData = new byte[1025];
    senddata = word.getBytes();
    
  //sending/making a packet -moving it over ot the server
  DatagramPacket sendspacket = new DatagramPacket(senddata,senddata.length,serveraddress,5050);
  clientsock.send(sendspacket);
  
  //response portion, we are recieving a packet back from the server sendpacket
  DatagramPacket receivePacket = new DatagramPacket(rData, rData.length);
  clientsock.receive(receivePacket);
  //grabs our data and gives it to the user
  String msg = new String(receivePacket.getData()); //creates new string from our previous info
  System.out.println("Heres your lowercase word :"+msg);
  clientsock.close(); //close clientsock
   
    }
    
}
