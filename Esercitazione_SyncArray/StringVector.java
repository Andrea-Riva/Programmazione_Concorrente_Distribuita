public class StringVector {
    private String[] stringArray = new String[10];   // Array condiviso di stringhe con 10 posizioni
    private int currentIndex = 9;
    public synchronized void add(String thread_id) {
        // Sezione critica
        this.stringArray[this.currentIndex] = thread_id;    // Aggiunge in coda all'array l'id del thread
        this.currentIndex--;
    }

    public boolean isFull() {
        if(currentIndex == -1) {
            return true;
        }
        return false;
    }

    public String[] getStringArray() {
        return this.stringArray;
    }
}
