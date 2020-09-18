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
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	    $('#files').selectmenu({
	    	width: 500,
	    	change: function(event, ui) {
				//console.log($(this).val());
				console.log(ui.item.value);
			}
	    });
	});
</script>
</head>
<body>

<select id="files">
	<option value="jquery">jQuery.js</option>
	<option value="jqueryui">ui.jQuery.js</option>	
	<option value="somefile">Some Unknown file</option>
	<option value="someotherfile">Some other file</option>		
</select>

</body>
</html>