package Cep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        boolean continua = true;
        Busca busca = new Busca();
        ArrayList<InfosRecord> lista = new ArrayList<>();

        Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();

        while(continua){
            System.out.println("Qual o cep que você quer buscar as informações?");
            int cep = in.nextInt();
            
            InfosRecord infosRecord = busca.buscar(cep);
            lista.add(infosRecord);

            if(infosRecord!= null){
                System.out.println("Cep identificado com sucesso!");
                System.out.println("---------");
                System.out.println("Que informação você quer ver?");
                System.out.println("1 - Todas");
                System.out.println("2 - Nome da rua");
                System.out.println("3 - Nome do bairro");
                System.out.println("4 - Nome da cidade");
                System.out.println("5 - Nome do estado");
                System.out.println("6 - Número do ddd");
                System.out.println("7 - Sair");
                int num = in.nextInt();
                switch (num) {
                    case 1:
                        System.out.println(infosRecord.toString());
                        break;
                    
                    case 2:
                        System.out.println(infosRecord.logradouro());
                        break;

                    case 3:
                        System.out.println(infosRecord.bairro());
                        break;

                    case 4:
                        System.out.println(infosRecord.localidade());
                        break;

                    case 5:
                        System.out.println(infosRecord.uf());
                        break;

                    case 6:
                        System.out.println(infosRecord.ddd());
                        break;

                    case 7:
                        System.out.println("Programa encerrado com sucesso.");
                        continua = false;
                        break;

                    default:
                        System.out.println("Informe um valor válido");
                        break;
                }   

            GeradorArquivo gerar = new GeradorArquivo();
            gerar.GerarArquivo(lista);
            }else{
                System.out.println("Cep invalido, informe outro cep.");
            }

        }
        
    }
}
