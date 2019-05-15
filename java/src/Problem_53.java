/**
 * @author wwwanjian
 * @className Problem_53
 * @description TODO
 * @create 2019/5/15 13:12
 * @vsersion 1.0
 **/
//1，统计某个数组再排序数组中出现的次数
public class Problem_53 {
    public static void main(String args[]) {
        //获得排序数组
        int[] arr = {-3, -1, 1, 4, 5};
        int target = 6;
        //统计次数
        long start = System.nanoTime();
//        int result = timesOfNum_enter(arr, target);
//        int result = findMissNum(arr);
        int result = findNumEqualToIndex(arr);
        long end = System.nanoTime();
        System.out.println("总共用时:" + (end - start));
        //输出结果
        System.out.println(result);
    }

    //题目一：统计次数入口函数
    public static int timesOfNum_enter(int[] arr, int target) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return 0;
        }
        //统计次数
        int result = timesOfTarget_2(arr, target, 0, arr.length - 1);
        //返回结果
        return result;
    }

    //思路1：遍历
    //思路2：二分查找,在两边分别查找,这里实现思路2 用时3800ns
    private static int timesOfTarget_1(int[] arr, int target, int start, int end) {
        if (start == end) {
            return arr[start] == target ? 1 : 0;
        }
        int mid = (start + end) / 2;
        int left = 0;
        int right = 0;
        if (arr[mid] > target) {
            left = timesOfTarget_1(arr, target, start, mid);
        } else if (arr[mid] < target) {
            right = timesOfTarget_1(arr, target, mid + 1, end);
        } else {
            left = timesOfTarget_1(arr, target, start, mid);
            right = timesOfTarget_1(arr, target, mid + 1, end);
        }
        return left + right;
    }

    //思路3：用二分查找找到第一个k和最后一个k  用时5000ns
    private static int timesOfTarget_2(int[] arr, int target, int start, int end) {
        //找到第一个k
        int fristK = findFirstK(arr, target, start, end);
        //找到最后一个k
        int lastK = findLastK(arr, target, start, end);
        //统计次数
        return fristK == -1 ? 0 : lastK - fristK + 1;
    }

    //二分查找递归找到第一个k
    private static int findFirstK(int[] arr, int target, int start, int end) {
        if (start == end) {
            return arr[start] == target ? start : -1;
        }
        int mid = (end + start) / 2;
        if (arr[mid] == target) {
            if (mid > 0) {
                if (arr[mid - 1] != target) {
                    return mid;
                } else {
                    return findFirstK(arr, target, start, mid - 1);
                }
            } else {
                return mid;
            }
        } else if (arr[mid] > target) {
            return findFirstK(arr, target, start, mid - 1);
        } else {
            return findFirstK(arr, target, mid + 1, end);
        }
    }

    //二分查找递归找到最后一个k
    private static int findLastK(int[] arr, int target, int start, int end) {
        if (start == end) {
            return arr[start] == target ? start : -1;
        }
        int mid = (end + start) / 2;
        if (arr[mid] == target) {
            if (mid < arr.length - 1) {
                if (arr[mid + 1] != target) {
                    return mid;
                } else {
                    return findLastK(arr, target, mid + 1, end);
                }
            } else {
                return mid;
            }
        } else if (arr[mid] > target) {
            return findLastK(arr, target, start, mid - 1);
        } else {
            return findLastK(arr, target, mid + 1, end);
        }
    }

    //题目二：0-n-1中缺失的数字
    public static int findMissNum(int[] arr) {
        //输入检查
        if (arr == null | arr.length < 1) {
            return 0;
        }
        //获取确实数字
        int result = findFristErrorIndex(arr, 0, arr.length - 1);
        //返回结果
        return result;
    }

    //获取确实数字
    //思路1:暴力遍历，如果不是与上一个数字连续的则找到缺失的，时间O(n)
    //思路2：求和，0-n-1的和减去数组的和即为缺失的数字，时间O(n)
    //思路3：数组是排序的，缺失值之前的数和索引相同，缺失值后面的数和索引相差一，可用二分查找找到第一个索引与值不相同的数，O(lgn)
    private static int findFristErrorIndex(int[] arr, int start, int end) {
        //查找终止条件
        if (start == end) {
            return arr[start] == start ? start + 1 : start;
        }
        //二分查找
        int mid = (start + end) / 2;
        if (arr[mid] != mid) {
            if (mid > 0) {
                if (arr[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    return findFristErrorIndex(arr, start, mid - 1);
                }
            } else {
                return mid;
            }
        } else {
            return findFristErrorIndex(arr, mid + 1, end);
        }
    }

    //题目三：数组中数值和下标相等的元素
    public static int findNumEqualToIndex(int[] arr) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return -1;
        }
        //找到元素
        int result = findNumEqualToIndexCore(arr, 0, arr.length);
        //返回结果
        return result;
    }

    //找到数字和下标相等的元素
    //思路1：暴力遍历
    //思路2：二分查找，数值比索引大，右边不可能会有这种数，查找左边，反之亦然
    private static int findNumEqualToIndexCore(int[] arr, int start, int end) {
        //查找终止条件
        if (start == end) {
            return arr[start] == start ? start : -1;
        }
        //二分查找
        int mid = (start + end) / 2;
        if (arr[mid] > mid) {
            return findNumEqualToIndexCore(arr, start, mid - 1);
        } else if (arr[mid] < mid) {
            return findNumEqualToIndexCore(arr, mid + 1, end);
        } else {
            return mid;
        }
    }
}