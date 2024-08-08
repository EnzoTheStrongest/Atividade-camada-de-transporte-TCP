package TCPProtocolo;

import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Esta linha de código é responsável por tentar conexão com o servidor, essa
            // função é específica para orientação de conexões entre cliente/servidor, o que
            // é uma característica do protocolo TCP, logo sendo definitivo a disserção
            // desse código ser uma requisição TCP.
            
            Socket socket = new Socket("localhost", 8080);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite uma mensagem: ");
            String message = scanner.nextLine();
            writer.println(message);
            scanner.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
