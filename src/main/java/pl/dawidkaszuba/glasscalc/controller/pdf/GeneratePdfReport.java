package pl.dawidkaszuba.glasscalc.controller.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class GeneratePdfReport {

    public static ByteArrayInputStream glass(Glass2Tiles glass2Tiles) {



        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);


        Chunk name = new Chunk(glass2Tiles.getName()+ " ", font);
        Chunk price = new Chunk(String.valueOf(glass2Tiles.getPrice())+ " ", font);
        Chunk dimension = new Chunk(String.valueOf(glass2Tiles.getWidth())
                + "x" + String.valueOf(glass2Tiles.getHeight())+"[mm]", font);
        Chunk deliveryTime = new Chunk("czas oczekiwania [dni]: " + String.valueOf(glass2Tiles.getDeliveryTime()));

        try {
            PdfWriter.getInstance(document, out);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.open();
        try {
            document.add(name);
            document.add(price);
            document.add(dimension);
            document.add(deliveryTime);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();


        return new ByteArrayInputStream(out.toByteArray());
    }

}
