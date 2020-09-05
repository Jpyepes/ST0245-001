package com.company;

public class Codingbat_arrays {
    //Ejercicios de Array-2

    public int countEvens(int[] nums) {
        int cont = 0;
        for(int i= 0; i<nums.length; i++){
            if(nums[i]%2 == 0){
                cont++;
            }
        }
        return cont;
    }

    public int bigDiff(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int i=0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return max-min;
    }

    public int centeredAverage(int[] nums) {
        int min = nums[0], max = nums[0];
        int suma = 0;
        for(int i=0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            suma = suma + nums[i];
        }
        suma = (suma-max)-min;
        //suma = suma-min;
        return suma/(nums.length-2);
    }

    public int sum13(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int suma = 0;
        for(int i=0; i<nums.length; i++){
            if (nums[i] == 13){
                i++;
            }else
                suma = suma + nums[i];
        }
        return suma;
    }

    public int sum67(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int suma = 0;
        int cont = 0;
        for(int i=0; i<nums.length; i++){
            if (nums[i] == 6){
                int j = i;
                while(j<nums.length && nums[j] != 7){
                    cont++;
                    j++;
                }
                i = j;
            }else
                suma = suma + nums[i];
        }
        return suma;
    }

    //Ejercicios de Array-3

    public int maxSpan(int[] nums) {
        int count = 0;

        if(nums.length<=1 || nums[0]==nums[nums.length-1]){
            return nums.length;
        }
        else{
            for(int i = 1; i < nums.length; i++) {
                count++;
            }
        }
        return count;
    }

    public int[] fix34(int[] nums) {
        for(int i=0; i<nums.length;i++){
            for (int j=0; j<nums.length;j++){
                if(nums[j]== 3 && nums[i] == 4){
                    int temp = nums[j+1];
                    nums[j+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public boolean canBalance(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        boolean result = false;
        for(int i = 0; i<nums.length; i++){
            sum1 = sum1+nums[i];
        }
        int j=0;
        while(j<nums.length && !result){
            sum1 = sum1 - nums[j];
            sum2 = sum2 + nums[j];
            if(sum1 == sum2){
                result = true;
            }
            j++;
        }
        return result;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        boolean result = false;
        int cont = 0;

        if(inner.length == 0){
            return true;
        }
        for(int i=0; i<outer.length; i++){
            if(inner[cont] == outer[i]){
                cont++;
                if(cont == inner.length){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public int countClumps(int[] nums) {
        int cont = 0;
        for(int i=0; i<nums.length-1; i++){
            if (nums[i] == nums[i+1]){
                cont++;

                for(int j = i;j<nums.length-1 && nums[j] == nums[j+1];j++){
                    i++;
                }
            }
        }
        return cont;
    }

}
