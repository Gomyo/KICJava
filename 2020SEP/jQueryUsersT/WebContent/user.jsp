<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 디자인에 관련된부분 --> <!-- ui때문에 stylesheet가 들어감 -->
<link rel="stylesheet" href="./css/base/jquery-ui.css"/>
<style>
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
 </style>
<!-- 자바스크립에 관련된부분 -->
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>

<script type="text/javascript">
   $(document).ready(function() {
	   $('#dialog-form').dialog({
	         autoOpen: false,
	         modal: true,
	         width: 500,
	         height: 300,
	         buttons: {
	            '취소': function() {
	               $(this).dialog('close');
	            },
	            '확인': function() {
	            	var name = $('#name').val();
	            	var email = $('#email').val();
	            	var password = $('#password').val();
	            	
	            	// 데이터의 검사 구문
	            	writerServer( name, email, password);
	            	// ajax의 특성 상 DB에 값이 들어가기 전에 비동기식으로 닫힌다. 따라서 여기서 다이얼로그를 닫으면 안된다.
// 	               	$(this).dialog( 'close' );
	            }
	         }
	   });
	   
	   $('#create-user').button().on('click', function() {
	         $('#dialog-form').dialog('open');
	   });
	   
	   listServer();
   });
   
   var listData = function(data) {
// 	   $( '#users tbody' ).empty(); // 이게 없으면 또 에러가 난다.
		
		$.each(data, function(index, item) {
			var html = '';
			html += '<tr>';
			html += '	<td>' + item.name + '</td>';
			html += '	<td>' + item.email + '</td>';
			html += '	<td>' + item.password + '</td>';
			html += '	<td>';
			html += '		<button id="modify-user" index="' + index + '">수정</button>';
			html += '		<button id="delete-user" index="' + index + '">삭제</button>';
			html += '	</td>';
			html += '</tr>';
			
			$( '#users tbody' ).append( html );
			
			$( '#users tbody tr:eq( ' + index + ' ) button' ).button().on( 'click', function() {
				var row = $( this ).attr( 'index' );
			
				if( $( this ).text() == '수정' ) {
					console.log( $( '#users tbody tr:eq(' + row + ') td:eq(0)' ).text() );
					console.log( $( '#users tbody tr:eq(' + row + ') td:eq(1)' ).text() );
				} else if( $( this).text() == '삭제' ) {
					var index = $( this ).attr( 'index' );
					$( '#users tbody tr:eq(' + row + ')' ).empty();
				}
			} );
		});
   };
	   
   var listServer = function() {
	   $.ajax ({ 
		   url:'./data/user_json.jsp',
		   type: 'get',
		   dataType: 'json',
		   success: function(data) {
			   console.log(data);
			   listData(data);
		   },
		   error: function(e) {
				console.log('[에러] ' + e.status);
				console.log('[에러] ' + e.responseText);
		   }
		   });
	};
	  
	  var writerServer = function(name, email, password) {
		  $.ajax ({ 
			   url:'./data/user_write.jsp',
			   data: {
				   name: name,
				   email: email,
				   password: password
			   },
			   type: 'get',
			   dataType: 'json',
			   success: function(json) {
				   
				   if (json.flag == 0) {
					   $('#dialog-form').dialog( 'close' );
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

<button id="create-user">추가</button>
<br/><hr/><br/>
<div id="user-contain" class="ui-widget">
   <h1>Existing User: </h1>
   <table id="users" class="ui-widget ui-widget-content">
   <thead>
   <tr class="ui-widget-header">
      <th width="200">Name</th>
      <th width="200">Email</th>
      <th width="200">Password</th>
      <th width="100"></th>
   </tr>
   </thead>
   <tbody>
   
   </tbody>
   </table>
</div>
<br/><hr/><br/>

<div id="dialog-form" title="Create new user">
  <p class="validateTips">All form fields are required.</p>
  <form>
    <fieldset>
      <label for="name">Name</label>
      <input type="text" name="name" id="name" value="Jane Smith" class="text ui-widget-content ui-corner-all">
      <label for="email">Email</label>
      <input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" value="xxxxxxx" class="text ui-widget-content ui-corner-all">
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>

</body>
</html>