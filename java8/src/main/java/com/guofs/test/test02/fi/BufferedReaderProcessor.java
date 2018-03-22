package com.guofs.test.test02.fi;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/22 13:06
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
