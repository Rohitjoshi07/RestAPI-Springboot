This is the backend for the Credit Card Application, which is responsible for handling REST API requests from the frontend and interacting with the database to manage user data and issue credit cards.

Technologies used
The following technologies were used to build this backend:

Java 11
Spring Boot
PostgresSQL
JWT (JSON Web Tokens)
256-bit SHA encryption

Installation
Clone the repository:

'''
git clone https://github.com/your_username/credit-card-app-backend.git
cd credit-card-app-backend
'''

Install dependencies:

The backend uses Maven for dependency management. Make sure you have Maven installed. Then, run the following command to install dependencies:

'''
mvn clean install
Start the server:
'''

Run the following command to start the server:

'''
mvn spring-boot:run
'''

The server will start running on http://localhost:8080 by default.
Security
This backend implements the following security measures:

JWT (JSON Web Tokens) are used for authentication and authorization. This ensures that only authenticated users can access protected routes.
Multiple card allotment is restricted based on user's credit score and income.
User data is encrypted using 256-bit SHA encryption. This ensures that sensitive user data is stored securely in the database.

Conclusion
This backend provides a robust and secure backend for the Credit Card Application. It is designed to handle REST API requests and interact with the database to manage user data and issue credit cards. If you have any questions or suggestions, feel free to contact us.

