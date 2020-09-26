import java.util.LinkedList;

class tecladoRoto {


    public void teclado (String s){
        LinkedList<Character> texto =new LinkedList<>();
        int index=0;
        for (char letra : s.toCharArray()) {
            if (letra=='[') 
                index=0;
            else if (letra==']') 
                index=texto.size();
            else 
                texto.add(index++,letra);
        }

        StringBuilder sb=new StringBuilder();
        for (char letra : texto) 
            sb.append(letra);
        System.out.println(sb.toString());

    }
}
