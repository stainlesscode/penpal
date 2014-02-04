package com.stainlesscode.penpal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddressComponent {
    String longName;
    String shortName;
    List<AddressComponentType> types = new ArrayList<AddressComponentType>();

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<AddressComponentType> getTypes() {
        return types;
    }

    public void setTypes(List<AddressComponentType> types) {
        this.types = types;
    }

    public void addToTypes(AddressComponentType type) {
        types.add(type);
    }

    public String toString() {
        return "long_name: " + longName + ", short_name: " + shortName + ", types: " + types;
    }
}
