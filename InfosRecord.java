package Cep;

public record InfosRecord(String logradouro, String bairro, String localidade, String uf, int ddd) {
    public String toString(){
        return "Nome da rua: " + logradouro
        + ", bairro: " + bairro 
        + ", cidade: " + localidade
        + ", estado: " + uf 
        + ", ddd: " + ddd;
    }
}
