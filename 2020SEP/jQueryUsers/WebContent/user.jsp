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
	  $.ajax({
		  url:'./data/user_json.jsp',
		  type: 'get',
		  dataType: 'json',
		  success: function(data) {
			  console.log(typeof data);
			  console.log(data.length);
			  console.log(data);

              // tr의 갯수를 알면, 순서값을 통해 위치를 특정할 수 있다.
              console.log($('#users tbody tr').length);
              
              var html = '';
			  for (var i=0; i<data.length; i++) {
	              html += '<tr>';
	              html += '   <td>' + data[i].name + '</td>';
	              html += '   <td>' + data[i].email + '</td>';
	              html += '   <td>' + data[i].password + '</td>';
	              html += '   <td>';
	              html += '   <button id="modify-user" index="' + i + '">수정</button>';
	              html += '   <button id="delete-user" index="' + i + '">삭제</button>';
	              html += '   </td>';
	              html += '</tr>';
			  }
              $('#users tbody').append(html);
              
              $( '#users tbody tr:eq( ' + ( $('#users tbody tr').length - 1 ) + ' ) button' ).button().on( 'click', function() {
                  if( $( this ).text() == '수정' ) {
                     var index = $( this ).attr( 'index' );
                     console.log(index);
                     
                     console.log( $( '#users tbody tr:eq(' + index + ') td:eq(0)' ).text() );
                     console.log( $( '#users tbody tr:eq(' + index + ') td:eq(1)' ).text() );
//                      $('#dialog-form').dialog('open');
//                      $( '#users tbody tr:eq(' + index + ')').empty();
                  } else if( $( this).text() == '삭제' ) {
                     // 삭제는 tr: empty로 걸면 된다.
                     var index = $( this ).attr( 'index' );
                     $( '#users tbody tr:eq(' + index + ')').remove();
                  }
               });
		  },
		  error: function(e) {
				colsole.log('[에러] ' + e.status);
				colsole.log('[에러] ' + e.responseText);
		  }
	  }),
	  
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
               $(this).dialog('close');
               $.ajax({
         		  url:'./data/user_write.jsp',
         		  type: 'get',
         		  dataType: 'json',
         		  success: function(data) {
         			  
         		  }
               }),
               
               $(this).dialog( 'close' );
            }
         }
      });
      
      $('#create-user').button().on('click', function() {
         $('#dialog-form').dialog('open');
      });
      
      
   });
   
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