/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-19 23:29:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.archive.wayback.core.WaybackRequest;

public final class CookieJS_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<script type=\"text/javascript\">\n");
      out.write("function SetCookie(cookieName,cookieValue,nDays) {\n");
      out.write("  var today = new Date();\n");
      out.write("  var expire = new Date();\n");
      out.write("  if (nDays==null || nDays==0) nDays=1;\n");
      out.write("  expire.setTime(today.getTime() + 86400000*nDays);\n");
      out.write("  document.cookie = cookieName+\"=\"+escape(cookieValue)\n");
      out.write("    + \";expires=\"+expire.toGMTString() + \";path=/\";\n");
      out.write("}\n");
      out.write("function SetAnchorDate(date) {\n");
      out.write("  SetCookie(\"");
      out.print( WaybackRequest.REQUEST_ANCHOR_DATE );
      out.write("\",date,365);\n");
      out.write("}\n");
      out.write("function SetAnchorWindow(maxSeconds) {\n");
      out.write("  SetCookie(\"");
      out.print( WaybackRequest.REQUEST_ANCHOR_WINDOW );
      out.write("\",maxSeconds,365);\n");
      out.write("}\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
