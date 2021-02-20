package String;

public class LC1370_IncreasingDecreasingString {
    public String sortString(String s) {
        StringBuffer sb = new StringBuffer();
        int[] count = new int[26];

        // count freq
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        while (sb.length() < s.length()) {
            // append ascending
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }
            // append descending
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }
}
