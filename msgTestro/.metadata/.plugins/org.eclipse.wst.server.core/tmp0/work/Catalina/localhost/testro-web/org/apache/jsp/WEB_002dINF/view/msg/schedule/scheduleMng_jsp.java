package org.apache.jsp.WEB_002dINF.view.msg.schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class scheduleMng_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" />\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/js/src/css/ui.jqgrid.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/themes/ui.datepicker.css\" media=\"screen\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/utils/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/src/i18n/grid.locale-en.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery.jqGrid.src.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/ui.datepicker.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery.contextmenu-fixed.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/popupcalendar.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/util.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/common.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/msg/schedule/scheduleMng.js\" charset=\"utf-8\"></script>\r\n");
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
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body bgcolor=\"#FFFFFF\" background=\"images/left_menu_bg.jpg\" leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onLoad=\"MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg','images/top_menu_message_02.jpg','images/top_menu_statistics_02.jpg','images/top_menu_mytest_02.jpg','images/top_menu_system_02.jpg')\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"Minwidth\">\r\n");
      out.write("        <div id=\"Page\">\r\n");
      out.write("            <div id=\"contents\">\r\n");
      out.write("            <!-- top menu 시작 --> \r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/topMenu.jsp", out, true);
      out.write("\r\n");
      out.write("            <!-- top menu 끝 -->   \r\n");
      out.write("            \r\n");
      out.write("                <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"Table_01\">\r\n");
      out.write("                    <tr> \r\n");
      out.write("\t\t\t\t\t\t<!-- left menu 시작 -->\r\n");
      out.write("\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- left menu 끝 -->\r\n");
      out.write("                        <td valign=\"top\">\r\n");
      out.write("                            <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"15\" cellspacing=\"0\">\r\n");
      out.write("                                <tr> \r\n");
      out.write("                                  <td valign=\"top\">\r\n");
      out.write("                                    \r\n");
      out.write("<table border=0 cellpadding=0 cellspacing=0 width=100%>\r\n");
      out.write("                                            <tr> \r\n");
      out.write("                                                <td width=\"20\"><img src=\"images/title_bullet1.gif\"></td>\r\n");
      out.write("                                                <td width=\"150\" class=\"sub_tit\">테스트예약 실행관리</td>\r\n");
      out.write("                                                <td valign=\"bottom\" class=\"point_text\" id=\"flowMsg\" >목록에서 마우스오른쪽 버튼을 누르신후, 테스트예약설정/결과보고서보기 메뉴를 사용 할 수 있습니다.</td>\r\n");
      out.write("                      \t\t\t\t\t\t</tr>\r\n");
      out.write("                                            <tr > \r\n");
      out.write("                                                <td background=\"images/tit_line_bg.gif\" height=\"6\" colspan=\"6\"><img src=\"images/tit_line_bg.gif\"></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr > \r\n");
      out.write("                                                <td height=\"10\" colspan=\"4\"></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                      </table>\r\n");
      out.write("                                    \r\n");
      out.write("                                        <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td bgcolor=\"#e1e9f0\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                              <td bgcolor=\"#FFFFFF\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">\r\n");
      out.write("                                                  <tr>\r\n");
      out.write("                                                    <td width=\"145\" class=\"box_txt\">케이스/시나리오 구분 :</td>\r\n");
      out.write("                                              <td><select id=\"testUnitCd\" name=\"select\"   class=\"menu\" style=\"width:115px\">\r\n");
      out.write("                                                </select></td>\r\n");
      out.write("                                                    <td width=\"130\" class=\"box_txt\">케이스/시나리오 ID :</td>\r\n");
      out.write("                                              <td>\r\n");
      out.write("                                              \t<input id=\"tsDataId\" name=\"textfield\" type=\"text\" class=\"input_topinq\" maxlength=\"20\" style=\"width:100px\">\r\n");
      out.write("                                              \t<img id=\"img_eraserId\" src=\"images/btn_eraser.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer;\">\r\n");
      out.write("                                              </td>\r\n");
      out.write("                                                    <td width=\"65\" class=\"box_txt\">실행상태 :</td>\r\n");
      out.write("                                                    <td><select id=\"jobExeStusCd\" name=\"select2\"   class=\"menu\" style=\"width:100px\">\r\n");
      out.write("                                                    </select></td>\r\n");
      out.write("                                                    <td><table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                        <tr>\r\n");
      out.write("                                                          <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                                          <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor: pointer\" onclick=\"search();\">조 회</td>\r\n");
      out.write("                                                          <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                                        </tr>\r\n");
      out.write("                                                    </table></td>\r\n");
      out.write("                                                  </tr>\r\n");
      out.write("                                                  <tr>\r\n");
      out.write("                                                    <td class=\"box_txt\">테스트예약 실행일자 :</td>\r\n");
      out.write("                                                    <td colspan=\"3\"><input id=\"startJobResrvYms\" readonly=\"readonly\" name=\"startJobResrvYms\" type=\"text\" class=\"input_topinq\" style=\"width:65px\">\r\n");
      out.write("                                                      <img src=\"images/un_sub_cen_cal.gif\" alt=\"달력\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer\" onclick=\"popUpCalendar(this, 'startJobResrvYms', 'yyyy-mm-dd','CENTER','MIDDLE');\"> ~\r\n");
      out.write("                                                      <input id=\"endJobResrvYms\" name=\"endJobResrvYms\" readonly=\"readonly\" type=\"text\" class=\"input_topinq\" style=\"width:65px\">\r\n");
      out.write("                                                      <img src=\"images/un_sub_cen_cal.gif\" alt=\"달력\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer\" onclick=\"popUpCalendar(this, 'endJobResrvYms', 'yyyy-mm-dd','CENTER','MIDDLE');\">\r\n");
      out.write("                                                      <img id=\"img_eraser\" src=\"images/btn_eraser.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer;\"></td>\r\n");
      out.write("                                                    <td class=\"box_txt\">등록자 :</td>\r\n");
      out.write("                                                    <td>\r\n");
      out.write("                                                    \t<input id=\"writeName\" name=\"textfield2\" type=\"text\" maxlength=\"30\" class=\"input_topinq\" style=\"width:100px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.usrname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                                                    \t<img id=\"img_eraserName\" src=\"images/btn_eraser.gif\" alt=\"삭제\" width=\"23\" height=\"21\" hspace=\"4\" align=\"absmiddle\" style=\"cursor: pointer;\">\r\n");
      out.write("                                                    </td>\r\n");
      out.write("                                                    <td>&nbsp;</td>\r\n");
      out.write("                                                  </tr>\r\n");
      out.write("                                              </table></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table></td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td height=\"10\" colspan=\"3\"></td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td class=\"sub_tit02\">테스트 예약실행 목록</td>                                        <td><table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                          <tr>\r\n");
      out.write("                                            <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                            <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor: pointer\" onclick=\"deleteRow();\">삭 제</td>\r\n");
      out.write("                                            <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                          </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                          <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                              <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                              <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor: pointer\" onClick=\"popRegisterSchedule('msg.schedule.popRegisterSchedule.do','예약등록')\"  style=\"cursor:pointer;\">예약등록</td>\r\n");
      out.write("                                              <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                          </table></td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                    <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("\t\t                               <tr>\r\n");
      out.write("\t\t                                   <td valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t                                      \t<table id=\"list\"></table>\r\n");
      out.write("\t\t                                      \t<div id=\"pager\"></div>\r\n");
      out.write("\t\t                                   </td>\r\n");
      out.write("\t\t                               </tr>\r\n");
      out.write("                                   \t</table>\r\n");
      out.write("    \t\t\t\t\t\t\t\t<!-- 우클릭 메뉴 --> \r\n");
      out.write("\t\t\t\t\t\t\t\t    <div class=\"contextMenu\" id=\"myMenu1\" style=\"display:none\" > \r\n");
      out.write("\t\t\t\t\t\t\t\t     <ul style=\"width: 300px\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t     <li id=\"edit\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t     <span style=\"font-size:80%; font-family:돋움,돋움체,Arial;\">테스트예약설정</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t     </li> \r\n");
      out.write("\t\t\t\t\t\t\t\t     <li id=\"viwreport\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t     <span style=\"font-size:80%; font-family:돋움,돋움체,Arial;\">결과보고서</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t     </li> \r\n");
      out.write("\t\t\t\t\t\t\t\t     </ul> \r\n");
      out.write("\t\t\t\t\t\t\t\t    </div> \r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
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
