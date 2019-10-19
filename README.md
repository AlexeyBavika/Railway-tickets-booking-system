# Railway-tickets-booking-system
***
## Description
Site for booking railway tickets. Here are two roles : admins and passengers. Passenger can buy tickets for actual routes. Passenger
chooses route, then system picks up all trains for current route and passenger chooses type of place with different prices.

Admin manages with passengers, routes, prices, trains and orders.
***
## Requirements
Please make sure that you have already installed : 

    1. JDK 1.8 or higher
    2. MySQL 8.0.15 or higher
***
## Installiation

    1. Clone this project from GitHub
    2. Go to /src/main/resources/database.properties and fill in connection parameters to your database (url/login/password).
    3. Execute script /src/main/resources/railway_tickets_booking_system_database.sql
***
## Running
    1. cd to root project folder and execute command mvn clean tomcat7:run
    2. After server start, application will be available by URL http://localhost:8080/
    3. Use login "admin@gmail.com" and password "123" to log in with administrator rights.
    4. Or register new user to log in as passenger.
