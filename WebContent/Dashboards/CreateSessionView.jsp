<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="listSessions" type="java.util.ArrayList<com.pronatation.Session.SessionBeans>" scope="request" />

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Admin - Create Session</title>
    <link rel="stylesheet" href="../css/User_menu_style.css">
    <link rel="stylesheet" href="../css/Admin_menu_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  </head>
  <body>

    <input type="checkbox" id="check">
    <!--header area start-->
    <header>
      <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
      </label>
      <div class="left_area">
        <h3>Pro <span>Natation</span></h3>
      </div>
      <div class="right_area">
        <a href="#" class="logout_btn">Logout</a>
      </div>
    </header>
    <!--header area end-->
    <!--sidebar start-->
    <div class="sidebar">
      <center>
        <img src="./img/logo.jpg" class="profile_image" alt="">
        <h4>Administrator</h4>
      </center>
      <a id="CreateSessionPage" href="<s:url action="ViewSession.action"></s:url>"><i class="fas fa-calendar"></i><span>Créer une session</span></a>
      <a id="CreateCoursePage" href="<s:url action="listSessions.action" ></s:url>"><i class="fas fa-table"></i><span>Ajouter un cours</span></a>      
      <a id="RegisterChildPage" href="<s:url action="redirectAddChild.action" ></s:url>"><i class="fas fa-graduation-cap"></i><span>Noter les nageurs</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
    </div>
    <!--sidebar end-->
    
    
    
    <div class="content">
    <div class="contentSession">
    		<h2>Create a New Session</h2>
    		
    		
    		<s:iterator value="listSessions" var="session">
					<i class="fa fa-chevron-right fa-rotate-90"> </i>
					<s:property value="#session.code"/>
					<s:property value="#session.season"/>
					<s:property value="#session.year"/>
					<s:property value="#session.sessionFrom"/>
					<s:property value="#session.sessionTo"/> <br><br>
				</s:iterator>
				
    	<s:form action="CreateNewSession" name="ajouterSession" onsubmit="return validForm()">
				<s:textfield cssClass="textfield" name="newSession.code" cssStyle="display:none;"/>
				<div class="select">
					<select name="newSession.season" id="format">
						<option selected disabled>Choisissez une saison</option>
						<option value="Hiver">Hiver</option>
						<option value="Ete">Été</option>
						<option value="Automne">Automne</option>
					</select>
				</div>
				<s:textfield cssClass="textfield" name="newSession.year" placeholder="Année : YYYY" />
				<s:textfield cssClass="textfield" name="newSession.sessionFrom" placeholder="Début : DD/MM/YYYY " />
				<s:textfield cssClass="textfield" name="newSession.sessionTo" placeholder="Fin : DD/MM/YYYY --" />
				<s:submit cssClass="button" value="Ajouter"></s:submit>
    	</s:form>
    	<h2 id="errorMsg" class="error"></h2>
    	
    	</div>
    	
    	<script type="text/javascript">
    		function validForm() {
    			let season = document.forms['ajouterSession']['newSession.season'].value;
    			let year = document.forms['ajouterSession']['newSession.year'].value.trim();
    			let sessionFrom = document.forms['ajouterSession']['newSession.sessionFrom'].value.trim();
    			let sessionTo = document.forms['ajouterSession']['newSession.sessionTo'].value.trim();
    			
    			let yearFormat = /(19|20)\d\d/i;
    			let dateFormat = /(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d/i;
    			
    			let invalide = season == "" || year == "" || sessionFrom == "" || sessionTo == "";
    			
    			if (invalide) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez remplir tout le formulaire";
    				return false;
    			}
    			else if (!year.match(yearFormat)) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez mettre l'anné au bon format (YYYY)";
    				return false;
    			}
    			else if (!sessionFrom.match(dateFormat)) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez mettre la date de début de session au bon format (DD/MM/YYYY)";
    				return false;
    			} 
    			else if (!sessionTo.match(dateFormat)) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez mettre la date de fin de session au bon format (DD/MM/YYYY)";
    				return false;
    			} 
    			
    			let firstLetterCode = season.substring(0, 1);
        		let yearCode = year.slice(-2);
        		let code = firstLetterCode+''+yearCode;
        		document.forms['ajouterSession']['newSession.code'].value = code;
        		document.forms['ajouterSession']['newSession.year'].value = year;
        		document.forms['ajouterSession']['newSession.sessionFrom'].value = sessionFrom;
        		document.forms['ajouterSession']['newSession.sessionTo'].value = sessionTo;
    		}
    	</script>
    </div>

  </body>
</html>
