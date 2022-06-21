import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Divisao implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            float n1 = Float.parseFloat(partes[2]);
            float n2 = Float.parseFloat(partes[3]);
            float resultado = n1/n2;
                byte[] resposta = Float.toString(resultado).getBytes();  
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
                return; 
    
        } finally {
            exchange.close();
        }
    }
}