package br.com.jasper.example.interfaces;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

public interface Jasper {
	/**
		 * Primeiro m�todo a ser chamado ao instanciar algum objeto que implemente Relatorio
		 * @param HttpServletRequest request
		 */
		void setUp(HttpServletRequest request);
		
		/**
		 * Busca os dados necess�rios para preencher o relat�rio principal no Jasper
		 * DataSources de eventuais subrelat�rios devem ser enviados via par�metro
		 * @return JRDataSource classe de DataSource
		 */
		JRDataSource getDataSource();
		
		/**
		 * Fornece par�metros adicionais para preencher o relat�rio no Jasper
		 * Retornar null caso n�o exista par�metro
		 * @return Map<String, Object> mapa
		 */
		Map<String, Object> getParametros() throws JRException;
		
		/**
		 * @return InputStream do .jrxml para compila��o
		 */
		InputStream getJRXML();
		
		/**
		 * @return String nome final do arquivo que ser� exibido para o usu�rio
		 */
		String getNomeArquivo();
}

