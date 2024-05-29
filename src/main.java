import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Mapa fase1 = Mapa.criarFase1();
    @SuppressWarnings("resource")
    Scanner leitor = new Scanner(System.in);
    

    while (true) {
      System.out.print("\033[H\033[2J");  
      System.out.flush();
      fase1.mostraMapa();
      System.out.println();
      System.out.printf("Score: %d\n", fase1.personagem().score());
      System.out.printf("Tentativas restantes: %d\n", fase1.personagem().tempoDeVida());
      System.out.print(fase1.personagem().posicaoX()); 
      System.out.print(fase1.personagem().posicaoY()); 

      System.out.print("Comando > ");
      String line = leitor.nextLine();
      for(int i=0;i<line.length();i++) {
        char comando = line.charAt(i);
        if (comando=='a') {
          fase1.moverParaEsquerda();
        }
        else if (comando == 'd') {
          fase1.moverParaDireita();
        }
        else if (comando == 'w') {
          fase1.moverParaCima();
        }
        else if (comando == 's') {
          fase1.moverParaBaixo();
        }
        else if (comando == 'n') {
          fase1.personagem().resetarTudo();
        }
      }

    }

  }
}
