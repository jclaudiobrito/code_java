
import java.util.Random;
import javax.swing.JOptionPane;
/* 
 *==========================================================*
 * Centro Universitario Senac                               *
 *                                                          *
 *            TADS - 2˚SEMESTRE DE 2016                     *
 *                                                          *
 *                                                          *
 *                                                          *
 *               PROJETO INTREGADOR                         * 
 *                                                          *
 *                                                          * 
 * AUTOR: JCLAUDIO DA ROCHA BRITO                           *
 *                                                          *
 *                                                          *
 * 10/12/2016                                               *  
 *==========================================================*
 */

public class jogodavelha {
    
    static String tabuleiro[][]; //Matriz global do tabuleiro.
    
    static void inicializarTabuleiro(){
            tabuleiro = new String[3][3];           
      
           for (int l = 0; l < tabuleiro.length; l++){    
          
           for (int c = 0; c < tabuleiro.length; c++){   // Função que inicializa o tabuleiro.
               
               tabuleiro[l][c] = "*";
           }             
        }             
    }
    
    static void imprimirTabuleiro(){
     
                      JOptionPane.showMessageDialog(null,
"         TABULEIRO      \n"+                          //Função que forma,e imprimir o tabuleiro. 
"      1          2          3  \n"+
"   |-----|-----|-----|\n"+
"1 |     "+tabuleiro[0][0]+"   |     "+tabuleiro[0][1]+"    |    "+tabuleiro[0][2]+"    |\n"+      
"   |-----|-----|-----|\n"+
"2 |     "+tabuleiro[1][0]+"   |     "+tabuleiro[1][1]+"    |    "+tabuleiro[1][2]+"    |\n"+       
"   |-----|-----|-----|\n"+
"3 |     "+tabuleiro[2][0]+"   |     "+tabuleiro[2][1]+"    |    "+tabuleiro[2][2]+"    |\n"+        
"   |-----|-----|-----|\n");             
    }
    
    static String imprimeMenuPrincipal(){     
    String opcao;
        do{                                     
opcao = JOptionPane.showInputDialog(
"......................\\.\\.~.~././ ..................\n"+
".........................(@.@) ......................\n"+
"......|===oOOo=(_)=oOOo==========l\n"+
"......|............................................................|\n"+           
"......|...BEM VINDO AO JOGO DA VELHA ......|\n"+
"......|                                                            |\n"+  
"......|..[1]: JOGADOR VS. JOGADOR...............|\n"+
"......|..[2]: JOGADOR VS. MÁQUINA FÁCIL....|\n"+
"......|..[3]: SAIR ............................................|\n"+
"......|========================|\n"+
"...............ooo0...............(........)........\n"+
"...............(.......)..............)...../ .........\n"+
"................\\.....(..............(__./ ..........\n"+
".................\\.__)::ESCOLHA UMA OPÇÃO::\n"); 
        
            switch(opcao){
                                           // Função do menu principal chama a função de escolha.
            case "1":                      // Sem parametro e retorna a função escolhida.
                modoJogador();
                break;
            
            case "2":
                modoFacil();
                break;
                
            case "3":           
                break;
                
            case "":
                
                JOptionPane.showMessageDialog(null, " Ops!\nCAMPO VAZIO, ESCOLHA UMA OPÇÃO!");
                break;
                
            default:
               
                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
                break;
            } 
        
        } while(!opcao.equals("3") || opcao.equals(""));
                       
     return opcao;
    }
    
    static int leiaCoordenadaLinha(){
 
     int linha =  Integer.parseInt(JOptionPane.showInputDialog(
"         TABULEIRO      \n"+            // Função coordenada da linha, recebe a posição da linha
"      1          2          3  \n"+    // Sem parametro e retorna o valor da linha recebido. 
"   |-----|-----|-----|\n"+
"1 |     "+tabuleiro[0][0]+"   |     "+tabuleiro[0][1]+"    |    "+tabuleiro[0][2]+"    |\n"+      
"   |-----|-----|-----|\n"+
"2 |     "+tabuleiro[1][0]+"   |     "+tabuleiro[1][1]+"    |    "+tabuleiro[1][2]+"    |\n"+       
"   |-----|-----|-----|\n"+
"3 |     "+tabuleiro[2][0]+"   |     "+tabuleiro[2][1]+"    |    "+tabuleiro[2][2]+"    |\n"+        
"   |-----|-----|-----|\n"+
"Digite a LINHA da posição:  (1 ^ 3): "))-1;   
       return linha;
    }
    
