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
	    $('#spinner1').spinner({
	    	min: 1,
	    	max: 9,
	    	step: 1
	    });
	    $('#spinner2').spinner({
	    	min: 1,
	    	max: 9,
	    	step: 1
	    });
	    $('#btn1').on('click', function() {
	    	$( "#accordion" ).accordion();
			var data = '';
			for( var i= $('#spinner1').spinner('value') ; i <= $('#spinner2').spinner('value') ; i++ ) {
				data += '<h3>' + i + '단 </h3>';
				data += '<div>';
				data += '	<p>';
				for( var j=1 ; j<=9 ; j++ ) {
					data +=  i + " X " + j + " = " + (i*j)+ "<br /><br />";
				}
				data += '	</p>';
				data += '</div>';
			}
			$( "#accordion" ).html(data);
			$( "#accordion" ).accordion('refresh');
		});
	});
</script>
</head>
<body>

<input type="text" id="spinner1" value="1" readonly="readonly" />

<input type="text" id="spinner2" value="9" readonly="readonly" />

<button id="btn1">구구단</button>
<br /><hr /><br />
<div id="accordion"></div>

</body>
</html>