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
 * Model representing an error when an authentication request fails.
 */
@Immutable
public class AuthenticationError
{
  /** The symbolic reason for the failure. */
  private final String reason;

  /** A human-readable message. */
  private final String message;

  /**
   * Constructor.
   * @param reason The symbolic reason for the failure.
   * @param message A human-readable error message.
   */
  public AuthenticationError(String reason, String message)
  {
    this.reason = Preconditions.checkNotNull(reason, "reason cannot be null");
    this.message = Preconditions.checkNotNull(message, "message cannot be null");
  }

  /**
   * Gets the symbolic reason.
   * @return The symbolic reason.
   */
  public String getReason()
  {
    return this.reason;
  }

  /**
   * Gets the human-readable error message.
   * @return The error message.
   */
  public String getMessage()
  {
    return this.message;
  }

  /**
   * Gets a string representation.
   * @return The object as a String.
   */
  @Override
  public String toString()
  {
    return "AuthenticationError{" +
           "reason='" + this.reason + '\'' +
           ", message='" + this.message + '\'' +
           '}';
  }
}
