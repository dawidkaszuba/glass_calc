package pl.dawidkaszuba.glasscalc.controller.pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GeneratePdfReportFor2TilesGlass {

    public static ByteArrayInputStream glass(Glass2Tiles glass2Tiles) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.open();

        String summary = "<h1>Summary</h1>" +
                         "<div style=\"margin-right:40px; float:left\">"+
                            "<p style=\"font-weight: bold\">Specification:</p>" +
                            "<p>"+glass2Tiles.getName()+"</p>"+
                            "<p><span style=\"font-weight: bold\">Price: </span>" + glass2Tiles.getPrice()+"</p>"+
                            "<p><span style=\"font-weight: bold\">Dimension:</span> <p><span style=\"font-weight: bold\">width: </span> "
                            + glass2Tiles.getWidth()+" mm</p>"+"<p><span style=\"font-weight: bold\">height: </span>"
                            + glass2Tiles.getWidth()+" mm</p></p>"+
                            "<p><span style=\"font-weight: bold\">Thickness: </span>" + glass2Tiles.getThickness()+" mm</p>"+
                            "<p><span style=\"font-weight: bold\">Weight: </span>//todo kg</p>"+
                            "<p><span style=\"font-weight: bold\">Delivery time: </span>" + glass2Tiles.getDeliveryTime()+"</p>"+
                            "<p style=\"text-decoration: underline; font-size: 30px\">Notes:</p>"+
                         "</div>";

        String extThickness = String.valueOf(glass2Tiles.getExternalTile().getThickness()*4);
        String intThickness = String.valueOf(glass2Tiles.getInternalTile().getThickness()*4);
        String frameThickness = String.valueOf(glass2Tiles.getFrame().getThickness()*4);

        String firstCoating = "";
        String secondCoating = "";

        if(glass2Tiles.getExternalTile().getCoating().getLowEmisly()){
            firstCoating = "<svg width=\"3\" height=\"300\" style=\"float:left\">" +
                    "<rect  width=\"3\" height=\"300\" style=\"fill:rgb(255,0,0)\"></rect>" +
                    "</svg>";
        }if(glass2Tiles.getInternalTile().getCoating().getLowEmisly()){
            secondCoating = "<svg width=\"3\" height=\"300\" style=\"float:left\">" +
                    "<rect  width=\"3\" height=\"300\" style=\"fill:rgb(255,0,0)\"></rect>" +
                    "</svg>";
        }

        String colorDependOfTempereExtTile;
        String colorDependOfTempereIntTile;



        if(glass2Tiles.getExternalTile().getIsTempered()){
            colorDependOfTempereExtTile = "fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)";
        }else{
            colorDependOfTempereExtTile = "fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)";
        }
        if(glass2Tiles.getInternalTile().getIsTempered()){
            colorDependOfTempereIntTile = "fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)";
        }else{
            colorDependOfTempereIntTile = "fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)";
        }

        try {
            HtmlConverter.convertToPdf(summary + "<div><svg width="+extThickness+
                    " height=\"300\" style=\"float:left\">" +
                    "<rect width="+extThickness+" height=\"300\" style="+colorDependOfTempereExtTile+"></rect>" +
                    "</svg>" +firstCoating+
                    "<svg width="+frameThickness+" height=\"300\" style=\"float:left\">" +
                    "<rect width="+frameThickness+" height=\"300\" style=\"fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)\"></rect>" +
                    "<rect y=\"270\" width="+frameThickness+" height=\"30\" style=\"fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)\"></rect>" +
                    "</svg>" +secondCoating+
                    "<svg width="+intThickness+" height=\"300\" >" +
                    "<rect width="+intThickness+" height=\"300\" style="+colorDependOfTempereIntTile+"></rect>" +
                    "</svg></div>"
                    ,new com.itextpdf.kernel.pdf.PdfWriter(out));
        } catch (IOException e) {
            e.printStackTrace();
        }


        document.close();


        return new ByteArrayInputStream(out.toByteArray());
    }

}
