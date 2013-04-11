package org.apache.jsp.WEB_002dINF.view.cmn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class leftMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("                       <td id=\"left_menu_area\" lmenuChk1=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.projno}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" lmenuChk2=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.connsevrdstcd}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" width=\"191\" valign=\"top\" background=\"images/left_menu_bg.jpg\">\r\n");
      out.write("                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><img src=\"images/left_menu_img_01.jpg\" alt=\"\" width=\"186\" height=\"28\"></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td background=\"images/left_menu_img_02.jpg\">\r\n");
      out.write("                                    \t<!-- 01 전문테스트 LEFT 시작 -->\r\n");
      out.write("                                    \t<table id=\"left01_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display: none;\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                            <td height=\"26\" >\r\n");
      out.write("                                                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td width=\"5\" background=\"images/left_menu_bg_t_01.jpg\"><img src=\"images/left_menu_bg_t_01.jpg\" width=\"5\" height=\"33\"></td>\r\n");
      out.write("                                                        <td width=\"171\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"images/lrft_menu_message.jpg\" alt=\"\" width=\"171\" height=\"47\">\r\n");
      out.write("                                                      <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                                <tr>\r\n");
      out.write("                                                                    <td class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">나의 최근작업관리</td>\r\n");
      out.write("                                                                </tr>\r\n");
      out.write("                                                                <tr>\r\n");
      out.write("                                                                    <td height=\"4\"></td>\r\n");
      out.write("                                                                        </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td>\r\n");
      out.write("                                                                                    <table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                                                        <tr>\r\n");
      out.write("                                                                                            <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_1_1_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_1_1\" style=\"cursor: pointer;\" mvUrl=\"msg.myLatestWork.myLatestWork.do\">나의 최근작업 조회</a></span></td>\r\n");
      out.write("                                                                                        </tr>\r\n");
      out.write("                                                                                        <tr>\r\n");
      out.write("                                                                                            <td height=\"3\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("                                                                                        </tr>\r\n");
      out.write("                                                                                    </table>\r\n");
      out.write("                                                                                </td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                        <tr>\r\n");
      out.write("                                                                    <td height=\"10\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("                                                                </tr>\r\n");
      out.write("                                                            </table>\r\n");
      out.write("                                                            <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                              <tr>\r\n");
      out.write("                                                                <td class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">전문관리</td>\r\n");
      out.write("                                                              </tr>\r\n");
      out.write("                                                              <tr>\r\n");
      out.write("                                                                <td height=\"4\"></td>\r\n");
      out.write("                                                              </tr>\r\n");
      out.write("                                                              ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                              <tr>\r\n");
      out.write("                                                                <td height=\"10\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("                                                              </tr>\r\n");
      out.write("                                                            </table>\r\n");
      out.write("                                                      <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                                <tr>\r\n");
      out.write("                                                                    <td height=\"18\" class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">테스트케이스/실행</td>\r\n");
      out.write("                                                                </tr>\r\n");
      out.write("                                                                <tr>\r\n");
      out.write("                                                                    <td height=\"4\"></td>\r\n");
      out.write("                                                                </tr>\r\n");
      out.write("                                                                <tr>\r\n");
      out.write("                                                                    <td>\r\n");
      out.write("                                                                        <table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_1_3_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_1_3\" style=\"cursor: pointer;\" mvUrl=\"msg.pretst.pretst.do\">거래테스트</a></span></td>\r\n");
      out.write("                                                                          </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_1_4_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_1_4\" style=\"cursor: pointer;\" mvUrl=\"msg.tcmng.tcmng.do\">테스트케이스 관리</a></span></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_1_5_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_1_5\" style=\"cursor: pointer;\" mvUrl=\"msg.tsmng.tsmng.do\">테스트시나리오 관리</a></span></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_1_6_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_1_6\" style=\"cursor: pointer;\" mvUrl=\"msg.report.resultReport.do\">결과보고서 조회</a></span></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                            <tr>\r\n");
      out.write("                                                                                <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("                                                                            </tr>\r\n");
      out.write("                                                                        </table>\r\n");
      out.write("                                                                  </td>\r\n");
      out.write("                                                                </tr>\r\n");
      out.write("                                                                <tr>\r\n");
      out.write("                                                                    <td height=\"15\">&nbsp;</td>\r\n");
      out.write("                                                                </tr>\r\n");
      out.write("                                                            </table>\r\n");
      out.write("                                                            \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                      <td width=\"15\" valign=\"top\"><img id=\"hide_1\" src=\"images/left_tab_hide.jpg\" style=\"cursor: pointer;\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\"></td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                </table>\r\n");
      out.write("                                            </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                    \t<!-- 01 전문테스트 LEFT 끝 -->\r\n");
      out.write("                                    \t\r\n");
      out.write("                                    \t<!-- 05예약실행 LEFT 시작 -->\r\n");
      out.write("                                        <table id=\"left05_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display: none;\">\r\n");
      out.write("\t\t\t                                <tr>\r\n");
      out.write("\t\t\t                                  <td height=\"26\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t                                      <tr>\r\n");
      out.write("\t\t\t                                        <td width=\"5\" background=\"images/left_menu_bg_t_01.jpg\"><img src=\"images/left_menu_bg_t_01.jpg\" width=\"5\" height=\"33\"></td>\r\n");
      out.write("\t\t\t                                        <td width=\"171\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"images/lrft_menu_reserve.jpg\" alt=\"\" width=\"171\" height=\"47\">\r\n");
      out.write("\t\t\t                                          <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"18\" class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">테스트예약 실행관리</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"4\"></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td><table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_5_1_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_5_1\" style=\"cursor: pointer;\" mvUrl=\"msg.schedule.scheduleMng.do\">테스트예약 실행관리</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                </table></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"15\">&nbsp;</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                          </table></td>\r\n");
      out.write("\t\t\t                                        <td width=\"15\" valign=\"top\"><img id=\"hide_5\" src=\"images/left_tab_hide.jpg\" style=\"cursor: pointer;\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\"></td>\r\n");
      out.write("\t\t\t                                      </tr>\r\n");
      out.write("\t\t\t                                  </table></td>\r\n");
      out.write("\t\t\t                                </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        <!-- 05예약실행 LEFT 끝 -->\r\n");
      out.write("                                        \r\n");
      out.write("                       \t\t\t\t\t<!-- 06결함관리 LEFT 시작 -->\r\n");
      out.write("                                        <table id=\"left06_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display: none;\">\r\n");
      out.write("\t\t\t                                <tr>\r\n");
      out.write("\t\t\t                                  <td height=\"26\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t                                      <tr>\r\n");
      out.write("\t\t\t                                        <td width=\"5\" background=\"images/left_menu_bg_t_01.jpg\"><img src=\"images/left_menu_bg_t_01.jpg\" width=\"5\" height=\"33\"></td>\r\n");
      out.write("\t\t\t                                        <td width=\"171\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"images/lrft_menu_defect.jpg\" alt=\"\" width=\"171\" height=\"47\">\r\n");
      out.write("\t\t\t                                          <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"18\" class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">나의 테스트 결함관리</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"4\"></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td><table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_6_1_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_6_1\" style=\"cursor: pointer;\" mvUrl=\"msg.flaw.myFlawList.do\">나의 결함조회</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\" ><span class=\"left_menu_2D_off\"><img id=\"leftmenu_6_2_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_6_2\" style=\"cursor: pointer;\" mvUrl=\"msg.flaw.myReTestList.do\">나의 재테스트 조회</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\" class=\"left_menu_2D_on\"><img id=\"leftmenu_6_3_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_6_3\" style=\"cursor: pointer;\" mvUrl=\"msg.statistics.defPrgsSts.do\">결함총괄표</a></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                </table></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"15\">&nbsp;</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                            </table></td>\r\n");
      out.write("\t\t\t                                        <td width=\"15\" valign=\"top\"><img id=\"hide_6\" src=\"images/left_tab_hide.jpg\" style=\"cursor: pointer;\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\"></td>\r\n");
      out.write("\t\t\t                                      </tr>\r\n");
      out.write("\t\t\t                                  </table></td>\r\n");
      out.write("\t\t\t                                </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        <!-- 06결함관리 LEFT 끝 -->\r\n");
      out.write("\r\n");
      out.write("                                    \t<!-- 02통계보고서 LEFT 시작 -->\r\n");
      out.write("\t\t\t                            <table id=\"left02_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display: none;\">\r\n");
      out.write("\t\t\t                                <tr>\r\n");
      out.write("\t\t\t                                  <td height=\"26\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t                                      <tr>\r\n");
      out.write("\t\t\t                                        <td width=\"5\" background=\"images/left_menu_bg_t_01.jpg\"><img src=\"images/left_menu_bg_t_01.jpg\" width=\"5\" height=\"33\"></td>\r\n");
      out.write("\t\t\t                                        <td width=\"171\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"images/lrft_menu_statistics.jpg\" alt=\"\" width=\"171\" height=\"47\">\r\n");
      out.write("\t\t\t                                            <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">진척현황</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"4\"></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td><table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_2_1_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_2_1\" style=\"cursor: pointer;\" mvUrl=\"msg.statistics.TestPrgsSts.do\">단계별 진척현황</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_2_2_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_2_2\" style=\"cursor: pointer;\" mvUrl=\"msg.statistics.prvtTestPrgsSts.do\">개인별 진척현황</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                </table></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"10\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                            </table></td>\r\n");
      out.write("\t\t\t                                        <td width=\"15\" valign=\"top\"><img id=\"hide_2\" src=\"images/left_tab_hide.jpg\" style=\"cursor: pointer;\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\"></td>\r\n");
      out.write("\t\t\t                                      </tr>\r\n");
      out.write("\t\t\t                                  </table></td>\r\n");
      out.write("\t\t\t                                </tr>\r\n");
      out.write("\t\t\t                            </table>\r\n");
      out.write("                                    \t<!-- 02통계보고서 LEFT 끝 -->\r\n");
      out.write("                                    \t\r\n");
      out.write("                                    \t<!-- 03나의 테스트환경 LEFT 시작 -->\r\n");
      out.write("                                        <table id=\"left03_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display: none;\">\r\n");
      out.write("\t\t\t                                <tr>\r\n");
      out.write("\t\t\t                                  <td height=\"26\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t                                      <tr>\r\n");
      out.write("\t\t\t                                        <td width=\"5\" background=\"images/left_menu_bg_t_01.jpg\"><img src=\"images/left_menu_bg_t_01.jpg\" width=\"5\" height=\"33\"></td>\r\n");
      out.write("\t\t\t                                        <td width=\"171\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"images/lrft_menu_mytest.jpg\" alt=\"\" width=\"171\" height=\"47\">\r\n");
      out.write("\t\t\t                                            <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"18\" class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">나의 프로젝트 정보관리</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"4\"></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td><table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_3_1_img\" src=\"images/left_menu_bullet_02.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_3_1\" style=\"cursor: pointer;\" mvUrl=\"msg.myQalty.myQalty.do\">나의 프로젝트 정보설정</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_3_3_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_3_3\" style=\"cursor: pointer;\" mvUrl=\"msg.myConfiguration.myConfiguration.do\">테스트대상시스템 설정</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_3_4_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_3_4\" style=\"cursor: pointer;\" >비밀번호 변경</a></span></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                    <tr>\r\n");
      out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                    </tr>\r\n");
      out.write("\t\t\t                                                </table></td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                              <tr>\r\n");
      out.write("\t\t\t                                                <td height=\"15\">&nbsp;</td>\r\n");
      out.write("\t\t\t                                              </tr>\r\n");
      out.write("\t\t\t                                            </table></td>\r\n");
      out.write("\t\t\t                                        <td width=\"15\" valign=\"top\"><img id=\"hide_3\" src=\"images/left_tab_hide.jpg\" style=\"cursor: pointer;\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\"></td>\r\n");
      out.write("\t\t\t                                      </tr>\r\n");
      out.write("\t\t\t                                  </table></td>\r\n");
      out.write("\t\t\t                                </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        <!-- 03 테스트환경 LEFT 끝 -->\r\n");
      out.write("                                        <!-- 04 시스템 관리 LEFT 시작 -->\r\n");
      out.write("                                        <table id=\"left04_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display: none;\">\r\n");
      out.write("\t\t\t                                <tr>\r\n");
      out.write("\t\t\t                                  <td height=\"26\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t                                      <tr>\r\n");
      out.write("\t\t\t                                        <td width=\"5\" background=\"images/left_menu_bg_t_01.jpg\"><img src=\"images/left_menu_bg_t_01.jpg\" width=\"5\" height=\"33\"></td>\r\n");
      out.write("\t\t\t                                        <td width=\"171\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"images/lrft_menu_system.jpg\" alt=\"\" width=\"171\" height=\"47\">\r\n");
      out.write("\t\t\t                                          <table width=\"160\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                            <tr>\r\n");
      out.write("\t\t\t                                              <td height=\"18\" class=\"left_menu_1D_on\"><img src=\"images/left_menu_bullet.gif\" width=\"11\" height=\"14\" hspace=\"5\" vspace=\"3\" align=\"absmiddle\">시스템 관리</td>\r\n");
      out.write("\t\t\t                                            </tr>\r\n");
      out.write("\t\t\t                                            <tr>\r\n");
      out.write("\t\t\t                                              <td height=\"4\"></td>\r\n");
      out.write("\t\t\t                                            </tr>\r\n");
      out.write("\t\t\t                                            <tr>\r\n");
      out.write("\t\t\t                                              <td><table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td height=\"20\"><span class=\"left_menu_2D_off\"><img id=\"leftmenu_4_1_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_4_1\" style=\"cursor: pointer;\" mvUrl=\"cmn.sysmng.loggerMng.do\">로그레벨 관리</a></span></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_4_2_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_4_2\" style=\"cursor: pointer;\" mvUrl=\"cmn.sysmng.sysEnvVarMng.do\">시스템 환경변수 조회</a></span></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td height=\"7\" background=\"images/left_menu_line.jpg\"></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_4_3_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_4_3\" style=\"cursor: pointer;\" mvUrl=\"cmn.sysmng.dBConfMng.do\">DB 설정 관리</a></span></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <!-- <tr>\r\n");
      out.write("\t\t\t                                                    <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_4_4_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_4_4\" style=\"cursor: pointer;\" >라이센스</a></span></td>\r\n");
      out.write("\t\t\t                                                  </tr>\r\n");
      out.write("\t\t\t                                                  <tr>\r\n");
      out.write("\t\t\t                                                    <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
      out.write("\t\t\t                                                  </tr> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t                                              </table></td>\r\n");
      out.write("\t\t\t                                            </tr>\r\n");
      out.write("\t\t\t                                            <tr>\r\n");
      out.write("\t\t\t                                              <td height=\"15\">&nbsp;</td>\r\n");
      out.write("\t\t\t                                            </tr>\r\n");
      out.write("\t\t\t                                          </table>\r\n");
      out.write("\t\t\t                                    </td>\r\n");
      out.write("\t\t\t                                        <td width=\"15\" valign=\"top\"><img id=\"hide_4\" src=\"images/left_tab_hide.jpg\" style=\"cursor: pointer;\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\"></td>\r\n");
      out.write("\t\t\t                                      </tr>\r\n");
      out.write("\t\t\t                                  </table></td>\r\n");
      out.write("\t\t\t                                </tr>\r\n");
      out.write("\t\t\t                            </table>\r\n");
      out.write("                                        <!-- 04 시스템 관리 LEFT 끝 -->\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><img src=\"images/left_menu_img_03.jpg\" alt=\"\" width=\"186\" height=\"2\"></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <!-- 접속 서버 시작 -->\r\n");
      out.write("                           ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            <!-- 접속 서버 끝 -->\r\n");
      out.write("                             <!-- <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                            <tr>\r\n");
      out.write("                            \t<td height=\"10\" colspan=\"3\"></td>\r\n");
      out.write("                               </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td width=\"4\"></td>\r\n");
      out.write("                                <td width=\"173\" valign=\"middle\" bgcolor=\"#c2c2c2\" >\r\n");
      out.write("                                <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\">\r\n");
      out.write("                                  <tr>\r\n");
      out.write("                                    <td height=\"30\" bgcolor=\"#FFFFFF\">&nbsp;<img src=\"images/ico_pdf.gif\" width=\"13\" height=\"13\" align=\"absmiddle\">&nbsp;&nbsp;&nbsp;<a href=\"javascript:fileDownload('document/messageTestRo_menual_V1.0.pdf');\" ><strong>사용자메뉴얼 </strong></span></td>\r\n");
      out.write("                                  </tr>\r\n");
      out.write("                                </table></td>\r\n");
      out.write("                                <td width=\"14\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                            </table> -->\r\n");
      out.write("                       </td>\r\n");
      out.write("                       \r\n");
      out.write("                       <td id=\"h_left_menu_area\" width=\"0\" width=\"0\" valign=\"top\" background=\"\" style=\"display: none;\">\r\n");
      out.write("                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><img src=\"images/left_menu_img_01.jpg\" alt=\"\" width=\"0\" height=\"28\"></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td background=\"\">\r\n");
      out.write("\r\n");
      out.write("                                        <!-- 04 시스템 관리 LEFT 시작 -->\r\n");
      out.write("                                        <table id=\"left04_tb\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("\t\t\t                                <tr>\r\n");
      out.write("\t\t\t                                  <td height=\"26\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t                                      <tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t                                        <td  valign=\"top\"><img id=\"show_1\" src=\"images/left_tab_hide.jpg\" name=\"Image29\" width=\"15\" height=\"77\" border=\"0\" style=\"cursor: pointer;\"></td>\r\n");
      out.write("\t\t\t                                      </tr>\r\n");
      out.write("\t\t\t                                  </table></td>\r\n");
      out.write("\t\t\t                                </tr>\r\n");
      out.write("\t\t\t                            </table>\r\n");
      out.write("                                        <!-- 04 시스템 관리 LEFT 끝 -->\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><img src=\"images/left_menu_img_03.jpg\" alt=\"\" width=\"0\" height=\"0\"></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            </td>");
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
    // /WEB-INF/view/cmn/leftMenu.jsp(49,62) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'01' == sessionScope.userinfo.usrlevel || '02' == sessionScope.userinfo.usrlevel}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                              <tr>\r\n");
        out.write("                                                                <td><table width=\"150\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
        out.write("                                                                    <tr>\r\n");
        out.write("                                                                      <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_1_2_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_1_2\" style=\"cursor: pointer;\" mvUrl=\"msg.layout.layoutMng.do\">전문관리</a></span></td>\r\n");
        out.write("                                                                    </tr>\r\n");
        out.write("                                                                    <tr>\r\n");
        out.write("                                                                      <td height=\"3\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
        out.write("                                                                    </tr>\r\n");
        out.write("                                                                </table></td>\r\n");
        out.write("                                                              </tr>\r\n");
        out.write("                                                              ");
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

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/view/cmn/leftMenu.jsp(267,55) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.usrlevel != '03' }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t                                                    <tr>\r\n");
        out.write("\t\t\t                                                      <td><span class=\"left_menu_2D_off\"><img id=\"leftmenu_3_2_img\" src=\"images/left_menu_bullet_03.jpg\" align=\"absmiddle\" hspace=\"6\" width=\"3\" height=\"8\"><a id=\"leftmenu_3_2\" style=\"cursor: pointer;\" mvUrl=\"msg.mngUser.mngUser.do\">사용자 정보관리</a></span></td>\r\n");
        out.write("\t\t\t                                                    </tr>\r\n");
        out.write("\t\t\t                                                    <tr>\r\n");
        out.write("\t\t\t                                                      <td height=\"7\" background=\"images/left_menu_line_02.jpg\"></td>\r\n");
        out.write("\t\t\t                                                    </tr>\r\n");
        out.write("\t\t\t                                                    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/view/cmn/leftMenu.jsp(354,27) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${null != sessionScope.userinfo.connsevrdstcd}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                           <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("                            <tr>\r\n");
        out.write("                            \t<td height=\"10\" colspan=\"3\"></td>\r\n");
        out.write("                               </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td width=\"4\"></td>\r\n");
        out.write("                                <td width=\"173\" valign=\"middle\" bgcolor=\"#c2c2c2\" >\r\n");
        out.write("                                <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\">\r\n");
        out.write("                                  <tr>\r\n");
        out.write("                                    <td height=\"30\" bgcolor=\"#FFFFFF\" align=\"center\">\r\n");
        out.write("                                    \t<img src=\"images/img_server.jpg\" width=\"22\" height=\"21\" align=\"absmiddle\"> <strong>테스트대상시스템<br/>\r\n");
        out.write("                                    \t<span class=\"sub_titid\" style=\"padding-left: 0px\">[ ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.connsevrdstcdnm}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(" ]</span></strong>\r\n");
        out.write("                                    </td>\r\n");
        out.write("                                  </tr>\r\n");
        out.write("                                </table></td>\r\n");
        out.write("                                <td width=\"14\" valign=\"top\">&nbsp;</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                            </table>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
