public class SimpleWriter extends Thread{
    private String id;  // ID del thread da aggiungere in coda all'array
    private StringVector stringVector;  // Oggetto condiviso

    public SimpleWriter(String id, StringVector stringVector) {
        this.id = id;
        this.stringVector = stringVector;
    }

    public void run() {
        for(int i = 0; i < 6; i++) {    // Inserisci ID per 6 volte (così si ha la certezza che ad una certa le posizioni dell'array saranno tutte occupate)
            System.out.println(this.id + " sta provando a scrivere nell'array...");
            if(stringVector.isFull()) {
                System.out.println("Array pieno: " + this.id + " non è riuscito a scrivere!");
            } else {
                System.out.println(this.id + " è riuscito a scrivere!");
                stringVector.add(this.id);
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
