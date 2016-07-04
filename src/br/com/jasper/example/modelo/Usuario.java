package br.com.jasper.example.modelo;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import br.com.jasper.example.interfaces.Jasper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

public class Usuario implements Jasper {
	private ServletContext context;
	private String nome;
		
	@Override
	public void setUp(HttpServletRequest request) {
		this.context =  request.getSession().getServletContext();
		this.nome = request.getParameter("nome");
	}

	@Override
	public JRDataSource getDataSource() {
		return new JREmptyDataSource();
	}

	@Override
	public Map<String, Object> getParametros() throws JRException {
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		// DATA
		LocalDate data = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu");
		
		parametros.put("nome", this.nome);
		parametros.put("data", formatter.format(data).toString());
		
		return parametros;
	}

	@Override
	public InputStream getJRXML() {
		return context.getResourceAsStream("/reports/Usuario.jrxml");
	}

	@Override
	public String getNomeArquivo() {
		return "valores-mensais";
	}
	
/*	private RelatorioParam getParams() {
		RelatorioParam relatorioParam = new RelatorioParam();
		
		relatorioParam.setAbertura(getParametro("abertura"));
		relatorioParam.setPeriodo(getParametro("periodo"));
		relatorioParam.setValores(getParametro("valores"));
		relatorioParam.setIdProjeto(getParametro("codProjeto"));
		relatorioParam.setNomeProjeto(getParametro("projeto"));
		relatorioParam.setTipoProjeto(getParametro("tipo"));
		relatorioParam.setIdUnidade(getParametro("codUnidade"));
		relatorioParam.setAnoBase(getParametro("anoBase"));
		
		return relatorioParam;
	}*/
	
/*	private String getParametro(String parameter) {
		String value = request.getParameter(parameter);

		try {
			value = new String(value.getBytes(), "UTF-8");
		} catch (java.io.UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}

		return value;
	}*/
}
