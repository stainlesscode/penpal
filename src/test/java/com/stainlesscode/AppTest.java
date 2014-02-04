package com.stainlesscode;

import com.stainlesscode.penpal.Address;
import com.stainlesscode.penpal.AddressFormat;
import com.stainlesscode.penpal.InvalidAddressException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.ParseException;
import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
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
            System.out.println(parsedAddress);
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
            System.out.println(parsedAddress);
        } catch (InvalidAddressException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
