package br.com.jasper.example.interfaces;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

public interface Jasper {
	/**
		 * Primeiro método a ser chamado ao instanciar algum objeto que implemente Relatorio
		 * @param HttpServletRequest request
		 */
		void setUp(HttpServletRequest request);
		
		/**
		 * Busca os dados necessários para preencher o relatório principal no Jasper
		 * DataSources de eventuais subrelatórios devem ser enviados via parâmetro
		 * @return JRDataSource classe de DataSource
		 */
		JRDataSource getDataSource();
		
		/**
		 * Fornece parâmetros adicionais para preencher o relatório no Jasper
		 * Retornar null caso não exista parâmetro
		 * @return Map<String, Object> mapa
		 */
		Map<String, Object> getParametros() throws JRException;
		
		/**
		 * @return InputStream do .jrxml para compilação
		 */
		InputStream getJRXML();
		
		/**
		 * @return String nome final do arquivo que será exibido para o usuário
		 */
		String getNomeArquivo();
}

