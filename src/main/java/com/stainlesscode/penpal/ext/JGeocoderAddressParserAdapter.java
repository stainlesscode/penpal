package com.stainlesscode.penpal.ext;

import com.stainlesscode.penpal.Address;
import com.stainlesscode.penpal.AddressComponentType;
import com.stainlesscode.penpal.InvalidAddressException;
import net.sourceforge.jgeocoder.AddressComponent;
import net.sourceforge.jgeocoder.us.AddressParser;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;

/**
 * Example: "1600 Amphitheatre Parkway, Mountain View, CA"
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class JGeocoderAddressParserAdapter implements com.stainlesscode.penpal.AddressParser {

    @Override
    public Address parseAddress(String text) throws InvalidAddressException, ParseException {
        Map<AddressComponent, String> parsedAddr = AddressParser.parseAddress(text);
        if (parsedAddr == null) throw new ParseException("Could not parse address", 0);
        Address address = new Address();
        Iterator it = parsedAddr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<AddressComponent, String> kvPair = (Map.Entry) it.next();
            AddressComponent sourceComponent = kvPair.getKey();
            String value = kvPair.getValue();
            switch (sourceComponent) {
                case NUMBER:
                    addComponent(address, AddressComponentType.STREET_NUMBER, value);
                    break;
                case LINE2:
                    addComponent(address, AddressComponentType.ROUTE, value);
                    break;
                case CITY:
                    addComponent(address, AddressComponentType.LOCALITY, value);
                    break;
                case COUNTY:
                    addComponent(address, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2, value);
                    break;
                case STATE:
                    addComponent(address, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1, value);
                    break;
                case ZIP:
                    addComponent(address, AddressComponentType.POSTAL_CODE, value);
                    break;
            }
        }

        return address;
    }

    private void addComponent(Address address, AddressComponentType type, String value) {
        com.stainlesscode.penpal.AddressComponent destComponent = new com.stainlesscode.penpal.AddressComponent();
        destComponent.addToTypes(type);
        destComponent.setLongName(value);
        address.addToAddressComponentList(destComponent);
    }
}
