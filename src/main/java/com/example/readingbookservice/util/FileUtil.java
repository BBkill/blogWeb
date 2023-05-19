package com.example.readingbookservice.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileUtil {
    public static boolean convertAndSave(String base64String, String outputFilePath) {
        try {
//            String[] parts = base64String.split(",");
//            String data = parts[1];
            byte[] bytes = Base64.getDecoder().decode(base64String);
            File file = new File(outputFilePath);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
