<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	response.sendRedirect("./board_json.do");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<style type="text/css">
    body { font-size: 70%; }
     #accordion-resizer {
          margin: 0 60px;
          max-width: 1500px;
     }
     #btngroup1 {
          text-align: right;
     }
     label.header {
          font-size: 10pt;
          margin-right: 5px;
     }

     input.text {
          width: 80%;
          margin-bottom: 12px;
          padding: .4em;
     }

     fieldset {
          margin-left: 15px;
          margin-top: 15px;
          border: 0;
     }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
		
        $('#accordion').accordion({
            heightStyle: 'content'
        });

        $("#writeDialog").css('display', 'none');
        $("#modifyDialog").css('display', 'none');
        $("#deleteDialog").css('display', 'none');
        // 1
        
        $('button.action').button().on('click', function() {
            if($(this).attr('action') == 'write') {
                $('#writeDialog').dialog({
                    width: 700,
                    height: 500,
                    modal: true,
                    buttons: {
                         "글쓰기": function() {
                             $(this).dialog('close');
                             var subject = $('#w_subject').val();
                             var writer = $('#w_writer').val();
                             var mail = $('#w_mail').val();
                             var password = $('#w_password').val();
                             var content = $('#w_content').val();
                             
                             writeServer(subject, writer, mail, password, content);
                         },
                         "취소": function() {
                             $(this).dialog('close');
                         }
                    }
                });
            } 
        });
        listServer();
    });
    
    var listServer = function() {
  	   $.ajax ({ 
  		   url:'./board_json.do',
  		   type: 'get',
  		   dataType: 'json',
  		   success: function(json) {
//   			   console.log(data);
  			   listData(json.data);
  		   },
  		   error: function(e) {
  				console.log('[에러] ' + e.status);
  				console.log('[에러] ' + e.responseText);
  		   }
  		});
  	};
  	var listData = function(data) {
 	   $( '#accordion' ).empty();
 	   
 		$.each(data, function(index, item) {
 			var html = '';
 			html += '<h3> ' + item.seq + '번 글 : '+ item.subject + '</h3>';
 			html += '<div>';
 			html += '	<div style="width: 80%; float: left;">' + item.content + '</div>';
 			html += '	<div class="buttons" style="text-align:right; vertical-align:bottom;">';
 			html += '		<button seq="' + item.seq + '" action="modify" class="action">수정</button>';
 			html += '		<button seq="' + item.seq + '" action="delete" class="action">삭제</button>';
 			html += '	</div>';
 			html += '</div>';
 			
 			$('#accordion').append(html);
 			$('.buttons:eq(' + index + ') button').button().on('click', function() {
 				
 				var seq = item.seq;
             	var subject = item.subject;
             	var writer = item.writer;
             	var mail = item.mail;
             	var content = item.content;
             	
				if( $( this ).text() == '수정' ) {
					$('#m_subject').val(subject);
					$('#m_writer').val(writer);
					$('#m_mail').val(mail);
					$('#m_content').val(content);
					
 	                $('#modifyDialog').dialog({
 	                    width: 700,
 	                    height: 500,
 	                    modal: true,
 	                    buttons: {
 	                    	"글수정": function() {
 	                             subject = $('#m_subject').val();
 	                             writer = $('#m_writer').val();
 	                             content = $('#m_content').val();
 	                             var password = $('#m_password').val();
 	                             
 	                             modifyServer(seq, subject, mail, password, content);
 	                         },
 	                         "취소": function() {
 	                             $(this).dialog('close');
 	                         }
 	                    }
 	                });
				} else if( $( this).text() == '삭제' ) {
					$('#d_subject').val(subject);
 	                $('#deleteDialog').dialog({
 	                    width: 700,
 	                    height: 200,
 	                    modal: true,
 	                    buttons: {
 	                         "글삭제": function() {
 	                             var password = $('#d_password').val();
 	                             deleteServer(seq, password);
 	                         },
 	                         "취소": function() {
 	                             $(this).dialog('close');
 	                         }
 	                    }
 	                });
 	            }
 			});
 		});
 		$('#accordion').accordion('refresh');
    };
    
    var writeServer = function(subject, writer, mail, password, content) {
		  $.ajax ({ 
			   url:'./board_write.do',
			   data: {
				   subject: subject,
				   writer: writer,
				   mail: mail,
				   password: password,
				   content: content
			   },
			   type: 'get',
			   dataType: 'json',
			   success: function(json) {
				   
				   if (json.flag == 0) {
					   $('#writeDialog').dialog( 'close' );
					   listServer();
				   } else {
					   alert('에러');
				   }
			  },
			  error: function(e) {
					console.log('[에러] ' + e.status);
					console.log('[에러] ' + e.responseText);
			  }
		});
	 };
    var deleteServer = function(seq, password) {
		  $.ajax ({ 
			   url:'./board_delete.do',
			   data: {
				   seq: seq,
				   password: password
			   },
			   type: 'get',
			   dataType: 'json',
			   success: function(json) {
				   
				   if (json.flag == 0) {
					   $('#deleteDialog').dialog( 'close' );
					   listServer();
				   } else {
					   alert('에러');
				   }
			  },
			  error: function(e) {
					console.log('[에러] ' + e.status);
					console.log('[에러] ' + e.responseText);
			  }
		});
	 };
    var modifyServer = function(seq, subject, mail, password, content) {
		  $.ajax ({ 
			   url:'./board_modify.do',
			   data: {
				   seq: seq,
				   subject: subject,
				   mail: mail,
				   password: password,
				   content: content
			   },
			   type: 'get',
			   dataType: 'json',
			   success: function(json) {
				   
				   if (json.flag == 0) {
					   $('#modifyDialog').dialog( 'close' );
					   listServer();
				   } else {
					   alert('에러');
				   }
			  },
			  error: function(e) {
					console.log('[에러] ' + e.status);
					console.log('[에러] ' + e.responseText);
			  }
		});
	 };
	 
