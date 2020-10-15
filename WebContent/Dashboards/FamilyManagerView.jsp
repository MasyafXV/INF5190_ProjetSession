
<h1>Ajouter mon enfant</h1>

<!--         <h4 style="color:white"><s:property value="userName" /></h4>
 -->
	 <s:form action="ChildRegistration">
	 
	    <s:hidden name="userName" value="%{#sessionUsername}"/>
	 
		<div class="inputs">
			<div class="input">
				<input placeholder="child firstname" name="child_firstname">
				<img src="./img/user.svg">
			</div>
			<div class="input">
				<input  placeholder="child lastname"  name="child_lastname">
				<img src="./img/user.svg">
			</div>
			<div class="input">
				<input  placeholder="child birth date"  name="child_bdate">
				<img src="./img/user.svg">
			</div>
		</div>
		<button type="submit" class="btn" value="ChildRegistration">Ajouter !</button>
	 </s:form>
	 
	 <style>

.align {
	height: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding-bottom: 8px;
}


.extend {
	max-height: 946px;
}

.head {
	width: 100%;
	display: flex;
	height: 72px;
	justify-content: space-between;
}

.head a {
	height: 100%;
	padding: 0 28px;
	display: flex;
	align-items: center;
	justify-content: center;
	color: rgb(140,140,140);
	font-size: 20px;
	font-weight: 500;
}

.head .selected {
	position: relative;
	color: #00FF5C;
	font-weight: 700;
}

.head .selected:after {
	position: absolute;
	content: "";
	bottom: 0;
	left: 0;
	height: 5px;
	width: 100%;
	background: #00FF5C;
	border-radius: 99px 99px 0 0;
}

.tabs {
	height: calc(100% - 72px);
	display: flex;
}

form {
	width: 60%;
	height: 100%;
	flex-shrink: 0;
	padding: 44px 38px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
	position: relative;
	right: 0;
	transition: right 0.2s;
}

.extend form {
	right: 100%;
}

.inputs {
	width: 100%;
	padding-top: 6px;
}

.input {
	position: relative;
	margin-bottom: 20px;
	width: 100%;
	display: flex;
	align-items: center;
}

.input input {
	width: 100%;
	font-size: 17px;
	background: #1C1C1C;
	border-radius: 8px;
	padding: 16px 18px 16px 51px;
	color: rgb(220,220,220);
}

.input img {
	width: 16px;
	position: absolute;
	left: 19px;
}



 btn {
	display: block;
	background: #45f564;
	padding: 14px 52px;
	border-radius: 12px;
	color: white;
	font-weight: 700;
	font-size: 21px;
	cursor: pointer;
}
</style>