package com.company;

public class CodingBat {
    //Recursion 1.
    public int factorial(int n) {
        if (n == 1){
            return 1;
        }else{
            return n*(factorial(n-1));
        }
    }
    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0;
        }else{
            return bunnyEars(bunnies-1)+2;
        }
    }
    public int fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public int bunnyEars2(int bunnies) {
        if (bunnies == 0){
            return 0;
        }if(bunnies%2 == 0){
            return bunnyEars2(bunnies-1)+3;
        }else{
            return bunnyEars2(bunnies-1)+2;
        }
    }
    public int triangle(int rows) {
        if(rows == 0){
            return 0;
        }
        if(rows == 1){
            return 1;
        }else
            return rows+(triangle(rows-1));
    }
    //Recursion 2
    public boolean groupSum6(int start, int[] nums, int target) {

        if (start >= nums.length)
            return (target == 0);

        if (groupSum6(start + 1, nums, target - nums[start]))
            return true;

        if (nums[start] == 6)
            target = target - 6;

        if (groupSum6(start + 1, nums, target)) return true;
        return false;

    }
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length)
            return (target == 0);

        if (groupNoAdj(start + 1, nums, target - nums[start]))
            if (groupNoAdj(start + 2, nums, target - nums[start]))
                return true;

        if (groupNoAdj(start + 1, nums, target))

            return true;

        return false;
    }
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length)
            return (target == 0);


        if (nums[start]%5 == 0){
            if((start+1<nums.length) && nums[start+1] == 1){
                return groupSum5(start+2, nums, target-nums[start]);
            }
            else{
                return groupSum5(start + 1, nums, target-nums[start]);
            }
        }

        if(groupSum5(start + 1, nums, target-nums[start])){
            return true;
        }
        if(groupSum5(start + 1, nums, target)){
            return true;
        }
        return false;

    }
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (target == 0)
            return true;

        if (start >= nums.length)
            return (false);

        int endIndex = start;
        while (endIndex < nums.length && nums[endIndex] == nums[start]) {
            endIndex = endIndex + 1;
        }
        int l = endIndex - start;

        if (groupSumClump(endIndex, nums, target - (nums[start] * l))) {
            return true;
        }
        if (groupSumClump(endIndex, nums, target)) {
            return true;
        }
        return false;
    }
    public boolean splitArray(int[] nums) {
        return auxSplitArray(0,nums,0,0);
    }
    public boolean auxSplitArray(int index, int[] nums, int total1, int total2){
        if(index >= nums.length){
            return (total1 == total2);
        }
        if(auxSplitArray(index+1,nums,nums[index]+total1,total2)){
            return true;
        }
        if(auxSplitArray(index+1,nums,total1,nums[index]+total2)){
            return true;
        }
        else return false;
    }


}