    static  int leiaCoordenadaColuna(){ 
      
    int coluna = Integer.parseInt(JOptionPane.showInputDialog(
"         TABULEIRO      \n"+
"      1          2          3  \n"+ // Função coordenada da coluna, aplica as mesmas regras da função coordenada da linha.
"   |-----|-----|-----|\n"+
"1 |     "+tabuleiro[0][0]+"   |     "+tabuleiro[0][1]+"    |    "+tabuleiro[0][2]+"    |\n"+      
"   |-----|-----|-----|\n"+
"2 |     "+tabuleiro[1][0]+"   |     "+tabuleiro[1][1]+"    |    "+tabuleiro[1][2]+"    |\n"+       
"   |-----|-----|-----|\n"+
"3 |     "+tabuleiro[2][0]+"   |     "+tabuleiro[2][1]+"    |    "+tabuleiro[2][2]+"    |\n"+        
"   |-----|-----|-----|\n"+
"Digite a COLUNA da posição:  (1 ^ 3): "))-1;
      
       return coluna;
    }
    
    static void imprimePontuacao(int qVitoria1,int qVitoria2){
        
JOptionPane.showMessageDialog(null, 
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨.-“``“-.\n" +
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨/______;¨\\\\\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨{_______}\\\\|\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨(/¨a¨a¨\\\\)(_)\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨(¨.-.#.-.¨“)\n"+
"¨¨¨¨¨_____ooo__(¨¨¨=¨¨¨)____________\n"+
"¨¨¨//¨¨¨¨¨¨¨¨¨¨““-.____.-“¨¨¨¨¨¨¨¨¨¨\\\\\n"+
"¨¨“|¨¨¨¨¨¨¨¨¨¨¨¨PLACAR¨¨¨¨¨¨¨¨¨¨¨¨¨¨|\n"+
"¨““|¨¨¨JOGADOR [X]:  "+qVitoria1+"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨|\n"+   // Função placar exibe a pontuação dos jagadores 
"¨““|¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨|\n"+                 // Com parametro,e sem retorno.
"¨““|¨¨¨JOGADOR [O]:  "+qVitoria2+"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨|\n"+
"¨¨“|¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨/\n"+
"¨¨¨¨\\\\____________________ooo____//\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨(___|___)\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨““\\\\__|__/\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨““{__|__}\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨““|_ | _|\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨““/-“Y“-\\\\\n"+
"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨“(__/ \\\\__)\n");                  
    }
    
    static boolean posicaoValida(int linha, int coluna){
      
     if(!tabuleiro[linha][coluna].equals("*")){  // Função que verificar se a posição é válida no tabuleiro.      
         return true;                           // Retorna se a posição é válida ou não.
     }                                         
     
     return false;
    }
    
    static int verificaVencedor(){  //Função que verificar se a um vencedor em todas as posição do tabuleiro.
                                    // sem parametro com retorno do vencedor.
        if(tabuleiro[0][0].equals("X") && tabuleiro[1][0].equals("X") && tabuleiro[2][0].equals("X")){
            return 1;
        }else if (tabuleiro[0][0].equals("O") && tabuleiro[1][0].equals("O") && tabuleiro[2][0].equals("O")){
            return 2;
        }
         
        if(tabuleiro[0][1].equals("X") && tabuleiro[1][1].equals("X") && tabuleiro[2][1].equals("X")){
            return 1;
        }else if (tabuleiro[0][1].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[2][1].equals("O")){
            return 2;
        }
        
        if(tabuleiro[0][2].equals("X") && tabuleiro[1][2].equals("X") && tabuleiro[2][2].equals("X")){
            return 1;
        }else if (tabuleiro[0][2].equals("O") && tabuleiro[1][1].equals("2") && tabuleiro[2][2].equals("O")){
            return 2;
        }
        
        
        
        if(tabuleiro[0][0].equals("X") && tabuleiro[0][1].equals("X") && tabuleiro[0][2].equals("X")){
            return 1;
        }else if (tabuleiro[0][0].equals("O") && tabuleiro[0][1].equals("O") && tabuleiro[0][2].equals("O")){
            return 2;
        }
        
        if(tabuleiro[1][0].equals("X") && tabuleiro[1][1].equals("X") && tabuleiro[1][2].equals("X")){
            return 1;
        }else if (tabuleiro[1][0].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[1][2].equals("O")){
            return 2;
        }
        
        if(tabuleiro[2][0].equals("X") && tabuleiro[2][1].equals("X") && tabuleiro[2][2].equals("X")){
            return 1;
        }else if (tabuleiro[2][0].equals("O") && tabuleiro[2][1].equals("O") && tabuleiro[2][2].equals("O")){
            return 2;
        }
       
        
        if(tabuleiro[0][0].equals("X") && tabuleiro[1][1].equals("X") && tabuleiro[2][2].equals("X")){
            return 1;
        }else if (tabuleiro[0][0].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[2][2].equals("O")){
            return 2;
        }

         if(tabuleiro[2][0].equals("X") && tabuleiro[1][1].equals("X") && tabuleiro[0][2].equals("X")){
            return 1;
        }else if (tabuleiro[2][0].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[0][2].equals("O")){
            return 2;
        }
       
        return 0;   
    }
    
    static boolean verificaVelha(){
        int contador= 0;
        
        for(int l =0;l<3;l++){        // Função que verificar se deu velha, testando todas as posição.
                                     // E comparar com a função verificar vencedor  
            for(int c= 0;c<3;c++){  // Sem parametro,com retorno se sim ou não. 
                
                if(!tabuleiro[l][c].equals("*")){
                    contador++;
                }
            }
        }
        
        if(contador==9){
            
            if(verificaVencedor()==0){
                JOptionPane.showMessageDialog(null, "DEU VELHA!");
                return true;
            }
        }             
        return false;      
    }
    
    static void modoJogador(){
        
        int qtdJogadas=0;
        int qtdVitoriaJ1 =0;
        int qtdVitoriaJ2 =0;        
        
        while(qtdVitoriaJ1!=3 || qtdVitoriaJ2!=3){
            
        imprimePontuacao(qtdVitoriaJ1,qtdVitoriaJ2);    //Função modo jogador aqui aplica todas as regras 
        inicializarTabuleiro();                        //do modo jogador, chama outras funções como
        imprimirTabuleiro();                          //leicoordenadas, Linha, coluna, verifica posição válida no tabuleiro
                                                     //Sem parametro, sem retorno.    
        if(qtdVitoriaJ1==3 || qtdVitoriaJ2==3){
            break;
         }
            while(verificaVelha()==false && verificaVencedor()==0){
                
                JOptionPane.showMessageDialog(null, "JOGADOR ["+(qtdJogadas%2==0?"X":"O"+"]"));
                                              // Exibe o jogador que vai jogar.
                int linha = 0;
                int coluna = 0;

                do{
                    linha = leiaCoordenadaLinha();
                    coluna = leiaCoordenadaColuna();
                                       
                    if (posicaoValida(linha, coluna)){
                        JOptionPane.showMessageDialog(null, "POSIÇÃO INVÁLIDA!");
                    }
                  
                } while(posicaoValida(linha, coluna));

                jogadaUsuario(linha, coluna, qtdJogadas%2==0?1:2); // Chama o jogador para jogada.
                qtdJogadas++;
                
                imprimirTabuleiro();

                if(verificaVencedor()!= 0){


                    if(verificaVencedor()== 1){                      
                        qtdVitoriaJ1++;
                   
                    }else{
                        qtdVitoriaJ2++;
                    }                                      
                                                             // Exibe o jogador vencedor.
                    JOptionPane.showMessageDialog(null, "JOGADOR ["+(verificaVencedor()==1?"X":"O")+"] VENCEDOR");                    
                }
            }
        }
    
    }
    
    static void modoFacil(){
        
        int qtdJogadas=0;       /// Função Modo facil, aplica as mesmas regras do modo jogador ///   
        int qtdVitoriaJ1 =0;   /// Sem parametro, sem retorno.
        int qtdVitoriaJ2 =0;
        

        while(qtdVitoriaJ1<3 || qtdVitoriaJ2<3){
            
            imprimePontuacao(qtdVitoriaJ1,qtdVitoriaJ2);
            inicializarTabuleiro();
            imprimirTabuleiro();
            
            if(qtdVitoriaJ1==3 || qtdVitoriaJ2==3){
                break;
            }
            while(verificaVelha()==false && verificaVencedor()==0){
                
                 JOptionPane.showMessageDialog(null, "JOGADOR ["+(qtdJogadas%2==0?"X"+"]":"O"+"]"));
                                            // Exibe o jogador que vai jogar.
                int linha = 0;
                int coluna = 0;

                jogadaMaquinaFacil(qtdJogadas%2==0?1:2);
                qtdJogadas++;
                imprimirTabuleiro();

                if(verificaVencedor()!= 0){

                    if(verificaVencedor()== 1){
                        qtdVitoriaJ1++;
                    }else{
                        qtdVitoriaJ2++;
                    }
                    JOptionPane.showMessageDialog(null, "JOGADOR ["+(verificaVencedor()==1?"X":"O")+"] VENCEDOR");                    
                    qtdJogadas=0;
                    break;
                }

                 JOptionPane.showMessageDialog(null, "JOGADOR ["+(qtdJogadas%2==0?"X":"O"+"]"));


                do{

                    linha = leiaCoordenadaLinha();
                    coluna = leiaCoordenadaColuna();
                    
                     if (posicaoValida(linha, coluna)){
                       JOptionPane.showMessageDialog(null, "POSIÇÃO INVÁLIDA!");
                    }
                    
                } while(posicaoValida(linha, coluna));

                jogadaUsuario(linha, coluna, qtdJogadas%2==0?1:2);
                qtdJogadas++;
                imprimirTabuleiro();


                if(verificaVencedor()!= 0){


                    if(verificaVencedor()== 1){
                        qtdVitoriaJ1++;
                        
                    }else{
                        qtdVitoriaJ2++;
                    }                                         // Exibe o jogador vencedor.
                    
                    JOptionPane.showMessageDialog(null, "JOGADOR ["+(verificaVencedor()==1?"X":"O")+"] VENCEDOR");                   
                    qtdJogadas=0;
                    break;
                }
            }
        }
    }
    
    static void jogar(int linha, int coluna, int jodador){
       
        String jogada = "";
        
        if(jodador == 1){        // Função jogar, recebe a posição de linha, coluna do jogador 
          jogada = "X";         // E aplica "X" para o jogador 1, "O" para o jogador 2, no tabuleiro.
                               // com parametro, sem retorno.
        }
        else if(jodador == 2){
           jogada = "O"; 
           
        }
        tabuleiro[linha][coluna] = jogada;       
      
    }
    
    static void jogadaUsuario(int linha, int coluna, int jogador){
        
        jogar(linha, coluna, jogador); //Função jogada usuário que chama, a função modo jogador  
                                      //Com parametro, sem retorno.
    }
    
    static void jogadaMaquinaFacil(int jogador){ 
        
        Random maquina = new Random();
                                       // Função jogada maquina facil, faz as jogadas aleatórias  
                                        // jogando em uma posição vazia e válida no tabuleiro
        int linha;                   // Com parametro, sem retorno.
        int coluna;
        
        do{ 
            
         coluna = (maquina.nextInt(3));
         linha = (maquina.nextInt(3));
         
         jogar(linha, coluna, jogador);           
         
        } while(!posicaoValida(linha, coluna));
      
    }
    
    public static void main(String[] args) {
       
        imprimeMenuPrincipal();   //Função main chama a função do menu principal para iniciar o jogo.
      
    }
    
}
