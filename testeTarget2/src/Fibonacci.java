public class Fibonacci {
    public static void main(String[] args) throws Exception {

        int entrada = 2;
        int n1 = 0;
        int n2 = 1;
        int control = 0;
        boolean pertence = false;

        while (n1 <= entrada) {
            control = n1;
            n1 = n2;
            n2 = control + n2;
            if (entrada == n1) {
                pertence = true;
            }
        }

        if (pertence) {
            System.out.println("Pertence a sequência de Fibonacci");
        } else {
            System.out.println("Não pertence a sequência de Fibonacci");
        }

    }
}
