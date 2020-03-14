import java.util.*;

public class Permutations {

//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        helper(nums, list, result);
//        return result;
//    }
//
//    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> result) {
//        if(nums.length == list.size()) {
//            result.add(new ArrayList<>(list));
//        } else {
//            for(int i = 0; i < nums.length; i++) {
//                list.add(nums[i]);
//                helper(nums, list, result);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    public static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        helper(s, new StringBuilder(), result);
        return result;
    }

    private static void helper(String s, StringBuilder permutation, List<String> result) {
        if(permutation.length() == s.length()) {
            result.add(permutation.toString());
        } else {
            for(int i = 0; i < s.length(); i++) {
                if(permutation.toString().contains(String.valueOf(s.charAt(i)))) {
                    continue;
                }
                permutation.append(s.charAt(i));
                helper(s, permutation, result);
                permutation.deleteCharAt(permutation.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        List<String> output = permute("abcd");
        System.out.println(output);
    }
}
