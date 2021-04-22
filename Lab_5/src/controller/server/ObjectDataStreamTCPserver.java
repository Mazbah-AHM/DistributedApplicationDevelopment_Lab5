package controller.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Lab.ItemProduct;

public class ObjectDataStreamTCPserver {

	public static void main(String[] args) {
		
		
		
		try {
			int portNo=4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println(" Ready for request");
			
			int itemProductId=0, totalRequest =0;
			
	
			while (true)
			{
				

				Socket socket = serverSocket.accept();
				
	
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
		
				ItemProduct item = (ItemProduct) objectIS.readObject();
				
				
		
				ItemNameValidate validation = new ItemNameValidate();
				
				String result = validation.validateItemName(item);
				
				
				item.setItemProductId(++itemProductId);
				

				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
				
				objectOS.writeObject(item);
				
				
	
				objectOS.writeObject(result);
				objectOS.flush();
				
				
				System.out.println(" Total request : " + ++totalRequest);
				System.out.println(" Validation Result : " + result);
				System.out.println("\n Ready for next request");
				
	
				objectIS.close();
				objectOS.close();		
							
			}
		
		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		
}
}
