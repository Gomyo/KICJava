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
	.ui-menu {width: 150px;}
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	    // 해야될 내용 기술
	    $('#menu').menu();
	});
</script>
</head>
<body>
<ul id="menu">
  <li class="ui-state-disabled"><div>Toys (n/a)</div></li>
  <li><div>Books</div></li>
  <li><div>Clothing</div></li>
  <li><div>Electronics</div>
    <ul>
      <li class="ui-state-disabled"><div>Home Entertainment</div></li>
      <li><div>Car Hifi</div></li>
      <li><div>Utilities</div></li>
    </ul>
  </li>
  <li><div>Movies</div></li>
  <li><div>Music</div>
    <ul>
      <li class="ui-state-disabled"><div>Rock</div>
        <ul>
          <li><div>Alternative</div></li>
          <li><div>Classic</div></li>
        </ul>
      </li>
      <li><div>Jazz</div>
        <ul>
          <li><div>Freejazz</div></li>
          <li><div>Big Band</div></li>
          <li><div>Modern</div></li>
        </ul>
      </li>
      <li><div>Pop</div></li>
    </ul>
  </li>
  <li class="ui-state-disabled"><div>Specials (n/a)</div></li>
</ul>
</body>
</html>