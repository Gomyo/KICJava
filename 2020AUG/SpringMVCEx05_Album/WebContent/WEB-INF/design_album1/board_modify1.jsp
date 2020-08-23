<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="albummodel1.*" %>
<%
// 	if(session.getAttribute("s_id") == null) {
// 		out.println("<script type='text/javascript'>");
// 		out.println("alert('로그인 해야 합니다.');");
// 		out.println("location.href='./board_list1.jsp';");
// 		out.println("</script>");
// 	} else {	
	
		
		BoardTO dto = (BoardTO)request.getAttribute("to");
		String cpage = request.getParameter( "cpage" );
		String seq = dto.getSeq();
		String subject = dto.getSubject();
		String writer = dto.getWriter();
		String mail[] = dto.getMail().split( "@" );
		if( mail.length == 1 ) {
			mail = new String[] { "", "" };
		}
		String content = dto.getContent();
		String filename = dto.getFilename();	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_write.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('mbtn').onclick = function() {
			if (document.mfrm.password.value.trim() == '') {
				alert('비밀번호를 입력해야 합니다.');
				return false
			};
			if (document.mfrm.subject.value.trim() == '') {
				alert('제목을 입력해야 합니다.');
				return false
			};
			if (document.mfrm.upload.value.toLowerCase().endsWith('png') ||
					document.mfrm.upload.value.toLowerCase().endsWith('jpg') || 
					document.mfrm.upload.value.toLowerCase().endsWith('gif') ||
					document.mfrm.upload.value.toLowerCase().endsWith('jpeg') ||
					document.mfrm.upload.value ==''
					)
			{
				alert('업로드합니다.');
				document.mfrm.submit();
			} else {
				alert('이미지 파일을 업로드해야 합니다.');
				return false;
			}
		};
	};
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<a href="list.do"><img style="vertical-align: middle" alt="" src="./images/home_icon.gif" /></a> &gt; 커뮤니티 &gt; <strong><%= subject %></strong>
		</p>
	</div> 
	<form action="modify_ok.do" method="post" name="mfrm" enctype="multipart/form-data">
		<input type="hidden" name="seq" value="<%= seq %>"/>
		<input type="hidden" name="cpage" value="<%= cpage %>"/>
		<div class="contents_sub">
		<!--게시판-->
			<div class="board_write">
				<table>
				<tr>
					<th class="top">글쓴이</th>
					<td class="top" colspan="3"><input type="text" name="writer" value="<%= writer %>" class="board_write_input_100" maxlength="5" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="subject" value="<%= subject %>" class="board_write_input" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="password" name="password" value="" class="board_write_input_100"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<textarea name="content" class="board_editor_area"><%= content %></textarea>
					</td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td colspan="3">
						기존 파일 : <%= filename %><br /><br />
						<input type="file" name="upload" value="" class="board_write_input" />
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><input type="text" name="mail1" value="<%= mail[0] %>" class="board_write_input_100"/> @ <input type="text" name="mail2" value="<%= mail[1] %>" class="board_write_input_100"/></td>
				</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">			
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='view.do?cpage=<%= cpage %>'" />
					<input type="button" value="보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='view.do?cpage=<%= cpage %>&seq=<%= seq %>'" />
				</div>
				<div class="align_right">			
					<input type="button" id = "mbtn" value="수정" class="btn_write btn_txt01" style="cursor: pointer;" />
				</div>	
			</div>	
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>