package com.example.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {

        var inetAddress = InetAddress.getByName("localhost");

        try (var socket = new Socket(inetAddress, 7771);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
//              var response  = inputStream.readUTF();
                System.out.println("response  server " + inputStream.readUTF());
            }
        }
    }
}
