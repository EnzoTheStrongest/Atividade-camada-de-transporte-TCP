package TCPProtocolo;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Server {
    public static void main(String[] args) {
        try {
            // Esta é a linha de código que define esse código ser um protocolo TCP, pois
            // essa função faz aguardar a conexão do clientee linha de código do cliente :
            // Socket socket = new Socket("localhost", 8080); tenta se conectar com o
            // servidor, logo referenciando um emissor e um destinnatário, fechando a
            // conexão ponta ponta, que é uma característica do protocolo TCP

            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server rodando.. localhost 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String message = reader.readLine();
                System.out.println(clientSocket.getInetAddress() + "-Mensagem: " + message);

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
