package cipher;
import java.util.BitSet;

public class LFSR {


    public static byte[] LFSR1(int length) {

        int bitsCount = 25;
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();
        bits1.set(0, bitsCount);
        bits2.set(0, bitsCount);

        while(bitsCount < length) {
            //x^25 +x^3 + x + 1
            boolean bit = bits1.get(24) ^ bits1.get(2) ^ bits1.get(0);

            for(int i = 0; i < bitsCount - 1; i++) {
                bits1.set(i, bits1.get(i + 1));
            }
            bits1.set(bitsCount - 1, bit);

            bits2.set(bitsCount, bit);
            bitsCount++;

        }

        return bits2.toByteArray();

    }
}