class Solution {
    public int minEatingSpeed(int[] piles, int h) {
   /*
         * First, read and understood the question
         * There is piles array, where pile[i] contains bananas
         * and there is a time limit 'h' to eat the bananas from all the piles
         * We need to assign or fix the time for each pile and need to all the bananas.
         * Key, If we eat all the in one pile, we are not allowed to move to another pile until our assigned time completed
         *
         * For example, In pile[0] there are 2 bananas and koko can eat 2 bananas per hr.
         * If time assigned is 3 for each pile. Here, koko can finish eating 2 bananas in 2hrs, one hr left.
         * koko not able to move to another pile until 3hrs completed.
         *
         * We need to find how many minimum no of bananas koko can eat in give h time.
         *
         * Here key, In pile[], If koko selects to eat maximum no of bananas/hr. koko can finish with in given time h
         *
         * But, we need to minimum no eat with time h.
         *
         * so we can use binary search from by eating 1 to maximum elemement in pile.
         */

        int minSpeed = 1;
        int maxSpeed = 0;
        // We need to maxi element in pile
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            // now we need to check koko can finish eating in midspeed.
            // we need to check for full pile array.
            if (canFinish(piles, midSpeed, h)) {
                // if koko can finish in midSpeed, we can assign that as maxSpeed and check for lower speed
                // why because we need to finf min eating speed
                maxSpeed = midSpeed;
            } else {
                minSpeed = midSpeed + 1;
            }

        }
        return minSpeed;
    }

    private boolean canFinish(int[] piles, int midSpeed, int h) {
        double time = 0;
        // calculate time for finishing all pile bananas
        for (int pile : piles) {
            time += Math.ceil((double) pile / midSpeed);
        }
        //check koko able to eat within given time
        return time <= h;
    }
}
