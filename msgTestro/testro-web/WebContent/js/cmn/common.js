/************************************************************************************/
/* 전역변수 선언 영역                                                                   */
/************************************************************************************/
	var abc;
    var zipView;
    var gObjLawdCd;
    var gObjAddr;
    var gDateObj;
    var gJobGbn;
    var realNameView;
    var gObjOpenFrm;
    var gObjOpenJumin1;
    var gObjOpenJumin2;
    var gObjOpenName;
    var isMciTcMng=false;
    //단말세션 정보
    var termSessID="";
    //ATM세션 정보
    var ATMSessID="";
/************************************************************************************/
/* 전역 선언                                        */
/************************************************************************************/
    var gLawRemark = "";

/************************************************************************************/
/* 여기서부터는 공통 popup 관련 Script 임                                              */
/************************************************************************************/
/*
 * 달력 공통 POPUP
 * Parameter :
    dateObj : 날짜가 입력될 input 객체
    top     : 달력이 popup 될 top 위치   ('' 일 경우 '250')
    left    : 달력이 popup 될 left 위치  ('' 일 경우 '400')
    작성자     : 
 */
    function fncCalOpen(dateObj,top,left)
    {
        gDateObj = dateObj;
        if (top == '')
            top = '250';
        if (left == '')
            left = '400';

        option = 'status=no, toolbar=no, width=245, height=230,'+'top='+top+',left='+left;
        window.open( 'calendar.do', 'calendar', option );
    }


/*
 * 도움말  POPUP
 * Parameter :
    dateObj : 날짜가 입력될 input 객체
    top     : 달력이 popup 될 top 위치   ('' 일 경우 '250')
    left    : 달력이 popup 될 left 위치  ('' 일 경우 '400')
    작성자     : 
 */
    function fncHelpOpen(url)
    {
        var top = 0;
        var left =0;
        option = 'status=no, toolbar=no, width=780, height=599,'+'top='+top+',left='+left;
        window.open( url, 'help', option );
    }

/*
 * window open (사이즈 조절 불가)
 * 작성자  : 
 * Parameter :
    url : url (ex. 'zipView.do?cmp=retrieve')
    width : popup 창 width
    height : popup 창 height
    name : popup 창 name
    참고).  사용중
 */
    function newOpenNoResize( url, width, height, name )
    {
        var left = (window.screen.availWidth - width - 12)/2;
        var top  = (window.screen.availHeight - height - 32)/2;
        var option = "menubar=no, resizable=no, scrollbars=no, status=yes, titlebar=no, toolbar=no, "
                    + " left="+left+", top="+top+", width="+width+", height="+height;
        winName = window.open( url, name, option );
        return winName;
    }

/*
 * window open (사이즈 조절 가능)
 * 작성자  : 
 * Parameter :
    url : url (ex. 'zipView.do?cmp=retrieve')
    width : popup 창 width
    height : popup 창 height
    name : popup 창 name
    참고). 미사용
 */

    function newOpenResize( url, width, height, name )
    {
        var left = (window.screen.availWidth - width - 12)/2;
        var top  = (window.screen.availHeight - height - 32)/2;
        var option = "menubar=no, resizable=yes, scrollbars=auto, status=no, titlebar=no, toolbar=no, "
                    + " left="+left+", top="+top+", width="+width+", height="+height;
        winName = window.open( url, name, option );
        return winName;

    }
/************************************************************************************/
/* 여기서부터는 유효성 check 부분  (현재 사용중)                                            */
/************************************************************************************/
/*
 * 입력여부 check 후 오류일 경우 focus 이동
 *  작성자     : 
 * Parameter :
    obj : input 객체
    msgStr : Label (ex. '사용자 ID')
    참고).  사용중
 */
    function fncSpaceChecked(obj,msgStr)
    {
        if (trim(obj.value) == "")
        {
            alert("필수항목이 입력되지 않았습니다."+"("+msgStr+")");
            obj.focus();
            return true;
        }
        else return false;
    }

/*
 * 에러 메시지 처리 후 포커스를 넘김
 * Parameter : object, message
   참고).  사용
 */
function ErrMsg(obj, msg)
{
    alert(msg);
    obj.select();
    obj.focus();
}

/*
 * 입력값이 NULL인지 체크
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isNull(objValue)
{
    if(objValue == null || objValue == "")
        return true;

    return false;
}

/**
 * 입력값에 숫자만 있는지 체크
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isNum(objValue)
{
    var chars = "0123456789.";

    if(objValue == null || objValue == "") return false;

    return containsCharsOnly(objValue, chars);
}

/**
 * 입력값에 숫자만 있는지 체크
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isNumP(objValue)
{
    var chars = "0123456789.|";

    if(objValue == null || objValue == "") return false;

    return containsCharsOnly(objValue, chars);
}

/**
 * 입력값에 숫자만 있는지 체크
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isNumNoZ(objValue)
{
    var chars = "0123456789";

    if(objValue == null || objValue == "" || objValue == "0") return false;

    return containsCharsOnly(objValue, chars);
}

/**
 * 입력값이 특정 문자(chars)만으로 되어있는지 체크 (String값을 체크한다.)
 * 특정 문자만 허용하려 할 때 사용
 * ex) if (!containsCharsOnly(form.blood.value ,"ABO"))
 *     {
 *         alert("혈액형 필드에는 A,B,O 문자만 사용할 수 있습니다.");
 *     }
 * Parameter : value, chars
 * Return : true / false
   참고).  사용
 */
