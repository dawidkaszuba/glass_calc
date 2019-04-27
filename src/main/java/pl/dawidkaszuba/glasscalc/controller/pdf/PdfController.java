package pl.dawidkaszuba.glasscalc.controller.pdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.controller.pdf.GeneratePdfReport;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;
import pl.dawidkaszuba.glasscalc.repository.Glass2TilesRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class PdfController {

    @Autowired
    private Glass2TilesRepository glass2TilesRepository;

    @RequestMapping(value = "/pdfreport/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> glassReport(@PathVariable Long id) throws IOException {


        ByteArrayInputStream bis = GeneratePdfReport.glass(this.glass2TilesRepository.findOne(id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename="+glass2TilesRepository.findOne(id).getName()+".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
