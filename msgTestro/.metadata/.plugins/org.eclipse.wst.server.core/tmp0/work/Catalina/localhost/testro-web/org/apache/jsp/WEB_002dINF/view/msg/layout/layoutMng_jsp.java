package org.apache.jsp.WEB_002dINF.view.msg.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class layoutMng_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css\" media=\"screen\" /> \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/js/src/css/ui.jqgrid.css\" media=\"screen\" /> \r\n");
      out.write("<style> \r\n");
      out.write("html, body { \r\n");
      out.write(" margin: 0; \r\n");
      out.write(" padding: 0; \r\n");
      out.write(" font-size: 75%; \r\n");
      out.write("} \r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/src/i18n/grid.locale-en.js\" charset=\"utf-8\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery.jqGrid.src.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/utils/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/util.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/msg/layout/layoutMng.js\"></script>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body bgcolor=\"#FFFFFF\" background=\"images/left_menu_bg.jpg\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onLoad=\"MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg','images/btn_del_02.jpg')\">\r\n");
      out.write("<input id=\"chnlDstcd\" name=\"chnlDstcd\" type=\"hidden\"/><!-- hidden 채널구분코드 -->\r\n");
      out.write("<input id=\"fldDiv\" name=\"fldDiv\" type=\"hidden\"/><!-- hidden 필드구성 -->\r\n");
      out.write("<input id=\"writeId\" name=\"writeId\" type=\"hidden\"/><!-- hidden 작성자ID -->\r\n");
      out.write("<input id=\"writeName\" name=\"writeName\" type=\"hidden\"/><!-- hidden 작성자명 -->\r\n");
      out.write("<input id=\"cretnYMS\" name=\"cretnYMS\" type=\"hidden\"/><!-- hidden 생성일시 -->\r\n");
      out.write("<div id=\"Minwidth\">\r\n");
      out.write("        <div id=\"Page\">\r\n");
      out.write("            <div id=\"contents\">\r\n");
      out.write("             <!-- top menu 시작 --> \r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/topMenu.jsp", out, true);
      out.write("\r\n");
      out.write("            <!-- top menu 끝 --> \r\n");
      out.write("            \r\n");
      out.write("                <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"Table_01\">\r\n");
      out.write("                    <tr> \r\n");
      out.write("                        <!-- left menu 시작 -->\r\n");
      out.write("\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/cmn/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- left menu 끝 -->\r\n");
      out.write("                        <td valign=\"top\">\r\n");
      out.write("                            <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"15\" cellspacing=\"0\">\r\n");
      out.write("                                <tr> \r\n");
      out.write("                                  <td valign=\"top\">\r\n");
      out.write("                                    \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table border=0 cellpadding=0 cellspacing=0 width=100%>\r\n");
      out.write("                                            <tr> \r\n");
      out.write("                                                <td width=\"20\"><img src=\"images/title_bullet1.gif\"></td>\r\n");
      out.write("                                                <td width=\"80\" class=\"sub_tit\">전문관리</td>\r\n");
      out.write("                                                <td valign=\"bottom\" class=\"point_text\" id=\"flowMsg\" >신규생성 및 불러오기를 하실 수 있습니다.</td>\r\n");
      out.write("                                                <td height=\"2\" align=\"right\">\r\n");
      out.write("                                                \t<a href=\"#\" id=\"Image56\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image56','','images/btn_newtc_02.jpg',1)\" onClick=\"newLayout()\">\r\n");
      out.write("                                                \t\t<img src=\"images/btn_newtc_01.jpg\" name=\"Image56\" width=\"65\" height=\"19\" hspace=\"2\" border=\"0\">\r\n");
      out.write("                                                \t</a>\r\n");
      out.write("                                                \t<a href=\"#\" id=\"Image57\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image57','','images/btn_import_02.jpg',1)\" onClick=\"getLayout()\">\r\n");
      out.write("                                                \t\t<img src=\"images/btn_import_01.jpg\" name=\"Image57\" width=\"65\" height=\"19\" hspace=\"2\" border=\"0\">\r\n");
      out.write("                                                \t</a>\r\n");
      out.write("                                                \t<a href=\"#\" id=\"Image58\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"\" onClick=\"\">\r\n");
      out.write("                                                \t\t<img src=\"images/btn_savetc_03.jpg\" name=\"Image58\" width=\"48\" height=\"19\" hspace=\"2\" border=\"0\">\r\n");
      out.write("                                                \t</a>\r\n");
      out.write("                                                \t<a href=\"#\" id=\"Image31\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"\" onClick=\"\">\r\n");
      out.write("                                                \t\t<img src=\"images/btn_del_03.jpg\" name=\"Image31\" width=\"48\" height=\"19\" border=\"0\">\r\n");
      out.write("                                                \t</a>\r\n");
      out.write("                                                \t<a href=\"#\" id=\"Image59\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"\" onClick=\"\">\r\n");
      out.write("                                                \t\t<img src=\"images/btn_initialize_03.jpg\" name=\"Image59\" width=\"57\" height=\"19\" hspace=\"2\" border=\"0\">\r\n");
      out.write("                                                \t</a>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                    \t\t\t\t\t\t</tr>\r\n");
      out.write("                                            <tr > \r\n");
      out.write("                                                <td background=\"images/tit_line_bg.gif\" height=\"6\" colspan=\"6\"><img src=\"images/tit_line_bg.gif\"></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr > \r\n");
      out.write("                                                <td height=\"10\" colspan=\"4\"></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                      </table>\r\n");
      out.write("                                    \r\n");
      out.write("                                        <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                                          <tr>\r\n");
      out.write("                                            <td bgcolor=\"#e1e9f0\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                  <td bgcolor=\"#FFFFFF\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">\r\n");
      out.write("                                                      <tr>\r\n");
      out.write("                                                        <!-- td width=\"80\" class=\"box_txt\">채널구분 :</td>\r\n");
      out.write("                                                        <td id=\"chnlDstName\"></td -->\r\n");
      out.write("                                                        <td id=\"tranCdTitle\" width=\"80\" class=\"box_txt\">거래코드 :</td>\r\n");
      out.write("                                                        <td id=\"tranCd\" width=\"300\"></td>\r\n");
      out.write("                                                        <td id=\"tranNameTitle\" width=\"110\" class=\"box_txt\">거래명 :</td>\r\n");
      out.write("                                                        <td id=\"tranName\"></td>\r\n");
      out.write("                                                      </tr>\r\n");
      out.write("                                                      <tr>\r\n");
      out.write("                                                        <td class=\"box_txt\">필드구성 :</td>\r\n");
      out.write("                                                        <td id=\"fldDivName\"></td>\r\n");
      out.write("                                                        <td id=\"refTranCdTitle\" class=\"box_txt\">헤더부참조코드 :</td>\r\n");
      out.write("                                                        <td id=\"refTranCd\"></td>\r\n");
      out.write("                                                      </tr>\r\n");
      out.write("                                                  </table></td>\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                            </table></td>\r\n");
      out.write("                                          </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td height=\"10\" colspan=\"2\"></td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td class=\"sub_tit02\">전문 구성 필드</td>\r\n");
      out.write("                                        <td>\r\n");
      out.write("                                        <div id=\"btnArea\" disabled>\r\n");
      out.write("                                        <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                          <tr>\r\n");
      out.write("                                            <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                            <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onClick=\"deleteRow();\">행삭제</td>\r\n");
      out.write("                                            <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                          </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                          <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                              <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                              <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onClick=\"insertRow();\">행추가</td>\r\n");
      out.write("                                              <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                          </table>\r\n");
      out.write("                                          <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                              <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                              <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onClick=\"downRow();\">▼</td>\r\n");
      out.write("                                              <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                          </table>\r\n");
      out.write("                                          <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                              <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                              <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onClick=\"upRow();\">▲</td>\r\n");
      out.write("                                              <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                          </table>\r\n");
      out.write("                                         </div>\r\n");
      out.write("                                         </td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                    <table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td height=\"100%\" valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("                                        \t<table id=\"list1\"></table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div id=\"pager1\"></div>\r\n");
      out.write("                                        </td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                    <div id=\"btnArea2\" disabled>\r\n");
      out.write("                                    <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                      <tr>\r\n");
      out.write("                                        <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                        <td background=\"images/btn_img_02.gif\" class=\"btn_text\" onclick=\"importExcel();\" style=\"cursor:pointer;\" >엑셀업로드</td>\r\n");
      out.write("                                        <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                      </tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                    <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                     <tr>\r\n");
      out.write("                                       <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                                       <td background=\"images/btn_img_02.gif\" class=\"btn_text\" onclick=\"exportExcel();\" style=\"cursor:pointer;\" >엑셀다운로드</td>\r\n");
      out.write("                                       <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                                     </tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
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
