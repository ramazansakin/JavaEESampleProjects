package com.obss.ramazansakin.sixth;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

 
public class ServerNIO {
 
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
 
		// Selector: multiplexor of SelectableChannel objects
		Selector selector = Selector.open(); // selector is open here
		Random rand = new Random();
		int numberToBeGuessed = rand.nextInt(10);
		System.out.println("The number to be guessed is " + numberToBeGuessed);
 
		// ServerSocketChannel: selectable channel for stream-oriented listening sockets
		ServerSocketChannel mSocket = ServerSocketChannel.open();
		InetSocketAddress socketAddress = new InetSocketAddress("localhost", 1111);
 
		// Binds the channel's socket to a local address and configures the socket to listen for connections
		mSocket.bind(socketAddress);
 
		// Adjusts this channel's blocking mode.
		mSocket.configureBlocking(false);
 
		int ops = mSocket.validOps();
		SelectionKey selectKy = mSocket.register(selector, ops, null);
 
		// Keep server running
		while (true) {
 
			message("Server started to read connection requests...");
			// Selects a set of keys whose corresponding channels are ready for I/O operations
			selector.select();
 
			// token representing the registration of a SelectableChannel with a Selector
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> mIterator = selectionKeys.iterator();
 
			while (mIterator.hasNext()) {
				SelectionKey myKey = mIterator.next();
 
				// Tests whether this key's channel is ready to accept a new socket connection
				if (myKey.isAcceptable()) {
					SocketChannel client = mSocket.accept();
 
					// Adjusts this channel's blocking mode to false
					client.configureBlocking(false);
 
					// Operation-set bit for read operations
					client.register(selector, SelectionKey.OP_READ);
					message("Connection Accepted: " + client.getLocalAddress() + "\n");
 
					// Tests whether this key's channel is ready for reading
				} else if (myKey.isReadable()) {
					
					SocketChannel sClient = (SocketChannel) myKey.channel();
					ByteBuffer buffer = ByteBuffer.allocate(256);
					sClient.read(buffer);
					String result = new String(buffer.array()).trim();
 
					message("Message received: " + result);

					// Close the server
					if (result.equals("Close")) {
						sClient.close();
						message("Connection was closed with current client!");
						message("\nServer will keep running. Try running client again to establish new connection");
					} else {
						if( Integer.parseInt(result) == numberToBeGuessed ){
							CharBuffer bufferMsg = CharBuffer.wrap("Congratilations");
			                while (bufferMsg.hasRemaining()) {
			                    sClient.write(Charset.defaultCharset().encode(bufferMsg));
			                }
							
						} else if ( Integer.parseInt(result) > numberToBeGuessed ) {
							CharBuffer bufferMsg = CharBuffer.wrap(result + " is bigger than Y");
			                while (bufferMsg.hasRemaining()) {
			                    sClient.write(Charset.defaultCharset().encode(bufferMsg));
			                }
							
						} else {
							CharBuffer bufferMsg = CharBuffer.wrap(result + " is less than Y");
			                while (bufferMsg.hasRemaining()) {
			                    sClient.write(Charset.defaultCharset().encode(bufferMsg));
			                }
						}
					}
					
				}
				mIterator.remove();
			}
		}
	}
 
	private static void message(String str) {
		System.out.println(str);
	}
}

