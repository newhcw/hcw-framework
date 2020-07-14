package com.hcw.framework.design.pattern.factory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class InputStreamReaderFactory implements ReaderFactory{
    @Override
    public InputStreamReader getReader(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //StringReader stringReader = new StringReader(inputStreamReader);

        return inputStreamReader;
    }
}
