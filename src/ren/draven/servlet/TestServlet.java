package ren.draven.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * <servlet>
		<servlet-name>TestServlet</servlet-name>
		<servlet-class>ren.draven.servlet.TestServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>TestServlet</servlet-name>
		<url-pattern>/test</url-pattern>
	</servlet-mapping>
	
	name === <servlet-name>
	urlPatterns === <url-pattern>
	urlPatterns 和 value 等同，只能二选一
	
	loadOnStartup === <load-on-startup></load-on-startup>
	
	@WebInitParam(name="",value="") === 
		<init-param>
			<param-name>nickname</param-name>
			<param-value>小凯</param-value>
		</init-param>
 */

@WebServlet(name = "TestServlet", urlPatterns = { "/test", "/testServlet" }, loadOnStartup = 1,initParams= {@WebInitParam(name="nickname",value="小凯")})
public class TestServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ServletConfig config = this.getServletConfig();
		String name = config.getInitParameter("nickname");
		System.out.println("-------init-----: " + name);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("------doGet--------");
	}

}
