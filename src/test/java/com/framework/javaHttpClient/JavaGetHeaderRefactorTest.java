package com.framework.javaHttpClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaGetHeaderRefactorTest {
    private static final String BASE_URL = "https://api.github.com";
    static HttpClient httpClient = HttpClient.newBuilder().build();
    static HttpResponse<Void> response;

    @BeforeEach
    static void sendGetToBaseEndpoint() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();
        response = httpClient.send(get,HttpResponse.BodyHandlers.discarding());

    }
    @ParameterizedTest
    @CsvSource({"X-Ratelimit-limit,60","content-type,application/json; charset=utf-8",
    "server,GitHub.com","x-frame-options,deny"})
    void xRateLimitIsPresent(String header, String expectedResult) throws IOException, InterruptedException {
       //Arrange
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        //Act
        String contentType = response.headers().firstValue(header).get();

        //Assert
        Assertions.assertEquals(expectedResult, contentType);
    }
}
