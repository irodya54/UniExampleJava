package com.example.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        try (var socket = new DatagramSocket()) {
            byte[] buffer = "Hello world".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetAddress, 7777);
            socket.send(packet);
        }
    }
}
