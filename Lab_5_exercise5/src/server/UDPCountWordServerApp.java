package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException

public class UDPCountWordServerApp {
	
	public static void main(String[] args) {
		
	
		final int serverPort=50001;
		int bufferSize = 1024;
		
		try {
			
		
			DatagramSocket serverSocket = new DatagramSocket (serverPort);
			
	
		    byte receivingDataBuffer[] = new byte[bufferSize];
		    
		    DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
		    System.out.println("Waiting for a client to connect...");
		    
		 
		    serverSocket.receive(inputPacket);
			
	
		    String receivedData = new String (inputPacket.getData());
		    System.out.println("Sent from the client: " + receivedData);
			
			CountWord countWord = new CountWord();
			String sendData = countWord.getWordCount(receivedData);
			System.out.println("Number of words in sentence: " + sendData);
			
	
			byte sendingDataBuffer[]= sendData.getBytes();
			
		
			InetAddress clientAddress = inputPacket.getAddress(); 
			int clientPort = inputPacket.getPort();
			
			
			DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, clientAddress, clientPort);
			
		
	
		    serverSocket.send(outputPacket);
		    
		    

		    serverSocket.close();
			
			
		
		
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
