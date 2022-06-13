package com.dev7ex.common.java.database;

/**
 * @author Dev7ex
 * @since 08.09.2020
 */
public interface DatabaseProvider {

    void openConnection();

    void closeConnection();

    boolean isConnected();

}
