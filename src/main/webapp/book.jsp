<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>eCommerce Product Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <link href="${contextPath}/css/sprod.css" rel="stylesheet">
    <script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/debute/pen/axzkb?limit=all&page=2&q=comment" />

    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css'><link rel='stylesheet prefetch' href='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
    <style class="cp-pen-styles">@-webkit-keyframes rotating {
      from {
        -webkit-transform: rotate(0deg);
      }
      to {
        -webkit-transform: rotate(360deg);
      }
    }
    @-moz-keyframes rotating {
      from {
        -moz-transform: rotate(0deg);
      }
      to {
        -moz-transform: rotate(360deg);
      }
    }
    @-o-keyframes rotating {
      from {
        -o-transform: rotate(0deg);
      }
      to {
        -o-transform: rotate(360deg);
      }
    }
    @keyframes rotating {
      from {
        transform: rotate(0deg);
      }
      to {
        transform: rotate(360deg);
      }
    }
    .comments {
      width: 500px;
      min-height: 150px;
      position: absolute;
      left: 275px;
      margin: 15px auto;
      padding: 20px;
      font-family: "Helvetica Neue",arial,sans-serif;
      font-size: 15px;
    }
    .comments .loader {
      height: 45px;
      width: 45px;
      border: 4.5px solid rgba(0, 0, 0, 0.2);
      border-radius: 50%;
      border-left-color: #000;
      position: absolute;
      top: 70px;
      left: 245.5px;
      -webkit-animation: rotating 0.9s infinite linear;
      -moz-animation: rotating 0.9s infinite linear;
      -o-animation: rotating 0.9s infinite linear;
      animation: rotating 0.9s infinite linear;
    }
    .comments .inner {
      display: none;
    }
    .comments .inner .comment {
      border: 1px dashed #ccc;
      padding: 15px;
      min-height: 48px;
      margin-bottom: 10px;
      color: #ccc;
    }
    .comments .inner .comment .avatar {
      width: 48px;
      height: 48px;
      float: left;
    }
    .comments .inner .comment .body {
      margin-left: 55px;
    }
    .comments .inner .comment .body p {
      color: black;
    }
    .comments .inner .comment:hover {
      color: rgba(0, 39, 59, 0.35);
      background-color: rgba(200, 200, 200, 0.1);
      border-style: solid;
    }

    .add-new {
      margin-bottom: 55px;
    }
    .add-new .input {
      display: block;
      width: 475px;
      border: 3px solid #ccc;
      color: #888;
      padding: 8px 10px;
      outline: 0;
      font-family: "Helvetica Neue",arial,sans-serif;
      font-size: 15px;
    }
    .add-new .input.your-name {
      border-top-left-radius: 5px;
      border-top-right-radius: 5px;
    }
    .add-new .input.your-name.dived {
      margin-top: 2px;
      padding: 9px 10px 11px 10px;
    }
    .add-new .input.your-msg {
      margin-top: -5px;
      max-width: 475px;
      max-height: 150px;
      border-bottom-left-radius: 5px;
      border-bottom-right-radius: 5px;
    }
    .add-new .send-msg {
      border: 3px solid #ccc;
      color: #888;
      text-transform: uppercase;
      font-weight: bold;
      border-radius: 5px;
      padding: 8px 10px;
      background-color: transparent;
      outline: 0;
      float: right;
      margin-right: -1px;
      cursor: pointer;
    }
    .add-new .send-msg:hover {
      color: white;
      background-color: #ccc;
    }

    a {
      color: #408ac9;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
    </style>

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
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="${book.large}" /></div>
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">"${book.title}"</h3>
							<p class="product-description">
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							</p>
						<h4 class="price">author: <span>${book.author}</span></h4>
						<h4 class="avaliable">year: <span>${book.year}</span></h4>
						<br>
						<div class="action">
						    <form action="${contextPath}/purchase?id=${product.id}" method = "post">
							<button class="add-to-cart btn btn-default" type="submit">Add</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

 </body>
</html>
