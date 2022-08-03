package com.example.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("file:C:\\Users\\ASRock\\IdeaProjects\\http-servlets\\src\\com\\example\\socket\\DatagramRunner.java");
        var connection = url.openConnection();
        try (var inputStream = connection.getInputStream()) {
            System.out.println(new String(inputStream.readAllBytes()));
        }
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://google.com");
        var urlConnection = url.openConnection();
        urlConnection.getContent();

        try (OutputStream stream = urlConnection.getOutputStream()) {
        }

        System.out.println();
    }
}
