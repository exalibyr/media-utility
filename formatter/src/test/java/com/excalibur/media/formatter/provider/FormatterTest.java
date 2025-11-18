package com.excalibur.media.formatter.provider;

import com.excalibur.media.formatter.model.FilenameType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

abstract class FormatterTest {

    abstract Formatter getImplementation();

    abstract List<String> getInputOpts();

    abstract String getExpectedResult();

    abstract FilenameType expectedFilenameType();

    @Test
    void format() {
        getInputOpts().forEach(
                opt -> Assertions.assertEquals(
                        getExpectedResult(),
                        getImplementation().format(opt)
                )
        );
    }

    @Test
    void getType() {
        Assertions.assertEquals(
                expectedFilenameType(),
                getImplementation().getType()
        );
    }

}
