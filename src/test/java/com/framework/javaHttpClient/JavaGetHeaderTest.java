package com.framework.javaHttpClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaGetHeaderTest {
    private static final String BASE_URL = "https://api.github.com";

    @Test
    void getReturns200() throws IOException, InterruptedException {
        HttpClient httpCient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET()
                .setHeader("User-Agent","Java 11 http request")
                .build();

        HttpResponse<Void> httpResponse = httpCient.send(get, HttpResponse.BodyHandlers.discarding());

        int actualCode = httpResponse.statusCode();
        Assertions.assertEquals(200, actualCode);
    }
    @Test
    void contentTypeIsJson() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();
        HttpResponse<Void> response = httpClient.send(get,HttpResponse.BodyHandlers.discarding());
        String contentType = response.headers().firstValue("content-type").get();
        Assertions.assertEquals("application/json; charset=utf-8", contentType);

    }

    @Test
    void xRateLimitIsPresent() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();
        HttpResponse<Void> response = httpClient.send(get,HttpResponse.BodyHandlers.discarding());
        String xRateLimit = response.headers().firstValue("X-RateLimit").get();
        Assertions.assertEquals(60, Integer.parseInt(xRateLimit));
    }
}
