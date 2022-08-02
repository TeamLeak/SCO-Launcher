package com.github.lkapitman.minecraft.utils.net;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/**
 * The type Byte utils.
 */
public class ByteUtils  {

    /**
     * Subarray byte [ ].
     *
     * @param in the in
     * @param a  the a
     * @param b  the b
     * @return the byte [ ]
     */
    public static byte[] subarray(byte[] in, int a, int b) {
        if (b - a > in.length)
            return in;

        byte[] out = new byte[(b - a) + 1];

        if (b + 1 - a >= 0)
            System.arraycopy(in, a, out, 0, b + 1 - a);

        return out;
    }

    /**
     * Trim byte [ ].
     *
     * @param arr the arr
     * @return the byte [ ]
     */
    public static byte[] trim(byte[] arr) {

        if (arr[0] != 0 && arr[arr.length] != 0)
            return arr;

        int begin = 0, end = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                begin = i;
                break;
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] != 0) {
                end = i;
                break;
            }
        }

        return subarray(arr, begin, end);
    }

    /**
     * Split byte [ ] [ ].
     *
     * @param input the input
     * @return the byte [ ] [ ]
     */
    public static byte[][] split(byte[] input) {

        ArrayList<byte[]> temp = new ArrayList<byte[]>();

        byte[][] output;
        output = new byte[input.length][input.length];
        int out_index = 0;

        int index_cache = 0;
        for (int i = 0 ; i < input.length; i++) {
            if (input[i] == 0x00) {
                byte[] b = subarray(input, index_cache, i-1);
                temp.add(b);
                index_cache = i+1;
            }
        }
        if (index_cache != 0) {
            byte[] b = subarray(input, index_cache, input.length-1);
            temp.add(b);
        }

        output = new byte[temp.size()][input.length];
        for (int i = 0; i < temp.size(); i++) {
            output[i] = temp.get(i);
        }

        return output;
    }

    /**
     * Pad array end byte [ ].
     *
     * @param arr    the arr
     * @param amount the amount
     * @return the byte [ ]
     */
    public static byte[] padArrayEnd(byte[] arr, int amount) {
        byte[] arr2 = new byte[arr.length+amount];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        for (int i = arr.length; i < arr2.length; i++) {
            arr2[i] = 0;
        }
        return arr2;
    }

    /**
     * Bytes to short short.
     *
     * @param b the b
     * @return the short
     */
    public static short bytesToShort(byte[] b) {
        ByteBuffer buf = ByteBuffer.wrap(b, 0, 2);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        return buf.getShort();
    }

    /**
     * Int to bytes byte [ ].
     *
     * @param in the in
     * @return the byte [ ]
     */
    public static byte[] intToBytes(int in) {
        byte[] b;
        b = new byte[] {
                        (byte) (in >>> 24	& 0xFF),
                        (byte) (in >>> 16	& 0xFF),
                        (byte) (in >>> 8	& 0xFF),
                        (byte) (in >>> 0 & 0xFF)
        };
        return b;
    }

    /**
     * Bytes to int int.
     *
     * @param in the in
     * @return the int
     */
    public static int bytesToInt(byte[] in) {
        return ByteBuffer.wrap(in).getInt();
    }

}