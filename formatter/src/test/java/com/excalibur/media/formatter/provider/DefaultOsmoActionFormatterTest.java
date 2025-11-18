package com.excalibur.media.formatter.provider;

import com.excalibur.media.formatter.model.FilenameType;

import java.util.List;

class DefaultOsmoActionFormatterTest extends FormatterTest {

    @Override
    Formatter getImplementation() {
        return new DefaultOsmoActionFormatter();
    }

    @Override
    List<String> getInputOpts() {
        return List.of("DJI_20250316185508_0007_D.MP4");
    }

    @Override
    String getExpectedResult() {
        return "2025_03_16_18_55_08_0007.MP4";
    }

    @Override
    FilenameType expectedFilenameType() {
        return FilenameType.OSMO_ACTION;
    }

}
