<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                           	<table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">거래정보</td>
                              </tr>
                            </table>
                           	<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                           	  <tr>
                                <td width="150" class="tm_left_slim">거래코드</td>
                                <td class="tm_text">${rptTsResult.trancd}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">거래코드 명</td>
                                <td class="tm_text">${rptTsResult.tranname}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">체크포인트</td>
                                <td class="tm_text">${rptTsResult.chekyn}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">성공실패 여부</td>
                                <td class="tm_text">${rptTsResult.rsultsucssyn}</td>
                              </tr>
                            </table>
                            <c:choose>
                           	  <c:when test="${gubun == '01'}">
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">테스트케이스 정보</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                              <tr>
                                <td width="150" class="tm_left_slim">테스트케이스 ID</td>
                                <td class="tm_text">${rptTsResult.tscaseid}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트케이스 명</td>
                                <td class="tm_text">${rptTsResult.tscasename}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트케이스 설명</td>
                                <td class="tm_text">${rptTsResult.tscasedesc}</td>
                              </tr>
                            </table>
                              </c:when>
                              <c:when test="${gubun == '02'}">
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">테스트시나리오 정보</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">  
                              <tr>
                                <td width="150" class="tm_left_slim">테스트시나리오 ID</td>
                                <td class="tm_text">${rptTsResult.tssnrioid}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트시나리오 명</td>
                                <td class="tm_text">${rptTsResult.tssnrioname}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트시나리오 설명</td>
                                <td class="tm_text">${rptTsResult.tssnriodesc}</td>
                              </tr>
                            </table>
                              </c:when>
                            </c:choose>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">테스트데이터 정보</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                              <tr>
                                <td width="150" class="tm_left_slim">테스트데이터 ID</td>
                                <td class="tm_text">${rptTsResult.tsdataid}</td>
                              </tr>
                              <tr>
                                <td width="150" class="tm_left_slim">테스트데이터 수행회차</td>
                                <td class="tm_text">${rptTsResult.acmplnth}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트데이터 명</td>
                                <td class="tm_text">${rptTsResult.tsdataname}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트데이터 설명</td>
                                <td class="tm_text">${rptTsResult.tsdatadesc}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트 시작/종료 일시</td>
                                <td class="tm_text">${rptTsResult.teststartyms} ~ ${rptTsResult.testendyms}</td>
                              </tr>
                              <tr>
                                <td class="tm_left_slim">테스트 경과시간</td>
                                <td class="tm_text">${rptTsResult.elapsedtime} ms</td>
                              </tr>
                            </table>