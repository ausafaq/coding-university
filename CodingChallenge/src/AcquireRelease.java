import java.util.*;

public class AcquireRelease {

    public static int lockCounter(List<String> lockList) {

        Set<Integer> acquireSet = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < lockList.size(); i++) {
            String[] l = lockList.get(i).split(" ");
            switch (l[0].toUpperCase()) {
                case "ACQUIRE":
                    int acquireLock = Integer.parseInt(l[1]);
                    if (!acquireSet.contains(acquireLock)) {
                        acquireSet.add(acquireLock);
                        stack.push(acquireLock);
                    } else {
                        return i + 1;
                    }
                    break;

                case "RELEASE":
                    int releaseLock = Integer.parseInt(l[1]);
                    if (stack.size() > 0 && stack.peek() == releaseLock) {
                        stack.pop();
                        acquireSet.remove(releaseLock);
                    } else {
                        return i + 1;
                    }
                    break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("ACQUIRE 123");
        input.add("ACQUIRE 364");
        input.add("ACQUIRE 84");
        input.add("RELEASE 84");
        input.add("RELEASE 364");
        input.add("ACQUIRE 789");
        input.add("RELEASE 456");
        input.add("RELEASE 123");

        System.out.println(lockCounter(input));
    }
}
