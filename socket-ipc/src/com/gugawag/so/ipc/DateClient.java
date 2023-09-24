package com.gugawag.so.ipc;

/**
 * Client program requesting current date from server.
 *
 * Figure 3.22
 *
 * @author Silberschatz, Gagne and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Eighth Edition
 */ 

import java.net.*;
import java.io.*;

public class DateClient {
	public static void main(String[] args)  {
		try {
			// this could be changed to an IP name or address other than the localhost
			Socket sock = new Socket("localhost",6013); // Creates a new socket that listens on port 6013
			InputStream in = sock.getInputStream(); // Gets input stream from socket
			BufferedReader bin = new BufferedReader(new InputStreamReader(in)); // Creates a buffer reader, to read from the input stream

			System.out.println("=== Cliente iniciado ===\n");

			String line = bin.readLine(); // Creates a string using the buffer reader
			System.out.println("O servidor me disse:" + line);
				
			sock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
