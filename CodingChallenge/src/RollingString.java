public class RollingString {

    public static void main(char[] w) {
        w++;
        System.out.println(w);
        w++;

    }

    public static void main(String[] args) {
        int  s = 0;
        while(s++ < 10) {
            if(s < 4 && s < 9) {
                continue;
            }
            System.out.print(s + " ");
        }
    }

}
