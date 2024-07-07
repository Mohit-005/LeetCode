class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Initialize the total number of bottles drunk to the initial number of full bottles.
        int totalDrunkBottles = numBottles;
        
        // Initialize the number of empty bottles to the initial number of full bottles.
        int emptyBottles = numBottles;

        // Continue the process as long as we have enough empty bottles to exchange for at least one full bottle.
        while (emptyBottles >= numExchange) {
            // Calculate the number of new full bottles we can get by exchanging empty bottles.
            int newFullBottles = emptyBottles / numExchange;
            
            // Add the new full bottles to the total number of bottles drunk.
            totalDrunkBottles += newFullBottles;
            
            // Update the number of empty bottles:
            // - The remainder of empty bottles after the exchange.
            // - Plus the new empty bottles obtained from drinking the new full bottles.
            emptyBottles = emptyBottles % numExchange + newFullBottles;
        }

        // Return the total number of bottles drunk.
        return totalDrunkBottles;
    }
}
