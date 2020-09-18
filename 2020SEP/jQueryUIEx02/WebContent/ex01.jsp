<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="./css/base/jquery-ui.css" /> -->
<link rel="stylesheet" href="./css/ui-lightness/jquery-ui.css" />
<style type="text/css">
	body { font-size: 80%; }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	    $('#btn2').button();

	    $('input').button();
	    
	    $('a').button();
	    
	    $('#btn5').button();
	});
</script>
</head>
<body>
<button id="btn1">버튼1</button><br /><br />
<button id="btn2">버튼2</button><br /><br />

<input type="submit" value="버튼3" /><br /><br />
<input type="button" value="버튼3" /><br /><br />

<a href="#">버튼4</a><br /><br />

<div id="btn5">버튼5</div><br /><br />
</body>
</html>