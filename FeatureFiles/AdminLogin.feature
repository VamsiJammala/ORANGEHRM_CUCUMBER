Feature: Login Module
@tag1
Scenario: Admin login valid credentials
Given launch chrome browser 
When i open application with url with "http://orangehrm.qedgetech.com/"
Then i should see login page
When i enter username as "Admin"
And i enter password as "Qedge123!@#"
And i click login button
Then i should see admin dashboard
When i click logout link
And close the browser