package com.obss.ramazansakin.sixth;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
 
/**
 * @author Crunchify.com
 *
 */
 
public class ClientNIO{
 
	public static void main(String[] args) throws IOException, InterruptedException {
 
		InetSocketAddress adress = new InetSocketAddress("localhost", 1111);
		SocketChannel client = SocketChannel.open(adress);
		String res;
		
		message("Connecting to Server on port 1111...");
		
		try {
			// tries 3 times to guess the number...
			res = sendNumberToGuess(4, client);
			if( !res.equals("Congratilations") ){
				res = sendNumberToGuess(5, client);
				if( !res.equals("Congratilations") ){
					sendNumberToGuess(2, client);
				}
			}
			
			//Close the conection
			sendNumberToGuess(-1, client);
		} catch (Exception e) {
			message("IOException was catched!");
			e.printStackTrace();
		}
		
		// close the client channel
		client.close();
	}
 
	private static void message(String str) {
		System.out.println(str);
	}
	
	private static String sendNumberToGuess(int number, SocketChannel client) throws IOException{
		
		byte[] numberStr;
		if( number == -1 ) {
			numberStr = "Close".getBytes();
		} else {
			numberStr = new String( new Integer(number).toString() ).getBytes();
		}
		
		ByteBuffer buffer = ByteBuffer.wrap(numberStr);
		client.write(buffer);
 
		message("sending number to server : " + number );
		buffer.clear();
		
		ByteBuffer bufferServerMsg = ByteBuffer.allocate(256);
		client.read(bufferServerMsg);
		String result = new String(bufferServerMsg.array()).trim();
		
		message(result);
		
		return result;
	}
}

