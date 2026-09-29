package org.example;

import java.io.*;

public class Parte2{
    public static class ProductoTransient implements Serializable {
        private String nome;
        private transient int num1;
        private double num2;

        public ProductoTransient() {
        }

        public ProductoTransient(String nome, int num1, double num2) {
            this.nome = nome;
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public static void main(String[] args) {

        System.out.println("Parte 2 Ejercicio 2");
        System.out.println("===============================");
        try {
            ProductoTransient p1 =
                    new ProductoTransient("Ordenador", 25, 899.99);

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("serial"));

            oos.writeObject(p1);
            oos.close();

            System.out.println("\nObxecto parte 2 guardado correctamente ");
            System.out.println("===========================");

            System.out.println("Nombre " + p1.nome);
            System.out.println("Numero1 " + p1.num1);
            System.out.println("Numero2 " + p1.num2);


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\nParte 2 Ejercicio 3");
        System.out.println("===============================");
        try {
            ProductoTransient p2 = new ProductoTransient();

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("serial"));

            p2 = (ProductoTransient) ois.readObject();

            ois.close();

            System.out.println("\nObxecto parte 2 con num1 transient ");
            System.out.println("===========================");

            System.out.println("Nombre " + p2.nome);
            System.out.println("Numero1 " + p2.num1);
            System.out.println("Numero2 " + p2.num2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

