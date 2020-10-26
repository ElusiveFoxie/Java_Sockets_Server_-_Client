import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client(String hostname, int port){
        try {
            socket = new Socket(hostname, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        talk();
    }

    public void talk(){

        try {
//            socket.getOutputStream().write(
//                    ("GET / HTTP/1.1\r\n"+
//                     "Host: elusivefox.net\r\n\r\n").getBytes());
//
//            InputStream input = socket.getInputStream();
//            int tmp;
//            while((tmp = input.read()) != -1){
//                System.out.print((char)tmp);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        writer.println("textToUpperCase");

        String line;
            while((line = reader.readLine()) != null){
            System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1",1337);
    }
}
