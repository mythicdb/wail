/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-12 14:04:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.archive.wayback.core.WaybackRequest;
import org.archive.wayback.core.UIResults;
import org.archive.wayback.util.StringFormatter;

public final class UI_002dheader_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n");
      out.write("   \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

UIResults results = UIResults.getGeneric(request);
WaybackRequest wbRequest = results.getWbRequest();
StringFormatter fmt = wbRequest.getFormatter();

String staticPrefix = results.getStaticPrefix();
String queryPrefix = results.getQueryPrefix();
String replayPrefix = results.getReplayPrefix();


      out.write("\n");
      out.write("<!-- HEADER -->\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t      \n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" \n");
      out.write("\t\t\thref=\"");
      out.print( staticPrefix );
      out.write("css/styles.css\"\n");
      out.write("\t\t\tsrc=\"");
      out.print( staticPrefix );
      out.write("css/styles.css\" />\n");
      out.write("\t\t<title>");
      out.print( fmt.format("UIGlobal.pageTitle") );
      out.write("</title>\n");
      out.write("\t\t<base target=\"_top\" />\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body bgcolor=\"white\" alink=\"red\" vlink=\"#0000aa\" link=\"blue\" \n");
      out.write("\t\tstyle=\"font-family: Arial; font-size: 10pt\">\n");
      out.write("\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\n");
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- WAYBACK LOGO -->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<td width=\"26%\"><a href=\"");
      out.print( staticPrefix );
      out.write("\"><img src=\"");
      out.print( staticPrefix );
      out.write("images/wayback_logo_tr.gif\" width=\"153\" height=\"54\" border=\"0\"></a></td>\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- /WAYBACK LOGO -->\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<!-- COLLECTION-EMPTYLOGO -->\n");
      out.write("\n");
      out.write("\t\t\t\t<td width=\"70%\" align=\"right\"></td>\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- /COLLECTION-EMPTY LOGO -->\n");
      out.write("\n");
      out.write("\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t<!-- GREEN BANNER -->\n");
      out.write("\t\t\t<tr> \n");
      out.write("\t\t\t\t<td colspan=\"2\" height=\"30\" align=\"center\" class=\"mainSecHeadW\"> \n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<tr class=\"mainBColor\">\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t\t\t\t\t\t<table border=\"0\" width=\"80%\" align=\"center\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- URL FORM -->\n");
      out.write("\t\t\t\t\t\t\t\t\t<form action=\"");
      out.print( queryPrefix );
      out.write("query\" method=\"get\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td nowrap align=\"center\"><img src=\"");
      out.print( staticPrefix );
      out.write("images/shim.gif\" width=\"1\" height=\"20\"> \n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<b class=\"mainBodyW\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<font size=\"2\" color=\"#FFFFFF\" face=\"Arial, Helvetica, sans-serif\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print( fmt.format("UIGlobal.enterWebAddress") );
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</font> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.print( WaybackRequest.REQUEST_TYPE );
      out.write("\" value=\"");
      out.print( WaybackRequest.REQUEST_CAPTURE_QUERY );
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"");
      out.print( WaybackRequest.REQUEST_URL );
      out.write("\" value=\"http://\" size=\"24\" maxlength=\"256\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</b> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"");
      out.print( WaybackRequest.REQUEST_DATE );
      out.write("\" size=\"1\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\" selected>");
      out.print( fmt.format("UIGlobal.selectYearAll") );
      out.write("</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2010</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2009</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2008</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2007</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2006</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2005</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2004</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2003</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2002</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2001</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>2000</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>1999</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>1998</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>1997</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option>1996</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" name=\"Submit\" value=\"");
      out.print( fmt.format("UIGlobal.urlSearchButton") );
      out.write("\" align=\"absMiddle\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print( staticPrefix );
      out.write("advanced_search.jsp\" style=\"color:white;font-size:11px\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print( fmt.format("UIGlobal.advancedSearchLink") );
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- /URL FORM -->\n");
      out.write("\t\t\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<!-- /GREEN BANNER -->\n");
      out.write("\t\t</table>\n");
      out.write("<!-- /HEADER -->\n");
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
