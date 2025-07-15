package com.excalibur.media.formatter.provider;

import static com.excalibur.media.formatter.model.CharConstants.UNDERSCORE;

public class DefaultOsmoActionFormatter implements Formatter {

    @Override
    public String format(String filename) {
        //DJI_20250316185508_0007_D.MP4
        return new StringBuilder()
                //2025_
                .append(filename, 4, 8)
                .append(UNDERSCORE)
                //03_
                .append(filename, 8, 10)
                .append(UNDERSCORE)
                //16_
                .append(filename, 10, 12)
                .append(UNDERSCORE)
                //18_
                .append(filename, 12, 14)
                .append(UNDERSCORE)
                //55_
                .append(filename, 14, 16)
                .append(UNDERSCORE)
                //08_0007
                .append(filename, 16, 23)
                //.MP4
                .append(filename, 25, filename.length())
                .toString();
    }

}
