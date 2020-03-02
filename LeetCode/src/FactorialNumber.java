public class FactorialNumber {
//
//    int res = 1;
//        if (n == 1)
//    {
//        return 1;
//    }
//        else
//    {
//        res=  n * Factorial(n - 1);
//    }
//        return res;
//}


    // FACTORIAL OF A NUMBER - BOTTOM UP
    public int FactorialBU(int n)
    {
        int[] memo = new int[n + 1];
        memo[0] = 1;

        for(int i=1;i<=n;i++)
        {
            memo[i] = i * memo[i-1];
        }
        return memo[n];
    }
}


