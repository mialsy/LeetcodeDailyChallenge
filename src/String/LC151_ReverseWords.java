package String;

public class LC151_ReverseWords {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        reverse(arr, 0, arr.length - 1);

        // handle extra space
        int len = removeSpace(arr);

        // handle removing extra space
        int start = 0;
        int end = 0;
        while (end < len) {
            while (end < len && arr[end] != ' ') {
                end++;
            }
            reverse(arr, start, end - 1);
            start = ++end;
        }

        return new String(arr, 0, len);
    }

    private int removeSpace(char[] arr) {
        int slow = 0;
        for (int fast = 0; fast <arr.length ; fast++) {
            if (arr[fast] == ' ' && (slow == 0 || arr[slow - 1] == ' ')) {
                // extra space, do not copy
                continue;
            }  else {
                // copy
                arr[slow++] = arr[fast];
            }
        }

        if (slow == 0) {
            return 0;
        }
        return arr[slow - 1] == ' ' ? slow - 1: slow;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
