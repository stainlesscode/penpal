package com.stainlesscode;

import com.stainlesscode.penpal.Address;
import com.stainlesscode.penpal.AddressFormat;
import com.stainlesscode.penpal.InvalidAddressException;
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

    public void testLog4j() {
        BasicConfigurator.configure();
        log.debug("OK");
    }

    public void testUnsupportedLocale() {
        try {
            AddressFormat.getInstance(Locale.FRANCE);
        } catch (IllegalArgumentException e) {
            assertEquals("Address format not supported (yet) for locale " + Locale.FRANCE.toString(), e.getMessage());
        }
    }

    public void testParseAddress() {
        BasicConfigurator.configure();
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
}