function containsCharsOnly(objValue, chars)
{
    for (inx=0; inx<objValue.length; inx++)
    {
        if (chars.indexOf(objValue.charAt(inx)) == -1) return false;
    }
    return true;
}
/*
 * 입력값의 영숫자여부 체크
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isNotAlphaOrNum(objValue)
{
     var ch = "\0";
    var flag = true;

    for(var i = 0, ch = objValue.charAt(i); (i<objValue.length) && (flag); ch = objValue.charAt(++i))
    {
        if      ((ch >= '0') && (ch <= '9')) flag = true;
        else if ((ch >= 'a') && (ch <= 'z')) flag = true;
        else if ((ch >= 'A') && (ch <= 'Z')) flag = true;
        else flag = false;
    }

    return flag;
}

/*
 * 입력값의 영(소문자)숫자여부 체크
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isNotAlphaSmallOrNum(objValue)
{
     var ch = "\0";
    var flag = true;

    for(var i = 0, ch = objValue.charAt(i); (i<objValue.length) && (flag); ch = objValue.charAt(++i))
    {
        if      ((ch >= '0') && (ch <= '9')) flag = true;
        else if ((ch >= 'a') && (ch <= 'z')) flag = true;
        else flag = false;
    }

    return flag;
}

/*
 * 입력값의 영숫자혼용여부 체크(반드시 혼용)
 * Parameter : value
 * Return : true / false
   참고).  사용
 */
function isAlphaNum(objValue)
{
    var ch = "\0";
    var a_flag = false;
    var n_flag = false;
    var flag = true;

    for(var i = 0, ch = objValue.charAt(i); (i<objValue.length) && (flag); ch = objValue.charAt(++i))
    {
        if      ((ch >= '0') && (ch <= '9')) n_flag = true;
        else if ((ch >= 'a') && (ch <= 'z')) a_flag = true;
        else if ((ch >= 'A') && (ch <= 'Z')) a_flag = true;
        else if ( ch == ' ' || ch == '~' || ch == '`' || ch == '\\'||
                  ch == '-' || ch == '_' || ch == '|' || ch == '+' ||
                  ch == '=' || ch == ',' || ch == '.' || ch == '/' ||
                  ch == '<' || ch == '>' || ch == '?' || ch == '!' ||
                  ch == '@' || ch == '#' || ch == '$' || ch == '%' ||
                  ch == '^' || ch == '&' || ch == '*' || ch == '(' ||
                  ch == ')' || ch == '\"' || ch == '[' || ch == '(' )
        {
            flag = false;
            n_flag = false;
            a_flag = false;
        }
    }
    if(n_flag && a_flag) flag = true;
    else flag = false;

    return flag;
}

/************************************************************************************/
/* 여기서부터는 유효성 check 부분  (현재 미사용)                                            */
/************************************************************************************/
/*
 * 입력값에 스페이스 이외의 의미있는 값이 있는지 체크
 * Parameter : value
 * Return : true / false
 */
function isEmpty(objValue)
{
    if(objValue == null || objValue.replace(/ /gi,"") == "")
        return true;

    return false;
}

/*
 * 입력값의 한글여부 체크
 * Parameter : value
 * Return : true / false
 */
function isKorean(objValue)
{
     var ch = "\0";
    var flag = true;

    for(var i = 0, ch = objValue.charAt(i); (i<objValue.length) && (flag); ch = objValue.charAt(++i))
    {
        if      ((ch >= '0') && (ch <= '9')) flag = false;
        else if ((ch >= 'a') && (ch <= 'z')) flag = false;
        else if ((ch >= 'A') && (ch <= 'Z')) flag = false;
        else if ( ch == ' ' || ch == '~' || ch == '`' || ch == '\\'||
                  ch == '-' || ch == '_' || ch == '|' || ch == '+' ||
                  ch == '=' || ch == ',' || ch == '.' || ch == '/' ||
                  ch == '<' || ch == '>' || ch == '?' || ch == '!' ||
                  ch == '@' || ch == '#' || ch == '$' || ch == '%' ||
                  ch == '^' || ch == '&' || ch == '*' || ch == '(' ||
                  ch == ')' || ch == '\"' || ch == '[' || ch == '(' )
                  flag = false;
    }

    return flag;
}


/*
 * 입력값의 영문여부 체크
 * Parameter : value
 * Return : true / false
 */
function isAlpha(objValue)
{
    var input = trim(objValue);
    var ch = "\0";
    var flag = true;

    if(input.length > 0)
    {
        if((!(input.charAt(0) >= 'a') && (input.charAt(0) <= 'z')) ||
           (!(input.charAt(0) >= 'A') && (input.charAt(0) <= 'Z')))
        {
            flag = false;
        }
    }
    for (var i = 0, ch = input.charAt(i); (i<input.length) && (flag); ch = input.charAt(++i))
    {
        if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) flag = false;
    }

    return flag;
}

/*
 * 입력값의 전화번호 여부 체크
 * Parameter : value
 * Return : true / false
 */
function isTelNum(objValue)
{
    var chars = "0123456789-()";

    if(objValue == null || objValue == "" || objValue == "0") return false;

    return containsCharsOnly(objValue, chars);
}

