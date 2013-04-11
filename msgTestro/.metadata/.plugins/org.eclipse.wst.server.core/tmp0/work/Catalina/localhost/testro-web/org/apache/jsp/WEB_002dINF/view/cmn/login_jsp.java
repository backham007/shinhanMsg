package org.apache.jsp.WEB_002dINF.view.cmn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/TESTRO.ico\" type=\"image/ico\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-image: url();\r\n");
      out.write("\tbackground-repeat: repeat;\r\n");
      out.write("\tbackground-color: #bebebe;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("-->\r\n");
      out.write("</style></head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jqgrid/js/jquery-1.5.2.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.blockUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/login.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/common.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cmn/jquery.cookie.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$.cookie('top_menu', '', { expires: -1 });\r\n");
      out.write("\t$.cookie('left_menu', '', { expires: -1 });\r\n");
      out.write("});\r\n");
      out.write("function loginCheck(){\r\n");
      out.write("\tvar usrid = trim(document.frm.usrid.value);\r\n");
      out.write("\tvar usrpwd =  trim(document.frm.usrpwd.value);\r\n");
      out.write("\tif(usrid == \"\"){\r\n");
      out.write("\t\talert('아이디를 입력하세요.');\r\n");
      out.write("\t\tdocument.frm.usrid.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(usrpwd == \"\"){\r\n");
      out.write("\t\talert('패스워드를 입력하세요.');\r\n");
      out.write("\t\tdocument.frm.usrpwd.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\tif($(\"#checkbox\").is(\":checked\")){\r\n");
      out.write("\t\tsetCookie(\"usrid\", document.frm.usrid.value);\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tsetCookie(\"usrid\", \"\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t    type: \"POST\",\r\n");
      out.write("\t    url:'cmn.login.excutelogin.do',\r\n");
      out.write("\t    dataType:'json',\r\n");
      out.write("\t    data:{\"usrid\":usrid,\"usrpwd\":usrpwd},\r\n");
      out.write("\t    success: function(xhr){\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\t//오류코드 처리\r\n");
      out.write("\t\t\tif(xhr.errCd){\r\n");
      out.write("\t\t\t\talert('에러코드 : ' + xhr.errCd + \"\\n에러메시지 : \" + xhr.errMsg);\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t    \tif(\"\" != xhr.message && 'undefined' != xhr.message){ //로그인 오류 메세지\r\n");
      out.write("\t    \t\talert(xhr.message);\r\n");
      out.write("\t    \t\treturn;\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tvar left = 0;\r\n");
      out.write("\t\t\tvar top = 0;\r\n");
      out.write("\t\t\tvar screenWidth = screen.availWidth;\r\n");
      out.write("\t\t\tvar screenHeight = screen.availHeight;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar width, height;\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(screenWidth <= 1024 || screenHeight <= 768){ // 1024 X 768\r\n");
      out.write("\t\t\t\twidth = 1020;\r\n");
      out.write("\t\t\t\theight = 680;\r\n");
      out.write("\t\t\t}else{\t// 1280 X 1024\r\n");
      out.write("\t\t\t\twidth = 1276;\r\n");
      out.write("\t\t\t\theight = 800;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t    \tvar temp = xhr.userinfo;\r\n");
      out.write("\t    \tif(\"testro01\" == temp.usrpwd){ //초기생성자의 경우 패스워드 변경을 꼭해야함.\r\n");
      out.write("\t    \t\tvar url = \"msg.popUserPass.popUserPass.do\";\r\n");
      out.write("\t    \t    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=470px; dialogHeight=206px; scroll:no; status:no; help:no; resizable:no; location:no; ');\r\n");
      out.write("\t    \t    \r\n");
      out.write("\t    \t    if( \"1\" != returnValue ){//패스워드를 변경안하고 창을 닫으면 다음페이지로 이동불가.\r\n");
      out.write("\t    \t    \t$.ajax({\r\n");
      out.write("\t    \t\t\t\ttype : \"POST\",\r\n");
      out.write("\t    \t\t\t\tasync : true,\r\n");
      out.write("\t    \t\t\t\turl : \"cmn.login.excutelogout.do\",\r\n");
      out.write("\t    \t\t\t\tsuccess: function(data){\r\n");
      out.write("\r\n");
      out.write("\t    \t\t\t\t}\r\n");
      out.write("\t    \t\t\t});\r\n");
      out.write("\t    \t    \treturn;\r\n");
      out.write("\t    \t    }\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \t$.cookie('top_menu', 'top_menu_03');\r\n");
      out.write("\t    \t$(location).attr('href',\"msg.myQalty.myQalty.do\"); \r\n");
      out.write("\t    },\r\n");
      out.write("\t    error: function (request, status, error) { \r\n");
      out.write("\t    \talert(\"로그인중에 오류가 발생하였습니다.[\" + error + \"]\"); \r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<body onload=\"loadpage();\">\r\n");
      out.write("<form name = \"frm\" action=\"#\" method=\"post\">\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("  <table width=\"747\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td colspan=\"4\"><img src=\"images/login_01.jpg\" width=\"747\" height=\"208\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td height=\"303\" rowspan=\"2\"><img src=\"images/login_02_01.jpg\" width=\"85\" height=\"303\"></td>\r\n");
      out.write("      <td rowspan=\"2\"><img src=\"images/login_02_02.jpg\" width=\"236\" height=\"303\"></td>\r\n");
      out.write("      <td width=\"307\"><img src=\"images/login_logo_message.jpg\" width=\"307\" height=\"138\"></td>\r\n");
      out.write("      <td rowspan=\"2\"><img src=\"images/login_02_04.jpg\" width=\"119\" height=\"303\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td height=\"165\" valign=\"top\" style=\"text-align: \" background=\"images/login_input_bg.jpg\">\r\n");
      out.write("      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"51\" colspan=\"3\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><img src=\"images/login_input_02.jpg\" width=\"85\" height=\"22\" /></td>\r\n");
      out.write("          <td width=\"133\"><input name=\"usrid\" id=\"usrid\" maxlength=\"30\" type=\"text\" class=\"login_input\" style=\"width:120px;ime-mode:disabled;\" onkeydown=\"if(event.keyCode ==13){javascript:loginCheck();}\" /></td>\r\n");
      out.write("          <td rowspan=\"2\" width=\"87\"><a style=\"cursor: pointer; \" onclick=\"javascript:loginCheck();\"><img src=\"images/login_input_04.jpg\" width=\"69\" height=\"40\" style=\"border:0px\"/></a></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><img src=\"images/login_input_03.jpg\" width=\"85\" height=\"22\" /></td>\r\n");
      out.write("          <td><input name=\"usrpwd\" id=\"usrpwd\" type=\"password\" maxlength=\"30\" class=\"login_input\" style=\"width:120px;ime-mode:disabled;\" onkeydown=\"if(event.keyCode ==13){javascript:loginCheck();}\"/></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td colspan=\"3\" align=\"right\"><label>\r\n");
      out.write("            <input type=\"checkbox\" name=\"checkbox\" id=\"checkbox\">\r\n");
      out.write("            <img src=\"images/login_save.jpg\" width=\"82\" height=\"17\" vspace=\"5\" align=\"absmiddle\"></label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      <span  class=\"point_text\">*TestRo는 화면 해상도 1280*1024에 최적화 되어 있습니다.</span>\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    \r\n");
      out.write("    <tr>\r\n");
      out.write("      <td colspan=\"4\"><img src=\"images/login_03.jpg\" width=\"747\" height=\"115\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
