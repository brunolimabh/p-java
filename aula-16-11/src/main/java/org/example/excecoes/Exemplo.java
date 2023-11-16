package org.example.excecoes;

import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Exemplo {
    public static void main(String[] args) {

        // Existem dois teipos de anormalidades no java -> Throwable
        // Exception, Error

        // TOP 3 Exception:
        // NullPointerException
        // IndexOutBoundsException
        // FileNoteFoundException

        // TOP 3 Errors
        // StackOverflowError
        // OutOfMemoryError
        // VirtualMachineError

        Scanner leitor = new Scanner(System.in);

        try {
            System.out.println("Digite um número de 0 - 10;");
            Integer numero1 = leitor.nextInt();
            if (numero1 < 0 || numero1 > 10){
                throw new NumeroForaDoIntervaloException("São aceitos apenas números entre 0 e 10");
            }


            System.out.println("Digite outro número;");
            Integer numero2 = leitor.nextInt();

            Integer divisao = numero1/numero2;
            System.out.println("O resultado da divisão é: ".formatted(divisao));
        } catch (InputMismatchException | NumeroForaDoIntervaloException e){
            System.out.println("Número inválido!");
            if (Objects.nonNull(e)) {
                System.out.println(e.getMessage());
            }
        } catch (ArithmeticException e){
            System.out.println("Não é possivel dividir um número por 0");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado!");
        }

        // As exception podem ser subdividias em dois tipos
        // Checked exceptions e Unchecked expections

        Calculadora calc = new Calculadora();

        try {
            calc.dividir(10,9);
        } catch (DivisaoPorZeroException e) {
            System.out.println("Xpto");
        }
    }
}
