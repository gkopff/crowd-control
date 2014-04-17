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

import javax.annotation.concurrent.Immutable;

/**
 * Model representing a password-based authentication request.
 */
@Immutable
public class AuthenticationRequest
{
  /** The user's password. */
  private final String value;

  /**
   * Constructor.
   * @param password The password.
   */
  public AuthenticationRequest(String password)
  {
    this.value = Preconditions.checkNotNull(password, "password cannot be null");
  }

  /**
   * Gets the password.
   * @return The password.
   */
  public String getPassword()
  {
    return this.value;
  }
}
