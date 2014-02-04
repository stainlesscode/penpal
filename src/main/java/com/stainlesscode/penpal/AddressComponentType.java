package com.stainlesscode.penpal;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public enum AddressComponentType {
    STREET_ADDRESS("street_address"),
    ROUTE("route"),
    INTERSECTION("intersection"),
    POLITICAL("political"),
    COUNTRY("country"),
    ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
    ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
    ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
    COLLOQUIAL_AREA("colloquial_area"),
    LOCALITY("locality"),
    SUBLOCALITY("sublocality"),
    SUBLOCALITY_LEVEL_5("sublocality_level_5"),
    NEIGHBORHOOD("neighborhood"),
    PREMISE("premise"),
    SUBPREMISE("subpremise"),
    POSTAL_CODE("postal_code"),
    NATURAL_FEATURE("natural_feature"),
    AIRPORT("airport"),
    PARK("park"),
    POST_BOX("post_box"),
    STREET_NUMBER("street_number"),
    FLOOR("floor"),
    ROOM("room"),
    NAME("name"),
    SALUTATION("salutation");
    private final String value;

    private AddressComponentType(String value) {
        this.value = value;
    }
}
