package org.tinder_proj;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.tinder_proj.dao.DAOLike;
import org.tinder_proj.dao.DAOMessage;
import org.tinder_proj.dao.DAOUser;
import org.tinder_proj.db.DbConn;
import org.tinder_proj.servlets.*;
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

  public static void main(String[] args) throws Exception {
    // temporary
//    DbSetup.migrate(ConnDetails.url, ConnDetails.username, ConnDetails.password);
//    DbSetup.migrate(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
    // temporary
//    Connection conn = DbConn.create(ConnDetails.url, ConnDetails.username, ConnDetails.password);
//    Connection conn = DbConn.createFromURL(HerokuEnv.jdbc_url());
    Connection conn = DbConn.create(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
//    Connection conn = null;

    final DAOUser DAO_USER = new DAOUser(conn);
    final DAOLike DAO_LIKE = new DAOLike(conn);
    final DAOMessage DAO_MESSAGE = new DAOMessage(conn);

    Server server = new Server(HerokuEnv.port());
    ServletContextHandler handler = new ServletContextHandler();

    TemplateEngine templateEngine = new TemplateEngine(FREEMARKER_DIR);

    handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");

    handler.addServlet((FirstPageServlet.class), "/*");
    handler.addServlet(new ServletHolder(new RegisterServlet(DAO_USER)), "/register");
    handler.addServlet(new ServletHolder(new LoginServlet(DAO_USER)), "/login");
    handler.addServlet(new ServletHolder(new LikePageServlet(DAO_USER, DAO_LIKE, templateEngine)), "/users");
    handler.addServlet(new ServletHolder(new UserServlet(DAO_USER, DAO_LIKE, templateEngine)), "/likes");
    handler.addServlet(new ServletHolder(new MessageServlet(DAO_USER, DAO_MESSAGE, templateEngine)), "/message/*");


    server.setHandler(handler);
    server.start();
    server.join();
  }
}