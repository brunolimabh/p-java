package school.sptech;

/*
    Class - objeto
    Interface - especie de contrato
    Enum - enumeradores, lista
 */
public class Tipos {
    public static void main(String[] args) {
        String nome =  "Bruno";
        /*
            Em Java os tipos não são dinamicos
            nome = 30;
        */

        /*
        Numéricos
            Inter = 10
            Double = 0.1
            * BigDecimal
            * Float (recomendado não usar) =
        Gerais
            String = "Bruno"
            Boolean = true, false
         */

        Integer numeroINteiro = 10;
        Integer numeroINteiro2;
        // Declarando todas as variaveis na mesma linha, nao recomendado
        Integer num1, num2, num3;

        Double numeroReal = 0.1;

        // is ou has - eh comum ver na frente das variaveis boolean
        Boolean isPago = true;

        /*
            Classes Wrapper X Tipos Primitivos
                Integer x int
                Double x double
                Boolean x boolean
         */

        // sout
        System.out.println(nome);

    }
}