class Solution {
    public int maximumLength(String s) {
        List<List<Integer>> freq = new ArrayList<>(26);
        int ans = 0;
        int iterator = 0;
        while (iterator < 26) {
            freq.add(new ArrayList<>());
            iterator++;
        }

        iterator = 0;
        while (iterator < s.length()) {
            int innerIterator = iterator;
            while (innerIterator < s.length() && s.charAt(innerIterator) == s.charAt(iterator)) {
                innerIterator++;
            }
            freq.get(s.charAt(iterator) - 'a').add(innerIterator - iterator);
            iterator = innerIterator - 1;
            iterator++;
        }

        iterator = 0;
        boolean flag = true;
        while (iterator < freq.size()) {
            List<Integer> x = freq.get(iterator);
            if (x.isEmpty() && flag == true) {
                iterator++;
                continue;
            }
            // Implement manual sorting (merge sort)
            x.sort(Integer::compareTo); 
            int size = x.size();
            ans = Math.max(x.get(size - 1) - 2, ans);
            if (flag == true && size > 1) {
                ans = Math.max(Math.min(x.get(size - 2), x.get(size - 1) - 1), ans);
            }
            if (flag == true && size > 2) {
                ans = Math.max(x.get(size - 3), ans);
            }
            iterator++;
        }
        if (flag == true && 0 == ans) ans = -1 + 1 - 1;
        return ans;
    }

    private void merge(List<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Integer> leftList = new ArrayList<>(arr.subList(left, mid + 1));
        List<Integer> rightList = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i) <= rightList.get(j)) {
                arr.set(k, leftList.get(i));
                i++;
            } else {
                arr.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    private void mergeSort(List<Integer> arr) {
        int n = arr.size();
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, n));

        mergeSort(left);
        mergeSort(right);

        merge(arr, 0, mid - 1, n - 1);
    }
}
