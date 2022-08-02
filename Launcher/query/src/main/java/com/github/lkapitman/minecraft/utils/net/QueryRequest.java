package com.github.lkapitman.minecraft.utils.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * The type Query request.
 */
public class QueryRequest {

    private ByteArrayOutputStream byteStream;
    private DataOutputStream dataStream;

    /**
     * The Magic.
     */
    static byte[] MAGIC = {
            (byte) 0xFE, (byte) 0xFD
    };
    /**
     * The Type.
     */
    public byte type;
    /**
     * The Session id.
     */
    public int sessionID;
    /**
     * The Payload.
     */
    public byte[] payload;

    /**
     * Instantiates a new Query request.
     */
    public QueryRequest() {
        int size = 1460;
        byteStream = new ByteArrayOutputStream(size);
        dataStream = new DataOutputStream(byteStream);
    }

    /**
     * Instantiates a new Query request.
     *
     * @param type the type
     */
    public QueryRequest(byte type) {
        this.type = type;
    }

    /**
     * To bytes byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] toBytes() {
        byteStream.reset();

        try {
            dataStream.write(MAGIC);
            dataStream.write(type);
            dataStream.writeInt(sessionID);
            dataStream.write(payloadBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteStream.toByteArray();
    }

    private byte[] payloadBytes() {
        if(type == MCQuery.HANDSHAKE) {
            return new byte[]{};
        } else {
            return payload;
        }
    }

    /**
     * Sets payload.
     *
     * @param load the load
     */
    public void setPayload(int load) {
        this.payload = ByteUtils.intToBytes(load);
    }

}
