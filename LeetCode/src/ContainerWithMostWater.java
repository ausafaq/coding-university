public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;

        while(l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(input));
    }
}
