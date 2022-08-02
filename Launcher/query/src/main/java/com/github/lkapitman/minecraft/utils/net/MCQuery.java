package com.github.lkapitman.minecraft.utils.net;

import java.net.*;

/**
 * The type Mc query.
 */
public class MCQuery {
    /**
     * The constant HANDSHAKE.
     */
    public final static byte HANDSHAKE = 9;
    /**
     * The constant STAT.
     */
    public final static byte STAT = 0;

    /**
     * The Server address.
     */
    public final String serverAddress;
    /**
     * The Query port.
     */
    public final int queryPort;

    /**
     * The Local port.
     */
    int localPort = 25566;

    private DatagramSocket socket = null;
    private int token;

    /**
     * Instantiates a new Mc query.
     *
     * @param address the address
     * @param port    the port
     */
    public MCQuery(String address, int port) {
        serverAddress = address;
        queryPort = port;
    }

    private void handshake() {
        QueryRequest req = new QueryRequest();
        req.type = HANDSHAKE;
        req.sessionID = generateSessionID();

        int val = 11 - req.toBytes().length;
        byte[] input = ByteUtils.padArrayEnd(req.toBytes(), val);
        byte[] result = sendUDP(input);

        token = Integer.parseInt(new String(result).trim());
    }

    /**
     * Basic stat query response.
     *
     * @return the query response
     */
    public QueryResponse basicStat() {
        handshake();

        QueryRequest req = new QueryRequest();
        req.type = STAT;
        req.sessionID = generateSessionID();
        req.setPayload(token);
        byte[] send = req.toBytes();

        byte[] result = sendUDP(send);

        QueryResponse res = new QueryResponse(result, false);
        return res;
    }

    /**
     * Full stat query response.
     *
     * @return the query response
     */
    public QueryResponse fullStat() {
        handshake();

        QueryRequest req = new QueryRequest();
        req.type = STAT;
        req.sessionID = generateSessionID();
        req.setPayload(token);
        req.payload = ByteUtils.padArrayEnd(req.payload, 4);

        byte[] send = req.toBytes();

        byte[] result = sendUDP(send);

        QueryResponse res = new QueryResponse(result, true);
        return res;
    }

    private byte[] sendUDP(byte[] input) {
        try {
            while(socket == null) {
                try {
                    socket = new DatagramSocket(localPort);
                } catch (BindException e) {
                    ++localPort;
                }
            }

            InetAddress address = InetAddress.getByName(serverAddress);
            DatagramPacket packet1 = new DatagramPacket(input, input.length, address, queryPort);
            socket.send(packet1);

            byte[] out = new byte[1024];
            DatagramPacket packet = new DatagramPacket(out, out.length);
            socket.setSoTimeout(500);
            socket.receive(packet);

            return packet.getData();
        } catch (SocketTimeoutException e) {
            System.err.println("Socket Timeout! Is the server offline?");
        } catch (UnknownHostException e) {
            System.err.println("Unknown host!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private int generateSessionID() {
        return 1;
    }

    @Override
    public void finalize() {
        socket.close();
    }

}