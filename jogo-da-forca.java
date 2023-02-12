
import javax.swing.JOptionPane;


public class jogodaforca {
    
    static String LerPalavra(){
          
              String palavra;
          
             do{ 
              palavra = JOptionPane.showInputDialog("DIGITE UMA PALAVRA").toUpperCase();
          
             if (palavra.contains(" ")) {
                JOptionPane.showMessageDialog(null,"A PALAVRA DIGITADA CONTÉM ESPAÇO EM BRANCO...");
                
             } else if (palavra.equals("")) {
                JOptionPane.showMessageDialog(null," Ops!\n DIGITE UMA PALAVRA, CAMPO VAZIO!");               
            
            }

        } while (palavra.contains(" ") || (palavra.equals("")));  
          
      return  palavra;
    }
    
    static String CriarAsterisco(String palavra){
        
        char  formaPalavra = '*';
        String palavraParcial = "";
        
        for(int i =0; i < palavra.length(); i++){
            
          palavraParcial += formaPalavra;  
        }
        
      return palavraParcial;
    }
    
    
    static String LerLetras(String palavraParcial ){
        
         String adivinha="",palavra="",letras ="";
         int erros =0;
         
           while (erros < 7 && !palavra.equals(palavraParcial)){
          
           do{    
        adivinha = JOptionPane.showInputDialog("( "+palavraParcial+" )\n"
                     + "Chutes: "+letras+"\n"
                     + "Erros: "+erros).toUpperCase(); 
            
             if (letras.equals(adivinha) || adivinha.contains("")){

                    JOptionPane.showMessageDialog(null, "VOCÊ JÁ CHUTOU!!!");
                    
                }else if(adivinha.equals("")){
                    JOptionPane.showMessageDialog(null," Ops!\n DIGITE UMA LETRA, CAMPO VAZIO!");
                               
                } else  {

                    letras += adivinha + "-";  // Acumula letras junto um hífen.
                    
                }
                if (adivinha.equals(palavra) || adivinha.length() > 1 ) {

                    JOptionPane.showMessageDialog(null, "DIGITE APENAS UMA LETRA POR VEZ! ");
                    
                } 

            } while (adivinha.equals(palavra) || adivinha.length() > 1 || adivinha.equals(""));
        
           }
        return adivinha;
    }
    
    static boolean verificarLetras(String adivinha){
            
        String palavra="";
        boolean ver = true;
        if (palavra.contains(adivinha)) {
                   
            ver = true;
                   
            } 
        
      return ver;
    }
    
    static String RevelarLetras(String adivinha){
        
        String palavraParcial="";
        String palavra =""; 
        if (palavra.contains(adivinha)) {

               int cont = palavra.indexOf(adivinha);

                while (cont != -1) {
                    palavraParcial = palavraParcial.substring(0, cont) + adivinha + palavraParcial.substring(cont + 1);
                    cont = palavra.indexOf(adivinha, cont + 1);  /// Concatenação das letras parcial. 
                }
                
        }     
       return palavraParcial;
    }
    
    
    static boolean Tela( String palavra, int erros){
        
           
        String palavraParcial="";
        
        boolean ver = false;
        while (erros < 7 && !palavra.equals(palavraParcial)){
            
            if (palavra.equals(palavraParcial) && ver == true) {
                     JOptionPane.showMessageDialog(null, "VOCÊ GANHOU");
               
            } else{
                erros++;
            }
            if(erros == 7){
                     JOptionPane.showMessageDialog(null, "VOCÊ PERDEU");              
            }
        }
        
        return  ver;
    }
  
    public static void main(String[] args) {
        String adivinha="",palavraParcial ="";
        int erros =0;
       
        String palavra = LerPalavra();
        String Criar = CriarAsterisco(palavra);
        
        String Ler = LerLetras(palavraParcial);
        boolean Ver = verificarLetras(adivinha);
        String Revelar = RevelarLetras(adivinha);
        boolean tela = Tela(palavra, erros);
        
        JOptionPane.showMessageDialog(null, Criar +Ler + Ver + Revelar+tela);
        
    }
    
}
