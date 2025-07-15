package com.excalibur.media.formatter.provider;

import static com.excalibur.media.formatter.model.CharConstants.DASH;
import static com.excalibur.media.formatter.model.CharConstants.UNDERSCORE;

public class DefaultCanonFormatter implements Formatter {

    @Override
    public String format(String filename) {
        //2025-03-1718-38-397147.CR3
        return new StringBuilder()
                .append(filename, 0, 10)
                .append(UNDERSCORE)
                .append(filename, 10, 18)
                .append(UNDERSCORE)
                .append(filename.substring(18))
                .toString()
                .replaceAll(DASH, UNDERSCORE);
    }

}
