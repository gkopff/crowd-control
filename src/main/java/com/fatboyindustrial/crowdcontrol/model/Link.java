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
 * Model representing a link.
 */
@Immutable
public class Link
{
  /** The relative resource. */
  private final String rel;

  /** The hyperlink. */
  private final String href;

  /**
   * Constructor.
   * @param rel The relative resource.
   * @param href The hyperlink.
   */
  public Link(String rel, String href)
  {
    this.rel = Preconditions.checkNotNull(rel, "rel cannot be null");
    this.href = Preconditions.checkNotNull(href, "href cannot be null");
  }

  /**
   * Gets the relative resource.
   * @return The relative resource.
   */
  public String getRel()
  {
    return this.rel;
  }

  /**
   * Gets the hyperlink.
   * @return The link.
   */
  public String getHref()
  {
    return this.href;
  }

  /**
   * Gets a string representation.
   * @return The object as a String.
   */
  @Override
  public String toString()
  {
    return "Link{" +
           "rel='" + this.rel + '\'' +
           ", href='" + this.href + '\'' +
           '}';
  }
}
