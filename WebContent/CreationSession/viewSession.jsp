<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<!-- Pour l'itération, il faut spécifier le type de données -->
<jsp:useBean id="listSessions" type="java.util.ArrayList<com.pronatation.Session.SessionBeans>" scope="request" />

<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des sessions</title>
    </head>
    <body>
        
        <% for(int i = 0; i < listSessions.size(); i+=1) { %>
            <div><%=listSessions.get(i).getSeason()%> <%=listSessions.get(i).getYear()%></div>
            </br>
        <% } %>
        
    </body>
</html>