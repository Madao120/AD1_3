package org.example;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;

public class Parte3 {

    public static void main(String[] args) {

        System.out.println("Parte 3");
        System.out.println("===============================");

        try {
            // 1. Crear el objeto XMLOutputFactory
            XMLOutputFactory factory = XMLOutputFactory.newInstance();

            // 2. Crear el XMLStreamWriter para poder escribir en el objeto
            XMLStreamWriter writer =
                    factory.createXMLStreamWriter(
                            new FileWriter("autores.xml"));

            // Declaración XML
            writer.writeStartDocument("1.0");

            // <autores>
            writer.writeStartElement("autores");

            // <autor codigo="a1">
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1");

            // <nome>Alexandre Dumas</nome>
            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement();

            // <titulo>El conde de montecristo</titulo>
            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement();

            // <titulo>Los miserables</titulo>
            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement();

            // </autor>
            writer.writeEndElement();


            // <autor codigo="a2">
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");

            // <nome>Fiodor Dostoyevski</nome>
            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement();

            // <titulo>El idiota</titulo>
            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement();

            // <titulo>Noches blancas</titulo>
            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();

            // </autor>
            writer.writeEndElement();

            // </autores>
            writer.writeEndElement();

            // Finalizar documento
            writer.writeEndDocument();

            // Cerrar el writer
            writer.close();

            System.out.println("Archivo autores.xml creado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
