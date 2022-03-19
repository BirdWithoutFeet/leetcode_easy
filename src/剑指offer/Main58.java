package 剑指offer;
/*字符串反转
* */
public class Main58 {
    public static String reverseWords(String s) {

        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s1.length-1; i >= 0 ; i--) {
            if (s1[i].equals(""))
                continue;
            builder.append(s1[i]);
            builder.append(" ");
        }

        return builder.toString().trim();
    }

    public static void main(String[] args) {
        reverseWords("");
    }
}
