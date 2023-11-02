class Solution {
    public int findKthNumber(int m, int n, int k) {
    return findKthNumberHelper(m, n, k, 1, m * n);
}

private boolean enough(int num, int m, int n, int k) {
    int count = 0;
    for (int val = 1; val <= m; val++) {
        int add = Math.min(num / val, n);
        if (add == 0) {
            break;
        }
        count += add;
    }
    return count >= k;
}

private int findKthNumberHelper(int m, int n, int k, int left, int right) {
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (enough(mid, m, n, k)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}

}