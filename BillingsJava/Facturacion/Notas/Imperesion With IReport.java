        String reportSrcFile = "C:\\Users\\jamartinez\\Documents\\UNAPEC\\2018Enero\\INF111\\Projectos\\Facturacion\\src\\Reporte\\RFactura.jrxml";
        Connection con = GetConexion();
        try {
            // First, compile jrxml file.
            JasperReport jasperReport;
            jasperReport = JasperCompileManager.compileReport(reportSrcFile);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("NFac", 6);
            JasperPrint print;
            print = JasperFillManager.fillReport(jasperReport,parameters,con);
            JasperPrintManager.printReport( print, true);
//            File outDir = new File("C:/Reporte");
//            outDir.mkdirs();
//            
//            JRPdfExporter exporter;
//            exporter = new JRPdfExporter();
//            ExporterInput exporterInput = new SimpleExporterInput(print);
//            
//            // ExporterInput
//          exporter.setExporterInput(exporterInput);
//          
//              // ExporterOutput
//        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("C:/Reporte/FirstJasperReport.pdf");
//          
//            // Output
//        exporter.setExporterOutput(exporterOutput);
//        
//        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//        exporter.setConfiguration(configuration);
//        exporter.exportReport();
        System.out.print("Done!");
        } catch (JRException ex) {
            Logger.getLogger(FExportacion.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		
		/*
		
		Exportacion A java formato txt
		
		*/