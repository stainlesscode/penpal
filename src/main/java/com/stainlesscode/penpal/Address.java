package com.stainlesscode.penpal;

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
    private List<AddressComponent> addressComponentList = new ArrayList<AddressComponent>();
    private String formattedAddress;
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

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
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

    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (AddressComponent comp : addressComponentList) {
            buf.append(comp.toString() + "\n");
        }
        return buf.toString();
    }
}
