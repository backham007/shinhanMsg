package org.apache.jsp.WEB_002dINF.view.msg.tcmng;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tcmngReg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>전문 테스트로(TESTRO)</title>\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var opener = window.dialogArguments;\r\n");
      out.write("\r\n");
      out.write("var tsCaseID\t\t= opener.document.frmname.tsCaseID.value;\r\n");
      out.write("var tsCaseName\t\t= opener.document.frmname.tsCaseName.value;\r\n");
      out.write("var tsCaseDesc\t\t= opener.document.frmname.tsCaseDesc.value;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\r\n");
      out.write("\tif(tsCaseID == \"\"){\r\n");
      out.write("\t\t$(\"#newNameReg\").attr(\"disabled\", \"disabled\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#tsCaseID\").html(tsCaseID);\r\n");
      out.write("\t$(\"#tsCaseName\").val(tsCaseName);\r\n");
      out.write("\t$(\"#tsCaseDesc\").val(tsCaseDesc);\r\n");
      out.write("\r\n");
      out.write("\t$(\"#newNameReg\").click(function(){\r\n");
      out.write("\t\tif($(\"#tsCaseName\").val() == \"\"){\r\n");
      out.write("\t\t\t$(\"#tsCaseName\").focus();\r\n");
      out.write("\t\t\talert(\"테스트케이스명은 필수 입력 항목입니다.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}else if($(\"#tsCaseDesc\").val() == \"\"){\r\n");
      out.write("\t\t\t$(\"#tsCaseDesc\").focus();\r\n");
      out.write("\t\t\talert(\"테스트케이스설명은 필수 입력 항목입니다.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar list = new Array();\r\n");
      out.write("\t\tlist[0] = \"\";\r\n");
      out.write("\t\tlist[1] = $(\"#tsCaseName\").val();\r\n");
      out.write("\t\tlist[2] = $(\"#tsCaseDesc\").val();\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\twindow.returnValue = list;\r\n");
      out.write("\t\tself.close();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(\"#nameReg\").click(function(){\r\n");
      out.write("\t\tif($(\"#tsCaseName\").val() == \"\"){\r\n");
      out.write("\t\t\t$(\"#tsCaseName\").focus();\r\n");
      out.write("\t\t\talert(\"테스트케이스명은 필수 입력 항목입니다.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}else if($(\"#tsCaseDesc\").val() == \"\"){\r\n");
      out.write("\t\t\t$(\"#tsCaseDesc\").focus();\r\n");
      out.write("\t\t\talert(\"테스트케이스설명은 필수 입력 항목입니다.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar list = new Array();\r\n");
      out.write("\t\tlist[0] = tsCaseID;\r\n");
      out.write("\t\tlist[1] = $(\"#tsCaseName\").val();\r\n");
      out.write("\t\tlist[2] = $(\"#tsCaseDesc\").val();\r\n");
      out.write("\r\n");
      out.write("\t\twindow.returnValue = list;\r\n");
      out.write("\t\tself.close();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(\"#close\").click(function(){\r\n");
      out.write("\t\tself.close();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"43\"><img src=\"images/pop_tit_01.gif\" width=\"43\" height=\"51\"></td>\r\n");
      out.write("    <td background=\"images/pop_tit_02.gif\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td class=\"pop_tit\">테스트케이스 저장</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td width=\"216\"><img src=\"images/pop_tit_03.gif\" width=\"216\" height=\"51\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"3\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\"><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td bgcolor=\"#e1e9f0\"><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td valign=\"top\" bgcolor=\"#FFFFFF\"><table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\"  bgcolor=\"#baccdc\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td bgcolor=\"#e1e9f0\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td bgcolor=\"#FFFFFF\"><table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"120\" class=\"box_txt_red\">테스트케이스 ID:</td>\r\n");
      out.write("                            <td id=\"tsCaseID\">&nbsp;</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td class=\"box_txt_red\">테스트케이스 명:</td>\r\n");
      out.write("                            <td><input id=\"tsCaseName\" type=\"text\" class=\"input_topinq\" style=\"width:100%\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td class=\"box_txt_red\">테스트케이스 설명 :</td>\r\n");
      out.write("                            <td><input id=\"tsCaseDesc\" type=\"text\" class=\"input_topinq\" style=\"width:100%\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                          </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"5\" colspan=\"3\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                      <td id=\"newNameReg\" background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\">다른이름으로 저장</td>\r\n");
      out.write("                      <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </table>\r\n");
      out.write("                  <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                      <td id=\"nameReg\" background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\">저 장</td>\r\n");
      out.write("                      <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </table></td>\r\n");
      out.write("                  <td ><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                          <td id=\"close\" background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\">닫 기</td>\r\n");
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
