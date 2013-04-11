package org.apache.jsp.WEB_002dINF.view.msg.tcmng;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tcmngInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/js/src/css/ui.jqgrid.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    font-size: 75%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/src/i18n/grid.locale-en.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery.jqGrid.src.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/utils/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/util.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/msg/tcmng/tcmngInfo.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/validation_v01.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/popupcalendar.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// iframe resize\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\tloadPage();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function autoResize(i)\r\n");
      out.write("{\r\n");
      out.write("    var iframeHeight=\r\n");
      out.write("    (i).contentWindow.document.body.scrollHeight;\r\n");
      out.write("    (i).height=iframeHeight+20;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("\r\n");
      out.write("<form name=\"frmName\" method=\"post\" action=\"#\">\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"43\"><img src=\"images/pop_tit_01.gif\" width=\"43\" height=\"51\"></td>\r\n");
      out.write("    <td background=\"images/pop_tit_02.gif\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td class=\"pop_tit\">테스트케이스 불러오기</td>\r\n");
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
      out.write("                      <td bgcolor=\"#FFFFFF\">\r\n");
      out.write("                      \t<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"65\" class=\"box_txt\">조회구분 :</td>\r\n");
      out.write("                            <td colspan=\"3\">\r\n");
      out.write("                            \t<select name=\"inqType\" id=\"inqType\" class=\"menu\" style=\"width:150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"tsCaseName\">테스트케이스명</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"tsCaseDesc\">테스트케이스설명</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"tsCaseID\">테스트케이스ID</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"tranCd\">거래코드</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>&nbsp;&nbsp;\r\n");
      out.write("                               \t<input name=\"textfield\" id=\"textfield\" type=\"text\" class=\"input_topinq\" style=\"width:472px\">\r\n");
      out.write("                               \t<img src=\"images/btn_eraser.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer\" onclick=\"{$('#textfield').val('').focus()}\">\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                            \t<table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                            \t\t<tr>\r\n");
      out.write("\t\t                                <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("\t\t                                <td background=\"images/btn_img_02.gif\" class=\"btn_text\" onclick=\"getTcList();\" style=\"cursor:pointer;\">조 회</td>\r\n");
      out.write("\t\t                                <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("\t\t                    \t\t</tr>\r\n");
      out.write("                            \t</table>\r\n");
      out.write("                            </td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td class=\"box_txt\">작성자명 :</td>\r\n");
      out.write("                            <td width=\"300\">\r\n");
      out.write("                            \t<input name=\"writeName\" id=\"writeName\" type=\"text\" class=\"input_topinq\" style=\"width:120px\">\r\n");
      out.write("                            \t<img src=\"images/btn_eraser.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer\" onclick=\"doNameClear();\">\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td class=\"box_txt\" width=\"65\" >작성일자 :</td>\r\n");
      out.write("                            <td width=\"300\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input name=\"startDt\" id=\"startDt\" type=\"text\" class=\"input_topinq\" style=\"width:65px\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"images/un_sub_cen_cal.gif\" alt=\"달력\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer;\" onclick=\"javascript:popUpCalendar(this, 'startDt', 'yyyy-mm-dd','CENTER','MIDDLE');\"> ~\r\n");
      out.write("\t\t\t\t\t\t\t\t<input name=\"endDt\" id=\"endDt\" type=\"text\" class=\"input_topinq\" style=\"width:65px\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"images/un_sub_cen_cal.gif\" alt=\"달력\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer;\" onclick=\"javascript:popUpCalendar(this, 'endDt', 'yyyy-mm-dd','CENTER','MIDDLE');\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"images/btn_eraser.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor:pointer\" onclick=\"doClear();\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("                          </tr> \r\n");
      out.write("                        </table>\r\n");
      out.write("                      </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"10\" colspan=\"2\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td class=\"sub_tit02\">테스트케이스 목록</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("              <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"100%\" valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t              <!-- 그리드 테스트케이스 리스트 시작 -->\r\n");
      out.write("\t\t              <table id=\"list1\"></table>\r\n");
      out.write("\t\t\t\t\t  <div id=\"pager1\"></div>\r\n");
      out.write("\t\t              <!-- 그리드 테스트케이스 리스트 끝 -->\r\n");
      out.write("              \t  </td>\r\n");
      out.write("              \t</tr>\r\n");
      out.write("              </table>\r\n");
      out.write("              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"10\" colspan=\"3\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td width=\"110\" class=\"sub_tit02\">테스트데이터 목록</td>\r\n");
      out.write("                  <td id=\"titleDiv1\" class=\"point_result\" ></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("              <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"100%\" valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t              <!-- 그리드 테스트데이터 리스트 시작 -->\r\n");
      out.write("\t\t              <table id=\"list2\"></table>\r\n");
      out.write("\t\t\t\t\t  <div id=\"pager2\"></div>\r\n");
      out.write("\t\t              <!-- 그리드 테스트데이터 리스트 끝-->\r\n");
      out.write("              \t  </td>\r\n");
      out.write("              \t</tr>\r\n");
      out.write("              </table>\r\n");
      out.write("              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"10\" colspan=\"3\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td width=\"110\" class=\"sub_tit02\">테스트데이터 상세</td>\r\n");
      out.write("                  <td id=\"titleDiv2\" class=\"point_result\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("\r\n");
      out.write("              <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td width=\"4\"><img height=\"31\" src=\"images/tabbg_01_01.gif\" width=\"4\"></td>\r\n");
      out.write("                  <td background=\"images/tabbg_01_02.gif\" valign=\"top\"><!-- menu -->\r\n");
      out.write("                      <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td>&nbsp;</td>\r\n");
      out.write("                          <td><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n");
      out.write("                             <tr>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                \t<div id=\"view0_on\">\r\n");
      out.write("\t                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td width=5 background=\"images/tab_01.gif\" height=30>&nbsp;</td>\r\n");
      out.write("\t                                        <td class=tab_tit background=images/tab_02.gif  style=\"cursor:pointer;\">헤더부</td>\r\n");
      out.write("\t                                        <td width=5 background=images/tab_03.gif>&nbsp;</td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                    </table>\r\n");
      out.write("\t                                </div>\r\n");
      out.write("                                    <div id=\"view0_off\">\r\n");
      out.write("                                      <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                          <td width=3 background=\"images/btn_bg_02_01.jpg\"><img height=30 src=\"images/tab01_01.gif\" width=4></td>\r\n");
      out.write("                                          <td class='tab_tit02' onclick=\"javascript:doSearch('view0');\" valign=\"middle\" background=\"images/tab01_02.gif\"><font style=\"cursor:pointer;\">헤더부</font></td>\r\n");
      out.write("                                          <td valign=bottom background=\"images/btn_bg_02_02.jpg\"><img height=30 src=\"images/tab03_03.gif\" width=3></td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                      </table>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td width=2>&nbsp;</td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                \t<div id=\"view1_on\">\r\n");
      out.write("\t                                    <table cellspacing=0 cellpadding=0 border=0>\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td width=5 background=images/tab_01.gif height=30>&nbsp;</td>\r\n");
      out.write("\t                                        <td class=tab_tit background=\"images/tab_02.gif\"><font style=\"cursor:pointer;\">개별부</font></td>\r\n");
      out.write("\t                                        <td width=5 background=\"images/tab_03.gif\">&nbsp;</td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                    </table>\r\n");
      out.write("                                \t</div>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("\t                                <div id=\"view1_off\">\r\n");
      out.write("\t                                    <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td width=3 background=images/btn_bg_02_01.jpg><img height=30 src=\"images/tab01_01.gif\" width=4></td>\r\n");
      out.write("\t                                        <td class=tab_tit02  onclick=\"javascript:doSearch('view1');\" valign=\"middle\" background=\"images/tab01_02.gif\"><font style=\"cursor:pointer;\">개별부</font></td>\r\n");
      out.write("\t                                        <td valign=bottom background=images/btn_bg_02_02.jpg><img height=30 src=\"images/tab03_03.gif\" width=3></td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                    </table>\r\n");
      out.write("\t                                </div>\r\n");
      out.write("                                </td>\r\n");
      out.write("                             </tr>\r\n");
      out.write("                          </table></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table></td>\r\n");
      out.write("                  <td width=4><img height=31 src=\"images/tabbg_01_03.gif\" width=4></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td width=3 background=\"images/tabbg_02_01.gif\" bgcolor=#456788></td>\r\n");
      out.write("                  <td valign=top width=\"100%\" >\r\n");
      out.write("                  \t<div id=\"layoutDiv\" style=\"height:107px;\" class=\"apDiv1\">\r\n");
      out.write("                  \t</div>\r\n");
      out.write("                  </td>\r\n");
      out.write("                  <td width=3 height=\"100%\" background=\"images/tabbg_02_03.gif\" bgcolor=#456788></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td width=4 height=4><img height=4 src=\"images/tabbg_03_01.gif\" width=4></td>\r\n");
      out.write("                  <td background=images/tabbg_03_02.gif><img height=4 src=\"images/tabbg_03_02.gif\" width=3></td>\r\n");
      out.write("                  <td width=4 height=4><img height=4 src=\"images/tabbg_03_03.gif\" width=4></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"5\" colspan=\"3\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                        <td background=\"images/btn_img_02.gif\" class=\"btn_text\" onclick=\"doApply();\" style=\"cursor:pointer;\">적 용</td>\r\n");
      out.write("                        <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                  </table>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  <td ><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                          <td background=\"images/btn_img_02.gif\" class=\"btn_text\" onclick=\"self.close();\" style=\"cursor:pointer;\">닫 기</td>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
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
