<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.*" %>
<%
	request.setCharacterEncoding("utf-8");

	ArrayList<ZipcodeTO> lists
		= (ArrayList<ZipcodeTO>)request.getAttribute("lists");
	
	StringBuffer sbHtml = new StringBuffer();
	
	if ( lists != null) {
		
		sbHtml.append("<table border='1' width='800'>");
		for (ZipcodeTO to : lists) {
			sbHtml.append("<tr>");
			sbHtml.append("<td>"+to.getZipcode()+"</td>");
			sbHtml.append("<td>"+to.getSido()+"</td>");
			sbHtml.append("<td>"+to.getGugun()+"</td>");
			sbHtml.append("<td>"+to.getDong()+"</td>");
			sbHtml.append("<td>"+to.getBunji()+"</td>");
			sbHtml.append("<td>"+to.getRi()+"</td>");
			
			sbHtml.append("</tr>");
		}
		sbHtml.append("</table>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('zbtn').onclick = function() {
			if (document.frm.dong.value.trim().length < 2) {
				alert('두 글자 이상 입력하셔야 합니다.');
				return false;
			}
			document.frm.submit();
		}
	}
</script>
</head>
<body>
	<form action="zipcodeForm.jsp" method="post" name="frm">
		동입력<input type="text" name="dong" size="40" maxlength="4" placeholder="동이름 입력" onkeydown="if (event.keyCode == 13) {return false;}"/>
		<input type="button" id="zbtn" value="출력"/>
	</form>
<br><hr/><br>
<%= sbHtml %>
</body>
</html>