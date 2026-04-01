class Solution {

    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            maxHeap.add(i);
        }
        System.out.println(maxHeap);
      while (maxHeap.size() > 1) {
          int num1 = maxHeap.poll();
           
          int num2 = maxHeap.poll();
           
          if (num1 != num2) {
              maxHeap.offer(num1 - num2);
          } 
      }


        return maxHeap.size() == 0 ? 0: maxHeap.peek();
    }
}
