package school.sptech;

/*
    Classes -> PascalCase
    ex: MinhaClasse
 */
public class Operadores {
    public static void main(String[] args) {
        /*
            + - * / %
            potencia = Math.pow(num1, num2);
         */

        Integer num1 = 10;
        Integer num2 = 10;


        System.out.println("Soma: " + (num1 + num2));

        Double numReal1 = 1.5;
        Double numReal2 = 4.9;

        /*
            Operadores logicos
            == > < >= <= != || &&
         */

        Boolean isIgual = num1 == num2;

        String mensagem  = isIgual ? "é igual" : "n é igual";

        System.out.println(mensagem);

        if (isIgual) {
            System.out.println("É igual");
        } else {
            System.out.println("Não é igual");
        }

        Integer numOp = 2;

        // switch - "obsersva essa variavel"
        // case - "caso seja X"
        switch (numOp) {
            case 1:
                System.out.println("Usuário escolheu 1");
            break;
            case 2:
                System.out.println("Usuário escolheu 2");
            break;
            case 3:
                System.out.println("Usuário escolheu 3");
            break;
            default:
                System.out.println("Opção não encontrada");
        }

        String nome1 = "Bruno";
        String nome2 = "Bruno";
        // ele compara se a referencia da memoria eh a mesma
        // ent, nuca usar == para comparar texto e sim o .equals
        if (nome1.equals(nome2)) {
            System.out.println("é igual");
        }
    }
}
