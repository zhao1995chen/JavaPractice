

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener()
public final class MySessionListener
        implements HttpSessionBindingListener,
        HttpSessionAttributeListener, HttpSessionListener, ServletContextListener {

    ServletContext context;
    int users = 0;
    //HttpSessionBindingListener

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        logout("valueBound(" + event.getSession().getId() + event.getValue() + ")");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logout("valueUnbound(" + event.getSession().getId() + event.getValue() + ")");
    }
    //HttpSessionAttributeListener

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        logout("attributeAdded('" + event.getSession().getId() + "', '"
                + event.getName() + "', '" + event.getValue() + "')");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

        logout("attributeRemoved('" + event.getSession().getId() + "', '"
                + event.getName() + "', '" + event.getValue() + "')");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        logout("attributeReplaced('" + se.getSession().getId() + ",'" + se.getName() + "','" + se.getValue() + "')");
    }//HttpSessionAttributeListener
    //HttpSessionListener

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        users++;
        logout("sessionCreated('" + event.getSession().getId() + "'),目前有" + users + "個用戶");
        context.setAttribute("users", new Integer(users));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        users--;
        logout("sessionDestroyed('" + event.getSession().getId() + "'),目前有" + users + "個用戶");
        context.setAttribute("users", new Integer(users));
    }//HttpSessionListener
    //ServletContextListener

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logout("contextDestroyed()-->ServletContext被銷毀");
        this.context = null;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        logout("contextInitialized()-->ServletContext初始化了");
    }//ServletContextListener

    private void logout(String message) {
        System.out.println(message);
    }
}
