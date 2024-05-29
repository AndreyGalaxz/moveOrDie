public class ObjetoBase {
    private String id;
    private int posicaoX;
    private int posicaoY; 

    // construtor iniciliza id 
    public ObjetoBase(String novo_id) {
        this.id = novo_id; 
    }
    
    public int posicaoX() {
        return this.posicaoX;
    }
    public int posicaoY() {
        return this.posicaoY;
    }
    public String toString() {
        return this.id;
    }

    // setter
    public void definirPosicao(int nova_posicaoX, int nova_posicaoY) {
        this.posicaoX = nova_posicaoX;
        this.posicaoY = nova_posicaoY;
    }
}

