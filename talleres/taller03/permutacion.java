public class permutacion
{
    public static void permutacion(int level, String permuted,boolean used[], String original) {
        int length = original.length();
        if (level == length) {
            System.out.println(permuted);
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(permuted));
        } else {
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permutacion(level + 1, permuted + original.charAt(i),
                        used, original);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        boolean used[] = {false,false,false,false};
        permutacion(0, "", used, s);
        
    }
}

