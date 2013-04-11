package org.apache.jsp.WEB_002dINF.view.msg.pretst;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createAutoData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>전문 테스트로(TESTRO)</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" />\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// iframe resize\r\n");
      out.write("function autoResize(i)\r\n");
      out.write("{\r\n");
      out.write("    var iframeHeight=\r\n");
      out.write("    (i).contentWindow.document.body.scrollHeight;\r\n");
      out.write("    (i).height=iframeHeight+20;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var opener = window.dialogArguments;\r\n");
      out.write("\r\n");
      out.write("function getReturnSave(){\r\n");
      out.write("\tvar  reParam = document.frm.reParam.value;\r\n");
      out.write("\tif(reParam ==\"\"){\r\n");
      out.write("\t\talert(\"변환할 데이터를 입력해 주십시오.\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.returnValue = reParam;\t\r\n");
      out.write("\tself.close();\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"43\"><img src=\"images/pop_tit_01.gif\" width=\"43\" height=\"51\"></td>\r\n");
      out.write("    <td background=\"images/pop_tit_02.gif\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td class=\"pop_tit\">입력 도우미</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td width=\"180\"><img src=\"images/pop_tit_03.gif\" width=\"216\" height=\"51\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<form name=\"frm\" method=\"post\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"3\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\"><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td bgcolor=\"#e1e9f0\"><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td class=\"sub_tit02\">기존에 보유하고 계신 테스트 데이터(전문)를 복사하여 주시기 바랍니다.</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("              <table width=\"100%\" height=\"380\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                \t<td><textarea name=\"reParam\" id=\"reParam\" tabindex=\"3\" style=\"width:99%;height:330px; overflow: auto\"></textarea></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"5\" colspan=\"3\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                      <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onclick=\"getReturnSave();\">적 용</td>\r\n");
      out.write("                      <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </table></td>\r\n");
      out.write("                  <td ><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                          <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onclick=\"self.close();\">닫 기</td>\r\n");
      out.write("                          <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                      </table>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<!-- Start of wrap -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
