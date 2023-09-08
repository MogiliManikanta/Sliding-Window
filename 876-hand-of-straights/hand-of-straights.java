import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count the frequency of each element in the hand array
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Iterate through the unique elements in ascending order
        for (int card : map.keySet()) {
            int count = map.get(card);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    // Check if the next cards in the sequence exist and reduce their counts
                    int nextCard = card + i;
                    if (map.containsKey(nextCard) && map.get(nextCard) >= count) {
                        map.put(nextCard, map.get(nextCard) - count);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
