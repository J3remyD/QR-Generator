import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class QRGenerator {

    private QRGenerator() {
        new IllegalAccessException();
    }

    protected static BitMatrix generateMatrix(String data, int size) {
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
        } catch(WriterException w) {
        }
        return bitMatrix;
    }

    protected static void writeImage(String outputFileName, String format, BitMatrix bitMatrix)  {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName))) {
            MatrixToImageWriter.writeToStream(bitMatrix, format, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
