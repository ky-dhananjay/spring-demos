package com.example.demo.service;

import com.example.demo.model.domain.InvoiceModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class InvoiceService {
    Logger log = LoggerFactory.getLogger(InvoiceService.class);

    private final String invoice_template_path = "/jasper/invoice_template.jrxml";
    private static final String logo_path = "/jasper/images/Logo.jpg";
    // OrderModel is a POJO contains all the data about the Invoice
    // Locale is used to localize the PDF file (French, English...)
    public File generateInvoiceFor(InvoiceModel invoice) throws IOException {
        // Create a temporary PDF file
        File pdfFile = File.createTempFile("my-invoice", ".pdf");
        // Initiate a FileOutputStream
        try(FileOutputStream pos = new FileOutputStream(pdfFile))
        {
            // Load the invoice jrxml template.
            final JasperReport report = loadTemplate();
            // Create parameters map.
            final Map<String, Object> parameters = parameters(invoice);

            // Create an empty datasource.
            final JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(Collections.singletonList("Invoice"));

            // Render the PDF file
            JasperReportsUtils.renderAsPdf(report, parameters, dataSource, pos);

            return pdfFile;
        }
        catch (final Exception e)
        {
            log.error(String.format("An error occured during PDF creation: %s", e));
        }
        return null;
    }
    // Fill template order parametres
    private Map<String, Object> parameters(InvoiceModel invoice) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("logo", getClass().getResourceAsStream(logo_path));
        parameters.put("invoice",  invoice);

        return parameters;
    }
    // Load invoice jrxml template
    private JasperReport loadTemplate() throws JRException {

        log.info(String.format("Invoice template path : %s", invoice_template_path));

        final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template_path);
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        return JasperCompileManager.compileReport(jasperDesign);
    }
}
