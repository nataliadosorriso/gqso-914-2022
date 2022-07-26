package com.nataliadosorriso.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class DivisaoTest {
    @Test
    public void divisao() {
        MockRouter router = new MockRouter(new App());
        router.get("/divisao/4/2", rsp -> {
            assertEquals(2.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void divisao_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/divisao/b/b", rsp -> {});
        });
    }

    @Test
    public void divisao_semParametros() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/divisao", rsp -> {});
        });
    }

    @Test
    public void divisao_semUmParametro() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/divisao/2", rsp -> {});
        });
    }
}