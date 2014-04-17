# crowd-control

A simple wrapper around the Atlassian Crowd REST API for authenticating against a Crowd server.

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
