package com.excalibur.media.formatter.service;

import com.excalibur.media.formatter.model.FilenameType;
import com.excalibur.media.formatter.provider.Formatter;
import com.excalibur.media.formatter.FormatterFactory;
import com.excalibur.media.support.exception.OperationFailedException;
import java.io.IOException;
import java.nio.file.*;

public class MediaService {

    private final Formatter formatter;
    private final FilenameType type;
    private final boolean recursiveSearch;

    private MediaService(FilenameType type, Formatter formatter, boolean recursiveSearch) {
        this.type = type;
        this.formatter = formatter;
        this.recursiveSearch = recursiveSearch;
    }

    public static MediaService forType(FilenameType type) {
        return new MediaService(
                type,
                FormatterFactory.of(type),
                false
        );
    }

    public static MediaService forTypeWithRecursive(FilenameType type, boolean recursive) {
        return new MediaService(
                type,
                FormatterFactory.of(type),
                recursive
        );
    }

    public Integer countFiles(String folder) {
        try {
            return countFiles(Path.of(folder), type);
        }
        catch (Exception e) {
            System.err.printf("Failed to count files in folder %s: %s%n", folder, e.getMessage());
            e.printStackTrace();
            System.err.println();
            throw new OperationFailedException();
        }
    }

    public Integer renameFiles(String folder) {
        try {
            //TODO make validator as interface too
            int result = renameFiles(Path.of(folder), type);
            System.out.printf("Formatted %s files%n", result);
            return result;
        }
        catch (Exception e) {
            System.err.printf("Failed to rename files in folder %s: %s%n", folder, e.getMessage());
            e.printStackTrace();
            System.err.println();
            throw new OperationFailedException();
        }
    }

    private int countFiles(Path folder, FilenameType type) throws IOException {

        try (DirectoryStream<Path> items = Files.newDirectoryStream(folder)) {

            int count = 0;

            for (Path item : items) {

                if (recursiveSearch && item.toFile().isDirectory()) {
                    count += countFiles(item, type);
                }

                String filename = item.getFileName().toString();

                if (FilenameValidator.validate(filename, type)) {
                    count++;
                }

            }

            return count;

        }
    }

    private int renameFiles(Path folder, FilenameType type) {

        int count = 0;
        try (DirectoryStream<Path> items = Files.newDirectoryStream(folder)) {

            for (Path item : items) {

                if (recursiveSearch && item.toFile().isDirectory()) {
                    count += renameFiles(item, type);
                }

                String filename = item.getFileName().toString();

                if (FilenameValidator.validate(filename, type)) {
                    try {
                        Files.move(
                                item,
                                item.resolveSibling(formatter.format(filename)),
                                LinkOption.NOFOLLOW_LINKS
                        );
                        count++;
                    } catch (Exception e) {
                        System.err.printf("%s rename failed with message: %s%n", item.toAbsolutePath(), e.getMessage());
                        e.printStackTrace();
                        System.err.println();
                    }
                }

            }

        } catch (Exception e) {
            System.err.printf("Failed to open folder %s: %s%n", folder, e.getMessage());
            e.printStackTrace();
            System.err.println();
        }

        return count;
    }

}
