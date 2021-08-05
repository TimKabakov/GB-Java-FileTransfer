package Utilities;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utilities {
    public static void main(String[] args) {
        Encode("string builder");
    }
    public void downloadFile(){

    }
    public void uploadFile(){

    }
    public byte commandDecoder(String command){
        switch (command){
            case "/download" : return 4;
            case "/upload" : return 5;
            case "/list" : return 6;
        }
        return 0;
    }
    public String commandEncoder(byte command){
        switch (command){
            case 4: return "download";
            case 5: return "upload";
            case 6: return "list";
            case 0: return "incorrect msg";
        }
        return "unknown msg";
    }
    public static byte[] Encode (String message){

        String[] strings = message.split(" ");
        System.out.println(strings.length);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < data.length; i++) {
            System.out.println(Array.getByte(data,i));
        }
        byte[] ds = Base64.getDecoder().decode(message);
        System.out.println(ds);


        return data;
    }
}
