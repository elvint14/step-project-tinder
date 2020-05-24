package org.tinder_proj.utils;

import javax.servlet.http.HttpServletRequest;

public class GetRequest {
  public static String getParameter(HttpServletRequest req, String paramName) {
    try {
      return req.getParameter(paramName);
    } catch (NullPointerException ex) {
      throw new IllegalArgumentException("Something went wrong..." + ex);
    }
  }
}
