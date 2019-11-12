import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        writer.write("Give me some information\n");
        writer.flush();

        System.out.println(reader.readLine());


        writer.close();
        reader.close();
        clientSocket.close();
    }
}
