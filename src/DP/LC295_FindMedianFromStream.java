package DP;

import java.util.ArrayList;
import java.util.List;

public class LC295_FindMedianFromStream {
    class MedianFinder {
        List<Integer> list;
        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            if (list.size() == 0) {
                list.add(num);
            } else {
                int index = binarySearch(num);
                if (index == -1) {
                    // all list item smaller than num
                    list.add(num);
                } else {
                    list.add(index, num);
                }
            }
        }

        // find smallest larger element than num
        private int binarySearch(int num) {
            int left = 0;
            int right = list.size() - 1;

            while (left < right - 1) {
                int mid = (right - left) / 2 + left;
                if (list.get(mid) <= num) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (list.get(left) > num) {
                return left;
            }
            if (list.get(right) > num) {
                return right;
            }
            return -1;
        }

        public double findMedian() {
            int mid = list.size() / 2;
            if (list.size() % 2 == 0) {
                return ((double)list.get(mid) + list.get(mid - 1)) / 2;
            } else {
                return (double)list.get(mid);
            }
        }
    }
}
