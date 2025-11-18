package com.excalibur.media.formatter.provider;

import com.excalibur.media.formatter.model.FilenameType;

import java.util.List;

class DefaultSamsungS22FormatterTest extends FormatterTest {
    @Override
    Formatter getImplementation() {
        return new DefaultSamsungS22Formatter();
    }

    @Override
    List<String> getInputOpts() {
        return List.of("20221127_180517.dng");
    }

    @Override
    String getExpectedResult() {
        return "2022_11_27_18_05_17.dng";
    }

    @Override
    FilenameType expectedFilenameType() {
        return FilenameType.SAMSUNG_S22;
    }
}
