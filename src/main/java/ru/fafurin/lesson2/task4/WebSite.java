package ru.fafurin.lesson2.task4;

import java.io.File;

public class WebSite {
    String uri;
    File[] files;

    public WebSite() {
    }

    public WebSite(String uri) {
        this.uri = uri;
    }

    public WebSite(File[] files) {
        this.files = files;
    }

    public WebSite(String uri, File[] files) {
        this.uri = uri;
        this.files = files;
    }
}

