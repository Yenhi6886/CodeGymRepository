package com.codegym.blog.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySqlCleanupListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}