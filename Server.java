import java.net.*;
import java.io.*;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Server(int port){
        try {
            serverSocket = new ServerSocket(1337);
            socket = serverSocket.accept();
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }
        catch (IOException e){
            e.printStackTrace();
        }
        echo();
    }
    public void echo(){
        try {
            String response = "";
            String line;

            while((line = reader.readLine()) != null){
                response += line;
                writer.println(response.toUpperCase());

            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Server(1337);
    }
}
