package br.edu.ifpb.kelvin.nfs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting NFS Client...");

        Socket socket = new Socket("localhost", 8080);
        String message = "";

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        while (true) {
            System.out.print("< ");
            Scanner scanner = new Scanner(System.in);

            dataOutputStream.writeUTF(scanner.nextLine());

            message = dataInputStream.readUTF();
            System.out.println("> " + message);

            if (message.equals("Bye!")) {
                exit(0);
            }
        }
    }
}
