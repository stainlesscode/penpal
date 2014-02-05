package com.stainlesscode.penpal;

import com.stainlesscode.penpal.ext.JGeocoderAddressParserAdapter;
import com.stainlesscode.penpal.ext.OpenNLPAddressParserAdapter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddressFormat_en_US extends AddressFormat {

    protected Locale locale = Locale.US;
 //   private JGeocoderAddressParserAdapter adapter;
    private OpenNLPAddressParserAdapter adapter;

    protected AddressFormat_en_US() {
        super();
 //       this.adapter = new JGeocoderAddressParserAdapter();
        this.adapter = new OpenNLPAddressParserAdapter();
    }

    @Override
    public void isValid(Address address) throws InvalidAddressException {
        throw new UnsupportedOperationException("Address validation is not yet supported for this locale: " + locale);
    }

    @Override
    public Address parseAddress(String text) throws InvalidAddressException, ParseException {
        return adapter.parseAddress(text);
    }
}
