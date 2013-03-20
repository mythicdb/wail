/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-19 23:29:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.replay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.lang.StringBuffer;
import org.archive.wayback.archivalurl.ArchivalUrlDateRedirectReplayRenderer;
import org.archive.wayback.ResultURIConverter;
import org.archive.wayback.core.UIResults;
import org.archive.wayback.core.WaybackRequest;
import org.archive.wayback.core.CaptureSearchResult;
import org.archive.wayback.util.StringFormatter;

public final class UrlRedirectNotice_jsp extends org.apache.jasper.runtime.HttpJspBase
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


UIResults results = UIResults.extractReplay(request);

WaybackRequest wbr = results.getWbRequest();
StringFormatter fmt = wbr.getFormatter();
CaptureSearchResult cResult = results.getResult();
ResultURIConverter uric = results.getURIConverter();

String sourceUrl = cResult.getOriginalUrl();
String targetUrl = cResult.getRedirectUrl();
String captureTS = cResult.getCaptureTimestamp();
Date captureDate = cResult.getCaptureDate();

String dateSpec = 
	ArchivalUrlDateRedirectReplayRenderer.makeFlagDateSpec(captureTS, wbr);

String targetReplayUrl = uric.makeReplayURI(dateSpec,targetUrl);

String safeSource = fmt.escapeHtml(sourceUrl);
String safeTarget = fmt.escapeHtml(targetUrl);
String safeTargetJS = fmt.escapeJavaScript(targetUrl);
String safeTargetReplayUrl = fmt.escapeHtml(targetReplayUrl);
String safeTargetReplayUrlJS = fmt.escapeJavaScript(targetReplayUrl);

String prettyDate = fmt.format("MetaReplay.captureDateDisplay",captureDate);
int secs = 5;


      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/template/UI-header.jsp", out, true);
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"positionHome\">\n");
      out.write("            <section>\n");
      out.write("            <div id=\"logoHome\">\n");
      out.write("                <a href=\"/index.jsp\"><h1><span>Internet Archive's Wayback Machine</span></h1></a>\n");
      out.write("            </div>\n");
      out.write("            </section>\n");
      out.write("            <section>\n");
      out.write("            <div id=\"error\">\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\tfunction go() {\n");
      out.write("\t\tdocument.location.href = \"");
      out.print( safeTargetReplayUrlJS );
      out.write("\";\n");
      out.write("\t}\n");
      out.write("\twindow.setTimeout(\"go()\",");
      out.print( secs * 1000 );
      out.write(");\n");
      out.write("\t</script>\n");
      out.write("\t\t<p class=\"code\">Loading...</p>\n");
      out.write("\t\t<p class=\"code shift target\">");
      out.print( safeSource );
      out.write(' ');
      out.write('|');
      out.write(' ');
      out.print( prettyDate );
      out.write("</p>\n");
      out.write("\t\t<p class=\"code shift red\">Got an HTTP 302 response at crawl time</p>\n");
      out.write("\t\t<p class=\"code\">Redirecting to...</p>\n");
      out.write("\t\t<p class=\"code shift target\">");
      out.print( safeTarget );
      out.write("</p>\n");
      out.write("        <p class=\"impatient\"><a href=\"");
      out.print( safeTargetReplayUrl );
      out.write("\">Impatient?</a></p>\n");
      out.write("            </div>\n");
      out.write("            </section>\n");
      out.write("            <div id=\"errorBorder\"></div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/template/UI-footer.jsp", out, true);
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
