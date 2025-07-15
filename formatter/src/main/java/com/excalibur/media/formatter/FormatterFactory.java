package com.excalibur.media.formatter;

import com.excalibur.media.formatter.model.FilenameType;
import com.excalibur.media.formatter.provider.DefaultCanonFormatter;
import com.excalibur.media.formatter.provider.DefaultOsmoActionFormatter;
import com.excalibur.media.formatter.provider.Formatter;
import com.excalibur.media.support.annotation.ThreadSafe;

@ThreadSafe
public class FormatterFactory {

    private FormatterFactory() {}

    public static Formatter of(FilenameType type) {
        return switch (type) {
            case CANON -> new DefaultCanonFormatter();
            case OSMO_ACTION -> new DefaultOsmoActionFormatter();
            case null -> throw new UnsupportedOperationException(String.format("Filename type %s not supported!", type));
        };
    }

}
