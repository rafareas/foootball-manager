import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoadFile {
    
    public Equipas parse() throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro("output.txt");
        //Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        //Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        //List<Jogo> jogos = new ArrayList<>();
        Equipas allTeams = new Equipas();
        Team ultima = null; Player j = null;
        int firstJogo = 1;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    if(ultima != null) allTeams.addTeam(ultima);
                    Team e = new Team(linhaPartida[1]);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer_time(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer_time(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer_time(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer_time(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer_time(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    if(firstJogo == 1) allTeams.addTeam(ultima);
                    //Jogo jo = Jogo.parse(linhaPartida[1]);
                    //jogos.add(jo);
                    break;
                default:
                    break; //throw new LinhaIncorretaException();

            }
        }

        //debug
        /*
        for (Equipa e: equipas.values()){
            System.out.println(e.toString());
        }
        for (Jogo jog: jogos){
            System.out.println(jog.toString());
        }
        */

        return allTeams;

    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }


}
    
       

