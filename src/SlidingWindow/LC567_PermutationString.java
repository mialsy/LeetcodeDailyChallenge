package SlidingWindow;

import java.util.Arrays;

public class LC567_PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            freq1[c - 'a']++;
        }

        int offset = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char in = s2.charAt(i);
            if (i < offset) {
                freq2[in - 'a']++;
            } else {
                if (Arrays.equals(freq1, freq2)) {
                    break;
                }
                char out = s2.charAt(i - offset);
                freq2[out - 'a']--;
                freq2[in - 'a']++;
            }
        }
        return Arrays.equals(freq1, freq2);
    }
}
