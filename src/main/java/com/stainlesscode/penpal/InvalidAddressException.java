package com.stainlesscode.penpal;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class InvalidAddressException extends Exception {
    public InvalidAddressException(String reason) {
        super(reason);
    }
}
