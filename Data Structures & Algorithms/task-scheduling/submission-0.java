class Solution {
    public int leastInterval(char[] tasks, int n) {
        // read question carefully
        /*
        As per question, there are tasks that are Alphabets in capital letters
        so, we can 26 letters and we can use count freq of tasks.
        */

        int[] freq = new int[26];

        // iterate over tasks
        for(char task: tasks) {
            // increase count in above arrat
            freq[task - 'A']++;
        }

        // we sort to know max freq value, which is needed
        Arrays.sort(freq);
        int maxFreq = freq[25];
        // after above code, we have fre count of letters
        // we need to calculate total no of cycles required to complete all tasks
        // we need to do taskA and next should be either taskB or taskC
        // not the same task immideately. to do same taskA, we need to wait idle time

        // so, we need calculate how many idel times, we get.
        // the formula for calulating idle
        int idle = (maxFreq -1) * n;

        /*
        To complete all the tasks, I need to first check how many idle periods I need to complete the maxFreq task. 
        So, if I complete the maxFreq task by calculating how much idle times I need. 
        It is concluding that I can complete the other tasks (starting from second max to beginning) by fitting them in the idle times.
    Also, maxFreq - 1 because I need the intervals. 
    As I don't need idle time after the last occurrence of maxFreq character (therefore, -1)
        */

        // calculate idle, 
        // in the above, we got max idle val, 
        
        // now, we need to decrease if we found task(this means, our freq count in freq array >=0)
        // in above, we added freq, so, all the val elements are tasks
        for(int i=24; i>=0; i--) {
            // if here i value >=0, then there is task and we add task before idle
            // decrease idle count
            idle -= Math.min(maxFreq -1, freq[i]);
        }
        // this is we don't need -ve values, iidle values -ve, we take 0
        idle = Math.max(0, idle);

        return tasks.length + idle;

        
    }
}
