package Soda;

import java.io.*;

class LCS

{
	static void lcs(String x, String y, int m, int n)
	{
		int[][] lcs = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				else
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
			}
		}
		int index = lcs[m][n];
		int temp = index;
		char[] c = new char[index + 1];
		c[index] = ' ';
		int i = m, j = n;
		while (i > 0 && j > 0)

		{

			if (x.charAt(i - 1) == y.charAt(j - 1))

			{

				c[index - 1] = x.charAt(i - 1);

				i--;

				j--;

				index--;

			}

			else if (lcs[i - 1][j] > lcs[i][j - 1])

				i--;

			else

				j--;

		}

		System.out.println("answer is ");

		for (int k = 0; k <= temp; k++)

			System.out.print(c[k]);

	}

	// driver program

	public static void main(String[] args)

	{
		String X = "abacaba";
		String Y = "abcdcba";
		int m = X.length();
		int n = Y.length();
		lcs(X, Y, m, n);
	}

}
