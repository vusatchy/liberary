<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">


    <link href="${contextPath}/css/product.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

  <div class="navbar navbar-inverse navbar-static-top">

   <div class="container">

        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${contextPath}/purchase">Your purchases</a></li>
            <li><a href="${contextPath}/logout">Log out</a></li>
          </ul>
        </div>
      </div>
    </div>

<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
   <style>
       .nav-tabs > li, .nav-pills > li {
           float:none;
           display:inline-block;
           *display:inline; /* ie7 fix */
            zoom:1; /* hasLayout ie7 trigger */
       }

       .nav-tabs, .nav-pills {
           text-align:center;
       }
    </style>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
	<div class="row">
        <c:forEach items="${books}" var="book">
        <div class="col-sm-3">
        	<article class="col-item">
        		<div class="photo">
        			<a href="#"> <img src="${book.large}"  width="190" height="230" alt="Product Image" /> </a>
        		</div>
        		<div class="info">
        			<div class="row">
        				<div class="price-details col-md-6">
        					<h1>${book.title}</h1>
        					<span class="price-new"><br>${book.author}</span>
        				</div>
        			</div>
        			<div class="separator clear-left">
        				<p class="btn-add">
        				<a href="${contextPath}/books?id=${book.id}" class="hidden-sm">Look at it</a>
        				</p>
        			</div>
        			<div class="clearfix"></div>
        		</div>
        	</article>
        </div>
        </c:forEach>
	</div>
</div
</body>
<div class="text-center">
<ul class="pagination  pagination-lg">
        <%
                   String prev = (String)request.getAttribute("prev");
                   if(prev != null){
                   out.println( "<li><a href=\"/books/" +  prev +"\">" + prev +"</a></li>");
                   }
        %>
     <li class="active"><a href="${contextPath}/books/${current}">${current}<span class="sr-only">(current)</span></a></li>

         <%
                              String next = (String)request.getAttribute("next");
                              if(next != null){
                              out.println( "<li><a href=\"/books/" +  next +"\">" + next +"</a></li>");
                              }
          %>
            </ul>
</div>