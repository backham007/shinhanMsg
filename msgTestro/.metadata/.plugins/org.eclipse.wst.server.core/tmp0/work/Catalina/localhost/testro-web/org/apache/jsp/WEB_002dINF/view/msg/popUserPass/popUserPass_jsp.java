package org.apache.jsp.WEB_002dINF.view.msg.popUserPass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class popUserPass_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqgrid/js/src/css/ui.jqgrid.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    font-size: 75%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/src/i18n/grid.locale-en.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery.jqGrid.src.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/popupcalendar.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/util.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// iframe resize\r\n");
      out.write("function autoResize(i)\r\n");
      out.write("{\r\n");
      out.write("    var iframeHeight=\r\n");
      out.write("    (i).contentWindow.document.body.scrollHeight;\r\n");
      out.write("    (i).height=iframeHeight+20;\r\n");
      out.write("}\r\n");
      out.write("function MM_openBrWindow(theURL,winName,features) { //v2.0\r\n");
      out.write("  window.open(theURL,winName,features);\r\n");
      out.write("}\r\n");
      out.write("//비밀번호 저장\r\n");
      out.write("function doPassSave(){\r\n");
      out.write("\tvar usrID = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userinfo.usrid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';    //사용자id\r\n");
      out.write("\tvar oldPass = $(\"#oldPass\").val();\r\n");
      out.write("\tvar newPass1 = $(\"#newPass1\").val();\r\n");
      out.write("\tvar newPass2 = $(\"#newPass2\").val();\r\n");
      out.write("\tif(oldPass == \"\"){\r\n");
      out.write("\t\talert(\"기존 비밀번호를 입력하세요\");\r\n");
      out.write("\t\tfrm.oldPass.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(newPass1 == \"\"){\r\n");
      out.write("\t\talert(\"신규 비밀번호를 입력하세요\");\r\n");
      out.write("\t\tfrm.newPass1.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(newPass1.length < 5){\r\n");
      out.write("\t\talert(\"비밀번호는 5자 이상입니다.\");\r\n");
      out.write("\t\tfrm.newPass1.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(newPass2 == \"\"){\r\n");
      out.write("\t\talert(\"신규 비밀번호확인을 입력하세요\");\r\n");
      out.write("\t\tfrm.newPass2.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(newPass1 != newPass2){\r\n");
      out.write("\t\talert(\"신규 비밀번호가 확인과 동일하지 않습니다.\");\r\n");
      out.write("\t\tfrm.newPass1.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t$.blockUI(); //block시작\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type:\"POST\",\r\n");
      out.write("\t\tdata:{\r\n");
      out.write("\t\t\t\"usrID\":usrID,\r\n");
      out.write("\t\t\t\"oldPass\":$(\"#oldPass\").val(),\r\n");
      out.write("\t\t\t\"newPass1\":$(\"#newPass1\").val(),\r\n");
      out.write("\t\t\t\"newPass2\":$(\"#newPass2\").val()\r\n");
      out.write("\t\t},\r\n");
      out.write("        dataType:\"json\",\r\n");
      out.write("        async : true,\r\n");
      out.write("        url:\"msg.userPassSave.popUserPass.do\",\r\n");
      out.write("        success:function(data, status) {\r\n");
      out.write("        \tif (data.errCd){\r\n");
      out.write("\t        \talert('에러코드 : ' + data.errCd + \"\\n에러메시지 : \" + data.errMsg);\r\n");
      out.write("\t        \t$.unblockUI(); //block시작\r\n");
      out.write("        \t}else{\r\n");
      out.write("\t            var intupdate = data.intupdate;\r\n");
      out.write("\t            if(intupdate == 1){\t\t\t\t\t\t\t\t//비밀번호가 변경 되었을 경우\r\n");
      out.write("\t\t\t\t\talert(\"비밀번호가 변경되었습니다.\");\r\n");
      out.write("\t\t\t\t\t$.unblockUI(); //block시작\r\n");
      out.write("\t\t\t\t\twindow.returnValue = intupdate;\r\n");
      out.write("\t\t\t\t\twindow.close();\r\n");
      out.write("\t            }else{\t\t\t\t\t\t\t\t\t\t\t//비밀번호가 틀리게 입력한 경우\r\n");
      out.write("\t            \talert(\"기존 비밀번호가 틀립니다.\");\r\n");
      out.write("\t            \t$.unblockUI(); //block시작\r\n");
      out.write("\t            \treturn false;\r\n");
      out.write("\t            }\r\n");
      out.write("        \t}\r\n");
      out.write("        },\r\n");
      out.write("        error:function(request, status, error) {\r\n");
      out.write("        \talert(\"비밀번호 변경중에 오류가 발생하였습니다.[\" + error + \"]\"); \r\n");
      out.write("        \t$.unblockUI(); //block시작\r\n");
      out.write("        \treturn false;\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("<form name=\"frm\" method=\"post\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"43\"><img src=\"images/pop_tit_01.gif\" width=\"43\" height=\"51\"></td>\r\n");
      out.write("    <td background=\"images/pop_tit_02.gif\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td class=\"pop_tit\">비밀번호 변경</td>\r\n");
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
      out.write("                            <td width=\"130\" class=\"box_txt_red\">기존 비밀번호 :</td>\r\n");
      out.write("                            <td><input name=\"oldPass\" id=\"oldPass\" type=\"password\" class=\"input_topinq\" style=\"width:200px\" maxlength=\"15\" onpaste=\"javascript:return false;\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("\t                         <tr>\r\n");
      out.write("\t\t                     \t<td height=\"5\" colspan=\"3\"></td>\r\n");
      out.write("\t\t                     </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td class=\"box_txt_red\">신규 비밀번호 :</td>\r\n");
      out.write("                            <td><input name=\"newPass1\" id=\"newPass1\"type=\"password\" class=\"input_topinq\" style=\"width:200px\" maxlength=\"15\" onpaste=\"javascript:return false;\">\r\n");
      out.write("                              <span class=\"point_result\">(5자 이상)</span></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td class=\"box_txt_red\">신규 비밀번호 확인 :</td>\r\n");
      out.write("                            <td><input name=\"newPass2\" id=\"newPass2\" type=\"password\" class=\"input_topinq\" style=\"width:200px\" maxlength=\"15\" onpaste=\"javascript:return false;\"></td>\r\n");
      out.write("                          </tr>\r\n");
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
      out.write("                  <td><table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                        <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor:pointer\" onclick=\"doPassSave(); return false;\" >저 장</td>\r\n");
      out.write("                        <td width=\"10\" background=\"images/btn_img_03.gif\">&nbsp;</td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                  </table>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  <td ><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"16\" height=\"21\" background=\"images/btn_img_01.gif\">&nbsp;</td>\r\n");
      out.write("                          <td background=\"images/btn_img_02.gif\" class=\"btn_text\" style=\"cursor: pointer;\" onclick=\"window.close(); return false;\">닫 기</td>\r\n");
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
      out.write("</form>\r\n");
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
