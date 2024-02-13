package ru.fafurin.lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class PageDownloader {

    public String downloadWebPage(String url) {
        StringBuilder res = new StringBuilder();
        String line;
        try {
            URLConnection urlConnection = new URI(url).toURL().openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IllegalArgumentException | IOException | URISyntaxException e) {
            System.out.println("Error 404. Page not found");
        }
        return res.toString();
    }
}