/*
 * 주민등록번호 체크
 * Parameter : value
 * Return : true / false
 */
function isValidSSN(objValue)
{
    var year   = objValue.substring(0,2);
    var month  = objValue.substring(2,4);
    var day    = objValue.substring(4,6);
    var sex    = objValue.substring(6,7);
    var result = false;

    if     (sex=="1" || sex=="2")
        year="19"+year;
    else if(sex=="3" || sex=="4")
        year="20"+year;

    if(isValidMonth(month) && isValidDay(year, month, day))
    {
        var check   = 0;
        var frontNo = objValue.substring(0, 6);
        var rearNo  = objValue.substring(6,13);

        for(var i=0; i<= 5; i++)
            check = check + (( i % 8 + 2 )* parseInt(frontNo.substring(i,i+1)));

        for(var i=6; i<=11; i++)
            check = check + (( i % 8 + 2 )* parseInt(rearNo.substring(i-6,i-5)));

        check = 11 - (check % 11);
        check = check % 10;

        if(check == parseInt(objValue.substring(12,13)))
            result=true;
    }

    return result;
}


/*
 * 테이블 Row 선택시 화면 표시
 * Parameter : LayerName
 */
var preEl;
var orgBColor;
var orgTColor;
function selectRow()
{
    backColor = "#efe9ec";
    textColor = "#0000ff";

    if(typeof(preEl) != 'undefined')
    {
        preEl.bgColor = orgBColor;
        try
        {
            ChangeTextColor(preEl, orgTColor);
        }
        catch(e) {;}
    }

    var el = event.srcElement;
    el = el.parentElement;
    orgBColor  = el.bgColor;
    orgTColor  = el.style.color;
    el.bgColor = backColor;

    try
    {
        ChangeTextColor(el, textColor);
    }
    catch(e) {;}
    preEl = el;
}

function ChangeTextColor(a_obj, a_color)
{
    for (i=0; i<a_obj.cells.length; i++) //put condition before increase!!!!!
        a_obj.cells(i).style.color = a_color;

}

/**
 *   Enter Key를 Check 한다.
 *   return :true / false
 */
function isEnterKey()
{
    if (window.event.keyCode == 13)
    {
        return true;
    }

    return false;
}


/**
 *   문자열에서 token을 뽑아 배열로 리턴한다.
 */
function makeToken(str, delim)
{
    var array= str.split(delim);
    return array;
}

//양쪽 공백 제거
String.prototype.trim = function() {   
    return this.replace(/^\s+|\s+$/g,"");   
}   
  
//왼쪽 공백 제거
String.prototype.ltrim = function() {   
    return this.replace(/^\s+/,"");      
}   
   
//오늘쪽 공백 제거
String.prototype.rtrim = function() {   
    return this.replace(/\s+$/,"");      
}  

/**
 *   입력된 값의 양쪽 공백을 제거한다.
 */
function trim(inputValue)
{
    //leading space
    while(''+inputValue.charAt(0)==' ')
    {
        inputValue = inputValue.substring(1,inputValue.length);
    }
    //trailing space
    while(''+inputValue.charAt(inputValue.length-1)==' ')
    {
        inputValue = inputValue.substring(0,inputValue.length-1);
    }
    return inputValue;
}


function enterKey(obj, method)
{
    keynum = event.keyCode;

    if(keynum == 13)
    {
        eval(method);
        if(obj.getAttribute("submit") != "")
            window.event.keyCode = 9;
    }
}

function nextFocus()
{
    window.event.keyCode = 9;
}

function delKey(obj1, obj2)
{
    if(event.keyCode == 46)
    {
        obj1.value = "";
        obj2.value = "";
    }
}
/*
function click()
{
    if ((event.button==2) || (event.button==3))
    {
        alert("오른쪽 마우스 버튼은 사용하실 수 없습니다.");
    }
}

document.onmousedown=click;

var statusFlag = true;
*/
function statusFrame()
{
    if(statusFlag)
    {
        top.mainFrame.mainFrameSet.cols = "0, *";
        top.topFrame.imgMenu.src = "/images/topLogo3.gif";
        statusFlag = false;
    }
    else
    {
        top.mainFrame.mainFrameSet.cols = "216, *";
        top.topFrame.imgMenu.src = "/images/topLogo2.gif";
        statusFlag = true;
    }
}

var ssn1 = null;
var orgClassName = null;

/*
 * 모든 object의 Validation 체크와 포맷을 맞춤
 * Parameter : object
 */
