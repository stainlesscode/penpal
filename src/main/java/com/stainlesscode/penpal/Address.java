package com.stainlesscode.penpal;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Address {
    private static org.apache.log4j.Logger log = Logger.getLogger(Address.class.getName());
    private List<AddressComponent> addressComponentList = new ArrayList<AddressComponent>();
    private Geometry geometry;

    public static Address parseAddress(String formattedAddress, Locale locale) {
        return null;
    }

    public List<AddressComponent> getAddressComponentList() {
        return addressComponentList;
    }

    public void setAddressComponentList(List<AddressComponent> addressComponentList) {
        this.addressComponentList = addressComponentList;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void addToAddressComponentList(AddressComponent component) {
        addressComponentList.add(component);
    }

    public List<AddressComponent> getAddressComponentsOfType(AddressComponentType type) throws InvalidAddressException {
        log.debug("entering getAddressComponentsOfType(" + type + ")");
        List<AddressComponent> result = new ArrayList();
        for (AddressComponent comp : addressComponentList) {
            log.debug("traversing comp " + comp);
            if (comp.getTypes().contains(type)) {
                result.add(comp);
            }
        }
        if (result.isEmpty()) {
            log.debug("about to throw InvalidAddressException, no component found for " + type);
            throw new InvalidAddressException("No address component for type " + type);
        }
        return result;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (AddressComponent comp : addressComponentList) {
            buf.append(comp.toString() + "\n");
        }
        return buf.toString();
    }
}
