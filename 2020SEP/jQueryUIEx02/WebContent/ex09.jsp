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
	    $('#spinner').spinner({
	    	min: 5,
	    	max: 250,
	    	step: 5,
	    	spin: function(event, ui) {
				// console.log($(this).spinner('value'));
	    		console.log(ui.value);
			}
	    });
	});
</script>
</head>
<body>
<input type="text" id="spinner" value="10" readonly="readonly" />
</body>
</html>