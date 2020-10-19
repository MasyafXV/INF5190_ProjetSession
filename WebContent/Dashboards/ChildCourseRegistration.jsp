
<h1>Inscrire mon enfant a un cours</h1>


<div class="CourseSelection">

<s:form action="ChildCourseRegistration" >

<s:hidden name="user.userName" value="%{#sessionUsername}"/>
<s:hidden name="child.childName" value="xxxx"/>
<s:hidden name="childInscription" value="true"/>

<div class="select">
   <select name="course.courseLevel" id="format">
      <option selected disabled>Choisissez un cours</option>
      <option value="Etoile_de_mer">Étoile de mer</option>
      <option value="Bambins">Bambins</option>
      <option value="Tortues">Tortues</option>
      <option value="Pingouins">Pingouins</option>
      <option value="Salamandre">Salamandre</option>
      <option value="Baleines">Baleines</option>
      <option value="Grenouilles">Grenouilles</option>
      <option value="Dauphins">Dauphins</option>
      <option value="Maitre_Nageur">Maître-Nageur</option>

   </select>
</div>
     <button type="submit" class="" value="UserCourseRegistration">>Register</button>

    </s:form>


</div>

<div>
<%--         <% for(int i = 0; i < childsList.size(); i+=1) { %>
            <div><%=childsList.get(i).getChildName()%> <%=childsList.get(i).getChildName()%></div>
            </br>
        <% } %> --%>
        

</div>


	 <style>
CourseSelection {
   display: flex;
   flex-direction: column;
   justify-content: center;
   align-items: center;
   height: 100vh;
   background: #23b499;
   font-family: 'Open Sans', sans-serif;
   color: #fff;
}
select {
   -webkit-appearance:none;
   -moz-appearance:none;
   -ms-appearance:none;
   appearance:none;
   outline:0;
   box-shadow:none;
   border:0!important;
   background: #5c6664;
   background-image: none;
   flex: 1;
   padding: 0 .5em;
   color:#fff;
   cursor:pointer;
   font-size: 1em;
   font-family: 'Open Sans', sans-serif;
}
select::-ms-expand {
   display: none;
}
.select {
   position: relative;
   display: flex;
   width: 20em;
   height: 3em;
   line-height: 3;
   background: #5c6664;
   overflow: hidden;
   border-radius: .25em;
}
.select::after {
   content: '\25BC';
   position: absolute;
   top: 0;
   right: 0;
   padding: 0 1em;
   background: #2b2e2e;
   cursor:pointer;
   pointer-events:none;
   transition:.25s all ease;
}
.select:hover::after {
   color: #23b499;
}
	 
		</style>