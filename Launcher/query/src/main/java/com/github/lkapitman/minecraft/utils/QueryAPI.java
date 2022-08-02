package com.github.lkapitman.minecraft.utils;

import com.github.lkapitman.minecraft.utils.net.MCQuery;

/**
 * The type Query api.
 */
public class QueryAPI {

    private final String ip;
    private final int port;

    /**
     * Instantiates a new Query api.
     *
     * @param ip   the ip
     * @param port the port
     */
    public QueryAPI(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * Players int.
     *
     * @return the int
     */
    public int players() {
        MCQuery mcQuery = new MCQuery(ip, port);
        return mcQuery.fullStat().getOnlinePlayers();
    }
}