</script>
</head>
<body>

<div id="accordion-resizer">
    <div id="btngroup1">
        <button action="write" class="action">글쓰기</button>
    </div>
    <br /><hr /><br />
    <div id="accordion">
        
    </div>
</div>

<div id="writeDialog" title="글쓰기"> 
     <fieldset>
          <div>
               <label for="subject" class="header">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</label>
               <input type="text" id="w_subject" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="writer" class="header">이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</label>
               <input type="text" id="w_writer" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="mail" class="header">메&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일</label>
               <input type="text" id="w_mail" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="password" class="header">비밀&nbsp;번호</label>
               <input type="password" id="w_password" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="content" class="header">본&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</label>
               <br />
               <textarea rows="15" cols="100" id="w_content" class="text ui-widget-content ui-corner-all">               </textarea>
          </div>
     </fieldset>
</div>

<div id="modifyDialog" title="글수정"> 
     <fieldset>
          <div>
               <label for="subject" class="header">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</label>
               <input type="text" id="m_subject" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="writer" class="header">이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</label>
               <input type="text" id="m_writer" class="text ui-widget-content ui-corner-all" readonly="readonly"/>
          </div>
          <div>
               <label for="mail" class="header">메&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일</label>
               <input type="text" id="m_mail" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="password" class="header">비밀&nbsp;번호</label>
               <input type="password" id="m_password" class="text ui-widget-content ui-corner-all"/>
          </div>
          <div>
               <label for="content" class="header">본&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</label>
               <br/>
               <textarea rows="15" cols="100" id="m_content" class="text ui-widget-content ui-corner-all"></textarea>
          </div>
     </fieldset>
</div>

<div id="deleteDialog" title="글삭제"> 
     <fieldset>
          <div>
               <label for="subject" class="header">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</label>
               <input type="text" id="d_subject" class="text ui-widget-content ui-corner-all" readonly="readonly"/>
          </div>
          <div>
               <label for="password" class="header">비밀&nbsp;번호</label>
               <input type="password" id="d_password" class="text ui-widget-content ui-corner-all"/>
          </div>
     </fieldset>
</div>

</body>
</html>
