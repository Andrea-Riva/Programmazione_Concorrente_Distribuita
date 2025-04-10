// Classe per la variabile condivisa
public class Counter {
    private long count = 0;     // Variabile condivisa
    public void add(long toAdd) {   // Metodo per la somma
        long temp = this.count;
        temp += toAdd;
        this.count = temp;
    }

    public long valueOfCount() {
        return this.count;  // return del count attuale
    }
}
