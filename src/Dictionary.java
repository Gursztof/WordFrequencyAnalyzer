public class Dictionary {
    private Word[] words;
    private int size;

    public Dictionary() {
        // 5 is default value for capacity of array.
        this.words = new Word[5];
        this.size = 0;
    }

    public void add(Word word) {
        Word match = contains(word);
        if (match != null) {
            match.addCount();
        } else {
            if (size >= words.length) {
                grow();
            }
            words[size] = word;
            size++;
        }
    }

    public Word contains(Word word) {
        for (int i = 0; i < size; i++) {
            Word compered = words[i];
            if (compered.equals(word)) {
                return compered;
            }
        }
        return null;
    }

    public Word mostCommon() {
        Word leaderWord = words[0];
        for (int i = 1; i < size; i++) {
            Word challengerWord = words[i];
            if (challengerWord.getCount() > leaderWord.getCount()) {
                leaderWord = challengerWord;
            }
        }
        return leaderWord;
    }

    private void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j <= size - 1; j++) {
                if (words[i].getCount() < words[j].getCount()) {
                    swap(i, j);
                }
            }
        }
    }

    private void swap(int fromIndex, int toIndex) {
       Word helper = words[toIndex];
       words[toIndex] = words[fromIndex];
       words[fromIndex] = helper;
    }

    private void grow() {
        int newCapacity = words.length * 2;
        Word[] newWords = new Word[newCapacity];
        for (int i = 0; i < size; i++) {
            newWords[i] = words[i];
        }
        words = newWords;
    }

    public void analyze() {
        sort();
        for (int i = 0; i < size; i++) {
            int fillPercentage = 100 * words[i].getCount() / mostCommon().getCount();
            ProgressBar progressBar = new ProgressBar(fillPercentage);
            System.out.println(words[i] + " " + progressBar);
        }
    }
}
