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
	$( function() {
		$.ajax({
			url: './data/data_json.jsp',
			type: 'get',
			dataType: 'json',
			success: function(json) {
				//console.log(json);
				$( "#tags" ).autocomplete({
					source: json
				});
			},
			error: function(e) {
				console.log('[에러] ' + e.status);
				console.log('[에러] ' + e.responseText);
			}
		});
		
		/* var availableTags = ;
		$( "#tags" ).autocomplete({
			source: availableTags
		}); */
	} );
</script>
</head>
<body>
<div class="ui-widget">
  <label for="tags">Tags: </label>
  <input id="tags">
</div>
</body>
</html>