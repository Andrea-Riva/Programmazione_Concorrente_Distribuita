// Esercitazione 20/03/2025 sulla sincronizzazione: Esercizio per casa

public class SyncArrayApp {
    public static void main(String[] args) throws InterruptedException {
        StringVector stringVector = new StringVector(); // Creazione oggetto condiviso
        // Creazione dei threads
        SimpleWriter t1 = new SimpleWriter("t1", stringVector);
        SimpleWriter t2 = new SimpleWriter("t2", stringVector);
        // Esecuzione dei threads
        t1.run(); t2.run();
        // Stampa il risultato finale
        System.out.println("Risultato finale: ");
        for(String s : stringVector.getStringArray()) {
            System.out.println(s);
        }
    }
}
