/*
 * Copyright 2014 Greg Kopff
 * All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.fatboyindustrial.crowdcontrol;

import com.fatboyindustrial.crowdcontrol.model.AuthenticationError;
import com.fatboyindustrial.crowdcontrol.model.AuthenticationRequest;
import com.fatboyindustrial.crowdcontrol.model.AuthenticationResponse;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.annotation.concurrent.Immutable;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * An interactor for authenticating a user.
 */
@Immutable
public class AuthenticationInteractor
{
  /** The base URL of the crowd server. */
  private final String crowdBase;

  /** Crowd application name. */
  private final String appName;

  /** Crowd application password. */
  private final String appPassword;

  /**
   * Constructor.
   * @param crowdBase The base URL of the crowd server.
   * @param appName The application name as defined in Crowd.
   * @param appPassword The application password as defined in Crowd.
   * @throws IllegalArgumentException If either appName or appPassword are zero length.
   */
  public AuthenticationInteractor(String crowdBase, String appName, String appPassword) throws IllegalArgumentException
  {
    this.crowdBase = Preconditions.checkNotNull(crowdBase, "crowdBase cannot be null");
    this.appName = Preconditions.checkNotNull(appName, "appName cannot be null");
    this.appPassword = Preconditions.checkNotNull(appPassword, "appPassword cannot be null");

    Preconditions.checkArgument(! appName.isEmpty(), "appName cannot be empty");
    Preconditions.checkArgument(! appPassword.isEmpty(), "appPassword cannot be empty");
  }

  /**
   * Executes the interaction.
   * @param username The username to authenticate.
   * @param password The corresponding password.
   * @return Either a successful response, or the reason for the error.
   */
  public Either<AuthenticationResponse, AuthenticationError> execute(String username, String password)
  {
    Preconditions.checkNotNull(username, "username cannot be null");
    Preconditions.checkNotNull(password, "password cannot be null");
    
    final WebTarget target = resource(newClient(), username);
    final Response response = target.request()
        .accept(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.entity(json(password), MediaType.APPLICATION_JSON_TYPE), Response.class);

    if (response.getStatus() == Response.Status.OK.getStatusCode())
    {
      return Either.value(buildResponse(response.readEntity(String.class)));
    }
    else
    {
      return Either.error(buildError(response.readEntity(String.class)));
    }
  }

  /**
   * Creates a new HTTP client configured with basic authentication.
   * @return The HTTP client.
   */
  private Client newClient()
  {
    final Client client = ClientBuilder.newBuilder().build();
    client.register(HttpAuthenticationFeature.basic(this.appName, this.appPassword));

    return client;
  }

  /**
   * Creates a new web target for the authentication URL.
   * @param client The HTTP client.
   * @param username The username to authenticate.
   * @return The web target.
   */
  private WebTarget resource(Client client, String username)
  {
    return client.target(this.crowdBase)
        .path("rest/usermanagement/latest/authentication")
        .queryParam("username", username);
  }

  /**
   * Gets the JSON representation of an authentication request.
   * @param password The password to use in the request.
   * @return The JSON.
   */
  private static String json(String password)
  {
    final Gson gson = new GsonBuilder().create();
    return gson.toJson(new AuthenticationRequest(password));
  }

  /**
   * Converts the given JSON into an authentication response object.
   * @param json The JSON.
   * @return The object.
   */
  private static AuthenticationResponse buildResponse(String json)
  {
    final Gson gson = new GsonBuilder().create();
    return gson.fromJson(json, AuthenticationResponse.class);
  }

  /**
   * Converts the given JSON into an authentication error object.
   * @param json The JSON.
   * @return The object.
   */
  private static AuthenticationError buildError(String json)
  {
    final Gson gson = new GsonBuilder().create();
    return gson.fromJson(json, AuthenticationError.class);
  }
}
