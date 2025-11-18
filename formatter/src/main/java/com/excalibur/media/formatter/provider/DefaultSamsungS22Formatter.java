package com.excalibur.media.formatter.provider;

import com.excalibur.media.formatter.model.FilenameType;
import static com.excalibur.media.formatter.model.CharConstants.UNDERSCORE;

public class DefaultSamsungS22Formatter implements Formatter {

    @Override
    public String format(String filename) {
        //20221127_180517.dng
        return new StringBuilder()
                .append(filename, 0, 4)
                .append(UNDERSCORE)
                .append(filename, 4, 6)
                .append(UNDERSCORE)
                .append(filename, 6, 8)
                .append(UNDERSCORE)
                .append(filename, 9, 11)
                .append(UNDERSCORE)
                .append(filename, 11, 13)
                .append(UNDERSCORE)
                .append(filename, 13, 15)
                .append(filename, 15, filename.length())
                .toString();
    }

    @Override
    public FilenameType getType() {
        return FilenameType.SAMSUNG_S22;
    }
}
