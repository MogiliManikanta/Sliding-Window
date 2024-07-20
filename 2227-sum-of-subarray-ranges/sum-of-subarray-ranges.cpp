class Solution {
public:
    vector<int> findNextSmallerElement(vector<int> &arr) {
        int n = arr.size();
        vector<int> nse(n);  
        stack<int> st;       

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.empty() ? n : st.top();
            st.push(i);
        }
        return nse;
    }

    vector<int> findPreviousSmallerElement(vector<int> &arr) {
        int n = arr.size();
        vector<int> psee(n);  
        stack<int> st;       

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        return psee;
    }

    vector<int> findNextGreaterElement(vector<int> &arr) {
        int n = arr.size();
        vector<int> nge(n);  
        stack<int> st;       

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.empty() ? n : st.top();
            st.push(i);
        }
        return nge;
    }

    vector<int> findPreviousGreaterElement(vector<int> &arr) {
        int n = arr.size();
        vector<int> pge(n);  
        stack<int> st;       

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        return pge;
    }

    long long sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        vector<int> nse = findNextSmallerElement(arr);
        vector<int> psee = findPreviousSmallerElement(arr);
        long long total = 0;  

        for (int i = 0; i < n; i++) {
            long long left = i - psee[i];
            long long right = nse[i] - i;
            total += left * right * arr[i];
        }
        return total;
    }

    long long sumSubarrayMax(vector<int>& arr) {
        int n = arr.size();
        vector<int> nge = findNextGreaterElement(arr);
        vector<int> pge = findPreviousGreaterElement(arr);
        long long total = 0;  

        for (int i = 0; i < n; i++) {
            long long left = i - pge[i];
            long long right = nge[i] - i;
            total += left * right * arr[i];
        }
        return total;
    }

    long long subArrayRanges(vector<int>& nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
};
