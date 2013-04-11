package org.apache.jsp.WEB_002dINF.view.msg.pretst;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pretst_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\t<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<title>전문 테스트로(TESTRO)</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charse=UTF-8\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" />\r\n");
      out.write("\t<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/cmn/utils/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/msg/pretst/pretst.js\" charset=\"UTF-8\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/cmn/common.js\" charset=\"UTF-8\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t$.cookie('repeat_cookie','');\r\n");
      out.write("\t\tinputTranName();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("<body bgcolor=\"#FFFFFF\" background=\"images/left_menu_bg.jpg\" leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onLoad=\"MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg')\">\r\n");
      out.write("   <div id=\"Minwidth\">\r\n");
      out.write("       <div id=\"Page\">\r\n");
      out.write("           <div id=\"contents\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/topMenu.jsp", out, true);
      out.write("\r\n");
      out.write("               <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"Table_01\">\r\n");
      out.write("                   <tr> \r\n");
      out.write("\t\t\t\t\t<!-- left menu 시작 -->\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- left menu 끝 -->\r\n");
      out.write("                       <td valign=\"top\">\r\n");
      out.write("\t\t\t\t        \t<form name=\"frmName\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"chnlDstcd\" name=\"chnlDstcd\" />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                            <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"15\" cellspacing=\"0\">\r\n");
      out.write("                                <tr> \r\n");
      out.write("                                    <td valign=\"top\"> \r\n");
      out.write("                                        <table border=0 cellpadding=0 cellspacing=0 width=100%>\r\n");
      out.write("                                            <tr> \r\n");
      out.write("                                                <td width=\"20\"><img src=\"images/title_bullet1.gif\"></td>\r\n");
      out.write("                                                <td width=\"90\" class=\"sub_tit\">거래테스트</td>\r\n");
      out.write("                                                <td valign=\"bottom\" class=\"point_text\" id=\"flowMsg\" >돋보기 버튼을 클릭하여 거래코드를 불러 올 수 있습니다.</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr > \r\n");
      out.write("                                                <td background=\"images/tit_line_bg.gif\" height=\"6\" colspan=\"4\"><img src=\"images/tit_line_bg.gif\"></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr > \r\n");
      out.write("                                                <td height=\"10\" colspan=\"2\"></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td bgcolor=\"#e1e9f0\">\r\n");
      out.write("                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("                                                        <tr>\r\n");
      out.write("                                                            <td bgcolor=\"#FFFFFF\">\r\n");
      out.write("                                                                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">\r\n");
      out.write("                                                                    <tr>\r\n");
      out.write("                                                                        <td width=\"65\" class=\"box_txt_red\">거래코드 :</td>\r\n");
      out.write("                                                                      <td width=\"200\"><input name=\"tranCd\" id=\"tranCd\" type=\"text\" class=\"input_topinq\" style=\"width:160px;ime-mode:disabled;\" value=\"\" onKeyDown=\"if(event.keyCode ==13){javascript:getDataList();}\">\r\n");
      out.write("                                                                        <img src=\"images/btn_pop.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer\" onClick=\"getLayoutOpen();\"></td>\r\n");
      out.write("                                                                        <td width=\"55\" class=\"box_txt\">거래명 :</td>\r\n");
      out.write("                                                                        <td><input name=\"tranName\" id=\"tranName\" type=\"text\" class=\"input_topinq\" style=\"width:100%\" value=\"\" readonly=\"readonly\">\r\n");
      out.write("                                                                     </td>\r\n");
      out.write("                                                                      <td width=\"90\" align=\"right\">\r\n");
      out.write("                                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                                          <tr>\r\n");
      out.write("                                                                            <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                                                            <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onclick=\"getDataList();\">조 회</td>\r\n");
      out.write("                                                                            <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                                                          </tr>\r\n");
      out.write("                                                                        </table>\r\n");
      out.write("                                                                      </td>\r\n");
      out.write("                                                                    </tr>\r\n");
      out.write("                                                                </table>\r\n");
      out.write("                                                          </td>\r\n");
      out.write("                                                        </tr>\r\n");
      out.write("                                                    </table>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                                            <tr> \r\n");
      out.write("                                                <td height=\"20\">&nbsp;</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table> \r\n");
      out.write("                                  </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                         </form>  \r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            \t\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
