package com.excalibur.media.formatter.provider;

import com.excalibur.media.formatter.model.FilenameType;

import java.util.List;

class DefaultCanonFormatterTest extends FormatterTest {

    @Override
    Formatter getImplementation() {
        return new DefaultCanonFormatter();
    }

    @Override
    List<String> getInputOpts() {
        return List.of("2025-03-1718-38-397147.CR3");
    }

    @Override
    String getExpectedResult() {
        return "2025_03_17_18_38_39_7147.CR3";
    }

    @Override
    FilenameType expectedFilenameType() {
        return FilenameType.CANON;
    }

}
