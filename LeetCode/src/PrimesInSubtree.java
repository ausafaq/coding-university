import java.util.*;

public class PrimesInSubtree {

    //Tree creation
    public static Map<Integer, List<Integer>> createTree(List<Integer> first, List<Integer> second) {
        //create map
        Map<Integer, List<Integer>> nodeChildren = new HashMap<>();


        for (int i = 0; i < first.size(); i++) {
            if (nodeChildren.get(first.get(i)) == null) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(second.get(i));
                nodeChildren.put(first.get(i), tempList);
            } else {
                List<Integer> existingChildren = nodeChildren.get(first.get(i));
//                System.out.println(nodeChildren);
//                System.out.println(nodeChildren.get(first.get(i)));
//                System.out.println(second.get(i));
                existingChildren.add(second.get(i));
                nodeChildren.put(first.get(i), existingChildren);
            }
        }
        return nodeChildren;
    }

    //To be queried nodes list
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


    public static boolean isPrime(int num) {

        if(num <= 1) {
            return false;
        }

        for(int i = 2; i <= num/2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int isPrimeCount(List<Integer> toBeQueriedNodes, List<Integer> values) {
        int primeCount = 0;
        for(Integer node : toBeQueriedNodes){
//            System.out.println(toBeQueriedNodes);
//            System.out.println(values);
//            System.out.println(node);
//            System.out.println(values.get(node-1));
            if(isPrime(values.get(node-1))) {
                primeCount++;
            }
        }
        return primeCount;
    }

    public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (Integer toQuery : queries) {
            List<Integer> toBeTraversed = traverseTree(toQuery, first.get(0), createTree(first, second));
            result.add(isPrimeCount(toBeTraversed, values));
        }
        //System.out.println(result);
        return result;

    }

    public static void main(String[] args) {

//        List<Integer> first = Arrays.asList(1,1,8,8,8,8,5,9,6);
        List<Integer> first = Arrays.asList (9,6,8,3,6,4,1,8,5,1);
        List<Integer> second = Arrays.asList(9,9,9,5,7,8,8,10,8,2);
//        List<Integer> second = Arrays.asList(2,8,4,5,9,10,3,6,7);
        List<Integer> values = Arrays.asList(17, 29, 3, 20, 11, 8, 3, 23, 5, 15);
        List<Integer> queries = Arrays.asList(6, 1,8,9,6,4,3);
//        List<Integer> result = new ArrayList<>();

//
//        for (Integer toQuery : queries) {
//            List<Integer> toBeTraversed = traverseTree(toQuery, first.get(0), createTree(first, second));
//            result.add(isPrimeCount(toBeTraversed, values));
//        }
//        System.out.println(result);
        System.out.println(createTree(first, second));
        System.out.println(traverseTree(7, first.get(0), createTree(first, second)));
        System.out.println("********************");
        System.out.println(primeQuery(10, first, second, values, queries));
    }
}
