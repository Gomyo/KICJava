<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<style type="text/css">
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	$( function() {
	    $( ".widget button" )
	      .eq( 0 ).button()
	      .end().eq( 1 ).button( {
	        icon: "ui-icon-gear",
	        showLabel: false
	      } ).end().eq( 2 ).button( {
	        icon: "ui-icon-clipboard"
	      } ).end().eq( 3 ).button( {
	        icon: "ui-icon-gear",
	        iconPosition: "end"
	      } ).end().eq( 4 ).button( {
	        icon: "ui-icon-gear",
	        iconPosition: "top"
	      } ).end().eq( 5 ).button( {
	        icon: "ui-icon-gear",
	        iconPosition: "bottom"
	      } );
  } );
</script>
</head>
<body>
<div class="widget">
  <h1>Widget</h1>
  <button>Button with only text</button>
  <button>Button with icon only</button>
  <button>Button with icon on the left</button>
  <button>Button with icon on the right</button>
  <button>Button with icon on the top</button>
  <button>Button with icon on the bottom</button>
</div>
<div class="css">
  <h1>CSS</h1>
  <button class="ui-button ui-widget ui-corner-all">
    Button with only text
  </button>
  <button class="ui-button ui-widget ui-corner-all ui-button-icon-only" title="Button with icon only">
    <span class="ui-icon ui-icon-gear"></span> Button with icon only
  </button>
  <button class="ui-button ui-widget ui-corner-all">
    <span class="ui-icon ui-icon-gear"></span> Button with icon on the left
  </button>
  <button class="ui-button ui-widget ui-corner-all">
    Button with icon on the right <span class="ui-icon ui-icon-gear"></span>
  </button>
  <button class="ui-button ui-widget ui-corner-all">
    <span class="ui-icon ui-icon-gear ui-widget-icon-block"></span> Button with icon on the top
  </button>
  <button class="ui-button ui-widget ui-corner-all">
    Button with icon on the bottom <span class="ui-icon ui-icon-gear ui-widget-icon-block"></span>
  </button>
</div>
</body>
</html>