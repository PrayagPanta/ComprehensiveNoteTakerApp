# ComprehensiveNoteTakerApp
A springboot based webapp to take notes along with relevant pictures.

To run the project:

Download the project
Create a new database "crud" in mysql.
In sts or Eclipse simply click on import new maven project and then import the project.
Run the project as a Spring Boot Application.

Few issues:

Thymeleaf simply doesn't display the user-photos from /user-photos directory , hence the file had to be uploaded to static/images/userPhotos directory. The hardcoding for filepath had to done in FileUploadUtil. It is due to this issue, recently uploaded image doesn't shpow up in the index.html. To see the image , firslty change the location of your user-photos directory in FileUploadUtil before running the app. Then, right click your project on sts or Eclipse then click on Refresh then reload your webpage.

Also,Fix for pagination is coming soon . Stay tuned for that. For now please find and follow the commented logic for pagination on Maincontroller under showPage method.
