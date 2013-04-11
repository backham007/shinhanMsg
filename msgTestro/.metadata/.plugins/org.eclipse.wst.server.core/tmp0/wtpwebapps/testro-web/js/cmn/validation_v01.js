/*
 * 전체 폼 필수입력 체크
 * Added By 
 */
function required()
{
    returnValue = true;
    formCount = document.forms.length;
    for(f=0; f<formCount; f++)
    {
        form = document.forms[f];
        elementCount = form.elements.length;

        for(e=0; e<elementCount; e++)   {
            obj = form.elements[e];
    
            if(obj.className == "frm_req")  {
                if(obj.value == null || trim(obj.value) == "")
                {       
                  obj.select();       
                  obj.focus ();
                  alert("필수입력사항이 입력되지 않았습니다.");
                  return false;
                }
            }
        }
    }
    return returnValue;
}

/*
 * object가 포커스를 얻었을 때 
 * Parameter : object
 * Added By 
 */
function gotFocus(obj)
{
  switch(obj.getAttribute("alt"))
  {
    case "DATE":
      delDateDelim(obj);
      break;

    case "CURR":
      obj.value = delCurrencyDelim(obj);
      break;

    default :
      break;
  }
}

/*
 * 날짜 입력시 날짜의 dash('-')나 기타등등("/")을 제거하는 함수
 * Parameter : object
 * Added By 
 */
