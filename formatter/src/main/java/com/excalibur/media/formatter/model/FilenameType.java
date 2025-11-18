package com.excalibur.media.formatter.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public enum FilenameType {
    CANON(
            Pattern.compile("^\\d{4}-\\d{2}-\\d{4}-\\d{2}-\\d{6}$"),
            ".jpg", ".jpeg", ".mp4", ".cr3", ".xmp"
    ),
    OSMO_ACTION(
            Pattern.compile("^DJI_\\d{14}_\\d{4}_D$"),
            ".mp4", ".lrf"),
    SAMSUNG_S22(
            Pattern.compile("^\\d{8}_\\d{6}$"),
            ".jpg", ".mp4", ".dng"
    );

    FilenameType(Pattern pattern, String... extensions) {
        this(List.of(pattern), extensions);
    }

    FilenameType(List<Pattern> patterns, String... extensions) {
        this.patterns = patterns;

        Set<String> set = new HashSet<>(extensions.length);
        Collections.addAll(set, extensions);
        this.extensions = Collections.unmodifiableSet(set);
    }

    private final List<Pattern> patterns;

    private final Set<String> extensions;

    public List<Pattern> patterns() {
        return patterns;
    }

    public Set<String> extensions() {
        return extensions;
    }

    @Override
    public String toString() {
        return "FilenameType{" +
                "pattern=" + patterns +
                ", extensions=" + extensions +
                '}';
    }
}
