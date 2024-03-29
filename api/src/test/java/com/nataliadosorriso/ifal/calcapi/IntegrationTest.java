package com.nataliadosorriso.ifal.calcapi;

import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class IntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void shouldSayHi(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort)
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("Insira os valores para a operação! (/<operacao>/<valor1>/<valor2>)", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
  
//adição

  @Test
  public void adicao(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/adicao/8/5")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("13.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
  @Test
  public void adicao_carct(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/adicao/2/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }

  //subtracao

  @Test
  public void subtracao(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/subtracao/8/5")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("3.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
  @Test
  public void subtracao_carct(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/subtracao/2/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }

  //multiplicação

  @Test
  public void multiplicacao(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/multiplicacao/8/5")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("40.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
  @Test
  public void multiplicacao_carct(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/multiplicacao/2/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }

  //divisão

  @Test
  public void divisao(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/divisao/8/2")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("4.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
  @Test
  public void divisao_carct(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/divisao/2/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }
}
