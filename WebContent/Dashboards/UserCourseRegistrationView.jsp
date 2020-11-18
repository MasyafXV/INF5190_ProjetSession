<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	HttpSession sess = request.getSession(true);
if (sess.getAttribute("userName") == null) {
	response.sendRedirect("http://localhost:8080/INF5190_ProjetSession/Login");
}
%>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Menu</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link href="${pageContext.request.contextPath}/css/User_menu_style.css"
	rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/css/Checkout.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	charset="utf-8"></script>
</head>
<body>
	<s:url action='childsList' />
	<input type="checkbox" id="check">
	<!--header area start-->
	<header> <label for="check"> <i class="fas fa-bars"
		id="sidebar_btn"></i>
	</label>
	<div class="left_area">
		<h3>
			Pro <span>Natation</span>
		</h3>
	</div>
	<div class="right_area">
		<a href="#" class="logout_btn">Logout</a>
	</div>
	</header>
	<!--header area end-->
	<!--mobile navigation bar start-->
	<div class="mobile_nav">
	
	</div>
	<!--mobile navigation bar end-->
	<!--sidebar start-->
	<div class="sidebar">
		<div class="profile_info">
			<img src="${pageContext.request.contextPath}/img/avatar.png"
				class="profile_image" alt="">

			<h4 style="color: white">${sessionScope.userName}</h4>

			<s:set var="sessionUsername" value="userName" />
		</div>
		<a id="RegisterUserCoursePage"
			href="<s:url action="InitUserCourseInscription.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i
			class="fas fa-desktop"></i><span>S'inscrire a un cours</span></a> <a
			id="RegisterChildCoursePage"
			href="<s:url action="InitChildCourseInscription.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i
			class="fas fa-cogs"></i><span>Inscrire mon enfant</span></a> <a
			id="RegisterChildPage"
			href="<s:url action="redirectAddChild.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i
			class="fas fa-table"></i><span>Ajouter un enfant</span></a> <a href="#"><i
			class="fas fa-th"></i><span>Forms</span></a> <a href="#"><i
			class="fas fa-info-circle"></i><span>About</span></a> <a href="#"><i
			class="fas fa-sliders-h"></i><span>Settings</span></a>
	</div>
	<!--sidebar end-->

	<div class="content">

		<br />


		<h1>M'inscrire a un cours</h1>
		<div class="CourseSelection">


			<s:form action="UserCourseRegistration">

				<s:hidden name="user.userName" value="%{#sessionUsername}" />
				<s:hidden name="UserInscription" value="true" />
				<h2>Cours disponibles :</h2>

				<div class="select">
					<select name="course.courseCode" id="format"
						onchange="setValueCourseCode(this)">
						<option selected disabled>Choisissez un cours</option>



						<c:forEach items="${coursesList}" var="course">
							<option value="${course.courseLevel}">
								<c:out value="${course.sessionCode}" />-
								<c:out value="${course.courseLevel}" />
							</option>
						</c:forEach>
					</select>
				</div>
				<br />

			</s:form>
			
	<!-- Trigger/Open The Modal -->
			
				<div class="buttons">
					<div class="button-container">
						<button id="myBtn" class="btn effect01" type="submit" class="btn"
							value="UserCourseRegistration">Register</button>
					</div>
				</div>

		</div>

				<h1>
					<a id="UserHistoryCoursePage"
						href="<s:url action="UserCourseHistory.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><span>Historique
							de mes cours</span></a>
				</h1>
		<!-- The Modal -->
		<div id="myModal" class="modal">

			<!-- Modal content -->
			<div class="modal-content">
				<span class="close">&times;</span>

				<div class="checkout-div">
					<main id="main"> <section id="left">
					<div id="head">
						<h1>Devenez un pro</h1>
						<p>Venez nager!</p>
					</div>
					<h3>Seulement 79.99$</h3>
					</section> <section id="right">
					<h1>Purchase</h1>
					<form action="#">
						<div id="form-card" class="form-field">
							<label for="cc-number">Card number:</label> <input id="cc-number"
								maxlength="19" placeholder="1111 2222 3333 4444" required>
						</div>

						<div id="form-date" class="form-field">
							<label for="expiry-month">Expiry date:</label> <input type="date"
								id="cc-number" placeholder="expiry date" required>
						</div>

						<div id="form-sec-code" class="form-field">
							<label for="sec-code">Security code:</label> <input
								type="password" maxlength="3" placeholder="123" required>
						</div>
						<button   type="submit" value="UserCourseRegistration" form="UserCourseRegistration">Purchase !</button>
					</form>
					</section> 
				</main>
				</div>

			</div>

		</div>


		<script type="text/javascript">
			function setValueCourseCode(selectCourse) {
				let text = selectCourse.options[selectCourse.selectedIndex].text;
				selectCourse.options[selectCourse.selectedIndex].value = text;
			}

			// Get the modal
			var modal = document.getElementById("myModal");

			// Get the button that opens the modal
			var btn = document.getElementById("myBtn");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on the button, open the modal
			btn.onclick = function() {
				modal.style.display = "block";
			}

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
				modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		</script>


	</div>


</body>
</html>
