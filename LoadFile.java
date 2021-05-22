public class LoadFile {
    public void parse(){
        List<String> linhas = lerFicheiro("dados.csv");
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Guarda-Redes":
                    GuardaRedes j = parseGuardaRedes(linhaPartida[1]);
                    System.out.println(j.toString());
                    break;
                (...)
                default:
                    System.out.println("Linha invÃ¡lida.");
                    break;
            }
        }
        System.out.println("done!");
    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }


    public GuardaRedes parseGuardaRedes(String input){
        String[] campos = input.split(",");
        String nome = campos[0];
        Int numCamisola = Integer.parseInt(campos[1]);
        Int velocidade = Integer.parseInt(campos[2]);
        (...)
        return new GuardaRedes(...);
    }   
}
