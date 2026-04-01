class Solution {
    public int minEatingSpeed(int[] piles, int h) {
  int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }


        while (l <= r) {
            int midSpeed = l + (r - l) / 2;

            if (canFinish1(midSpeed, piles, h)) {
                r = midSpeed - 1;
            } else {
                l = midSpeed + 1;
            }
        }
        return l;
    }

    private boolean canFinish1(int midSpeed, int[] piles, int targetHours) {
        double time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / midSpeed);

        }
        return time <= targetHours;
}
}
