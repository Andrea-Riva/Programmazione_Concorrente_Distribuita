// Gestisce la Race Condition attraverso l'uso di semafori

import java.util.concurrent.Semaphore;

public class ManageRaceCondition_Sem {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();   // Inizializza la variabile condivisa

        // Semaforo a 1 --> il thread può accedere alla sezione critica
        // Semaforo a 0 --> il thread viene bloccato
        Semaphore s = new Semaphore(1); // Semaforo inizializzato a 1
        // Creazione dei threads
        SemaphoreThread thread1 =  new SemaphoreThread(c, s);   // Thread numero 1
        SemaphoreThread thread2 = new SemaphoreThread(c, s);    // Thread numero 2
        // Start e join dei thread
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Valore del contatore:\n" + c.valueOfCount());
    }
}
