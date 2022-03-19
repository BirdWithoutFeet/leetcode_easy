package 剑指offer;
/*返回x的算数平方根
* */
public class Main69 {
    public static int mySqrt(int x) {
        if(x <= 1)
            return x;
        int start = 0;
        int end = x>>>1;
        while( start < end){
            int mid = start+((end -start)>>>1);
//            num会溢出
            long num = (long) mid *mid;
            if ( num == x)
                return mid;
            else if (num > x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start*start > x ? start-1 : start;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
