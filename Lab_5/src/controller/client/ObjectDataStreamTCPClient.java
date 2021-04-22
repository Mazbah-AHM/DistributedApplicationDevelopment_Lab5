package controller.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import Lab.ItemProduct;

public class ObjectDataStreamTCPClient {

public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo of Object Stream\n");


		ItemProduct item = new ItemProduct();
		item.setName("iphone 12 Pro Max");
		item.setPrice(7000);
		
		
		try {
			

			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();
	
			Socket socket = new Socket(serverAddress, portNo);
		
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
			
			
	
			System.out.println(" Send object to server: " + item.toString());
			objectOS.writeObject(item);
			objectOS.flush();
			
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
	
			item = (ItemProduct) objectIS.readObject();
			
			String result = (String)objectIS.readObject();
			
			System.out.println("\n Validation Result : "+ result+ "\n");
			System.out.print (" Product Id : " + item.getItemProductId() + "\n Product Name : " + item.getName() );
			System.out.print("\n Product Price : "+ item.getPrice()+"\n");
			
			

			objectOS.close();
			objectIS.close();
			socket.close();
			
		
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		

	}
}
