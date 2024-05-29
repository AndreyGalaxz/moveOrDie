public class Personagem extends ObjetoBase {
    private int tempoDeVida;
    private int score;

    

    public Personagem() {
        super("Andrey");
        this.score = 0;
        this.tempoDeVida = 20; 
    }


    public int tempoDeVida() {
        return this.tempoDeVida;
    }

    public int score() {
        return this.score;

    }

    public void diminuirTempoDeVida() {
        this.tempoDeVida -=1;  
    }

    public void resetarTudo() {
        this.score = 0;
        this.tempoDeVida = 10; 
    }

    public void resetarTempoDeVida() { 
        this.tempoDeVida = 10;
        this.score = this.score+1; 
    }

    public boolean estaVivo() {
        if(tempoDeVida()>0) {
            return true; 
        } else {
            return false; 
        }
    }

    public String toString() {
        return "P"; 
    }

}
