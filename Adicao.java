import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Adicao implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            float n1 = Float.parseFloat(partes[2]);
            float n2 = Float.parseFloat(partes[3]);
            float adicao = n1+n2;
                byte[] resposta = Float.toString(adicao).getBytes();  
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
                return; 
    
        } finally {
            exchange.close();
        }
    }
}