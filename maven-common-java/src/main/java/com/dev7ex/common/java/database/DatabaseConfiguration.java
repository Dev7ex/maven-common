package com.dev7ex.common.java.database;

/**
 *
 * @author Dev7ex
 * @since 08.09.2020
 *
 */

public interface DatabaseConfiguration {

    boolean isConnectionAllowed();

    String getIpAddress();

    int getPort();

    String getUsername();

    String getPassword();

    String getDatabase();

}
