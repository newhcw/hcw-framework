package com.hcw.framework.design.pattern.factory;

import java.io.InputStream;
import java.io.Reader;

public interface ReaderFactory {

    public Reader getReader(InputStream inputStream);
}
