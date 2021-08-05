package Client;

import Utilities.Utilities;

import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

    public static final int PORT = 8189;
    public static final String HOST = "localhost";
    private Utilities utilities = new Utilities();

    public static void main(String[] args) {

       new Client().run();
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        try (Socket socket = new Socket(HOST, PORT);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner in = new Scanner(socket.getInputStream())) {
             out.write(input.getBytes(StandardCharsets.UTF_8));
            while (in.hasNext()) {
                String output = in.next();
                System.out.println(output);
            }

        } catch (Exception p) {
            p.printStackTrace();
        }
    }
}