function checkValidation(obj)
{
    objVal = trim(obj.value);

    switch(obj.getAttribute("types"))
    {
        case "DATE":    // 날짜
            delDateDelim(obj);
            if(isValidDate(obj.value))
                addDateDelim(obj);
            else
            {
                alert(ERR_DAT001);
                return false;
            }
            break;

        case "TIME":    // 시간
            delTimeDelim(obj);
            if(isValidTime(obj.value))
                addTimeDelim(obj);
            else
            {
                alert(ERR_TIM001);
                return false;
            }
            break;

        case "HCHR":    // 한글 2자 이상ssssssssssssssss
            if(!isKorean(obj.value))              { alert(ERR_CHA001);    return false; }
            else if(getByteLength(obj.value) < 4) { alert(ERR_CHA002);    return false; }
            break;

        case "CHAR":    // 한글만
            if(!isKorean(obj.value))              { alert(ERR_CHA001);    return false; }
            break;

        case "NUMB":    // 숫자
            if(!isNum(obj.value)) { alert(ERR_NUM001); return false; }
            break;

        case "EVAL":    // 숫자와 영문만
            if(isKorean(obj.value))              { alert(ERR_CHA003);    return false; }
            break;

        case "ALPH_NUM":    // 숫자와 영문만
            if(!isNotAlphaOrNum(objVal))          { alert(ERR_CHA003);    return false; }
            break;

        case "EVAL_BOTH":   // 숫자와 영문 (반드시 혼용)
            if(!isAlphaNum(obj.value))              { alert(ERR_CHA004);    return false; }
            break;

        case "TELNO":   // 숫자, '-', '(', ')'
            if(!isTelNum(obj.value))              { alert(ERR_NUM002);    return false; }
            break;
/*
        case "SSN1":    // 주민등록번호 앞자리
            if(!isNum(obj.value))          { alert(ERR_SSN001); return false; }
            else if(obj.value.length != 6) { alert(ERR_SSN002); return false; }
            ssn1 = obj.value;
            break;

        case "SSN2":    // 주민등록번호 뒷자리
            if(!isNum(obj.value))          { alert(ERR_SSN001); return false; }
            else if(obj.value.length != 7) { alert(ERR_SSN003); return false; }
            ssn = ssn1 + obj.value;
            if(!isValidSSN(ssn))
            {
                ans = confirm(ERR_SSN004+"\n"+QST_MSG002);
                if(ans) ans = false;
                else    ans = true;
                return ans;
            }
            break; */
    }

    return true;
}

/*
 * 두 날짜값(시작일, 끝일)의 선후 체크
 */
function checkDates(sdateObj, edateObj)
{
    svdate = delDateDelimiter(sdateObj);
    evdate = delDateDelimiter(edateObj);

    if((evdate-svdate) < 0)
    {
//      alert("시작일이 마지막일 보다 큽니다. 다시 선택 하십시오.");
        return false;
    }
    return true;
}

/*
 * 게시판 : 조회마감일자 체크(오늘날짜 이후로만 입력가능)
 */
function checkBoardCDate(dateObj, curDate)
{
    cdate = delDateDelimiter(curDate);
    vdate = delDateDelimiter(dateObj);

    if((cdate-vdate) < 0)
    {
        return true;
    }else{
        alert("조회마감일자는 현재일자이후로 선택하십시오.");
        return false;
    }
}


/*
 * 오늘 날짜 이후 체크
 */
function checkCurrentDate(dateObj, curDate)
{
    cdate = delDateDelimiter(curDate);
    vdate = delDateDelimiter(dateObj);

    if((cdate-vdate) < 0)
    {
        alert("현재일 보다 큽니다. 다시 선택 하십시오.");
        return false;
    }
    return true;
}

function checkCurrentDates(dateObj)
{
    var today = new Date();
    var tY = today.getYear ();
    var tM = today.getMonth()+1;
    var tD = today.getDate ();
    if (tM < 10) tM = "0" + tM;
    if (tD < 10) tD = "0" + tD;

    cdate = tY + "" + tM + "" + tD;

    vdate = dateObj.value.substring(0, 4) + dateObj.value.substring(5, 7) + dateObj.value.substring(8, 10);

    if((cdate-vdate) < 0)
    {
        alert("현재일 보다 큽니다. 다시 선택 하십시오.");
        return false;
    }
    return true;
}

function checkCurrDate(dateObj)
{
    var today = new Date();
    var tY = today.getYear ();
    var tM = today.getMonth()+1;
    var tD = today.getDate ();
    if (tM < 10) tM = "0" + tM;
    if (tD < 10) tD = "0" + tD;

    cdate = tY + "" + tM + "" + tD;

    vdate = dateObj.value.substring(0, 4) + dateObj.value.substring(5, 7) + dateObj.value.substring(8, 10);

    if((cdate-vdate) < 0)
    {
        alert("계약일은 오늘날짜까지만 입력이 가능합니다.");
        return false;
    }
    return true;
}

function checkDueYmd(dateObj)
{
    var today = new Date();
    var tY = today.getYear ();
    var tM = today.getMonth()+1;
    var tD = today.getDate ();
    if (tM < 10) tM = "0" + tM;
    if (tD < 10) tD = "0" + tD;

    cdate = tY + "" + tM + "" + tD;

    vdate = dateObj.value.substring(0, 4) + dateObj.value.substring(5, 7) + dateObj.value.substring(8, 10);

    if((cdate-vdate) > 0)
    {
        alert("만기일은 오늘날짜이후만 입력이 가능합니다.");
        return false;
    }
    return true;
}

function betweenDates(cDate, vDate, plan)
{
    sdate = beforeDate(delDateDelimiter(cDate), plan);

    if(sdate <= delDateDelimiter(vDate))
        return false;
    else
        return true;
}

/*
 * 금액을 한글과 표기
 * 작성자  : 
 * Parameter :
    srcNumber : 금액 (',' 구분자 빼고 넣어 넣기 ex. 33253535355)
    작성자     : 
 */
