package com.nataliadosorriso.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class SubtracaoTest {
    @Test
    public void adicao() {
        MockRouter router = new MockRouter(new App());
        router.get("/adicao/2/4", rsp -> {
            assertEquals(6.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void adicao_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/adicao/a/a", rsp -> {});
        });
    }
}