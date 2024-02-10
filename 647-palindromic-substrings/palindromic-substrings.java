class Solution {
    public int countSubstrings(String s) {
        int count=0;
        if(s.length()==0 || s.isEmpty()){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            count+=palindrome(s,i,i);
            count+=palindrome(s,i,i+1);
        }
        return count;
    }
    public int palindrome(String s ,int left,int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
        }
        return count;
    }
}
/**A very easy explanation with an example
Lets take a string "aabaa"

Step 1: Start a for loop to point at every single character from where we will trace the palindrome string.
checkPalindrome(s,i,i); //To check the palindrome of odd length palindromic sub-string
checkPalindrome(s,i,i+1); //To check the palindrome of even length palindromic sub-string

Step 2: From each character of the string, we will keep checking if the sub-string is a palindrome and increment the palindrome count. To check the palindrome, keep checking the left and right of the character if it is same or not.

First Loop:
0_1500788783696_300147d3-e98e-4977-83f1-9eb8213a485e-image.pngPalindrome: a (Count=1)0_1500788808121_fec1dec5-ab5f-44cf-8dbd-eb2780e8d65f-image.pngPalindrome: aa (Count=2)

Second Loop:
0_1500788845582_881440b8-6dde-4b6f-a864-24fef277069b-image.pngPalindrome: a (Count=3)0_1500788872920_61fc20cb-0cb2-4179-8f5a-529cbad7a2ec-image.pngPalindrome: No Palindrome

Third Loop:
0_1500788901120_bf12b13b-ff32-4703-86cf-0bcb54465428-image.pngPalindrome: b,aba,aabaa (Count=6)0_1500788934388_5cc2c31d-404c-456a-a77d-1432bb0c679b-image.pngPalindrome: No Palindrome

Forth Loop:
0_1500788981884_a2d3f30e-0745-4a75-b2c0-940834bd6a84-image.pngPalindrome: a (Count=7)0_1500789009429_f38aa5c2-17ac-47db-8fe9-b9bb4ceb1407-image.pngPalindrome: aa (Count=8)

Count = 9 (For the last character)

Answer = 9 */