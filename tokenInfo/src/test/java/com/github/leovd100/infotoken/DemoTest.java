package com.github.leovd100.infotoken;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class DemoTest {


    EmbeddedApplication<?> application;


    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

}
