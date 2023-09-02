package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/gift")
public class GreetingResource {

    @Inject
    SantaClausService santaClausService;

    @POST
    @ResponseStatus(201)
    @Produces(MediaType.APPLICATION_JSON)
    public Gift create(CreateRequest request) {
        final var gift = Gift.withName(request.getName());
        santaClausService.create(gift);

        return gift;
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public Gift get(Long id) {
        Gift gift = santaClausService.get(id);
        return gift;
    }
}
