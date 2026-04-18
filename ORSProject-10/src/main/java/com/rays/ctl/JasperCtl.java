package com.rays.ctl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.*;

/**
 * JasperCtl is a REST controller responsible for generating PDF reports
 * using JasperReports.
 * 
 * It loads a JRXML template, compiles it, fills it with data from the database,
 * and streams the generated PDF in the HTTP response.
 * 
 * This controller demonstrates integration of:
 * - JasperReports
 * - Hibernate (SessionFactory)
 * - Direct JDBC Connection
 * 
 * @author Lucky Tomar
 *
 */
@Transactional
@RestController
@RequestMapping("/jasper")
public class JasperCtl {

	@PersistenceContext
	private EntityManager entityManager;

	private SessionFactory sessionFactory;

	/**
	 * Generates a PDF report using JasperReports and sends it in HTTP response.
	 * 
	 * Steps:
	 * 1. Load JRXML template from resources
	 * 2. Compile JRXML into JasperReport
	 * 3. Set report parameters
	 * 4. Obtain DB connection using Hibernate
	 * 5. Fill report with data
	 * 6. Export report to PDF
	 * 7. Write PDF to HTTP response
	 * 
	 * @param response HttpServletResponse to send PDF output
	 * @throws JRException
	 * @throws IOException
	 * @throws SQLException
	 */
	@GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
	public void generateReport(HttpServletResponse response) throws JRException, IOException, SQLException {

		System.out.println("******** Jasper Report Start ********");

		Connection con = null;

		try {
			// ✅ 1. Load JRXML from resources
			InputStream input = getClass().getResourceAsStream("/report/Lucky_A4.jrxml");

			if (input == null) {
				throw new RuntimeException("JRXML file not found in resources/reports");
			}

			// ✅ 2. Compile
			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// ✅ 3. Parameters
			Map<String, Object> params = new HashMap<>();
			params.put("createdBy", "Admin");

			// ✅ 4. DB connection
			sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);

			con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class)
					.getConnection();

			// ✅ 5. Fill report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

			// ✅ 6. Export PDF
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			// ✅ 7. Response
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=marksheet.pdf");

			response.getOutputStream().write(pdf);
			response.getOutputStream().flush();

			System.out.println("******** Report Generated ********");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}