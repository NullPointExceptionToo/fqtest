package daily;

import java.util.Arrays;

/**
 * 排序练习
 */
public class SortStudy {
    public static void main(String[] args) {
        int[] array = {1,3,0,2,1,1,9};
        new SortStudy().gbSort(array);
//        new SortStudy().quickSort(array, 0, array.length-1);
//        new SortStudy().mpSort(array);
//        new SortStudy().binarySearch(array, 2);
        Arrays.stream(array).forEach(System.out::print);
    }
    /**
     * 冒泡
     */
    public void mpSort(int[] array) {
        int temp = 0;
        for(int i=0;i<array.length;i++) {
            for(int j=1;j<array.length-i;j++) {
                if(array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    /**
     * 快排
     */
    public void quickSort(int[] array, int left, int right){
        if(left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = array[l];
        while (l < r) {
            while(l < r && array[r] > temp) r--;
            if(l < r) {
                array[l] = array[r];
            }
            while(l < r && array[l] <= temp) l++;
            if(l < r) {
                array[r] = array[l];
            }
        }
        array[l] = temp;
        quickSort(array, left, l-1);
        quickSort(array, l+1, right);

    }
    /**
     * 归并
     */
    public void gbSort(int[] nums) {
        resove(nums, 0, nums.length-1);
    }
    public void resove(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (right-left)/2+left;
        resove(nums, left, mid);
        resove(nums, mid+1, right);
        merge(nums, left, right);
    }
    public void merge(int[] nums, int left, int right) {
        int mid = (right - left)/2+left;
        int[] array = new int[right-left+1];
        int ll = left, rl = mid+1;
        int index = 0;
        while(ll <= mid && rl <= right) {
            if(nums[ll] < nums[rl]){
                array[index++] = nums[ll];
                ll++;
            }else{
                array[index++] = nums[rl];
                rl++;
            }
        }
        while(ll <= mid) {
            array[index++] = nums[ll++];
        }
        while(rl <= right) {
            array[index++] = nums[rl++];
        }
        for(int i=0;i<array.length;i++){
            nums[left+i] = array[i];
        }
    }




    /**
     * 二分
     */
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length;
        while(left < right) {
            int mid = (right - left)/2+left;
            if(array[mid] < target) {
                left = mid+1;
            }else if(array[mid] > target) {
                right = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
