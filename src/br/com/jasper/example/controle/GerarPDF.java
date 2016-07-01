package br.com.jasper.example.controle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jasper.example.modelo.Usuario;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@WebServlet("/GerarPDF")
public class GerarPDF extends HttpServlet {
	private static final long serialVersionUID = 2422530570127876544L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String classeRelatorio = request.getParameter("relatorio");
			
			/*Class<?> classe = Class.forName(Parametros.PACKAGE_RELATORIO + classeRelatorio);
			Relatorio relatorio = (Relatorio) classe.newInstance();
			relatorio.setUp(request);*/
			
			Usuario usuario = new Usuario();
			usuario.setUp(request);
			
			JasperDesign design = JRXmlLoader.load(usuario.getJRXML());
			JasperReport report = JasperCompileManager.compileReport(design);
			JasperPrint print = JasperFillManager.fillReport(report, usuario.getParametros(), usuario.getDataSource());
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(print, byteArray);
			
			response.setContentLength(byteArray.size());
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + usuario.getNomeArquivo() + ".pdf\"");
			
			ServletOutputStream outputStream = response.getOutputStream();
			byteArray.writeTo(outputStream);
			outputStream.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