function delDateDelim(obj) 
{
  obj.value = obj.value.replace(/-/gi,"");
  obj.value = obj.value.replace(/\//gi,"");
}

/*
 * 날짜 입력시 날짜의 dash('-')나 기타등등("/")을 추가하는 함수
 * Parameter : object
 * Added By 
 */
function addDateDelim(obj) 
{
  var varDate = obj.value;

  obj.value = addDateDelimiter(varDate);
} 

/*
 * 날짜(yyyymmdd)를 받아 slash('/')를 추가하는 함수
 * Added By 
 * return : yyyy/mm/dd
 */
function addDateDelimiter(dateValue)
{
  var value = dateValue;
  
  if(value.length != 8) return value;

  year  = value.substring(0, 4);
  month = value.substring(4, 6);
  day   = value.substring(6, 8);
  
  return year + "/" + month + "/" + day;
}

/*
 * 날짜 입력시 날짜의 dash('-')를 삭제하는 함수
 * 날짜 입력란의 onFocus()시 호출
 * Parameter : object
 */
function delDateDelimiter(dateValue)
{
    if(dateValue.value)
    {
        dateValue = dateValue.value;
    }

    objvalue = dateValue.replace(/-/gi,"");
    objvalue = objvalue.replace(/\//gi,"");

    return objvalue;
}

/*
 * 날짜(yyyymmdd)를 받아 slash('-')를 추가하는 함수
 * Added By 
 * return : yyyy/mm/dd
 */
function addDateDelimiterEdit(dateValue)
{
  var value = dateValue;
  
  if(value.length != 8) return value;

  year  = value.substring(0, 4);
  month = value.substring(4, 6);
  day   = value.substring(6, 8);
  
  return year + "-" + month + "-" + day;
}

/*
 * 유효한 날짜(Date) 인지 체크
 * Parameter : YYYYMMDD(년월일)
 * Return : true / false
 * Added By 
 */
function isValidDate(objValue) 
{
  if(!isNum(objValue) || objValue.length < 8)
    return false;

  year  = objValue.substring(0, 4);
  month = objValue.substring(4, 6);
  day   = objValue.substring(6, 8);

  if (parseInt(year, 10) >= 1900  && isValidMonth(month) && isValidDay(year, month, day)) 
    return true;

  return false;
}

/* 유효한 월(月)인지 확인.
 * Parameter : MM(월)
 * Return : true / false
 * Added By 
 */
function isValidMonth(mm) 
{
  var m = parseInt(mm,10);

  return (m >= 1 && m <= 12);
}

/*
 * 유효한 일(日)인지 확인.
 * Parameter : YYYY, MM, DD(년, 월, 일)
 * Return : true / false
 * Added By 
 */
function isValidDay(yyyy, mm, dd) 
{
  var m = parseInt(mm,10) - 1;
  var d = parseInt(dd,10);

  var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
  if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) 
    end[1] = 29;

  return (d >= 1 && d <= end[m]);
}

/*
 * 숫자만, 한글만, 영문만 입력가능하도록 처리하는 함수
 * Parameter : obj
 * Return : 
 * Added By 
 */
function checkTypes(obj) 
{
  keynum = event.keyCode;
//      alert("keynum=" + keynum);
  switch(obj.getAttribute("alt"))
  {
    case "DATE":
    case "SSNR1":
    case "SSNR2":
    case "TIMEHH":
    case "TIMEMM":      
    case "CURR":
      if((keynum < 48 || keynum > 57) && 
         (keynum != 8 && keynum != 9 && keynum != 35 && keynum != 36 && keynum != 37 && keynum != 39 && keynum != 46 && keynum !=110 ) &&
         (keynum < 96 || keynum > 105)) 
      { 
        obj.focus();
        event.returnValue = false;
      } 
      else return true;
      break;

    case "NUMB":
      if((keynum < 48 || keynum > 57) && 
         (keynum != 8 && keynum != 9 && keynum != 35 && keynum != 36 && keynum != 37 && keynum != 39 && keynum != 46 && keynum !=110 && keynum !=190) &&
         (keynum < 96 || keynum > 105)) 
      { 
        obj.focus();
        event.returnValue = false;
      } 
      else return true;
      break;

    case "INTE":
      if((keynum < 48 || keynum > 57) && 
         (keynum != 8 && keynum != 9 && keynum != 35 && keynum != 36 && keynum != 37 && keynum != 39 && keynum != 46 && keynum !=110 && keynum !=190 && keynum !=189) &&
         (keynum < 96 || keynum > 105)) 
      { 
        obj.focus();
        event.returnValue = false;
      } 
      else return true;
      break;
  
    case "TELNO":
      if((keynum < 48 || keynum > 57) && 
         (keynum != 8 && keynum != 9 && keynum != 35 && keynum != 36 && keynum != 37 && keynum != 39 && keynum != 46 && keynum !=110 && keynum !=190 && keynum !=189 && keynum !=109) &&
         (keynum < 96 || keynum > 105)) 
      { 
        obj.focus();
        event.returnValue = false;
      } 
      else return true;
      break;

    default :
      break;
  }
}

/*
 * 키 체크후에 포커스 이동시 필요한 함수
 * Parameter : obj, nextObj
 * Return : 
 * Added By 
 */
function reCheckTypes(obj, nextObj) 
{
  if (obj.value.length == obj.getAttribute("maxlength"))
  {
    nextObj.focus();
    return true;
  }else{
    return false;
  }
}

/*
 * 통화 입력시 통화의 comma(',')를 삭제하는 함수
 * 통화 입력란의 onFocus()시 호출
 * Parameter : object
 * Added By 
 */
function delCurrencyDelim(obj) 
{
  var cur = obj.value.replace(/,/gi,"");
  return cur;
}

/*
 * 통화 입력시 통화의 comma(',')를 추가하는 함수
 * 통화 입력란의 onBlur()시 호출
 * Parameter : object
 * Added By 
 */
function addCurrencyDelim(obj) 
{
  var str = obj.value;
  var strLength = str.length;
  var index = 0;

  if(str.indexOf('.') == -1)
    index = strLength - 1;
  else
    index = str.indexOf('.') - 1;

  var res = "";
  var p = 0;
  for(i=index; i>=0; i--, p++)
  {
    if((p != 0) && ((p%3) == 0))
      res = "," + res;

    res = str.charAt(i) + res;
  }
  
  return res;
}

/* 한글의 길이를 체크하는 함수
 * Parameter : string
 * Return : length
 * Added By 
 */
function getByteLength(s)
{
  var len = 0;
  
  if(s == null) return 0;

  for(i=0; i<s.length; i++)
  {
    var c = escape(s.charAt(i));
    if(c.length == 1) len ++;
    else if (c.indexOf("%u") != -1) len += 3;
    else if (c.indexOf("%")  != -1) len += c.length/3;
  }
  return len;
}

/* 문자열중 숫자만 리턴한다.
 * Parameter : string
 * Return : num
 * Added By 
 */
function smStrToNum(objValue) 
{
  var retStr = "";
  for (i=0; i<objValue.length ; i++)
    {
    var ch = objValue.charAt(i);
        if ((ch >= '0') && (ch <= '9'))
        {
      retStr = retStr + ch;
        }
    }
    return retStr;
}

/* 특수문자를 html형식으로 변환
 * Parameter : string
 * Return : String
 * Added By 
 */
function str2html(s) 
{
  if ( s == null ) return null;

  retrunstr = "";
  for (i=0; i < s.length; i++) 
  {
//    var c = escape(s.charAt(i));
    var c = s.substr(i,1);
    if      ( c == '&' ) retrunstr = retrunstr + "&amp;"  ;
    else if ( c == '<' ) retrunstr = retrunstr + "&lt;"   ;
    else if ( c == '>' ) retrunstr = retrunstr + "&gt;"   ;
    else if ( c == '"' ) retrunstr = retrunstr + "&quot;" ;
    else if ( c == '\'') retrunstr = retrunstr + "&#039;" ;
    else if ( c == '\n') retrunstr = retrunstr + "<br>"   ;
    else retrunstr = retrunstr + c ;
  }
//alert("s=" + s + "\n:retrunstr=" + retrunstr);    

  return retrunstr;
}


/**
* Function      : 문자열의 앞뒤 space를 제거한다.
* @param        : value
* @return       : 앞뒤의 space가 제거된 문자열
*/
function trimmed(value) {
    value = value.replace(/^\s+/, "");  // remove leading white spaces
    value = value.replace(/\s+$/g, ""); // remove trailing while spaces
    return value;
}

/**
* Function      : 영문만 검사 한다.
* @param        : str
* @return       : boolean
*/
function isAlpha( str )     {
    for( i=0; i < str.value.length;i++)    {
        ch=str.value.charAt(i);
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') );
        else  return false;                            
    }
    return true;     
}
