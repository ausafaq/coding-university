public class Challenge {

    public static void main(String[] args) {
        int s = 0;
        while(s++ < 10) {
            if(s < 4 && s < 9) {
                continue;
            }
            System.out.print(s + " ");
        }
    }
}
