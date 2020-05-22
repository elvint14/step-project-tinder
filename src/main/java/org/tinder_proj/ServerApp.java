package org.tinder_proj;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.tinder_proj.db.DbConn;
import org.tinder_proj.servlets.FirstPageServlet;
import org.tinder_proj.servlets.StaticServlet;
import org.tinder_proj.utils.TemplateEngine;

import java.sql.Connection;

import static org.tinder_proj.utils.Dirs.FREEMARKER_DIR;

/**
 * http://localhost:8080/hello
 * <p>
 * http://localhost:8080/student
 * http://localhost:8080/student?x=1
 * http://localhost:8080/student?x=2
 */
public class ServerApp {
  private static final int SERVER_PORT = 8080;

  public static void main(String[] args) throws Exception {
    // temporary
//    DbSetup.migrate(ConnDetails.url, ConnDetails.username, ConnDetails.password);
//    DbSetup.migrate(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
    // temporary
//    Connection conn = DbConn.create(ConnDetails.url, ConnDetails.username, ConnDetails.password);
//    Connection conn = DbConn.createFromURL(HerokuEnv.jdbc_url());
    Connection conn = DbConn.create(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
//    Connection conn = null;

    Server server = new Server(SERVER_PORT);
    ServletContextHandler handler = new ServletContextHandler();

    TemplateEngine templateEngine = new TemplateEngine(FREEMARKER_DIR);

    handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");
    handler.addServlet(new ServletHolder(new FirstPageServlet()), "");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}