package hust.soict.dsai.garbage;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String content = "";
        try (BufferedReader br = new BufferedReader(new FileReader("large_text_file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content += line; 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success!");
    }
}