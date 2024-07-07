class Solution{
	public int numWaterBottles(int numBottles, int numExchange){
		if ( numBottles < numExchange ) return numBottles; 
		int bottlesDrank = numBottles;
		
		int emptyBottles = numBottles;
		while ( emptyBottles >= numExchange ){
			int exchangedBottles = emptyBottles/numExchange; //1
			emptyBottles =  emptyBottles%numExchange + exchangedBottles; // 2 + 1
			bottlesDrank += exchangedBottles;
		}
		
		return bottlesDrank;
	}
}
