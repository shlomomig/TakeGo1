package com.example.shlomo.takego.model.backend;

import com.example.shlomo.takego.model.datasource.List_DBManager;

/**
 * Created by Shlomo on 22/11/2017.
 */

public class Factory_DBManager {
    static DB_Manager manager = null;

    public static DB_Manager getManager() {
        if (manager == null)
            manager = new List_DBManager();
        return manager;
    }
}
