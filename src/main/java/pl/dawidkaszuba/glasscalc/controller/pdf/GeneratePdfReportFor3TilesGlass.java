package pl.dawidkaszuba.glasscalc.controller.pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import pl.dawidkaszuba.glasscalc.entity.Glass3Tiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GeneratePdfReportFor3TilesGlass {

    public static ByteArrayInputStream glass(Glass3Tiles glass3Tiles) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.open();

        String summary = "<h1>Summary</h1>" +
                "<div>"+
                    "<p style=\"font-weight: bold\">Specification:</p>" +
                    "<p>"+glass3Tiles.getName()+"</p>"+
                    "<p><span style=\"font-weight: bold\">Price: </span>" + glass3Tiles.getPrice()+"</p>"+
                    "<p><span style=\"font-weight: bold\">Dimension:</span> <p><span style=\"font-weight: bold\">width: </span> "
                    + glass3Tiles.getWidth()+" mm</p>"+"<p><span style=\"font-weight: bold\">height: </span>"
                    + glass3Tiles.getWidth()+" mm</p></p>"+
                    "<p><span style=\"font-weight: bold\">Thickness: </span>" + glass3Tiles.getThickness()+" mm</p>"+
                    "<p><span style=\"font-weight: bold\">Weight: </span>"+glass3Tiles.getWeight()+"kg</p>"+
                    "<p><span style=\"font-weight: bold\">Delivery time: </span>" + glass3Tiles.getDeliveryTime()+"</p>"+
                "</div>";

        String extThickness = String.valueOf(glass3Tiles.getExternalTile().getThickness()*4);
        String intThickness = String.valueOf(glass3Tiles.getInternalTile().getThickness()*4);
        String midThickness = String.valueOf(glass3Tiles.getMiddleTile().getThickness()*4);
        String firstFrameThickness = String.valueOf(glass3Tiles.getFirstFrame().getThickness()*4);
        String secondFrameThickness = String.valueOf(glass3Tiles.getSecondFrame().getThickness()*4);

        String firstCoating = "";
        String secondCoating = "";
        String thirdCoating = " ";

        if(glass3Tiles.getExternalTile().getCoating().getLowEmisly()){
            firstCoating = "<svg width=\"3\" height=\"300\" style=\"float:left\">" +
                    "<rect  width=\"3\" height=\"300\" style=\"fill:rgb(255,0,0)\"></rect>" +
                    "</svg>";
        }if(glass3Tiles.getInternalTile().getCoating().getLowEmisly()){
            secondCoating = "<svg width=\"3\" height=\"300\" style=\"float:left\">" +
                    "<rect  width=\"3\" height=\"300\" style=\"fill:rgb(255,0,0)\"></rect>" +
                    "</svg>";
        }
        if(glass3Tiles.getMiddleTile().getCoating().getLowEmisly()){
            secondCoating = "<svg width=\"3\" height=\"300\" style=\"float:left\">" +
                    "<rect  width=\"3\" height=\"300\" style=\"fill:rgb(255,0,0)\"></rect>" +
                    "</svg>";
        }



        String colorDependOfTempereExtTile;
        String colorDependOfTempereIntTile;
        String colorDependOfTempereMidTile;



        if(glass3Tiles.getExternalTile().getIsTempered()){
            colorDependOfTempereExtTile = "fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)";
        }else{
            colorDependOfTempereExtTile = "fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)";
        }
        if(glass3Tiles.getInternalTile().getIsTempered()){
            colorDependOfTempereIntTile = "fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)";
        }else{
            colorDependOfTempereIntTile = "fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)";
        }
        if(glass3Tiles.getMiddleTile().getIsTempered()){
            colorDependOfTempereMidTile = "fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)";
        }else{
            colorDependOfTempereMidTile = "fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)";
        }

        try {
            HtmlConverter.convertToPdf(summary +
                            "<div>" +
                                "<svg width="+extThickness+ " height=\"300\" style=\"float:left\">" +
                                    "<rect width="+extThickness+" height=\"300\" " +
                                        "style="+colorDependOfTempereExtTile+"></rect>" +
                                "</svg>"
                                +firstCoating+
                                "<svg width="+firstFrameThickness+" height=\"300\" style=\"float:left\">" +
                                    "<rect width="+firstFrameThickness+" height=\"300\" " +
                                        "style=\"fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)\"></rect>" +
                                    "<rect y=\"270\" width="+firstFrameThickness+" height=\"30\" " +
                                        "style=\"fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)\"></rect>" +
                                "</svg>"+
                                "<svg width="+midThickness+ " height=\"300\" style=\"float:left\">" +
                                    "<rect width="+midThickness+" height=\"300\" " +
                                        "style="+colorDependOfTempereMidTile+"></rect>" +
                                "</svg>"
                                +thirdCoating+
                                "<svg width="+secondFrameThickness+" height=\"300\" style=\"float:left\">" +
                                    "<rect width="+secondFrameThickness+" height=\"300\" " +
                                        "style=\"fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)\"></rect>" +
                                    "<rect y=\"270\" width="+secondFrameThickness+" height=\"30\" " +
                                        "style=\"fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)\"></rect>" +
                                "</svg>"
                                +secondCoating+
                                "<svg width="+intThickness+" height=\"300\" >" +
                                    "<rect width="+intThickness+" height=\"300\" " +
                                        "style="+colorDependOfTempereIntTile+"></rect>" +
                                "</svg>" +
                            "</div>" +
                            "<div>" +
                                "<p style=\"text-decoration: underline; font-size: 30px\">Notes:</p>"+
                            "</div>"
                    ,new com.itextpdf.kernel.pdf.PdfWriter(out));
        } catch (IOException e) {
            e.printStackTrace();
        }


        document.close();


        return new ByteArrayInputStream(out.toByteArray());
    }

}
