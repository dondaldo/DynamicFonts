package com.srikanth.dynamicfont;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * Created by srikanth on 23/10/17.
 */

public class FontDownloader {

    public static String getUrlImage(String url, Context context) {
        String fileName = UUID.nameUUIDFromBytes(url.getBytes()).toString();
        try {
            FileInputStream inputStream = context.openFileInput(fileName);
            inputStream.close();
            return context.getFilesDir().getAbsolutePath() + "/" + fileName;
        } catch (FileNotFoundException e) {
            InputStream inputStream = getInputStream(url);
            try {
                if (inputStream != null) {
                    byte[] buffer = readBytes(inputStream);
                    if (buffer != null) {
                        FileOutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                        outputStream.write(buffer);
                        outputStream.flush();
                        outputStream.close();
                        return context.getFilesDir().getAbsolutePath() + "/" + fileName;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                return null;
            } catch (IOException e1) {
                e1.printStackTrace();
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        if (inputStream == null) return null;
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }


    public static InputStream getInputStream(String url) {
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            return connection.getInputStream();
        } catch (MalformedURLException ignored) {
            return null;
        } catch (IOException ignored) {
            return null;
        }
    }
}
