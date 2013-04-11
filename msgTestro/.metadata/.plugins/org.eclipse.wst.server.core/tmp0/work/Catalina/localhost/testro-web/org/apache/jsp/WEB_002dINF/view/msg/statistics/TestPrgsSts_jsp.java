package org.apache.jsp.WEB_002dINF.view.msg.statistics;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TestPrgsSts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>전문 테스트로(TESTRO)</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache\"/> \r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\"/> \r\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/js/src/css/ui.jqgrid.css\" media=\"screen\" />\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    font-size: 75%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/src/i18n/grid.locale-en.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery.jqGrid.src.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/utils/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/popupcalendar.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/msg/statistics/statistics.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/util.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/msg/statistics/testPrgsSts.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("//초기값\r\n");
      out.write("var testStartYMS = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.teststartyms}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("var testEndYMS =  \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.testendyms}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function MM_swapImgRestore() { //v3.0\r\n");
      out.write("var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;\r\n");
      out.write("}\r\n");
      out.write("function MM_preloadImages() { //v3.0\r\n");
      out.write("var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\r\n");
      out.write("var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\r\n");
      out.write("if (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function MM_findObj(n, d) { //v4.01\r\n");
      out.write("var p,i,x;  if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\r\n");
      out.write("d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\r\n");
      out.write("if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\r\n");
      out.write("for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);\r\n");
      out.write("if(!x && d.getElementById) x=d.getElementById(n); return x;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function MM_swapImage() { //v3.0\r\n");
      out.write("var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)\r\n");
      out.write("if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}\r\n");
      out.write("}\r\n");
      out.write("function MM_openBrWindow(theURL,winName,features) { //v2.0\r\n");
      out.write("window.open(theURL,winName,features);\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("\r\n");
      out.write("// iframe resize\r\n");
      out.write("function autoResize(i)\r\n");
      out.write("{\r\n");
      out.write("var iframeHeight=\r\n");
      out.write("(i).contentWindow.document.body.scrollHeight;\r\n");
      out.write("(i).height=iframeHeight+20;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#FFFFFF\" background=\"images/left_menu_bg.jpg\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onLoad=\"MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg')\">\r\n");
      out.write("\t<form name=\"frm\" method=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"testStgeName\" id=\"testStgeName\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"tranCd\" id=\"tranCd\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"tranName\" id=\"tranName\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"tstrId\" id=\"tstrId\"/>\r\n");
      out.write("\t    <div id=\"Minwidth\">\r\n");
      out.write("\t        <div id=\"Page\">\r\n");
      out.write("\t            <div id=\"contents\">\r\n");
      out.write("\t            \t<!-- top menu 시작 --> \r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/topMenu.jsp", out, true);
      out.write("\r\n");
      out.write("            \t\t<!-- top menu 끝 -->      \r\n");
      out.write("\t            \r\n");
      out.write("\t                <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"Table_01\">\r\n");
      out.write("\t                    <tr> \r\n");
      out.write("\t                         <!-- left menu 시작 -->\r\n");
      out.write("\t\t\t\t\t\t\t ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t <!-- left menu 끝 -->\r\n");
      out.write("\t                        <td valign=\"top\">\r\n");
      out.write("\t                            <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"15\" cellspacing=\"0\">\r\n");
      out.write("\t                                <tr> \r\n");
      out.write("\t                                  <td valign=\"top\"><table border=0 cellpadding=0 cellspacing=0 width=100%>\r\n");
      out.write("\t                                    <tr>\r\n");
      out.write("\t                                      <td width=\"20\"><img src=\"images/title_bullet1.gif\"></td>\r\n");
      out.write("\t                                      <td width=\"120\" class=\"sub_tit\">단계별 진척현황</td>\r\n");
      out.write("\t                                      <td valign=\"bottom\" class=\"point_text\" id=\"flowMsg\" >조회된 내용을 더블클릭하여 상세조회를 확인 할 수 있습니다.</td>\r\n");
      out.write("\t                                    </tr>\r\n");
      out.write("\t                                    <tr >\r\n");
      out.write("\t                                      <td background=\"images/tit_line_bg.gif\" height=\"6\" colspan=\"3\"><img src=\"images/tit_line_bg.gif\"></td>\r\n");
      out.write("\t                                    </tr>\r\n");
      out.write("\t                                    <tr >\r\n");
      out.write("\t                                      <td height=\"10\" colspan=\"3\"></td>\r\n");
      out.write("\t                                    </tr>\r\n");
      out.write("\t                                  </table>\r\n");
      out.write("\t                                    <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("\t                                          <tr>\r\n");
      out.write("\t                                            <td bgcolor=\"#e1e9f0\">\r\n");
      out.write("\t                                              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t                                                    <tr>\r\n");
      out.write("\t                                                      <td bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t                                                          <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">\r\n");
      out.write("\t                                                              <tr>\r\n");
      out.write("\t                                                                <td width=\"120\" class=\"box_txt_red\">프로젝트 :</td>\r\n");
      out.write("\t                                                                <td width=\"360\" colspan=\"1\"><input id=\"projNo\" type=\"text\" class=\"input_topinq\" style=\"width:100px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.projno}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t                                                                    <img src=\"images/btn_pop.gif\" alt=\"프로젝트 조회\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" onClick=\"javascript:openProjPop('testStgeName2');\" style=\"cursor: pointer\">\r\n");
      out.write("\t                                                                <input id=\"projName\" type=\"text\" class=\"input_topinq\" style=\"width:200px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.projname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t                                                                </td>\r\n");
      out.write("\t                                                                <td width=\"90\" class=\"box_txt\">테스트단계 :</td>\r\n");
      out.write("\t                                                                <td>\r\n");
      out.write("\t\t                                                                <select id=\"testStgeName2\" class=\"menu\" style=\"width:120px\">\r\n");
      out.write("\t\t                                                                    <option value=\"\">== 전체 ==</option>\r\n");
      out.write("\t\t                                                                </select>\r\n");
      out.write("\t\t                                                            </td>\r\n");
      out.write("\t                                                                <td width=\"60\">\r\n");
      out.write("\t\t                                                                <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t                                                                  <tr>\r\n");
      out.write("\t\t                                                                    <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("\t\t                                                                    <td background=\"images/btn_img_02.gif\" id=\"srch_btn\" class=\"btn_text\" style=\"cursor:pointer;\" >조 회</td>\r\n");
      out.write("\t\t<!--                                                                    <td background=\"images/btn_img_02.gif\" class=\"btn_text\" onclick = 'javascript:getList();'><font style=\"cursor:pointer\">조 회</td>-->\r\n");
      out.write("\t\t                                                                    <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("\t\t                                                                  </tr>\r\n");
      out.write("\t\t                                                                </table>\r\n");
      out.write("\t                                                                </td>\r\n");
      out.write("\t                                                              </tr>\r\n");
      out.write("\t                                                              <tr>\r\n");
      out.write("\t                                                              \t<td class=\"box_txt_red\" colspan=\"1\">조회구분 :</td>\r\n");
      out.write("\t                                                                <td>\r\n");
      out.write("\t\t                                                                <select name=\"searchGubun\"  id=\"searchGubun\"  class=\"menu\" style=\"width:120px\">\r\n");
      out.write("\t\t                                                                </select>\r\n");
      out.write("\t\t                                                            </td>\r\n");
      out.write("\t                                                                <td class=\"box_txt_red\">조회기간 :</td>\r\n");
      out.write("\t                                                                <td><input name=\"testStartYMS\" id=\"testStartYMS\" type=\"text\" class=\"input_topinq\" style=\"width:65px\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"images/un_sub_cen_cal.gif\" alt=\"달력\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer\" onclick=\"popUpCalendar(this, 'testStartYMS', 'yyyy-mm-dd','CENTER','MIDDLE');\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ~\r\n");
      out.write("\t                                                                    <input name=\"testEndYMS\" id=\"testEndYMS\" type=\"text\" class=\"input_topinq\" style=\"width:65px\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"images/un_sub_cen_cal.gif\" alt=\"달력\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer\" onclick=\"popUpCalendar(this, 'testEndYMS', 'yyyy-mm-dd','CENTER','MIDDLE');\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t                                                                \r\n");
      out.write("\t                                                                <td>&nbsp;</td>\r\n");
      out.write("\t                                                              </tr>\r\n");
      out.write("\t                                                              <tr>\r\n");
      out.write("\t                                                              \t<td class=\"box_txt\">테스트대상시스템 :</td>\r\n");
      out.write("\t                                                                <td>\r\n");
      out.write("\t\t                                                                <select name=\"connSevrDstcd\" id=\"connSevrDstcd\"  class=\"menu\" style=\"width:120px\">\r\n");
      out.write("\t\t                                                                </select>\r\n");
      out.write("\t\t                                                            </td>\r\n");
      out.write("\t                                                              </tr>\r\n");
      out.write("\t                                                          </table>\r\n");
      out.write("\t                                                      </td>\r\n");
      out.write("\t                                                    </tr>\r\n");
      out.write("\t                                              </table>\r\n");
      out.write("\t                                            </td>\r\n");
      out.write("\t                                          </tr>\r\n");
      out.write("\t                                        </table>\r\n");
      out.write("\t                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td height=\"10\"></td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                    </table>\r\n");
      out.write("\t                                        <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("\t\t                                      <tr>\r\n");
      out.write("\t\t                                        <td valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t                                        \t<table id=\"list2\"></table>\r\n");
      out.write("\t\t                                        </td>\r\n");
      out.write("\t\t                                      </tr>\r\n");
      out.write("                                   \t \t\t</table>\r\n");
      out.write("\t                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td height=\"5\" colspan=\"3\"></td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td width=\"150\" height=\"10\">&nbsp;</td>\r\n");
      out.write("\t                                        <td align=\"center\"><span class=\"input_result\">[수행건수를 더블클릭하시면 상세조회가 가능합니다.]</span></td>\r\n");
      out.write("\t                                        <td width=\"150\" id=\"excelBtn\">\r\n");
      out.write("\t                                        <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t                                          <tr>\r\n");
      out.write("\t                                            <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("\t                                            <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onclick=\"downExcelTestPrgsSts()\">엑셀다운로드</td>\r\n");
      out.write("\t                                            <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("\t                                          </tr>\r\n");
      out.write("\t                                        </table>\r\n");
      out.write("\t                                       </td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                  </table></td>\r\n");
      out.write("\t                                </tr>\r\n");
      out.write("\t                            </table>\r\n");
      out.write("\t                        </td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                </table>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
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
