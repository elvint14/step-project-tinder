package org.tinder_proj;

public class HerokuEnv {
  private static final String PORT = "PORT";
  private static final String JDBC_DATABASE_URL = "JDBC_DATABASE_URL";
  private static final String EMPTY = " is empty!!!";
  private static final String JDBC_DATABASE_USERNAME = "JDBC_DATABASE_USERNAME";
  private static final String JDBC_DATABASE_PASSWORD = "JDBC_DATABASE_PASSWORD";

  public static int port() {
    try {
      System.out.println(System.getenv(PORT));
      return Integer.parseInt(System.getenv(PORT));
    } catch (NumberFormatException ex) {
      return 5000;
    }
  }

  public static String jdbc_url() {
    System.out.println(System.getenv(JDBC_DATABASE_URL));
    String url = System.getenv(JDBC_DATABASE_URL);
    if (url == null) throw new IllegalArgumentException(JDBC_DATABASE_URL + EMPTY);
    return url;
  }

  public static String jdbc_username() {
    System.out.println(System.getenv(JDBC_DATABASE_USERNAME));
    String url = System.getenv(JDBC_DATABASE_USERNAME);
    if (url == null) throw new IllegalArgumentException(JDBC_DATABASE_USERNAME + EMPTY);
    return url;
  }

  public static String jdbc_password() {
    System.out.println(System.getenv(JDBC_DATABASE_PASSWORD));
    String url = System.getenv(JDBC_DATABASE_PASSWORD);
    if (url == null) throw new IllegalArgumentException(JDBC_DATABASE_PASSWORD + EMPTY);
    return url;
  }

//  jdbc:postgresql://ec2-54-247-78-30.eu-west-1.compute.amazonaws.com:5432/d3du1hdp316o87
//  jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
}
