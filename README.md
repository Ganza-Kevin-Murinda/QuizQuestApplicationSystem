QuizQuest

QuizQuest: is a self-paced quiz application designed to help students enhance their understanding in different courses, focusing on programming-related questions. 
This Java Desktop application is built using the Hibernate framework and Remote Method Invocation (RMI), with MySQL as the database management system. 
The project is divided into two main directories: QuizQuestApplicationSystem_Client and QuizQuestApplicationSystem_Server.

Project Structure:

QuizQuestApplicationSystem_Client: Contains the client-side implementation, including user interface and interaction logic.
QuizQuestApplicationSystem_Server: Contains the server-side implementation, including database interaction and business logic.

Technologies Used:

Java
Hibernate: For Object-Relational Mapping (ORM) and database interaction.
RMI (Remote Method Invocation): For enabling communication between the client and server applications.
MySQL: As the relational database management system.
RMI: Remote Method Invocation

Remote Method Invocation:

RMI: is a Java technology used to develop distributed Java applications where a server and client can communicate over a network. 
The client application invokes methods hosted by the server, allowing for remote communication.

Key Concepts:

STUB: The gateway used by the client to invoke methods on the server.
SKELETON: The gateway used by the server to process method calls from the client.

Client-Side Method Invocation Process (STUB):

The client establishes a connection with the server.
It invokes a method exposed by the server.
The client waits for a response from the server.
The response is communicated back to the client.

Server-Side Method Invocation Process (SKELETON):

The server accepts a connection request from the client.
It checks if the invoked method exists.
The server processes the invoked method.
The response is sent back to the client.
