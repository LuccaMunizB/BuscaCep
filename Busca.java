package Cep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.*;

public class Busca {
    public InfosRecord buscar(int cep){
        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
        String json;

        try{
         HttpClient client =  HttpClient.newHttpClient();
                HttpRequest request =  HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

                 HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());

                json = response.body(); 
                
                return new Gson().fromJson(json, InfosRecord.class);
                
            }catch(Exception e){
                return null;
            }

       
    }
}
