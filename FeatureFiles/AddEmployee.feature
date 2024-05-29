Feature:
New Employee Creation/Adding

@tag3
Scenario Outline:
Employee Creation with Admin Credentials

Given launch chrome browser 
When i open application with url with "http://orangehrm.qedgetech.com/"
Then i should see login page
When i enter username as "Admin"
And i enter password as "Qedge123!@#"
And i click login button
Then i should see admin dashboard
When i click addemployee link
And i enter first name as "<fname>"
And i enter last name as "<lname>"
And i click save emp button
Then i should see employee in emptable
When i click logout link
And close the browser

Examples:
|fname|lname|
|vamsi1|jammala1|
|vamsi2|jammala2|
|vamsi3|jammala3|
|vamsi4|jammala4|
|vamsi5|jammala5|
|vamsi6|jammala6|
|vamsi7|jammala7|
|vamsi8|jammala8|
|vamsi9|jammala9|
