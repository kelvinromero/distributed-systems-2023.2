package br.edu.ifpb.kelvin.nfs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Staring NFS Server...");
        NioNFS nfs = new NioNFS();
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            try (Socket socket = serverSocket.accept();) {
                System.out.println("Client connected: " + socket.getInetAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    String message = dataInputStream.readUTF();
                    System.out.println("Message received: " + message);

                    if (message.equals("exit")) {
                        dataOutputStream.writeUTF("Bye!");
                        break;
                    }

                    dataOutputStream.writeUTF(nfs.process(message));
                }
            } catch (IOException e) {
                System.err.println("Server error: " + e.getMessage());
            }
        }

    }
}
