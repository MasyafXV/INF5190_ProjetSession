# INF5190_ProjetSession

Yassine Hasnaoui - HASY04089702

Tran Thien My Elsa - TRAT24569808

ARCOLE Alexandre-Thibault - ARCA83030008

Ceci est une application web pour l’inscription de cours de natation d'un nouveau centre aquatique utilisant Java EE avec le framework front-end struts 2. Pour la première itération, nous n'avons pas inclus de base de données mes plutons des fichiers .txt (le path vers ces fichiers devrait s'adapter d'une machine a une autre).Pour lancer cette application, il est nécessaire d'installer tomcat v9.

Nous avons décidé d'utiliser Struts 2 afin de profiter de ses multiples avantages dont sa facilité à être maintenue. Struts 2 offre notamment une conception simplifiée, car le code n'est pas étroitement lié au framework Struts ou à l'API Servlet. Il peut ce Plug-in facilement, les développeurs peuvent facilement utiliser d'autres technologies comme SiteMesh, Spring, Tiles, etc. De plus, les Actions sont également de simple plain old Java objects et elles n'ont pas besoin d'implémenter une interface ou d'étendre une classe. 

![preview](/preview.png)

- Url du login pour les Utilisateurs : http://localhost:8080/INF5190_ProjetSession/Login.jsp Il est possible de s'authentifier en utilisant le **nom d'utilisateur : User1 et le password : pass1**

- Url du login pour les Administrateurs : http://localhost:8080/INF5190_ProjetSession/AdminLogin.jsp Il est possible de s'authentifier en utilisant le **nom d'administrateur : admintest1 et le password : pass1**

## Important

Pour que le projet fonctionne correctement avec les fichiers simulant la base de données, nous avons implémenter un Path manager qui rend notre Application portable sous certaines conditions:

- Le répertoire workspace d'éclipse doit contenir le projet **INF5190_ProjetSession**

- Le Path de nos fichiers text (ce repertoire est temporaire en attendant l'implementation de notre base de donnée) est: ProjectWorkplace/INF5190_ProjetSession/WebContent/Data/

## Instruction pour l'utilisation de MangoDB

Installer MangoDB sur votre machine à l'aide de la `commande brew install mongodb-community` dans votre terminal. Verifier que MangoDB est bien installer a laide de `mongo --version` et demarrer le a l'aide de `brew services run mongodb-community`.

Acceder au Shell mango a laide de la commande `Mango`.

Entrez 

>`use MyDatabase`

Afin de creer une nouvelle base de donnees sous ce nom. Une fois completez, Telechargez et installer MongoDB Compass Afin de se connecter en local vers la base de donnes qu'on viens de creer. Pour vous connecter à votre MongoDB local, vous définissez Hostname sur localhost et Port sur 27017. Ces valeurs sont par défaut pour toutes les connexions MongoDB locales (sauf si vous les avez modifiées). Appuyez sur Connect, et vous devriez voir les bases de données dans votre MongoDB local. 

![DbConnection](/DbConnection.png)

Ici, vous devriez pouvoir voir `MyDatabase`.

![ConSuccess](/ConSuccess.png)


Toutes les dependances Jars necessaire au fonctionnement de MangoDB sont deja incluses dans le projet.

### Pour plus d'information

https://zellwk.com/blog/install-mongodb/

https://zellwk.com/blog/local-mongodb/#:~:text=To%20connect%20to%20your%20local,databases%20in%20your%20local%20MongoDB.







## À savoir

Nous nous sommes concentrés sur l'essentielle, c'est-à-dire le fonctionnement des fonctionnalités demandées dans l'énoncé du TP. Nous sommes conscients qu'il y a des use cases marginaux qu'on ne couvre pas dans nos fonctionnalités, mais nous espérons avoir le temps de couvrir cela dans la deuxième partie afin de rendre notre application encore plus robuste pour le lancement en production. Nous avons aussi rencontré quelques difficultés au sein de notre équipe de développement, nous avons dû nous séparer notre équipe initiale pour des raisons d'équité en termes de collaboration pour ce projet. Un nouveau membre nous a rejoints par la suite en mi-chemin de développement.

## Repartition du travail

L'ensemble des taches du projet ont été reparties initialement en 3 taches par personne. Le rôle de chacun se trouve dans le backlog du projet.
https://github.com/trafalgarxlaw/INF5190_ProjetSession/projects/1