function convertAmt(srcNumber) {


    if  (srcNumber != "" && srcNumber != "0")
    {

            var i, j=0, k=0;

            var han1 = new Array("","일","이","삼","사","오","육","칠","팔","구");
            var han2 = new Array("","만 ","억 ","조 ","경 ","해 ","시 ","양 ","구 ","간 ");
            var han3 = new Array("","십","백","천");
            var result="";
            var hangul = srcNumber + "";
            var str = new Array(), str2="";
            var strTmp = new Array();


            //'-' 가 들어왔을 경우 return space
            if(hangul.substring(0,1) == "-")
            {
                return "";
            }

            for(i=hangul.length; i > 0; i=i-4){
                            str[j] = hangul.substring(i-4,i); //4자리씩 끊는다.
                            for(k=str[j].length;k>0;k--){
                                            strTmp[k] = (str[j].substring(k-1,k))?str[j].substring(k-1,k):"";
                                            strTmp[k] = han1[parseInt(strTmp[k])];
                                            if(strTmp[k]) strTmp[k] += han3[str[j].length-k];
                                            str2 = strTmp[k] + str2;
                            }
                            str[j] = str2;
                            if(str[j]) result = str[j]+han2[j]+result;
                            //4자리마다 한칸씩 띄워서 보여주는 부분. 우선은 주석처리
                            //result = (str[j])? " "+str[j]+han2[j]+result : " " + result;

                            j++; str2 = "";
            }
            if (result == "")
                return "";
            else return  trim(result) + "원";

    }
    else
    {
            return "";
    }
}

/*
 * 세자리마다 ',' 추가하기
 * 작성자  : 
 * Parameter :
    srcNumber : 금액
    작성자     : 
 */
function addComma(txtNumber) {

        if (isNaN(txtNumber))
        {//숫자인가 비교
            return "";
        }
        else
        {
        var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
        var arrNumber = txtNumber.split('.');
        arrNumber[0] += '.';
           do {
             arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
            } while (rxSplit.test(arrNumber[0]));

           if (arrNumber.length > 1) {
           return arrNumber.join('');
           }
           else {
           return arrNumber[0].split('.')[0];
                }
        }
}

//값 치환
function replaceVal(obj,thisone,thatone,gubun)
{
    if (gubun == "obj")
        str = obj.value;
    else
        str = obj;

    if (str == "")
        return "0";
    tmp ="";
    tmp_str ="";
    var Strlength = str.length;

    if(str != "")
    {
        for ( i=0;i<Strlength ;i++ )
        {
            onechar = str.substring(i,(i+1));
            if(onechar == thisone)
            {
                tmp_str = tmp_str + thatone;
            }
            else
            {
                tmp_str = tmp_str + onechar;
            }
        }
        tmp=tmp_str;
        if (gubun == "obj")
        {
            obj.value =  tmp;
            obj.focus()
            obj.select()
        }
        else
        {
            return tmp;
        }
    }
}

function openWin(f) {

    var testname =window.open('','popup','status=no,toolbar=no,resizable=no,scrollbars=no,fullscreen=7,top=50,left=200,width=535, height=270');

    f.submit();
    testname.focus()
}

/*
 * 외국인등록번호 체크
 * Parameter : reg_no : 외국인 등록번호
 * Return : true / false
 *  작성자     : 
 */
function fgn_no_chksum(reg_no) {
    var sum = 0;
    var odd = 0;

    buf = new Array(13);
    for (i = 0; i < 13; i++) buf[i] = parseInt(reg_no.charAt(i));

    odd = buf[7]*10 + buf[8];

    if (odd%2 != 0) {
      return false;
    }

    if ((buf[11] != 6)&&(buf[11] != 7)&&(buf[11] != 8)&&(buf[11] != 9)) {
      return false;
    }

    multipliers = [2,3,4,5,6,7,8,9,2,3,4,5];
    for (i = 0, sum = 0; i < 12; i++) sum += (buf[i] *= multipliers[i]);


    sum=11-(sum%11);

    if (sum>=10) sum-=10;

    sum += 2;

    if (sum>=10) sum-=10;

    if ( sum != buf[12]) {
        return false;
    }
    else {
        return true;
    }
}

/* 에러 메시지 처리 (debug(msg))
 * Parameter : message */
function debug(msg){    if(debugData){alert(msg);}}

/* 에러 메시지 처리용 함수 셋팅 (debug(msg))
 * Parameter : booleal */
var debugData = false;
function setDebug(bool){    debugData = bool;}


