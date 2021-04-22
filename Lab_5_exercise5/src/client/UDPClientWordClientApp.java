package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClientWordClientApp {

public static void main(String[] args) {
		
		final int serverPort=50001;
		int bufferSize = 1024;
		
		try {
			
			
			DatagramSocket clientSocket = new DatagramSocket();
			
		
			InetAddress serverAddress = InetAddress.getByName("localhost");
			
		
			byte sendDataBuffer [] = new byte [bufferSize];
			
		
			String sentence = "How many words in this sentence?";
			sendDataBuffer = sentence.getBytes();
			
		
			DatagramPacket  outputPacket = new DatagramPacket(sendDataBuffer, sendDataBuffer.length, serverAddress, serverPort);
			
	
			clientSocket.send(outputPacket);
			
			
	
			byte receiveDataBuffer [] = new byte [bufferSize];
			
		
			DatagramPacket inputPacket = new DatagramPacket (
					receiveDataBuffer, receiveDataBuffer.length);
			
			clientSocket.receive(inputPacket);
			

			String result = new String (inputPacket.getData());
			System.out.print("Number of words in the sentence : " + result );
			
			
			
			clientSocket.close();
		
		
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

	
}
