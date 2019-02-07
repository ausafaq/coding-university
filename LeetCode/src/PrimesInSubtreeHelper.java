import java.util.*;

public class PrimesInSubtreeHelper {

    static boolean[] precomputedPrimes = computePrime(100000);

    public static Map<Integer, List<Integer>> createTree(List<Integer> first, List<Integer> second) {

        Map<Integer, List<Integer>> nodeChildren = new HashMap<>();

        //List<Integer> oneNode = searchElement(first, 1); // 6, 9
        Set<Integer> visitedList = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            visitedList.add(node);
            List<Integer> indexList = searchElement(first, node);
            for(int idx : indexList) {
                if(!visitedList.contains(second.get(idx))) {
                    queue.add(second.get(idx));
                    if(nodeChildren.get(node) == null) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(second.get(idx));
                        nodeChildren.put(node, tempList);
                    } else {
                        List<Integer> tempList = nodeChildren.get(node);
                        tempList.add(second.get(idx));
                        nodeChildren.put(node, tempList);
                    }
                }
            }

            indexList = searchElement(second, node);
            for(int idx : indexList) {
                if(!visitedList.contains(first.get(idx))) {
                    queue.add(first.get(idx));
                    if(nodeChildren.get(node) == null) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(first.get(idx));
                        nodeChildren.put(node, tempList);
                    } else {
                        List<Integer> tempList = nodeChildren.get(node);
                        tempList.add(first.get(idx));
                        nodeChildren.put(node, tempList);
                    }
                }
            }

        }
        return nodeChildren;
    }

    public static List<Integer> searchElement(List<Integer> first, int element) {
        List<Integer> search = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < first.size(); i++ ) {
            if(first.get(i) == element) {
                search.add(i);
            }
        }
        return search;
    }

    public static boolean[] computePrime(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }

    public static List<Integer> traverseTree(int queryNode, int root, Map<Integer, List<Integer>> nodeChildrenMap) {
        Queue<Integer> queue = new LinkedList();
        queue.add(root);
        boolean addNodeTobeQueriedNode = false;
        List<Integer> toBeQueriedNode = new ArrayList<>();
        if(root == queryNode) {
            addNodeTobeQueriedNode = true;
            toBeQueriedNode.add(queryNode);
        }
        while(!queue.isEmpty()) {
//            System.out.println("=====");
//            System.out.println(toBeQueriedNode);
//            System.out.println(queue);
            Integer node = queue.poll();
            if(nodeChildrenMap.get(node) == null) {
                continue;
            }
            List<Integer> children = nodeChildrenMap.get(node);
            if (children.contains(queryNode)) {
                queue.clear();
                queue.add(queryNode);
                addNodeTobeQueriedNode = true;
                toBeQueriedNode.add(queryNode);
            } else {
                for (Integer childNode : children) {
                    if(addNodeTobeQueriedNode) {
                        toBeQueriedNode.add(childNode);
                    }
                    queue.add(childNode);
                }
            }
        }
        return toBeQueriedNode;
    }

    public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (Integer toQuery : queries) {
            List<Integer> toBeTraversed = traverseTree(toQuery,1, createTree(first, second));
            result.add(isPrimeCount(toBeTraversed, values));
        }
        System.out.println(result);
        return result;

    }
//
//    public static boolean isPrime(int num) {
//        if(num <= 1) {
//            return false;
//        }
//
//        if(num <= 3) {
//            return true;
//        }
//
//        if (num % 2 == 0 || num % 3 == 0) {
//            return false;
//        }
//
//        for (int i=5; i*i <= num; i=i+6) {
//            if (num % i == 0 || num % (i+2) == 0) {
//                return false;
//            }
//        }
//        return true;
//    }


    public static int isPrimeCount(List<Integer> toBeQueriedNodes, List<Integer> values) {
        int primeCount = 0;
        for(Integer node : toBeQueriedNodes){
            System.out.println("--------------");
            System.out.println(toBeQueriedNodes);
//            System.out.println(values);
//            System.out.println(node);
//            System.out.println(values.get(node-1));
//            if(isPrime(values.get(node-1))) {
//                primeCount++;
//            }
            if(precomputedPrimes[values.get(node - 1)]) {
                System.out.println("Prime Number: " + values.get(node -1));
                primeCount++;
            }
        }
        return primeCount;
    }


    public static void main(String[] args) {
        List<Integer> first = Arrays.asList (9,6,8,3,6,4,1,8,5,1);
        List<Integer> second = Arrays.asList(9,9,9,5,7,8,8,10,8,2);

        System.out.println(createTree(first, second));
        System.out.println(traverseTree(1, 1, createTree(first, second)));
        List<Integer> values = Arrays.asList(1, 29, 3, 2, 11, 8, 3, 23, 5, 15);
        List<Integer> queries = Arrays.asList(6, 1,8,9,6,4,3);
        primeQuery(10, first, second, values, queries);
    }



}
