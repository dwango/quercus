/*
 * Copyright (c) 1998-2012 Caucho Technology -- all rights reserved
 *
 * This file is part of Resin(R) Open Source
 *
 * Each copy or derived work must preserve the copyright notice and this
 * notice unmodified.
 *
 * Resin Open Source is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Resin Open Source is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, or any warranty
 * of NON-INFRINGEMENT.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Resin Open Source; if not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330
 *   Boston, MA 02111-1307  USA
 *
 * @author Nam Nguyen
 */

package com.caucho.quercus;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class QuercusRequestAdapter
{
  public static String getPageURI(HttpServletRequest request)
  {
    String uri
      = (String) request.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI);

    if (uri != null)
      return uri;
    else {
      // php/0829

      uri
        = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);

      if (uri != null)
        return uri;
      else
        return request.getRequestURI();
    }
  }
  
  public static String getPageContextPath(HttpServletRequest request)
  {
    String contextPath
      = (String) request.getAttribute(RequestDispatcher.INCLUDE_CONTEXT_PATH);
    
    if (contextPath != null)
      return contextPath;
    else
      return request.getContextPath();
  }
  
  /**
   * Returns the servlet-path for the current page, i.e. this will return the
   * url of the include page, not the original request.
   */
  public static String getPageServletPath(HttpServletRequest request)
  {
    String servletPath
      = (String) request.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
    
    if (servletPath != null)
      return servletPath;
    else
      return request.getServletPath();
  }
  
  /**
   * Returns the path-info for the current page, i.e. this will return the
   * url of the include page, not the original request.
   */
  public static String getPagePathInfo(HttpServletRequest request)
  {
    String uri
      = (String) request.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI);
    
    if (uri != null)
      return (String) request.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
    else
      return request.getPathInfo();
  }
  
  /**
   * Returns the query-string for the current page, i.e. this will return the
   * url of the include page, not the original request.
   */
  public static String getPageQueryString(HttpServletRequest request)
  {
    String uri
      = (String) request.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI);
    
    if (uri != null)
      return (String) request.getAttribute(RequestDispatcher.INCLUDE_QUERY_STRING);
    else {
      /*
      // php/0829
      uri = (String) request.getAttribute(FWD_REQUEST_URI);

      if (uri != null)
        return (String) request.getAttribute(FWD_QUERY_STRING);
      else
        return request.getQueryString();
      */
      return request.getQueryString();
    }
  }
}
