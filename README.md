# INF5190_ProjetSession

Ceci est une application web pour l’inscription de cours de natation d'un nouveau centre aquatique utilisant Java EE avec le framework front-end struts 2. Pour la premiere iteration, nous n'avons pas inclus de base de donnée mais plutots des fichiers .txt (Le path vers ces fichiers devrais s'adapter d'une machine a une autre).Pour lancer cette application, il est necessaire d'installer tomcat v9.

Nous avons decider d'utiliser Struts 2 afin de profiter de ses multiples avantages dont sa facilité à être maintenue. Struts 2 offre notamment une conception simplifiée, car le code n'est pas étroitement lié au framework Struts ou à l'API Servlet. Il peut ce Plug-in facilement, les développeurs peuvent facilement utiliser d'autres technologies comme SiteMesh, Spring, Tiles, etc. De plus, les Actions sont également de simple plain old Java objects et elles n'ont pas besoin d'implémenter une interface ou d'étendre une classe. 

![preview](/preview.png)


- Url du login pour les Utilisateurs : http://localhost:8080/INF5190_ProjetSession/Login.jsp Il es possible de se loger en utilisant le **nom d'utilisateur : User1 et le password : pass1**

 - Url du login pout les Administrateurs : http://localhost:8080/INF5190_ProjetSession/AdminLogin.jsp Il es possible de se loger en utilisant le **nom d'administrateur : admintest1 et le password : pass1**

## Important

Pour que le projet fonctionne correctement avec les fichier simulant la base de donnee, nous avons implementer un Path manager qui rend notre Application portable sous certaine conditions:

- Le repertoire workspace d'eclipse doit contenire le projet **INF5190_ProjetSession**

- Le Path de nos fichiers text (il existe deja) est: ProjectWorkplace/INF5190_ProjetSession/WebContent/Data/

## Repartition du travail

L'ensemble des taches du projet ont ete repartie initialement en 3 taches par personnes. Le role de chacun se trouvre dans le backlog du projet.
https://github.com/trafalgarxlaw/INF5190_ProjetSession/projects/1


