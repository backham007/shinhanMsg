package org.apache.jsp.WEB_002dINF.view.msg.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerLayoutPop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>전문 테스트로(TESTRO)</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/util.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/msg/layout/registerLayoutPop.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("// iframe resize\r\n");
      out.write("function autoResize(i)\r\n");
      out.write("{\r\n");
      out.write("    var iframeHeight=\r\n");
      out.write("    (i).contentWindow.document.body.scrollHeight;\r\n");
      out.write("    (i).height=iframeHeight+20;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"43\"><img src=\"images/pop_tit_01.gif\" width=\"43\" height=\"51\"></td>\r\n");
      out.write("    <td background=\"images/pop_tit_02.gif\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td class=\"pop_tit\">전문저장</td>\r\n");
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
      out.write("                          <tr style=\"display: none\">\r\n");
      out.write("                            <td width=\"100\" class=\"box_txt_red\">채널구분 :</td>\r\n");
      out.write("                            <td><select id=\"chnlDstcd\" name=\"select\" class=\"menu\" style=\"width:120px\" onChange=\"setRefTranCd();\">\r\n");
      out.write("                            </select></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"100\" class=\"box_txt_red\">필드구성 :</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                            \t<select id=\"fldDiv\" name=\"select\" class=\"menu\" style=\"width:120px\" onChange=\"setRefTranCd();\"></select>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td id=\"refTranCdTitle\" class=\"box_txt\">헤더부참조코드 :</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                            \t<input id=\"refTranCd\" name=\"refTranCd\" type=\"text\" class=\"input_topinq\" maxlength=\"30\" style=\"width:120px\" readOnly>\r\n");
      out.write("                            \t<img id=\"refTranCdImg\" src=\"images/btn_pop.gif\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer\" onClick=\"getHeaderList();\">\r\n");
      out.write("                            </td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td id=\"tranCdTitle\" class=\"box_txt_red\">거래코드 :</td>\r\n");
      out.write("                            <td colspan=\"3\"><input id=\"tranCd\" name=\"textfield2\" type=\"text\" class=\"input_topinq\" maxlength=\"30\" style=\"width:100%; ime-mode:disabled;\" onPaste=\"javascript:return false;\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td id=\"tranNameTitle\" class=\"box_txt\">거래명 :</td>\r\n");
      out.write("                            <td colspan=\"3\"><input id=\"tranName\" name=\"textfield\" type=\"text\" class=\"input_topinq\" maxlength=\"500\" style=\"width:100%\"></td>\r\n");
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
      out.write("                      <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onClick=\"submit();\">저 장</td>\r\n");
      out.write("                      <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </table></td>\r\n");
      out.write("                  <td ><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                          <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onClick=\"self.close();\">닫 기</td>\r\n");
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
