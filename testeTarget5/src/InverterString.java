public class InverterString {
    public static void main(String[] args) {
        String string = "Douglas";
        String strInvertida = "";
        
        for (int i = string.length() - 1; i >= 0; i--) {
            strInvertida += string.charAt(i);
        }
        
        System.out.println(strInvertida);
    }
}
