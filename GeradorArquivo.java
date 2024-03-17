package Cep;

import java.io.FileWriter;
import java.util.ArrayList;
import com.google.gson.*;


public class GeradorArquivo {

    public void GerarArquivo(ArrayList<InfosRecord> a){
        Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();
        try{
                FileWriter write = new FileWriter("Cep/Cep.json");
                write.write(gson.toJson(a));
                write.close();
                }catch(Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
    }
}

