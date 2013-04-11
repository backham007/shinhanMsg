package org.apache.jsp.WEB_002dINF.view.cmn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class topMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.cookie.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/login.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/main.js\" charset=\"utf-8\"></script>\r\n");
      out.write("                \r\n");
      out.write("            \t<!--메뉴 시작--> \r\n");
      out.write("                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td height=\"64\" background=\"images/top_bg_prt_01.jpg\">\r\n");
      out.write("                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td width=\"215\" rowspan=\"2\" class=\"menu_tit02\"><img id=\"img_logo\" src=\"images/top_logo.jpg\" alt=\"\" style=\"cursor: pointer;\"></td>\r\n");
      out.write("                                    <td>\r\n");
      out.write("\t                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t                                      <tr>\r\n");
      out.write("\t                                        <td width=\"34\" background=\"images/top_bg_prt_02.jpg\"><img src=\"images/top_img_R_01.jpg\"  alt=\"\"></td>\r\n");
      out.write("\t                                        <td height=\"23\"  background=\"images/top_bg_prt_02.jpg\" valign=\"bottom\" >\r\n");
      out.write("\t\t                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("\t\t                                            <tr>\r\n");
      out.write("\t\t                                            \t<td valign=\"bottom\" class=\"user_login\" style=\"padding-bottom: 0px; padding-top: 3px; line-height: 10px;\"><strong>ㆍ프로젝트명 : </strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.projname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<strong> ㆍ테스트단계 : </strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.teststgename}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t                                            </tr>\r\n");
      out.write("\t\t                                        </table>\r\n");
      out.write("\t                                        </td>\r\n");
      out.write("\t                                        <td valign=\"bottom\" background=\"images/top_bg_prt_02.jpg\">\r\n");
      out.write("\t\t                                        <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t                                            <tr>\r\n");
      out.write("\t\t                                              <td><img src=\"images/top_img_R_02.jpg\" alt=\"\" width=\"16\" height=\"23\"></td>\r\n");
      out.write("\t\t                                              <td valign=\"bottom\" background=\"images/top_bg_prt_01.jpg\"  class=\"user_login\"><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.usrname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("님</strong>이 접속중입니다<!-- <a href=\"cmn.login.sessionCheck.do\">.</a> -->&nbsp;</td>\r\n");
      out.write("\t\t                                              <td align=\"right\" background=\"images/top_bg_prt_01.jpg\"><img id=\"logout_btn\" src=\"images/btn_logout.gif\" alt=\"\" hspace=\"2\" align=\"absmiddle\" style=\"cursor: pointer;\"></td>\r\n");
      out.write("\t\t                                              <td align=\"right\"><img src=\"images/top_img_R_03.jpg\" alt=\"\" width=\"6\" height=\"23\"></td>\r\n");
      out.write("\t\t                                            </tr>\r\n");
      out.write("\t\t                                        </table>\r\n");
      out.write("\t\t                                    </td>\r\n");
      out.write("\t                                      </tr>\r\n");
      out.write("\t                                    </table>\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr id=\"top_menu_area\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"top_projno\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.projno}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"top_connsevrdstcd\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.connsevrdstcd}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td width=\"110\"><a style=\"cursor: pointer;\" target=\"_parent\" onMouseOver=\"MM_swapImage('Image26','','images/top_menu_message_02.jpg',1)\"    onMouseOut=\"MM_swapImgRestore()\"><img id=\"top_menu_01\"  src=\"images/top_menu_message_01.jpg\" name=\"Image26\" width=\"110\" height=\"39\" border=\"0\"></a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t                                        <td width=\"110\"><a style=\"cursor: pointer;\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image23','','images/top_menu_reserve_02.jpg',1)\"><img id=\"top_menu_05\" src=\"images/top_menu_reserve_01.jpg\" name=\"Image23\" width=\"110\" height=\"39\" border=\"0\"></a></td>\r\n");
      out.write("\t                                        <td width=\"110\"><a style=\"cursor: pointer;\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image24','','images/top_menu_defect_02.jpg',1)\"><img id=\"top_menu_06\" src=\"images/top_menu_defect_01.jpg\" name=\"Image24\" width=\"110\" height=\"39\" border=\"0\"></a></td>\r\n");
      out.write("\t                                        \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td width=\"110\"><a style=\"cursor: pointer;\" target=\"_parent\" onMouseOver=\"MM_swapImage('Image27','','images/top_menu_statistics_02.jpg',1)\" onMouseOut=\"MM_swapImgRestore()\"><img id=\"top_menu_02\"  src=\"images/top_menu_statistics_01.jpg\" name=\"Image27\" width=\"110\" height=\"39\" border=\"0\"></a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\"><a style=\"cursor: pointer;\" target=\"_parent\" onMouseOver=\"MM_swapImage('Image28','','images/top_menu_mytest_02.jpg',1)\"     onMouseOut=\"MM_swapImgRestore()\"><img id=\"top_menu_03\"  src=\"images/top_menu_mytest_01.jpg\" name=\"Image28\" width=\"140\" height=\"39\" border=\"0\"></a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("                                    </table></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            \t<!--메뉴 끝-->  ");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/view/cmn/topMenu.jsp(52,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'01' == sessionScope.userinfo.usrlevel}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" width=\"110\"><a style=\"cursor: pointer;\" target=\"_parent\" onMouseOver=\"MM_swapImage('Image30','','images/top_menu_system_02.jpg',1)\"     onMouseOut=\"MM_swapImgRestore()\"><img id=\"top_menu_04\"  src=\"images/top_menu_system_01.jpg\" name=\"Image30\" width=\"110\" height=\"39\" border=\"0\"></a></td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
