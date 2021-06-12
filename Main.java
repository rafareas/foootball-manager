import java.io.IOException;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        //Titulo do jogo 
        System.out.println("+---------------------------+\n\nwelcome to football manager!\n\n+---------------------------+\n");
    
    
        /** Lê o Estado do Jogo */
        Equipas eq = new Equipas();

        try{
            try {
                eq = eq.readObject("estadoJogo.txt");
            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
        }
        catch(ClassNotFoundException classnot){
            System.out.println(classnot.getMessage() + ", Erro na leitura da classe");
        }

        /* Opção de ler do arquivo principal e gravar o estado
        
        LoadFile lf = new LoadFile();
        try{
          eq = lf.parse("logsV2.txt"); 
        } 
        catch(LinhaIncorretaException|ReadException ex){
            System.out.println(ex.getMessage() + " Linha incorreta / leu incorretamente\n");
         }
        
             
        
        try{
            eq.saveBinary("estadoJogo.txt");
        }
        catch(IOException e){
            System.out.println(e.getMessage() + " ,Erro na tentativa de gravar o estado do jogo");
        }
        */
        
        
        /** Realização do Menu Principal / Jogo */

        int op = 0; // opcao de sáida
        Menu m = new Menu();
        while(op != -1){ 
            op = m.menuPrincipal(); 
            if(op != 4){
                switch(op){
                    case 1:
                        String teamName = m.menuTimes(eq);
                        Team time = eq.getElenco(teamName);
                        m.showJogadores(time);
                        op = m.menuFinal();
                        break;
                    case 2:
                        m.execTransfer(eq);
                        op = m.menuFinal();
                        break;
                    case 3:
                        m.showHistory(eq);
                        op = m.menuFinal();
                        break;
                    default: break;             
                }
            }
        }
        System.out.println("\nAté a próxima!\n");
    }
}
