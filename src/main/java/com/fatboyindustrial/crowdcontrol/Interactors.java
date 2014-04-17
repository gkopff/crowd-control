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

import javax.annotation.concurrent.Immutable;

/**
 * Factory for creating specific interactors. <p/>
 *
 * Use as follows: <p/>
 *
 * <pre>
 *    final Either<AuthenticationResponse, AuthenticationError> result =
 *        Interactors.authentication("http://localhost:8095/crowd", "appName", "appPass").execute("userName", "userPass");
 *
 *    if (! result.isError())
 *    {
 *      final AuthenticationResponse response = result.getValue();
 *      System.out.println(response);
 *    }
 *    else
 *    {
 *      final AuthenticationError error = result.getError();
 *      System.out.println(error);
 *    }
 * </pre>
 */
@Immutable
public class Interactors
{
  /**
   * Creates an authentication interactor, useful for authenticating a user.
   * @param baseUrl The Crowd base URL.
   * @param appName The application name as defined in Crowd.
   * @param appPassword The application password as defined in Crowd.
   * @return The interactor.
   */
  public static AuthenticationInteractor authentication(String baseUrl, String appName, String appPassword)
  {
    return new AuthenticationInteractor(baseUrl, appName, appPassword);
  }
}