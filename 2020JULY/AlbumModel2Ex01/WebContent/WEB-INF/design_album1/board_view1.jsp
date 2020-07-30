<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="albummodel1.*" %>

<%
	String cpage = (String)request.getAttribute("cpage");
	String seq = (String)request.getAttribute("seq");
	String subject = (String)request.getAttribute("subject");
	String writer = (String)request.getAttribute("writer");
	String mail = (String)request.getAttribute("mail");
	String wip = (String)request.getAttribute("wip");
	String wdate = (String)request.getAttribute("wdate");
	String hit = (String)request.getAttribute("hit");
	String content = (String)request.getAttribute("content");
	String filename = (String)request.getAttribute("filename");
	ArrayList<CommentTO> commentLists = (ArrayList<CommentTO>)request.getAttribute("commentLists");
	
	StringBuffer commentHtml = new StringBuffer();
		
	for (CommentTO cdto : commentLists) {
		String cSeq = cdto.getSeq();
		String cWriter = cdto.getWriter();
		String cWdate = cdto.getWdate();
		String cContent = cdto.getContent();
		
		commentHtml.append("<tr>");
		commentHtml.append("<td class='coment_re' width='20%'>");
		commentHtml.append("<strong>"+ cWriter + "</strong> (" + cWdate + ")");
		commentHtml.append("<div class='coment_re_txt'>"+cContent);
		// 댓글 삭제 버튼 추가
		commentHtml.append("</div><form action='../board_comment1_delete_ok.jsp' method='post' name='cdfrm'>");
// 		commentHtml.append("<input type='hidden' name='cPassword' value='"+cSeq+"'>");
		commentHtml.append("<input type='hidden' name='seq' value='"+seq+"'>");
		commentHtml.append("<input type='hidden' name='cpage' value='"+cpage+"'>");
		commentHtml.append("<input type='hidden' name='cSeq' value='"+cSeq+"'>");
		commentHtml.append("<div class='align_right'><img src='../images/icon_del.gif' onclick=''/></a></form></td></tr>");
	}
%>
<!DOCTYPE html>
<html lang="ko">
<input type="hidden" value="<%= mail %>">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/board_view.css">
<script type="text/javascript">
	var commentDel = function () {
		location.href='delete_ok.do';
	}
	window.onload = function() {
		// 버튼을 누르고 값을 검사하기
		document.getElementById('cbtn').onclick = function() {
			if (document.cfrm.cwriter.value.trim() == '') {
				alert('이름을 입력하셔야 합니다.');
				return false;
			}
			if (document.cfrm.cpassword.value.trim() == '') {
				alert('비밀번호를 입력하셔야 합니다.');
				return false;
			}
			if (document.cfrm.ccontent.value.trim() == '') {
				alert('댓글 내용을 입력하셔야 합니다.');
				return false;
			}
			document.cfrm.submit();
		}
	};
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<a href="board_list1.jsp"><img style="vertical-align: middle" alt="" src="../images/home_icon.gif" /></a> &gt; 커뮤니티 &gt; <strong><%= subject %></strong>
		</p>
	</div>

	<div class="contents_sub">	
	<!--게시판-->
		<div class="board_view">
			<table>
			<tr>
				<th width="10%">제목</th>
				<td width="60%"><%= subject %></td>
				<th width="10%">등록일</th>
				<td width="20%"><%= wdate %></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><%= writer %></td>
				<th>조회</th>
				<td><%= hit %></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding:20px; line-height:160%">
					<div id="bbs_file_wrap">
						<div>
							<img src="../upload/<%= filename %>" width="900" onerror="" /><br />
						</div>
					</div>
					<%= content %>
				</td>
			</tr>			
			</table>
			<!-- 댓글 부분 -->
			<table>
				<%= commentHtml %>
			</table>

			<form action="../comment/comment_write_ok.do" method="post" name="cfrm">
			<input type="hidden" name="pseq" value="<%=seq %>" />	
			<input type="hidden" name="cpage" value="<%= cpage %>"/>
			<table>
			<tr>
				<td width="94%" class="coment_re">
					글쓴이 <input type="text" name="cwriter" maxlength="20" class="coment_input" />&nbsp;&nbsp;
					비밀번호 <input type="password" name="cpassword" class="coment_input pR10" />&nbsp;&nbsp;
				</td>
				<td width="6%" class="bg01"></td>
			</tr>
			<tr>
				<td class="bg01">
					<textarea name="ccontent" cols="" rows="" class="coment_input_text"></textarea>
				</td>
				<td align="right" class="bg01">
					<input type="button" id="cbtn" value="댓글등록" class="btn_re btn_txt01" />
				</td>
			</tr>
			</table>
			</form>
		</div>
		<div class="btn_area">
			<div class="align_left">			
				<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='list.do?cpage=<%=cpage%>'" />
			</div>
			<div class="align_right">
				<input type="button" value="수정" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='modify.do?cpage=<%= cpage %>&seq=<%=seq %>'" />
				<input type="button" value="삭제" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='delete.do?cpage=<%= cpage %>&seq=<%=seq %>'" />
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='write.do?cpage=<%= cpage %>'" />
			</div>	
		</div>
		<!--//게시판-->
	</div>
<!-- 하단 디자인 -->
</div>

</body>
</html>