# INF5190_ProjetSession

Ceci est une application web pour l’inscription de cours de natation d'un nouveau centre aquatique utilisant Java EE avec le framework front-end struts 2. Pour la première itération, nous n'avons pas inclus de base de données mes plutons des fichiers .txt (le path vers ces fichiers devrait s'adapter d'une machine a une autre).Pour lancer cette application, il est nécessaire d'installer tomcat v9.

Nous avons décidé d'utiliser Struts 2 afin de profiter de ses multiples avantages dont sa facilité à être maintenue. Struts 2 offre notamment une conception simplifiée, car le code n'est pas étroitement lié au framework Struts ou à l'API Servlet. Il peut ce Plug-in facilement, les développeurs peuvent facilement utiliser d'autres technologies comme SiteMesh, Spring, Tiles, etc. De plus, les Actions sont également de simple plain old Java objects et elles n'ont pas besoin d'implémenter une interface ou d'étendre une classe. 

![preview](/preview.png)

- Url du login pour les Utilisateurs : http://localhost:8080/INF5190_ProjetSession/Login.jsp Il est possible de s'authentifier en utilisant le **nom d'utilisateur : User1 et le password : pass1**

- Url du login pour les Administrateurs : http://localhost:8080/INF5190_ProjetSession/AdminLogin.jsp Il est possible de s'authentifier en utilisant le **nom d'administrateur : admintest1 et le password : pass1**

## Important

Pour que le projet fonctionne correctement avec les fichiers simulant la base de données, nous avons implémenter un Path manager qui rend notre Application portable sous certaines conditions:

- Le répertoire workspace d'éclipse doit contenir le projet **INF5190_ProjetSession**

- Le Path de nos fichiers text (il existe déjà) est: ProjectWorkplace/INF5190_ProjetSession/WebContent/Data/

## Repartition du travail

L'ensemble des taches du projet ont été reparties initialement en 3 taches par personne. Le rôle de chacun se trouver dans le backlog du projet.
https://github.com/trafalgarxlaw/INF5190_ProjetSession/projects/1


