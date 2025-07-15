package com.excalibur.media.formatter.provider;

import static com.excalibur.media.formatter.model.CharConstants.DASH;
import static com.excalibur.media.formatter.model.CharConstants.UNDERSCORE;

public class EnhancedCanonFormatter extends DefaultCanonFormatter {

    @Override
    public String format(String filename) {
        //2025-03-1718-38-397147.CR3
        String[] parts = filename.split(DASH);
        return new StringBuilder()
                .append(parts[0])
                .append(UNDERSCORE)
                .append(parts[1])
                .append(UNDERSCORE)
                .append(parts[2], 0, 2)
                .append(UNDERSCORE)
                .append(parts[2], 2, 4)
                .append(UNDERSCORE)
                .append(parts[3])
                .append(UNDERSCORE)
                .append(parts[4], 0, 2)
                .append(UNDERSCORE)
                .append(parts[4].substring(2))
                .toString();
    }
}
