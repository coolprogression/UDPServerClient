
package udpoperation;
import java.net.*;
/* Project A1: UDP
Filename: UDPServer.java
Authors: Toni Oluyide, Matt Simon
Instructions: Run this file first, and then the client UPDClient.java file
in either the command or an IDE
*Learning Experience is at the bottom*
*/
public class UDPServer {
  //Exception to handle our socketexception issue
  public static void main(String[] args) throws Exception {
  
  //creates sockets and assigns to it a port 5050
  DatagramSocket serversocket;
  serversocket= new DatagramSocket(5050);
  
  //buffers paramaters,using 1025 since it's a good/large numbers to use a buffer
  byte[] obtaineddata = new byte [1025];
  DatagramPacket recievedpacket = new DatagramPacket(obtaineddata,obtaineddata.length);
  
  //Initates a loop to wait for incoming packets
  while(true){
  System.out.println("Waiting"); //added this linee for testing purposes
  serversocket.receive(recievedpacket); //grabs the incoming packet
  
  //grabs the information from the packet, we need it to send the info back
  int incomingport = recievedpacket.getPort();
  InetAddress clientIp = recievedpacket.getAddress();
  String msg = new String(recievedpacket.getData()).trim();
  System.out.println("Got your word "+msg);
  // Sending the information back(Making a buffer/translating it into bytes)
  byte[] sentdata = new byte [1025];
  
  //Changing our word from ALL UPPERCASE -> lowercase
  msg = msg.toLowerCase();
  //translates to bytes
  sentdata = msg.getBytes();
  
  //creates new packet and sends modifed information back
  DatagramPacket sendpacket = new DatagramPacket(sentdata,sentdata.length,clientIp,incomingport);
  serversocket.send(sendpacket);
  
  
  /*                                       Learning Experience
  
  Before I did this assignment, I had some prior knowledge of socket programming from doing assignments in C++.
  However,I chose to use Java due to the level of documentation that is given. From reading around the web, the
  conventions that are used in Java, particularly the ripping of information from a recieved packet. With Java, 
  there are supported APIs/Libraries at your disposal. With C++, there is more digging involved since there are
  significantly less resources available. With both languages the process is essentially the same. You play a role
  similar to a mailman. You grab the data, get your location and the destination, and send to it there. The location will
  then take your message after waiting. Times vary like delivery days. The location(server) takes that message, and then
  unpacks it,grabbing all the necessary information (IP/Port/Data). In this particular case, the data is modified and
  returned to the origin. I saw this process especially in the code I wrote. I was essentially doing similar procedures on
  ends, recieving/sending, packing and unpacking.  With TCP, the process is slightly different due to it's nature. TCP
  emphasises the point of getting the message to its location, with sort of guarentee. We use two sockets instead
  of one to properly deliver our message.    
  
  
/* Matt Simon
  
 * Prior to this project, I had no experience in socket programming. While learning about it, I decided to used Java
 * because it was the only language i am familar with. I learned the use of datagram sockets and datagram packets to send and
  receive data. From my partner, I learned more of the process in depth. He had prior experience in socket programming from a 
  few on his c++ courses. From those interactions,I learned how fascinating socket programming was. The communication between the client 
  and server is an interesting and fascinating concept. I learned to see how the client sends data through the socket through packets 
  and the server unpacks the data and sends it back throught the use of a port. I saw this through many youtube tutorials 
  on how to do socket programming. I learned that TCP is a connection based protocol. Both UDP and TCP are similar in concept, it was  
  not hard to manipulate TCP after writing the UDP program. From these experiences, I have furthered my knowledge on programming and networking.
  Hoopefully, It will prove very beneficial in the near the future or even my next job.
  
 */


  
  
 
  
  
  
  
  
  }
  
 }
}
