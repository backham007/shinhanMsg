package org.apache.jsp.WEB_002dINF.view.msg.report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
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
      out.write("                           \t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td height=\"10\" colspan=\"2\"></td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"sub_tit02\">거래정보</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                           \t<table width=\"100%\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                           \t  <tr>\r\n");
      out.write("                                <td width=\"150\" class=\"tm_left_slim\">거래코드</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.trancd}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">거래코드 명</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tranname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">체크포인트</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.chekyn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">성공실패 여부</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.rsultsucssyn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td height=\"10\" colspan=\"2\"></td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"sub_tit02\">테스트데이터 정보</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <table width=\"100%\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td width=\"150\" class=\"tm_left_slim\">테스트데이터 ID</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tsdataid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td width=\"150\" class=\"tm_left_slim\">테스트데이터 수행회차</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.acmplnth}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">테스트데이터 명</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tsdataname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">테스트데이터 설명</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tsdatadesc}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">테스트 시작/종료 일시</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.teststartyms}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.testendyms}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                                <td class=\"tm_left_slim\">테스트 경과시간</td>\r\n");
      out.write("                                <td class=\"tm_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.elapsedtime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" ms</td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                            </table>");
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

  private boolean _jspx_meth_c_005fchoose_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                           \t  ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                              ");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/view/msg/report/testResult.jsp(30,30) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gubun == '01'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td height=\"10\" colspan=\"2\"></td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td class=\"sub_tit02\">테스트케이스 정보</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                            </table>\r\n");
        out.write("                            <table width=\"100%\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#baccdc\">\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td width=\"150\" class=\"tm_left_slim\">테스트케이스 ID</td>\r\n");
        out.write("                                <td class=\"tm_text\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tscaseid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td class=\"tm_left_slim\">테스트케이스 명</td>\r\n");
        out.write("                                <td class=\"tm_text\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tscasename}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td class=\"tm_left_slim\">테스트케이스 설명</td>\r\n");
        out.write("                                <td class=\"tm_text\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tscasedesc}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                            </table>\r\n");
        out.write("                              ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/view/msg/report/testResult.jsp(54,30) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gubun == '02'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td height=\"10\" colspan=\"2\"></td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td class=\"sub_tit02\">테스트시나리오 정보</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                            </table>\r\n");
        out.write("                            <table width=\"100%\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#baccdc\">  \r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td width=\"150\" class=\"tm_left_slim\">테스트시나리오 ID</td>\r\n");
        out.write("                                <td class=\"tm_text\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tssnrioid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td class=\"tm_left_slim\">테스트시나리오 명</td>\r\n");
        out.write("                                <td class=\"tm_text\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tssnrioname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                              <tr>\r\n");
        out.write("                                <td class=\"tm_left_slim\">테스트시나리오 설명</td>\r\n");
        out.write("                                <td class=\"tm_text\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rptTsResult.tssnriodesc}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("                              </tr>\r\n");
        out.write("                            </table>\r\n");
        out.write("                              ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }
}
