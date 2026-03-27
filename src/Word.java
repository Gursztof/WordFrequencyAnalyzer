public class Word {
    private final String content;
    private int count;

    public Word(String content) {
        String cleanContent = content.replaceAll("\\p{P}", "").toLowerCase();
        this.content = cleanContent;
        this.count = 1;
    }

    public String getContent() {
        return content;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    @Override
    public boolean equals(Object comparable) {
        if (comparable == this) {
            return true;
        }
        if (!(comparable.getClass() == this.getClass())) {
            return false;
        }

        Word wordAsWordObject = (Word) comparable;
        if (wordAsWordObject.getContent().equals(this.getContent())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String spaces = "";
        for (int i = 0; i < 20 - content.length(); i++) {
            spaces += " ";
        }
        return content + spaces;
    }
}
