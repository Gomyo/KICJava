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
		/* $('input[type="checkbox"]').checkboxradio({
			icon: false
		}); */
		
		/* $('input[type="checkbox"]').checkboxradio().on('click', function() {
			console.log('click');
		}); */
		
		$('input[type="checkbox"]').checkboxradio().on('change', function() {
			console.log($(this));
		});
		
		$('input[type="radio"]').checkboxradio({
			icon: false
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>Hotel Ratings</legend>
		<label for="cb-1">2 star</label><input type="checkbox" name="cb1" id="cb-1" />
		<label for="cb-2">3 star</label><input type="checkbox" name="cb2" id="cb-2" />
		<label for="cb-3">4 star</label><input type="checkbox" name="cb3" id="cb-3" />
		<label for="cb-4">5 star</label><input type="checkbox" name="cb4" id="cb-4" />
	</fieldset>
	<br /><br />
	<fieldset>
		<legend>Select a Location</legend>
		<label for="r-1">New York</label><input type="radio" name="r1" id="r-1" />
		<label for="r-2">Paris</label><input type="radio" name="r2" id="r-2" />
		<label for="r-3">London</label><input type="radio" name="r3" id="r-3" />
	</fieldset>
</body>
</html>