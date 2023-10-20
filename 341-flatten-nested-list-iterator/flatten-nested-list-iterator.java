/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> fList = null; // Flattened list to store integers
    private Iterator<Integer> it; // Iterator for the flattened list

    // Constructor that takes a nested list as input
    public NestedIterator(List<NestedInteger> nestedList) {
        fList = new ArrayList<>(); // Initialize the flattened list
        flattening(nestedList); // Flatten the nested list
        it = fList.iterator(); // Create an iterator for the flattened list
    }

    // A recursive helper method to flatten the nested list
    private void flattening(List<NestedInteger> nestedList) {
        for (NestedInteger currEl : nestedList) {
            if (currEl.isInteger()) {
                // If the current element is an integer, add it to the flattened list
                fList.add(currEl.getInteger());
            } else {
                // If the current element is a nested list, recursively flatten it
                flattening(currEl.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (it.hasNext()) {
            // If there is a next integer in the flattened list, return it
            return it.next();
        } else {
            // If there are no more integers, return null (as per Iterator contract)
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        // Check if there is a next integer in the flattened list
        return it.hasNext();
    }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */