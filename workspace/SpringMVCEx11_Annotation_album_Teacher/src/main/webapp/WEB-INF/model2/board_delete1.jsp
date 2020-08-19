<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="albummodel1.BoardDAO" %>
<%@ page import="albummodel1.BoardTO" %>
<%
	request.setCharacterEncoding( "utf-8" );

	BoardTO to = (BoardTO)request.getAttribute("to");
	
	String cpage = (String)request.getAttribute("cpage");
	String seq = to.getSeq();
	String subject = to.getSubject();
	String writer = to.getWriter();	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="././css/board_write.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('boardsubmit').onclick = function() {
			if(document.boardfrm.password.value.trim() == "") {
				alert('비밀번호를 입력하셔야 합니다.');
				return false;
			}
			document.boardfrm.submit();
		};
	};
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="././images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
		</p>
	</div> 

	<form action="./delete_ok.do" method="post" name="boardfrm">
		<input type="hidden" name="seq" value="<%=seq %>" />
		<div class="contents_sub">
		<!--게시판-->
			<div class="board_write">
				<table>
				<tr>
					<th class="top">글쓴이</th>
					<td class="top" colspan="3"><input type="text" name="writer" value="<%=writer %>" class="board_write_input_100" maxlength="5" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="subject" value="<%=subject %>" class="board_write_input" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="password" name="password" value="" class="board_write_input_100"/></td>
				</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">			
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='list.do?cpage=<%=cpage %>'" />
					<input type="button" value="보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='view.do?cpage=<%=cpage %>&seq=<%=seq %>'" />
				</div>
				<div class="align_right">			
					<input type="submit" value="삭제" id="boardsubmit" class="btn_write btn_txt01" style="cursor: pointer;" />					
				</div>	
			</div>	
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