function chnImg(btn, gb) {


    if(btn=="reset") {
        if(document.getElementById("resetBtn").disabled != true) {
            if(gb=="in") {
                document.getElementById("resetImg").src = "images/btn_reset_02.jpg";        
            } else {
                document.getElementById("resetImg").src = "images/btn_reset_01.jpg";        
            }
        }
    } else if(btn=="save") {
        if(document.getElementById("regBtn").disabled != true) {
            if(gb=="in") {
            document.getElementById("saveImg").src = "images/btn_save_02.jpg";      
            } else {
            document.getElementById("saveImg").src = "images/btn_save_01.jpg";      
            }
        }
    } else if(btn=="save_template") {
        if(document.getElementById("regTempBtn")  != null  ){
            if(document.getElementById("regTempBtn").disabled != true) {
                if(gb=="in") {
                document.getElementById("save_templateImg").src = "images/btn_save_template_02.jpg";        
                } else {
                document.getElementById("save_templateImg").src = "images/btn_save_template_01.jpg";        
                }
            }
        }
        
    } else if(btn=="del") {
        if(document.getElementById("delBtn").disabled != true) {
            if(gb=="in") {
            document.getElementById("delImg").src = "images/btn_del_02.jpg";        
            } else {
            document.getElementById("delImg").src = "images/btn_del_01.jpg";        
            }
        }
    } else if(btn=="load") {
        if(document.getElementById("loadBtn").disabled != true) {
            if(gb=="in") {
            document.getElementById("loadImg").src = "images/btn_load_02.jpg";      
            } else {
            document.getElementById("loadImg").src = "images/btn_load_01.jpg";      
            }
        }
    } else if(btn=="template") {
        if(document.getElementById("templateBtn").disabled != true) {
            if(gb=="in") {
                document.getElementById("templateImg").src = "images/template_open1.jpg";       
            } else {
                document.getElementById("templateImg").src = "images/template_open2.jpg";       
            }
        }
    } else if(btn=="new") {
        if(document.getElementById("newBtn").disabled != true) {
            if(gb=="in") {
            document.getElementById("newImg").src = "images/btn_new_02.jpg";        
            } else {
            document.getElementById("newImg").src = "images/btn_new_01.jpg";        
            }
        }
    } else if(btn=="mod") {
        if(document.getElementById("modBtn").disabled != true) {
            if(gb=="in") {
            document.getElementById("modImg").src = "images/btn_mod_02.jpg";        
            } else {
            document.getElementById("modImg").src = "images/btn_mod_01.jpg";        
            }
        }
    } else if(btn=="copy") {
        if(document.getElementById("copyBtn").disabled != true) {
            if(gb=="in") {
                document.getElementById("copyImg").src = "images/btn_copy_02.jpg";      
            } else {
                document.getElementById("copyImg").src = "images/btn_copy_01.jpg";      
            }
        }
    }
     
}

function viewBtn(vis) {

    if(vis==true) {
        document.getElementById("saveImg").src = "images/btn_save_03.jpg";      
        document.getElementById("delImg").src = "images/btn_del_03.jpg";    
        
        if(document.getElementById("save_templateImg")  != null  ){
            document.getElementById("save_templateImg").src = "images/btn_save_template_03.jpg";    
        }
            
    } else {
        document.getElementById("saveImg").src = "images/btn_save_01.jpg";      
        document.getElementById("delImg").src = "images/btn_del_01.jpg";
        if(document.getElementById("save_templateImg")  != null  ){
            document.getElementById("save_templateImg").src = "images/btn_save_template_01.jpg";
        }       
    }
    
    
    document.getElementById("addTcBtn").disabled = vis;     // 기존테스트케이스 버튼 비활성화
    document.getElementById("regBtn").disabled = vis;       // 테스트케이스 저장 버튼  비활성화
    
    
    if(document.getElementById("regTempBtn")  != null  ){
        document.getElementById("regTempBtn").disabled = vis;       // 테스트케이스 저장 버튼  비활성화 
    }
    if(document.getElementById("upLoadBtn") != null  ){   //엑셀업로드 버튼 활성화
        document.getElementById("upLoadBtn").disabled = vis;
    }
    if(document.getElementById("downBtn") != null  ){   //다운로드 버튼 활성화
        document.getElementById("downBtn").disabled = vis;
    }
    if(document.getElementById("tsUseBtn") != null  ){   //시나리오로 활용 버튼 활성화
        document.getElementById("tsUseBtn").disabled = vis;
    }
    // 테스트케이스 공통 버튼 비활성화
    document.getElementById("upBtn").disabled = vis;            // 위 버튼  비활성화
    document.getElementById("dnBtn").disabled = vis;            // 아래 버튼  비활성화
    document.getElementById("copyTcBtn").disabled = vis;        // 테스트케이스복사 버튼  비활성화
    document.getElementById("delTc1Btn").disabled = vis;        // 테스트케이스삭제 버튼  비활성화
    
    try {
        document.getElementById("scheduleBtn").disabled = vis;          // 스케줄등록 버튼  활성화
    }catch(e){
    }
    try {
        document.getElementById("editBtn").disabled = vis;          // 테스트케이스편집 버튼  활성화
    }catch(e){
    }
    if(document.getElementById("usrInputBtn")!= null)
        document.getElementById("usrInputBtn").disabled = vis;      // 데이터자동생성
    //테스트케이스관리버튼 비활성화
    document.getElementById("delBtn").disabled = vis;       // 테스트케이스삭제 버튼  비활성화
    
    //테스트실행버튼 비활성화
    document.getElementById("execBtn").disabled = vis;      // 테스트실행버튼  비활성화
    
    try {
        document.getElementById("calcBtn").disabled = vis;          //Numeric확인 버튼
    } catch(e) {
    }
    try {
        document.getElementById("chkNumeric").disabled = vis;           //Numeric확인 버튼
    } catch(e) {
    }
}

