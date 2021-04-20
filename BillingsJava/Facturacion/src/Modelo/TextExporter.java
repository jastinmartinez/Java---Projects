/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Formularios.FConsulta;
import static Modelo.Conexion.GetConexion;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleTextExporterConfiguration;
import net.sf.jasperreports.export.WriterExporterOutput;




/**
 *
 * @author Jamartinez
 */
public class TextExporter
{ 
public static void generateReport() throws JRException {
    JRCsvDataSource dataSource = new JRCsvDataSource(JRLoader.getLocationInputStream(""));
    dataSource.setRecordDelimiter("\r\n");
    dataSource.setUseFirstRowAsHeader(true);
    dataSource.setColumnNames(new String[]{ "USER_NAME", "LAST_ACCESSED", "IS_ACTIVE", "POINTS"});

    JasperReport jasperReport = JasperCompileManager.compileReport("");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

    JRTextExporter exporter = new JRTextExporter();
    

//    exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
//    exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
//    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//    exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outputFileName);
    exporter.exportReport();
}

    
}
