package 剑指offer;
/*
* 二进制中1的个数
* n&(n-1)
* 6 -> 4
* 110 -> 100 1
* 100 -> 0 2
* */
public class Main15 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
