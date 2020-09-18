<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<style type="text/css">
	body { font-size: 80%; }
	#draggable { width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0; }
  	#droppable { width: 150px; height: 150px; padding: 0.5em; float: left; margin: 10px; }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#draggable').draggable();
		$('#droppable').droppable({
			drop: function() {
				console.log('drop');
				console.log($(this).html());
				
				$(this).find('p').html('Dropped!').addClass("ui-state-highlight");
			}
		})
	});
</script>
</head>
<body>

<div id="draggable" class="ui-widget-content">
  <p>Drag me to my target</p>
</div>
 
<div id="droppable" class="ui-widget-header">
  <p>Drop here</p>
</div>

</body>
</html>