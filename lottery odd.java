1. import java.util.*;
2.
3
8. public class LotteryOdds
9. {
10. public static void main(String[] args)
11. {
12. Scanner in = new Scanner(System.in);
13.
14. System.out.print("How many numbers do you need to draw? ");
15. int k = in.nextInt();
16.
17. System.out.print("What is the highest number you can draw? ");
18. int n = in.nextInt();
23.
24. int lotteryOdds = 1;
25. for (int i = 1; i <= k; i++)
26. lotteryOdds = lotteryOdds * (n - i + 1) / i;
27.
28. System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
29. }
30. }