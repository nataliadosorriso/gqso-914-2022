package com.nataliadosorriso.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class SubtracaoTest {
    @Test
    public void subtracao() {
        MockRouter router = new MockRouter(new App());
        router.get("/subtracao/4/2", rsp -> {
            assertEquals(2.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void subtracao_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/subtracao/a/a", rsp -> {});
        });
    }

    @Test
    public void subtracao_semParametros() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/subtracao", rsp -> {});
        });
    }

    @Test
    public void subtracao_semUmParametro() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/subtracao/2", rsp -> {});
        });
    }
}