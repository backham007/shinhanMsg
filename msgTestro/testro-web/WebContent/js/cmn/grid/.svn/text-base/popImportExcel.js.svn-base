// 엑셀업로드
function executeImportExcel() {
	if (!$('#excelFile')[0].value) {
		alert('엑셀 파일을 반드시 선택하셔야 합니다.');
		return;
	}
	if (($('#excelFile')[0].value).match(/\.(xls|xlsx)$/i)) {
		if (window.opener && !window.opener.closed) {
			var limitRowCnt = $('#limitRowCnt')[0].value;
			var tcDataMaxCnt = $('#tcDataMaxCnt')[0].value;
			gridImportExcel(window.opener.mappingExcel, limitRowCnt, tcDataMaxCnt);
		}
	} else {
		alert("엑셀파일만 업로드 가능합니다.");
	}
}