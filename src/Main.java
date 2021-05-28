import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import cipher.LFSR;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream inFile = new FileInputStream("inputText.txt");
        FileOutputStream outFile = new FileOutputStream("cipherText.txt");

        byte[] buff = new byte[inFile.available()];
        inFile.read(buff, 0, inFile.available());

        byte[] bytes = LFSR.LFSR1(buff.length * 8);

        for(int i = 0; i < buff.length; i++) {
            buff[i] = (byte)(buff[i] ^ bytes[i]);
        }

        outFile.write(buff, 0, buff.length);

        FileInputStream inputFile = new FileInputStream("cipherText.txt");
        FileOutputStream outputFile = new FileOutputStream("decipherText.txt");

        inputFile.read(buff, 0, inputFile.available());

        for(int i = 0; i < buff.length; i++) {
            buff[i] = (byte)(buff[i] ^ bytes[i]);
        }

        outputFile.write(buff, 0, buff.length);
        System.out.println("Данные успешно зашифрованы и расшифрованы");


    }


}
