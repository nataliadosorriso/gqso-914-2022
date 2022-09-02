package com.nataliadosorriso.ifal.calcapi;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.exception.BadRequestException;

import io.jooby.annotations.*;

@Path("/adicao/{n1}?/{n2}?")
public class Adicao {

    /*adicionei

    @GET
    public double adicao(@PathParam("n1") String num1, @PathParam("n2") String num2) {
        return Double.parseDouble(num1) + Double.parseDouble(num2);
    }

    */

    @GET
    public double adicao(@PathParam("n1") String num1, @PathParam("n2") String num2) {
        try {
            if (num1 == null || num2 == null) {
                throw new BadRequestException("Parâmetros insuficientes");
            }
            return Double.parseDouble(num1) + Double.parseDouble(num2);
        } catch (NumberFormatException nfe) {
            throw new BadRequestException("Parâmetros inválidos: " + num1+ ", " + num2);
        }
    }
}