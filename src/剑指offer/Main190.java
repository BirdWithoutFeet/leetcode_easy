package 剑指offer;

import java.util.concurrent.ThreadPoolExecutor;

/*
*  颠倒二进制位*/
public class Main190 {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
//            从低位开始反转
            rev |= (n & 1) << (31 - i);
//            反转之后，看n的下一位
            n >>>= 1;
        }
        return rev;
    }
}
