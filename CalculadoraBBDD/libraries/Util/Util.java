/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Scanner;

/**
 *
 * @author michael
 */
public class Util {

    public static double pedirDouble(String texto) {
        Scanner teclado = new Scanner(System.in);
        boolean correcto = false;
        double n1 = 0;
        do {
            System.out.print(texto);
            if (teclado.hasNextDouble()) {
                n1 = teclado.nextDouble();
                correcto = true;
            } else {
                System.out.println("Error, introduzca un número decimal!");
            }
            teclado.nextLine();
        } while (!correcto);
        return n1;
    }

    public static int pedirInt(String texto) {
        Scanner teclado = new Scanner(System.in);
        boolean correcto = false;
        int num = 0;
        do {
            System.out.print(texto);
            if (teclado.hasNextInt()) {
                num = teclado.nextInt();
                correcto = true;
            } else {
                System.out.println("Error, introduzca un número entero!");
            }
            teclado.nextLine();
        } while (!correcto);

        return num;
    }
}
