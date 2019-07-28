# FoodApp

Raymond Neo Soon Aik S10185503D

Guhesh Nalachandiran S10187977C

Aniq

NP Foodie

Our team has to decide to create an application that enable anyone to leave a review on ofr canteens in Ngee Ann Polytechnic. By doing this students or outsiders are able to know what are the hottest and famous food stalls in NP.

![page 4](https://user-images.githubusercontent.com/52902576/62009598-b1095b00-b193-11e9-9b63-eb8fdad28f36.PNG)
This will be the first page that will be displayed when the user first launch the application.

			








![Page 1](https://user-images.githubusercontent.com/52902576/62009625-edd55200-b193-11e9-91db-e48b4c90a879.PNG)
If you are a new user, you are required to register an account before able to display or post a review

![Alt text](relative/path/to/img.jpg?raw=true "Title")















![page 5](https://user-images.githubusercontent.com/52902576/62009641-15c4b580-b194-11e9-9234-41bf3e1df58d.PNG)
When the user register an account, this is the page the user needs to go to. In this page the user is required to enter a username and password. Once done the user has to click the create and he/she will be brought back to the login page. Username has to be alphanumeric with 6 to 12 characters. Whereas Password requires at least a letter, number and special character like “@”  with at least  6 to 12 characters.    











![Court pic](https://user-images.githubusercontent.com/52902576/62009657-56bcca00-b194-11e9-9185-68aa3c272573.PNG)
  When the user logs in with their account successfully, the app will bring the user to this page. This page allows user to pick the food court the stall belongs to. This will then bring the user to a list of foodstalls. A log out page has been added so that user can log out when he is done.            

![Stall pic](https://user-images.githubusercontent.com/52902576/62009658-591f2400-b194-11e9-8121-c90285482462.PNG)
Once the user choose the desired food court, the app will bring the user to a list of food stalls that belongs to the food court, User can pick the right stalls to view the details of the stall individually. A return button is available at the bottom of the page in case the user wants to return.















![stallreview pic](https://user-images.githubusercontent.com/52902576/62009660-5de3d800-b194-11e9-82a5-3c51adc0746b.PNG)
After User choose the stall they want to view, the app will bring them to the details page. This page provides the user with stall information like the stall name, stall description and picture.
Users also can view the reviews that is posted to the stalls. There are two buttons at the bottom, one to post review and another to return. The post review button will user to another page that allow the user to write a review and post it to the stall.The return button will return user to the page that display the list of stalls









![review pic 1](https://user-images.githubusercontent.com/52902576/62009661-5fad9b80-b194-11e9-9663-200bea3ab934.PNG)
When the user press the post review button , the app will bring the user to this page to write up their review. The user can put a score of 1 - 10 depending how they like the food and the stall. The user then put a write up on the experience they had


















![review pic 2](https://user-images.githubusercontent.com/52902576/62009662-620ff580-b194-11e9-9a85-baba353904a9.PNG)
After the user have enter what they want to , they can press the post review button to go back to the stall details page. If the user enters a score input that is not 1-10, a toast message will show asking user to amend the score. If all the requirements are valid. User will be brought back to the stall details page.















![stall review pic 2](https://user-images.githubusercontent.com/52902576/62009663-63d9b900-b194-11e9-838d-d3d641e7f6e0.PNG)
After Posting the review, the app will bring the user back to the details page. The details page will then have a newly added review onto the review list displayed on the screen. The user can choose to return the app or post another review .


Guhesh:

Added Login Function for user to access by comparing with username and password 

Register activities for new user to add their account to the database.

Layout of the Login and Register

Added Validation: check user and pass by using regular expression, check corret valid username and password during login from database
apply error message if incorrect

Helped with the creation of DataBase tables, added user, foodourt,food stall,Review tables

Created the Finduser , Adduser , EditPassword and insertStall functions in database

Created the UserData Class

I also contributed in the storyboarding of our application: Contribute to the flow of the app and the looks

Raymond: 

Implement SharedPrefernces in the whole App

Implement Court activity that list the court using a recycle view

implement a clickable view to bring to the stall list page

Implement the Stall activity that list the stall of the selected court to recycler view , implement return button to foodcourt page

implement a clickable view to bring to the details page

Implement the FoodStallReview page : Allow the User to see the details of the stall and post review button

Implement the PostReviewPage: Allow user to Enter a score and Review to post it to database

Implement validation: Only allow score to be 1-10 

Helped with creation of DataBase Table: user,foodcourt,foodstall,review

Helped with creation of insert statement: Foodcourt data

Created getcourt , getstall , getstalldetail , add review and getreview in databasehandler 

Created Class: Stalls, Court, Review

Layout: courtlayout, stall layout, reviewlayout (recycler view) courtrv , stallrv , foodstallreview, post review(activty)

Aniq:

Implemented the MainMenu page to go to court page , settings and logout

Implemented the Settings Page : Get new username and Password from user and update them into the database

Validation used: Regular expression to ensure that password and username has the requirement needed, Ensure it is not the same as the current username and password. 

Implemented The recycler view for the foodstallreview activity

Helped with the insert statement in database: for the foodcourt and foodstalls

Layout for the foodstallreview , main menu and settings

storyboarding of our application: Contribute to the flow of the app and the looks





