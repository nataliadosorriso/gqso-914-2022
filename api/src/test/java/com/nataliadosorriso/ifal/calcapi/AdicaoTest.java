package com.nataliadosorriso.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;

//import io.jooby.exception.BadRequestException;

public class AdicaoTest {

    //adicionado

    @Test
    public void chamaadicao() {
      Adicao adicao = new Adicao();
      assertEquals(6.0, adicao.adicao("2", "4"));
    }

    //

    @Test
    public void adicao() {
        MockRouter router = new MockRouter(new App());
        router.get("/adicao/2/4", rsp -> {
            assertEquals(6.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    //nas demais modifiquei de BadRequestException para NumberFormatException

    @Test
    public void adicao_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(NumberFormatException.class, () ->{
            router.get("/adicao/b/b", rsp -> {});
        });
    }

    @Test
    public void adicao_semParametros() {
        MockRouter router = new MockRouter(new App());
        assertThrows(NumberFormatException.class, () ->{
            router.get("/adicao", rsp -> {});
        });
    }

    @Test
    public void adicao_semUmParametro() {
        MockRouter router = new MockRouter(new App());
        assertThrows(NumberFormatException.class, () ->{
            router.get("/adicao/2", rsp -> {});
        });
    }
}