//모든버튼 보이기/숨기기
function AllBtnDisabled(dis) {
    try {
        document.getElementById("chkNumeric").disabled = dis;           //Numeric확인 버튼
    } catch(e) {
    }
    document.getElementById("newBtn").disabled = dis;           //신규생성버튼
    document.getElementById("loadBtn").disabled = dis;      //불러오기버튼
    document.getElementById("resetBtn").disabled = dis;         //초기화버튼
    document.getElementById("delBtn").disabled = dis;       // 삭제 버튼  활성화
    document.getElementById("regBtn").disabled = dis;       // 저장 버튼  활성화
    
    if(document.getElementById("regTempBtn")  != null  ){
        document.getElementById("regTempBtn").disabled = dis;       // 저장 버튼  활성화
    }
    if(document.getElementById("upLoadBtn") != null  ){   //엑셀업로드 버튼 활성화
        document.getElementById("upLoadBtn").disabled = dis;
    }
    if(document.getElementById("downBtn") != null  ){   //다운로드 버튼 활성화
        document.getElementById("downBtn").disabled = dis;
    }
    if(document.getElementById("tsUseBtn") != null  ){   //시나리오로 활용 버튼 활성화
        document.getElementById("tsUseBtn").disabled = dis;
    }
    document.getElementById("upBtn").disabled = dis;            // 위 버튼  활성화
    document.getElementById("dnBtn").disabled = dis;            // 아래 버튼  활성화
    document.getElementById("addTcBtn").disabled = dis;         // 기존테스트케이스 버튼 활성화
    document.getElementById("copyTcBtn").disabled = dis;        // 테스트케이스복사 버튼  활성화
    document.getElementById("delTc1Btn").disabled = dis;        // 테스트케이스삭제 버튼  활성화
    document.getElementById("execBtn").disabled = dis;          // 테스트실행 버튼  활성화
    try{
        document.getElementById("calcBtn").disabled = dis;
    }catch(e){
    }
    try{
        document.getElementById("templateBtn").disabled = dis;
    }catch(e){
    }
    try {
        document.getElementById("scheduleBtn").disabled = dis;          // 스테쥴등록 버튼  활성화
    }catch(e){
    }
    try {
        document.getElementById("editBtn").disabled = dis;          // 테스트케이스편집 버튼  활성화
    }catch(e){
    }

    if(document.getElementById("usrInputBtn")!= null)
        document.getElementById("usrInputBtn").disabled = dis;          // 데이터자동생성 버튼  활성화

    if(dis==true) {
        document.getElementById("saveImg").src = "images/btn_save_03.jpg";  
        
        if(document.getElementById("save_templateImg")  != null  ){
            document.getElementById("save_templateImg").src = "images/btn_save_template_03.jpg";    
        }
        document.getElementById("delImg").src = "images/btn_del_03.jpg";        
        document.getElementById("loadImg").src = "images/btn_load_03.jpg";      
        document.getElementById("newImg").src = "images/btn_new_03.jpg";        
        document.getElementById("resetImg").src = "images/btn_reset_03.jpg";    
        try{
            document.getElementById("templateImg").src = "images/template_open3.jpg";       
        }catch(e){
        }
    } else {
        document.getElementById("saveImg").src = "images/btn_save_01.jpg";
        
        if(document.getElementById("save_templateImg")  != null  ){
            document.getElementById("save_templateImg").src = "images/btn_save_template_01.jpg";
        }   
        document.getElementById("delImg").src = "images/btn_del_01.jpg";        
        document.getElementById("loadImg").src = "images/btn_load_01.jpg";      
        document.getElementById("newImg").src = "images/btn_new_01.jpg";        
        document.getElementById("resetImg").src = "images/btn_reset_01.jpg";    
        try{
            document.getElementById("templateImg").src = "images/template_open2.jpg";       
        }catch(e){
        }
    }
}
// 일괄실행 시트에 내용 없을시
function onChkSheet() {
    if((mySheet.Rows - mySheet.HeaderRows) <= 0){
        document.getElementById("delImg").src = "images/btn_del_03.jpg";        
        document.getElementById("saveImg").src = "images/btn_save_03.jpg";  
        // 테스트케이스 공통 버튼 비활성화
        document.getElementById("upBtn").disabled = true;           // 위 버튼  비활성화
        document.getElementById("dnBtn").disabled = true;           // 아래 버튼  비활성화
        document.getElementById("delTc1Btn").disabled = true;       // 테스트케이스삭제 버튼  비활성화
        document.getElementById("execBtn").disabled = true;         // 일괄실행 버튼  비활성화
        document.getElementById("delImg").disabled = true;      
        document.getElementById("saveImg").disabled = true; //
        return true;
    }
}


/*  버튼 이미지 비활성화 함수
 *  (true-비활성화/false-활성화, 버튼ID, 버튼이미지경로)
 *  2009.02.11 정지혜      */
function cmnBtnDisabled(gd ,btn, btnImg) {
    if (gd=="true"){ //비활성화 (이미지경로_00)
        document.getElementById(btn).disabled = true;
        btnImg += "_00.jpg";
    }else if(gd=="false"){  //활성화 (이미지경로_01)
        document.getElementById(btn).disabled=false;
        btnImg += "_01.jpg";
    }
    if(btnImg!=""){ //이미지경로가 있는경우
        document.getElementById(btn).src = btnImg; //이미지 변경
    }
}

/*  버튼 이미지 마우스오버되는 함수
 *  (over-마우스오버 /out-마우스아웃 , 버튼ID, 버튼이미지경로)
 *  2009.02.11  정지혜     */
function cmnMouseOver(gd, btn, btnImg) {
    if(document.getElementById(btn).disabled != true) {
        if(gd=="over"){
            btnImg += "_02.jpg";
            document.getElementById(btn).src = btnImg;
        }else if(gd=="out"){
            btnImg += "_01.jpg";
            document.getElementById(btn).src = btnImg;
        }
    }
}

