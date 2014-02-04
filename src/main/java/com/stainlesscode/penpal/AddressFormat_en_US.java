package com.stainlesscode.penpal;

import com.stainlesscode.penpal.ext.JGeocoderAddressParserAdapter;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddressFormat_en_US extends AddressFormat {

    private JGeocoderAddressParserAdapter adapter;

    protected AddressFormat_en_US() {
        super();
        this.adapter = new JGeocoderAddressParserAdapter();
    }

    @Override
    public void isValid(Address address) throws InvalidAddressException {
        throw new UnsupportedOperationException("Address validation is not yet supported for this locale (en_US).");
    }

    @Override
    public Address parseAddress(String text) throws InvalidAddressException, ParseException {
        return adapter.parseAddress(text);
    }
}
