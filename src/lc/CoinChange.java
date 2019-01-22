package lc;

public class CoinChange {
	private int[] coins;
	
	public static void main(String[] args) {
		System.out.println(new CoinChange().coinChange(new int[] {2}, 3));
	}
	
	public int coinChangeRec(int amount) {
		if (amount==0)
			return 0;
		if (amount<0)
			return -1;
		int minChangePre = Integer.MAX_VALUE;
		for(int coin : coins) {
			int numChange = coinChangeRec(amount-coin);
			if ( numChange != -1) {
				minChangePre = Math.min(minChangePre, numChange);
			}
		}
		if (minChangePre == Integer.MAX_VALUE)
			return -1;
		else
			return minChangePre+1;
	}
	
	public int coinChange(int[] coins, int amount) {
		if (coins==null || coins.length==0 || amount<0)
			return -1;
        if (amount == 0)
            return 0;
        
		this.coins = coins;
		
		return coinChangeRec(amount); 
	}
}
