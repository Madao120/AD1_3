package org.example;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Parte1 {
    public static class Producto implements Serializable {

        public String nome;
        public int num1;
        public double num2;

        public Producto() {
        }

        public Producto(String nome, int num1, double num2) {
            this.nome = nome;
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    static void main() {
        try {
            // .2 Crear un obxecto Producto con valores
            // Y pasarlo al fichero serial
            Producto p1 = new Producto("Ordenador", 10, 899.99);

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("serial.txt"));

            oos.writeObject(p1);
            oos.close();

            System.out.println("Obxecto 1 que guardamos en serial.");
            System.out.println("======================");
            System.out.println("Nombre " + p1.nome);
            System.out.println("Numero1 " + p1.num1);
            System.out.println("Numero2 " + p1.num2);

            // .3 Crear un obxecto baleiro e cargar os datos desde serial cno el objeto que habíamos guardado
            Producto p2 = new Producto();

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("serial.txt"));

            p2 = (Producto) ois.readObject();
            ois.close();

            System.out.println("\n\nObxecto recuperado en Objeto2 a partir del serial.");
            System.out.println("===========================");

            System.out.println("Nombre " + p2.nome);
            System.out.println("Numero1 " + p2.num1);
            System.out.println("Numero2 " + p2.num2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
