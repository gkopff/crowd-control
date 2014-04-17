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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

/**
 * Tests for {@link Link}.
 */
public class LinkTest
{
  /**
   * Tests that the object encodes to the expected JSON.
   */
  @Test
  public void testJson() throws JSONException
  {
    final Gson gson = new GsonBuilder().create();
    final String expected = "{ \"rel\": \"self\", \"href\": \"http://localhost:8095/crowd/rest/foo?arg=value\" }";
    final String actual = gson.toJson(new Link("self", "http://localhost:8095/crowd/rest/foo?arg=value"));

    assertThat(actual, is(sameJSONAs(expected)));
  }

  /**
   * Tests that the expected non-null precondition check works.
   */
  @Test(expected =  NullPointerException.class)
  public void testPreconditionsNullRel()
  {
    new Link(null, "http://localhost:8095/crowd/rest/foo?arg=value\"");
  }

  /**
   * Tests that the expected non-null precondition check works.
   */
  @Test(expected =  NullPointerException.class)
  public void testPreconditionsNullHref()
  {
    new Link("self", null);
  }
}
