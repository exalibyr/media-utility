package com.excalibur.media.ui.model;

import com.excalibur.media.formatter.model.FilenameType;
import java.util.Arrays;
import java.util.List;

public enum FileType {
    OSMO_ACTION("Osmo action", FilenameType.OSMO_ACTION),
    CANON("Canon", FilenameType.CANON);

    FileType(String label, FilenameType filenameType) {
        this.label = label;
        this.filenameType = filenameType;
    }

    private final String label;
    private final FilenameType filenameType;

    public String getLabel() {
        return label;
    }

    public FilenameType getFilenameType() {
        return filenameType;
    }

    public static FileType of(String label) {
        List<FileType> options = Arrays
                                        .stream(FileType.values())
                                        .filter(fileType -> fileType.label.equals(label))
                                        .toList();

        if (options.size() != 1) {
            System.err.printf("Label %s has not been found in Enum %s or has more than one match!%n", label, FileType.class.getTypeName());
            return null;
        }

        return options.get(0);
    }

    @Override
    public String toString() {
        return "FileType{" +
                "label='" + label + '\'' +
                ", filenameType=" + filenameType +
                '}';
    }
}
