package com.nataliadosorriso.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class MultiplicacaoTest {
    @Test
    public void multiplicacao() {
        MockRouter router = new MockRouter(new App());
        router.get("/multiplicacao/4/2", rsp -> {
            assertEquals(8.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void multiplicacao_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/multiplicacao/a/a", rsp -> {});
        });
    }

    @Test
    public void multiplicacao_semParametros() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/multiplicacao", rsp -> {});
        });
    }

    @Test
    public void multiplicacao_semUmParametro() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/multiplicacao/2", rsp -> {});
        });
    }
}