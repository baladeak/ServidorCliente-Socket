package servidorcliente;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) throws IOException {
        try (ServerSocket servidor = new ServerSocket(12345)) {
            System.out.println("Servidor iniciado na porta 12345");
            
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
            
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Cliente diz: " + inputLine);
                out.println("Servidor recebeu: " + inputLine);
            }
            
            in.close();
            out.close();
            cliente.close();
        }
    }
}
