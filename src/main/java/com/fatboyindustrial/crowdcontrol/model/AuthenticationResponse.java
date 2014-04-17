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

package com.fatboyindustrial.crowdcontrol.model;

import com.google.common.base.Preconditions;
import com.google.gson.annotations.SerializedName;

import javax.annotation.concurrent.Immutable;

/**
 * Model representing a password-based authentication (positive) response.
 */
@Immutable
public class AuthenticationResponse
{
  /** TODO: determine what this represents. */
  private final String expand;

  /** The link to the user. */
  private final Link link;

  /** The username. */
  private final String name;

  /** User's given name. */
  @SerializedName("first-name")
  private final String firstName;

  /** User's family name. */
  @SerializedName("last-name")
  private final String lastName;

  /** User's display name. */
  @SerializedName("display-name")
  private final String displayName;

  /*** User's email address. */
  private final String email;

  /** TODO: determine what this represents. */
  private final String key;

  /** Is this an active user? */
  private final boolean active;

  /**
   * Constructor.
   * @param expand The expand text.
   * @param link The link to the user resource.
   * @param username The username.
   * @param givenName The user's given name.
   * @param familyName The user's family name.
   * @param displayName The user's display name.
   * @param email The user's email.
   * @param key The key.
   * @param active Is this user active?
   */
  public AuthenticationResponse(String expand,
                                Link link,
                                String username,
                                String givenName,
                                String familyName,
                                String displayName,
                                String email,
                                String key,
                                boolean active)
  {
    this.expand = Preconditions.checkNotNull(expand, "expand cannot be null");
    this.link = Preconditions.checkNotNull(link, "link cannot be null");
    this.name = Preconditions.checkNotNull(username, "username cannot be null");
    this.firstName = Preconditions.checkNotNull(givenName, "givenName cannot be null");
    this.lastName = Preconditions.checkNotNull(familyName, "familyName cannot be null");
    this.displayName = Preconditions.checkNotNull(displayName, "displayName cannot be null");
    this.email = Preconditions.checkNotNull(email, "email cannot be null");
    this.key = Preconditions.checkNotNull(key, "key cannot be null");
    this.active = active;
  }

  /**
   * Gets the expand text.
   * @return The text.
   */
  public String getExpand()
  {
    return this.expand;
  }

  /**
   * Gets the link to the user resource.
   * @return The user resource link.
   */
  public Link getLink()
  {
    return this.link;
  }

  /**
   * Gets the username.
   * @return The username.
   */
  public String getUsername()
  {
    return this.name;
  }

  /**
   * Gets the user's given name.
   * @return The given name.
   */
  public String getGivenName()
  {
    return this.firstName;
  }

  /**
   * Gets the user's family name.
   * @return The family name.
   */
  public String getFamilyName()
  {
    return this.lastName;
  }

  /**
   * Gets the user's display name.
   * @return The display name.
   */
  public String getDisplayName()
  {
    return this.displayName;
  }

  /**
   * Gets the user's email address.
   * @return The email address.
   */
  public String getEmail()
  {
    return this.email;
  }

  /**
   * Gets the key.
   * @return The key.
   */
  public String getKey()
  {
    return this.key;
  }

  /**
   * Is this user active?
   * @return True if the user is active, false otherwise.
   */
  public boolean isActive()
  {
    return this.active;
  }

  /**
   * Gets a string representation.
   * @return The object as a String.
   */
  @Override
  public String toString()
  {
    return "AuthenticationResponse{" +
           "expand='" + this.expand + '\'' +
           ", link=" + this.link +
           ", name='" + this.name + '\'' +
           ", firstName='" + this.firstName + '\'' +
           ", lastName='" + this.lastName + '\'' +
           ", displayName='" + this.displayName + '\'' +
           ", email='" + this.email + '\'' +
           ", key='" + this.key + '\'' +
           ", active=" + this.active +
           '}';
  }
}
