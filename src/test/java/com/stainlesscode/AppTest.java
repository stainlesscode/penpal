package com.stainlesscode;

import com.stainlesscode.penpal.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private static org.apache.log4j.Logger log = Logger.getLogger(AppTest.class.getName());
    Address constructedAddress;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    public void setUp() {
        constructedAddress = new Address();
        constructedAddress.addToAddressComponentList(new AddressComponent("1600","1600", AddressComponentType.STREET_ADDRESS));
        constructedAddress.addToAddressComponentList(new AddressComponent("Amphitheatre Pkwy","Amphitheatre Pkwy", AddressComponentType.ROUTE));
        constructedAddress.addToAddressComponentList(new AddressComponent("Mountain View","Mountain View", AddressComponentType.LOCALITY));
        constructedAddress.addToAddressComponentList(new AddressComponent("California","CA", AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2));
        constructedAddress.addToAddressComponentList(new AddressComponent("94043","94043", AddressComponentType.POSTAL_CODE));
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testUnsupportedLocale() {
        try {
            AddressFormat.getInstance(Locale.FRANCE);
        } catch (IllegalArgumentException e) {
            assertEquals("Address format not supported (yet) for locale " + Locale.FRANCE.toString(), e.getMessage());
        }
    }

    public void testParseAddress() {
        String address = "1600 Amphitheatre Pkwy, Mountain View, CA 94043";
        AddressFormat format = AddressFormat.getInstance(Locale.US);

        try {
            Address parsedAddress = format.parseAddress(address);
            System.out.println(format.printAddress(parsedAddress));
        } catch (InvalidAddressException e) {
            e.printStackTrace();
           fail(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        address = "1600 Amphitheatre Pkwy, Mountain View, CA";

        try {
            Address parsedAddress = format.parseAddress(address);
            System.out.println(format.printAddress(parsedAddress));
        } catch (InvalidAddressException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testPrintAddress() {
        try {
            System.out.println(AddressFormat.getInstance(Locale.US).printAddress(constructedAddress));
        } catch (InvalidAddressException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            fail(e.getMessage());
        }
    }
}
