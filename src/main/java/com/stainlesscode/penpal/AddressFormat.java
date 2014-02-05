package com.stainlesscode.penpal;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class AddressFormat implements AddressParser, AddressPrinter {
    protected AddressFormat() {
        // singleton
    }

    public static AddressFormat getInstance(Locale locale) throws IllegalArgumentException {
        if (locale.equals(Locale.US)) return new AddressFormat_en_US();
        else throw new IllegalArgumentException("Address format not supported (yet) for locale " + locale);
    }

    /**
     * Determine if the supplied address is valid for the expected locale
     * @param address the address to check
     * @throws InvalidAddressException if the supplied address is invalid
     */
    abstract public void isValid(Address address) throws InvalidAddressException;

}
