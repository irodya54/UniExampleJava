package com.example.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {

    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7771);
             var socket = serverSocket.accept();
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var scanner = new Scanner(System.in)) {
            var request = inputStream.readUTF();
            while (!"stop".equals(request)) {


                System.out.println("Client request" + request);
                var nextLine = scanner.nextLine();
                outputStream.writeUTF(nextLine);
                request = inputStream.readUTF();

            }
        }
    }
}
