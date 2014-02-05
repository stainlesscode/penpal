package com.stainlesscode.penpal;

/**
 * Interface for classes that can print addresses
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/5/14
 * Time: 8:00 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AddressPrinter {
    /**
     * Prints the specified address given contextual Local information in the implementing class
     * @param address the address to print
     * @return A String containing the formatted address
     * @throws InvalidAddressException if the address cannot be printed because it's invalid
     */
    public String printAddress(Address address) throws InvalidAddressException;
}
