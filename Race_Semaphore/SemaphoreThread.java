import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {
    private Counter count;  // Variabile condivisa
    private Semaphore semaphore;    // Semaforo per gestire la Race Condition

    public SemaphoreThread(Counter count, Semaphore semaphore) {    // Costruttore
        this.count = count;
        this.semaphore = semaphore;
    }

    public void run() { // Viene eseguito quando viene avviato il thread
        for(int i = 0; i < 1000; i++) {
            try {
                semaphore.acquire();    // Richiede l'accesso alla sezione critica
                // Accede alla sezione critica ed esegue operazioni sulla variabile condivisa
                System.out.println("Il thread è nella sezione critica e sta eseguendo l'operazione di add()");
                count.add(1);    // Incrementa la variabile condivisa
                semaphore.release();    // Rilascia la sezione critica
            } catch (InterruptedException e) {  // Eccezione
                System.out.println("Qualcosa è andato storto:\n" + e.getMessage());
                System.exit(-1);
            }
        }
    }
}
