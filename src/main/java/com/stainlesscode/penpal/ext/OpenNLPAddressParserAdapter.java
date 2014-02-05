package com.stainlesscode.penpal.ext;

import com.stainlesscode.penpal.Address;
import com.stainlesscode.penpal.AddressParser;
import com.stainlesscode.penpal.InvalidAddressException;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenNLPAddressParserAdapter implements AddressParser {

    protected Lock nameFinderLock = new ReentrantLock(true);
    protected TokenNameFinderModel model;

    public OpenNLPAddressParserAdapter() {
//        InputStream modelIn = ClassLoader.getSystemResourceAsStream("es-ner-location.bin");
        InputStream modelIn = ClassLoader.getSystemResourceAsStream("en-ner-location.bin");
 //       InputStream modelIn = ClassLoader.getSystemResourceAsStream("en-token.bin");

        if (modelIn==null) {
            throw new ExceptionInInitializerError("Could not find model file");
        }

        try {
            this.model = new TokenNameFinderModel(modelIn);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (modelIn != null) {
                try {
                    modelIn.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Override
    public Address parseAddress(String text) throws InvalidAddressException, ParseException {
        System.out.println("parse "+text);
        // not thread safe
        nameFinderLock.lock();
        try {
            NameFinderME nameFinder = new NameFinderME(model);
            String[] tokens = text.split(" ");
            for (String s : tokens) {
                System.out.println(s);
            }
            Span nameSpans[] = nameFinder.find(tokens);
            for (Span s : nameSpans) {
                System.out.println(s);
            }
        } finally {
            nameFinderLock.unlock();
        }

        return null;
    }
}
