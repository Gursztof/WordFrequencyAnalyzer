public class ProgressBar {
    private final int fillPercentage;

    public ProgressBar(int fillPercentage) {
        this.fillPercentage = fillPercentage;
    }

    // TODO BETTER NAMNG CUZ ITS NOT ROUDING
    private int roundPercentage() {
        int toRemove = fillPercentage % 5;
        return (fillPercentage - toRemove) / 5;
    }

    @Override
    public String toString() {
        String progressBar = "[";
        for (int i = roundPercentage(); i >= 0; i--) {
            progressBar += "█";
        }
        // NEED EXPLAINING MAGIC NUMBER 20 !!@!312   20 is 100% 0f how much squeres there can be
        for (int i = 20 - roundPercentage(); i >= 0; i--) {
            progressBar += " ";
        }
        progressBar += "]";

        return progressBar;
    }
}
