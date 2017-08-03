package br.com.jasper.example.controle;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jasper.example.modelo.Usuario;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@WebServlet("/GerarExcel")
public class GerarExcel extends HttpServlet {
	
	private static final long serialVersionUID = 4569921372379742054L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String classeRelatorio = request.getParameter("relatorio");

			/*Class<?> classe = Class.forName(Parametros.PACKAGE_RELATORIO + classeRelatorio);
			Relatorio relatorio = (Relatorio) classe.newInstance();
			relatorio.setUp(request);
			 */
			
			Usuario usuario = new Usuario();
			usuario.setUp(request);
			
			JasperDesign design = JRXmlLoader.load(usuario.getJRXML());
			JasperReport report = JasperCompileManager.compileReport(design);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, usuario.getParametros(), usuario.getDataSource());
			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition", "attachment;filename=" + usuario.getNomeArquivo() + ".xls");

			jasperPrint.setProperty("net.sf.jasperreports.export.xls.ignore.graphics", "true");
			//CONFIGS PARA MOSTRAR O CABECALHO
			jasperPrint.setProperty("net.sf.jasperreports.export.xls.exclude.origin.band.1", "");
			jasperPrint.setProperty("net.sf.jasperreports.export.xls.exclude.origin.band.2", "");
			jasperPrint.setProperty("net.sf.jasperreports.export.xls.exclude.origin.band.3", "");
			jasperPrint.setProperty("net.sf.jasperreports.export.xls.exclude.origin.band.4", "");

			OutputStream output = response.getOutputStream();

			SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
			configuration.setDetectCellType(true);
			configuration.setRemoveEmptySpaceBetweenRows(true);
			configuration.setWhitePageBackground(false);
			configuration.setMaxRowsPerSheet(65000);
			
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(output));
			exporter.setConfiguration(configuration);
			
			exporter.exportReport();
			
			output.flush();
			output.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		} 
	}
}
