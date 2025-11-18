package com.excalibur.media.formatter.provider;

import com.excalibur.media.formatter.model.FilenameType;
import com.excalibur.media.support.annotation.ThreadSafe;

@ThreadSafe
public interface Formatter {

    String format(String filename);

    FilenameType getType();

}
