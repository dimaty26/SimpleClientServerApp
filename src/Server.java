import java.net.*;
import java.io.*;


public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);
        int client = 0;
        System.out.println("Server started");

        while (true) {
            //wait for client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + client++);
            OutputStreamWriter writer =
                    new OutputStreamWriter(clientSocket.getOutputStream());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = "#" + client + ", your message length is " + request.length() + "\n";

            writer.write("HTTP/1.0 200 OK\n" +
                    "Content-type: text/html\n" +
                    "\n" +
                    response);
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }
        //serverSocket.close();
    }
}