/*
 * 디바이스 매니저 환경설정 파일 검사
 */
function isEnvSet(filePath){
    
    var fso, fileObj;
    var ForReading = 1;
    fso = new ActiveXObject('Scripting.FileSystemObject');
    if (fso.FileExists(filePath)){
        var fileStr = "";
        var strArr = new Array();
        fileObj = fso.OpenTextFile(filePath,ForReading);
        while (!fileObj.AtEndOfStream) {
            fileStr += fileObj.ReadLine() + '\n';
        }
        strArr = fileStr.split('\n');
        var splitArr = strArr[1].split('=');

        if (splitArr[1].length > 0) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

/****필드길이체크*****************/
function strlen_charCodeAt(str) {
    var i = 0;
    var lenNum = str.length;
    var tmp = 0;
    var mbyte = 0;
    for(i=0;i<lenNum;i++) {
        tmp = str.charCodeAt(i);
        if(tmp > 1000) { //크기 비교를 하는 기준 값으로 127를 기준으로 잡는 코드도 있습니다.
            // 줄바꿈(\n) - 10 , 빈공간(" ") - 32, \r - 13, 탭 - 9 의 값을 갖는다. 이러한 경우에 바이트를 계산하지 않는 경우도 있다.
            mbyte = mbyte+2;
        }
        mbyte = mbyte+1;
    }
    return mbyte;
}

/*-------------------------------------------------------------------------
Notes     : 입력값이 이메일 형식인지를 체크하는 함수
Parameter : Email문자열
Return    : void
Use       : if(checkEmailAddress(strEmail))
-------------------------------------------------------------------------*/
function checkEmailAddress(strEmail) {
    return strEmail.search(/^\s*[\w\~\-\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g)>=0;
}


/**
 * 공백존재여부
 * @param str
 * @return boolean
 */
function checkSpace( str )
{
     if(str.search(/\s/) != -1){
        return false;          
     } else {
         return true;
     }
}
/**
 * 같은문자열 연속여부 
 * @param str
 * @return boolean
 */
function isPassDupl(pwd) {

    //같은 문자열이 연속으로 3개 이상일 경우 제한합니다. 
    for(var i=0; i<=pwd.length-3; i++) { 
        if(pwd.charAt(i)==pwd.charAt(i+1) && pwd.charAt(i)==pwd.charAt(i+2)) { 
            return false; 
        } 
    }
    return true;
}

/**
 * 연속된 데이터 입력 여부 
 * @param str
 * @return boolean
 */
function isPassConti(pwd) {
    
    var alpaBig= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";    
    var numList = "01234567890";
    
    //연속된 문자가 3개 이상일 경우 제한: 영문자 체크
    for(var i=0; i<=pwd.length-3; i++) {
        
        for(var j=0; j<=alpaBig.length-3;j++) {
            if (pwd.charAt(i)==alpaBig.charAt(j)) {
                if(pwd.charAt(i+1)==alpaBig.charAt(j+1) && pwd.charAt(i+2)==alpaBig.charAt(j+2)) { 
                    return false; 
                }
            }
        }
    }
    //연속된 문자가 3개 이상일 경우 제한: 숫자 체크
    for(var i=0; i<=pwd.length-3; i++) {
        
        for(var j=0; j<=numList.length-3;j++) {
            if (pwd.charAt(i)==numList.charAt(j)) {
                if(pwd.charAt(i+1)==numList.charAt(j+1) && pwd.charAt(i+2)==numList.charAt(j+2)) { 
                    return false; 
                }
            }
        }
    }

    return true;
}

function replaceAll(str, orgStr, repStr) { 
    return str.split(orgStr).join(repStr);
}

function openShowModalDialog( url, width, height )
{
    var left = (window.screen.availWidth - width - 12)/2;
    var top  = (window.screen.availHeight - height - 32)/2;
    var option = "center:yes;"+
                 "dialogWidth="+width+"px; dialogHeight="+height+"px; dialogLeft="+left+"px; dialogTop="+top+
                 "px; scroll=no; status=yes; help=no; resizable:yes; status=no";
    winName = window.showModalDialog( url, window, option );
    return winName;

}

/**
* Function      : 현재날짜/시간을 출력한다. YYYY-MM-DD hh:mm:ss
* @param        : str
* @return       : boolean
*/
function getTimeStampYMDhms() {
	var d = new Date();
	var s = leadingZeros(d.getFullYear(), 4) + '-' +
	leadingZeros(d.getMonth() + 1, 2) + '-' +
	leadingZeros(d.getDate(), 2) + ' ' +
	
	leadingZeros(d.getHours(), 2) + ':' +
	leadingZeros(d.getMinutes(), 2) + ':' +
	leadingZeros(d.getSeconds(), 2);
	return s;
}


/**
* Function      : 현재날짜를 출력한다. YYYY-MM-DD
* @param        : str
* @return       : boolean
*/
function getTimeStampYMD() {
	var d = new Date();
	var s = leadingZeros(d.getFullYear(), 4) + '-' +
	leadingZeros(d.getMonth() + 1, 2) + '-' +
	leadingZeros(d.getDate(), 2);
	return s;
}


function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++) {
			zero += '0';
		}
	}
	return zero + n;
}