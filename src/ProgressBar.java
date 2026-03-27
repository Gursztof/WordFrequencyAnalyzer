public class ProgressBar {
    private final int fillPercentage;

    public ProgressBar(int fillPercentage) {
        this.fillPercentage = fillPercentage;
    }

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
        // 20 is max amount there can be in progress bar (100%)
        for (int i = 20 - roundPercentage(); i > 0; i--) {
            progressBar += " ";
        }
        progressBar += "]";

        return progressBar;
    }
}
