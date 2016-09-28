import com.google.zxing.common.BitMatrix;

public class Launcher {

    private static final String DATA = "http://tyndare.com";
    private static final int OUTPUT_SIZE = 128;
    private static final String SEPARATOR = ".";
    private static final String EXT ="png";
    private static final String OUTPUT_PATH = "src/main/resources/test2";

    public static void main(String[] args) {
        BitMatrix matrix = QRGenerator.generateMatrix(DATA, OUTPUT_SIZE);

        String outputFileName = OUTPUT_PATH + SEPARATOR + EXT;
        QRGenerator.writeImage(outputFileName, EXT, matrix);
    }
}
