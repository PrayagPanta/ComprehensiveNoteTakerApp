# ComprehensiveNoteTakerApp
A springboot based webapp to take notes along with relevant pictures.

To run the project:

Download the project
Create a new database "crud" in mysql.
In sts or Eclipse simply click on import new maven project and then import the project.
Run the project as a Spring Boot Application.

Few issues:

Thymeleaf simply doesn't display the user-photos from /user-photos directory , hence the file had to be uploaded to static/images/userPhotos directory. Due to this issue, recently uploaded image doesn't shpow up in the index.html. To see the image , right click your project on sts or Eclipse then click on Refresh then reload your webpage.
Fix for pagination is coming soon . Stay tuned for that.
