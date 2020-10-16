# INF5190_ProjetSession

description brouillon:
Java EE application utilisant le framework front-end struts 2. Pour la premiere iteration, nous n'avons pas inclus de base de donnée mais plutots des fichiers text (Le path vers ces fichiers devra changer d'une machine a une autre).Pour lancer cette application, il est necessaire d'installer tomcat v9.


Url du login pour les Utilisateurs : http://localhost:8080/INF5190_ProjetSession/Login.jsp

Url du login pout les Administrateurs : http://localhost:8080/INF5190_ProjetSession/AdminLogin.jsp

## Important

Pour que le projet fonctionne correctement avec les fichier simulant la base de donnee, nous avons implementer un Path manager qui rend notre Application portable sous certaine conditions:

- Le repertoire workspace d'eclipse doit contenire le projet **INF5190_ProjetSession**

