public class Mapa {
    private ObjetoBase[][] mapa;
    private Personagem personagem;
    private int largura;
    private int altura; 

    // instaciar - criar um objeto, fazer uma copia
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.mapa = new ObjetoBase[largura][altura];
    }

    public ObjetoBase[][] mapa() {
        return this.mapa; 
    }

    public Personagem personagem() {
        return this.personagem; 
    }

    public void colocarObjeto(ObjetoBase objeto, int posicaoX, int posicaoY) {
        if(objeto instanceof Personagem) {
            this.personagem = (Personagem) objeto; 
        }
        mapa[posicaoX][posicaoY] = objeto;
        objeto.definirPosicao(posicaoX, posicaoY);
    }

    public void mostraMapa() {
        
        for(int x = this.altura-1; x>=0; x--) {
            
            for (int y = this.largura-1; y>=0; y--) {
                if(personagem.estaVivo() == false) {
                    System.out.print("S");
                } else {
                    if(this.mapa[y][x] == null) {
                        System.out.print("A");
                    } else {
                        System.out.print("" +this.mapa[y][x].toString() + "");
                    }
                    
                }
            }
            System.out.print("\n");
        }
    }

    public void moverOuInteragir(int x, int y) {
        if(personagem.estaVivo() == true) {
            personagem.diminuirTempoDeVida();
            if(mapa[x][y] == null) {
                colocarObjeto(this.personagem, x, y);
            } else if (this.mapa[x][y] instanceof ObjetoBase) {
                if (((ObjetoInteragivel) this.mapa[x][y]).interagir(this)) colocarObjeto(personagem, x, y);

            }
        }
    }




    // movendo personagem

    public void moverParaCima() {
        if(personagem.estaVivo()) {
            if(this.mapa[this.personagem.posicaoX()][this.personagem.posicaoY() +1] == null || this.mapa[this.personagem.posicaoX()][this.personagem.posicaoY() +1] instanceof ObjetoInteragivel) {
                moverOuInteragir(this.personagem.posicaoX(), this.personagem.posicaoY()+1);
                mapa[this.personagem.posicaoX()][this.personagem.posicaoY()-1] = null;
            } 
        }
    }

    public void moverParaBaixo() {
        if(personagem.estaVivo()) {
            if(this.mapa[this.personagem.posicaoX()][this.personagem.posicaoY() -1] == null || this.mapa[this.personagem.posicaoX()][this.personagem.posicaoY() -1] instanceof ObjetoInteragivel) {
                moverOuInteragir(this.personagem.posicaoX(), this.personagem.posicaoY()-1);
                mapa[this.personagem.posicaoX()][this.personagem.posicaoY()+1] = null;
            } 
        }
    }

    public void moverParaDireita() {
        if(personagem.estaVivo()) {
            if(this.mapa[this.personagem.posicaoX()-1][this.personagem.posicaoY()] == null || this.mapa[this.personagem.posicaoX()+1][this.personagem.posicaoY()] instanceof ObjetoInteragivel) {
                moverOuInteragir(this.personagem.posicaoX()-1, this.personagem.posicaoY());
                mapa[this.personagem.posicaoX()+1][this.personagem.posicaoY()] = null;
            } 
        }
    }
    public void moverParaEsquerda() {
        if(personagem.estaVivo()) {
            if(this.mapa[this.personagem.posicaoX()+1][this.personagem.posicaoY()] == null || this.mapa[this.personagem.posicaoX()-1][this.personagem.posicaoY()] instanceof ObjetoInteragivel) {
                moverOuInteragir(this.personagem.posicaoX()+1, this.personagem.posicaoY());
                mapa[this.personagem.posicaoX()-1][this.personagem.posicaoY()] = null;
            } 
        }
    }
    public static Mapa criarFase1() {
        Mapa Barreiras = new Mapa(8, 8); 
        Personagem andrey = new Personagem();
        ObjetoBase parede = new ObjetoBase("I");
    
        Barreiras.colocarObjeto(andrey, Barreiras.largura-2, Barreiras.altura-2);
        for (int j = 0; j < Barreiras.altura; j++) {
            for (int i = 0; i < Barreiras.largura; i++) {
              if (j == 0 || j == Barreiras.altura - 1) {
                Barreiras.colocarObjeto(parede, j, i);
              }
              if (i == 0 || i == Barreiras.largura - 1) {
                Barreiras.colocarObjeto(parede, j, i);
              }
            }
          }
    
        return Barreiras;
    }
}

