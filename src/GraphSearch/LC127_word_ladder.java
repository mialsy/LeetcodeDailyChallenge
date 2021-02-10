package GraphSearch;

import java.util.*;

public class LC127_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> dict = new HashMap<>();

        for (String word: wordList) dict.put(word, false);
        if (!dict.containsKey(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();

        queue.offer(beginWord);
        dict.put(beginWord, true);
        int step = 1;

        while (!queue.isEmpty()) {
            for (String str: queue) {
                System.out.print(str);
            }
            int qsize = queue.size();
            step++;

            while(qsize--  > 0) {
                StringBuilder sb = new StringBuilder(queue.poll());

                for (int i = 0; i < sb.length(); i++) {
                    char curChar = sb.charAt(i);

                    for (char posChar = 'a'; posChar <= 'z'; posChar++) {
                        if (posChar != curChar) {
                            sb.setCharAt(i, posChar);
                            String str = sb.toString();

                            if (endWord.equals(str)) {
                                return step;
                            }

                            Boolean flag = dict.get(str);
                            if (flag != null && !flag) {
                                dict.put(str, true);
                                queue.offer(str);
                            }
                        }
                    }
                    sb.setCharAt(i, curChar);

                }
            }

        }
        return 0;
    }
}
