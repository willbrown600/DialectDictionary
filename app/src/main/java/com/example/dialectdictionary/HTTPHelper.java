package com.example.dialectdictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPHelper {

    public String readHTTP(String url){
        try {
            URL urlObj = new URL(url);

            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) urlObj.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder data = new StringBuilder();

            String line;

            do{
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
                line = reader.readLine();
                if(line != null){
                    data.append(line);
                }
            }
            while (line != null);

            return data.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading from the HTTP response: " + e);
            return null;
        }
        return null;
    }
}
