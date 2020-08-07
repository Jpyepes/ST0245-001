public class DarkSouls1
{
    public static boolean sumaGrupo(int[] nums, int target) {
        return sumaGrupo(0, nums, target);
    }    

    public static boolean sumaGrupo(int start, int[] nums, int target) {
        if (start >= nums.length) 
            return target == 0;

        else{
            return sumaGrupo(start+1, nums, target- nums[start]) ||  sumaGrupo(start+1, nums, target); 
        }
    }

    public static void main(String []args){
        System.out.println(sumaGrupo(new int[] {1,4,8}, 10));
        System.out.println(sumaGrupo(new int[] {2,4,8}, 6));    
    }
}

