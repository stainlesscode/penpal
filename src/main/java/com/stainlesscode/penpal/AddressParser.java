package com.stainlesscode.penpal;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AddressParser {
    /**
     * Parse the supplied text and return an address for the expected locale
     * @param text the formatted address text in a valid format for the expected locale
     * @return the Address object representing the supplied formatted address
     * @throws InvalidAddressException if the supplied text cannot be parsed
     */
    abstract public Address parseAddress(String text) throws InvalidAddressException, ParseException;
}
