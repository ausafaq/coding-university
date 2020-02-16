import java.util.LinkedList;
import java.util.List;

public class CountAndSay {

    public static String countAndSay(int n) {
        LinkedList<Integer> prevSeq = new LinkedList<Integer>();
        prevSeq.add(1);

        // Using -1 as delimiter
        prevSeq.add(-1);

        List<Integer> finalSeq = nextSequence(n, prevSeq);
        StringBuffer seqStr = new StringBuffer();
        for(Integer digit : finalSeq) {
            seqStr.append(String.valueOf(digit));
        }
        return seqStr.toString();
    }

    private static LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
        if(n <= 1) {
            prevSeq.pollLast();
            return prevSeq;
        }

        LinkedList<Integer> nextSeq = new LinkedList<Integer>();
        Integer prevDigit = null;
        Integer digitCnt = 0;
        for(Integer digit : prevSeq) {
            if(prevDigit == null) {
                prevDigit = digit;
                digitCnt += 1;
            } else if (digit == prevDigit) {
                digitCnt += 1;
            } else {
                nextSeq.add(digitCnt);
                nextSeq.add(prevDigit);
                prevDigit = digit;
                digitCnt = 1;
            }
        }

        // delimiter for the next recursion
        nextSeq.add(-1);
        return nextSequence(n-1, nextSeq);
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
