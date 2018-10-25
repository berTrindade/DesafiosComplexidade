package desafios;

public class SextoDesafio {

	private static int MAXN = 10001;
	int[] dp = new int[MAXN];
	boolean[] ok = new boolean[MAXN];
	int tempo = 55;
	int m = 3;
	int n = 5;
	
	
	public SextoDesafio(){
		ok[0] = true;
		for(int i = m ; i<=tempo;i++){
			if(ok[i-m]){
				dp[i] = Math.max(dp[i], dp[i-m]+1);
				ok[i] = true;
			}
			
		}
		for (int i = n; i <= tempo; i++){
			if (ok[i - n])
				dp[i] = Math.max(dp[i], dp[i - n] + 1);
				ok[i] = true;
		}
		int pos;
		for (pos = tempo; pos >= 0; pos--){
			if (dp[pos] > 0)
				break;
		}
		if (pos == tempo)
			System.out.println(dp[pos]);
		else if (pos == -1)
			System.out.println(0 + " "+ tempo);
		else
			System.out.println(dp[pos] + " "+ (tempo-pos));
	}
	
}
