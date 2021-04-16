package String;

public class LC1119_remove_vowels {
    public String removeVowels(String s) {
        char[] arr = s.toCharArray();

        int i = 0;
        int j = 0;

        for (; j < arr.length; j++) {
            if (arr[j] != 'a' && arr[j] != 'e' && arr[j] != 'i' && arr[j] != 'o' && arr[j] != 'u' ) {
                arr[i++] = arr[j];
            }
        }
        return new String(arr, 0, i);

    }
}
