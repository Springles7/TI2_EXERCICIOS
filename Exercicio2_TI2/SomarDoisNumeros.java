package Soma;

import java.util.*;


public class SomarDoisNumeros {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numero1, numero2, resultado;

        System.out.print("Digite o primeiro número: ");
        numero1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        numero2 = sc.nextInt();

        resultado = numero1 + numero2;

        System.out.println("A soma dos dois números é: " + resultado);
    }
}
