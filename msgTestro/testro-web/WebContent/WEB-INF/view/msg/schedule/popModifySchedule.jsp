<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/validation_v01.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/common.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/schedule/popModifySchedule.js" charset="utf-8"></script>
<script>
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
</script>
</head>

<body leftmargin="0" topmargin="0">
<form id="form">
<input name="jobSno" value="${result.jobSno}" type="hidden" />
<input id="pConnSevrDstCd" value="${result.connSevrDstCd}" type="hidden" />
<input id="jobResrvYms" name="jobResrvYms" value="${result.jobResrvYms}" type="hidden" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">테스트 예약설정</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
      <tr>
        <td bgcolor="#e1e9f0"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="5" cellspacing="1"  bgcolor="#baccdc">
              <tr>
                <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="2" cellspacing="0">
                        <tr>
                          <td width="140" class="box_txt_red">케이스/시나리오 ID :</td>
                          <td><input readonly="readonly" name="tsDataId" value="${result.tsDataId}" maxlength="20" type="text" class="input_topinq" style="width:200px"></td>
                          </tr>
                        <tr>
                          <td class="box_txt_red">케이스/시나리오 명 :</td>
                          <td><input readonly="readonly" name="testName" value="${result.testName}" maxlength="300" type="text" class="input_topinq" style="width:100%"></td>
                          </tr>
                        <tr>
                          <td class="box_txt_red">케이스/시나리오 설명  :</td>
                          <td><input readonly="readonly" name="testDesc" value="${result.testDesc}" maxlength="400" type="text" class="input_topinq" style="width:100%"></td>
                          </tr>
                        <tr>
                          <td class="box_txt_red">테스트 예약실행 일시 :</td>
                          <td><input id="prevDate" name="prevDate" type="text" readonly="readonly" class="input_topinq" style="width:65px">
                              <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer" onclick="popUpCalendar(this, 'prevDate', 'yyyy-mm-dd','CENTER','MIDDLE');">
                          	  <select id="hour" name="select"  class="menu" style="width:45px"></select> :
                              <select id="min" name="select"  class="menu" style="width:45px"></select>
<!--                              <input id="endDate"  type="text" maxlength="5" class="input_topinq" style="width:100px">-->
                          </td>
                          </tr>
                        <tr>
                          <td class="box_txt_red">테스트 대상시스템  :</td>
                          <td><select id="connSevrDstCd" name="connSevrDstCd" class="menu" style="width:120px"></select></td>
                          </tr>
                        <tr>
                          <td class="box_txt_red">테스트 예약실행 설명 :</td>
                          <td><input name="jobResrvCnt" value="${result.jobResrvCnt}" maxlength="200" type="text" class="input_topinq" style="width:100%"></td>
                          </tr>
                      </table></td>
                    </tr>
                </table></td>
              </tr>
            </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer" onclick="save();">저 장</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer" onclick="window.close();">닫 기</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    </td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<!-- Start of wrap -->
</body>

</html>
