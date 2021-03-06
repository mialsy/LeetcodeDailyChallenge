package String;

public class LC14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;

        while (true) {
            char current_c = '#';
            for (String str: strs) {
                if (i == str.length()) {
                    return str.substring(0, i);
                } else if (current_c == '#') {
                    current_c = str.charAt(i);
                } else if (current_c != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
            i++;
        }
    }
}
