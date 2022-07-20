package com.nataliadosorriso.ifal.calcapi;

import io.jooby.annotations.*;

@Path("/")
public class Controller {

  @GET
  public String sayHi() {
    return "Insira os valores para a operação! (/<operacao>/<valor1>/<valor2>)";
  }
}
