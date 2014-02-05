package com.stainlesscode.penpal;

import com.stainlesscode.penpal.ext.OpenNLPAddressParserAdapter;
import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;

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
    private static org.apache.log4j.Logger log = Logger.getLogger(AddressFormat_en_US.class.getName());
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

    @Override
    public String printAddress(Address address) throws InvalidAddressException {
        log.debug("entering printAddress(" + address + ")");
        StringTemplate query = new StringTemplate("$number$ $street$\n$city$ $state$ $zip$");
        String number = address.getAddressComponentsOfType(AddressComponentType.STREET_ADDRESS).get(0).getLongName();
        String street = address.getAddressComponentsOfType(AddressComponentType.ROUTE).get(0).getLongName();
        String city = address.getAddressComponentsOfType(AddressComponentType.LOCALITY).get(0).getLongName();
        String state = address.getAddressComponentsOfType(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2).get(0).getLongName();
        String zip = address.getAddressComponentsOfType(AddressComponentType.POSTAL_CODE).get(0).getLongName();
        query.setAttribute("number", number);
        query.setAttribute("street", street);
        query.setAttribute("city", city);
        query.setAttribute("state", state);
        query.setAttribute("zip", zip);
        return query.toString();
    }
}
