# crowd-control

A simple wrapper around the Atlassian Crowd REST API for authenticating against a Crowd server.

## Getting it

````
<dependency>
  <groupId>com.fatboyindustrial.crowd-control</groupId>
  <artifactId>crowd-control</artifactId>
  <version>0.1.0</version>
</dependency>
````

## How to use

````
 final Either<AuthenticationResponse, AuthenticationError> result =
     Interactors.authentication("http://localhost:8095/crowd", "appName", "appPass").execute("userName", "userPass");
 
 if (! result.isError())
 {
   final AuthenticationResponse response = result.getValue();
   System.out.println(response);
 }
 else
 {
   final AuthenticationError error = result.getError();
   System.out.println(error);
 }
````


##### Reference

* https://developer.atlassian.com/display/CROWDDEV/Crowd+REST+Resources
* https://developer.atlassian.com/display/CROWDDEV/JSON+Requests+and+Responses
