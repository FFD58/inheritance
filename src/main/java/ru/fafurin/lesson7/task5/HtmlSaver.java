package ru.fafurin.lesson7.task5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlSaver {

    private String content;

    public void getHtmlFileFromUrl(String content) {
        this.content = content;
        String filename = this.makeFilename();
        if (content.contains("!DOCTYPE html")) {
            try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filename, true))) {
                bufferWriter.write(content);
                bufferWriter.write("\n");
                System.out.println("Html " + filename + " saved.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String makeFilename() {
        String filename = "";
        try {
            if (this.content.contains("title")) {
                int index = this.content.indexOf("<title>") + "<title>".length();
                filename = this.content.substring(index, this.content.indexOf("</title>", index));
            }
            filename = filename.replace(":", "-").replace(",", "-").replace(" ", "-").replace("--", "-");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid address");
        }
        return filename;
    }
}
