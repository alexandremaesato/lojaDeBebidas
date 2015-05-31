
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Loja Bebidas</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>

<c:set var="tipo" value="${sessionScope.tipo}" />



<body>
     
<div id="main_container">
    <c:import url="header.jsp" />
  <div id="main_content">
   
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    <div class="error_message">
        <h1>${mensagem}</h1></br>
    <a class="botao" href="index.jsp">Voltar</a>
    
    </div>
    
  
  
   
   
  </div>
  <!-- end of main content -->
  <c:import url="footer.jsp" />
</div>
<!-- end of main_container -->

</body>
</html>