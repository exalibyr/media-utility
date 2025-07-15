package com.excalibur.media.formatter.service;

import com.excalibur.media.formatter.model.FilenameType;
import com.excalibur.media.support.annotation.ThreadSafe;

import static com.excalibur.media.formatter.model.CharConstants.DOT;

@ThreadSafe
public class FilenameValidator {

    private FilenameValidator() {}

    public static boolean validate(String filename, FilenameType type) {
        return checkExt(filename, type) && checkName(filename, type);
    }

    private static boolean checkExt(String filename, FilenameType type) {

        int extBegin = filename.lastIndexOf(DOT);
        if (extBegin == -1) {
            return false;
        }

        String ext = filename.substring(extBegin);
        return type.extensions().contains(ext.toLowerCase());
    }

    private static boolean checkName(String filename, FilenameType type) {
        String justName = filename.substring(0, filename.lastIndexOf(DOT));
        return type.patterns().stream().anyMatch(pattern -> pattern.matcher(justName).matches());
    }

}
