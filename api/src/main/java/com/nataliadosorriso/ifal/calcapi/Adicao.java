package com.nataliadosorriso.ifal.calcapi;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.exception.BadRequestException;

@Path("/adicao/{n1}?/{n2}?")
public class Adicao {

    @GET
    public double adicao(@PathParam("n1") String n1, @PathParam("n2") String n2) {
        try {
            if (n1 == null || n2 == null) {
                throw new BadRequestException("Parâmetros insuficientes");
            }
            return Double.parseDouble(n1) + Double.parseDouble(n2);
        } catch (NumberFormatException nfe) {
            throw new BadRequestException("Parâmetros inválidos: " + n1+ ", " + n2);
        }
    }
}