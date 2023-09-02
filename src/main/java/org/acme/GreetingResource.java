package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/gift")
public class GreetingResource {

    @Inject
    SantaClausService santaClausService;

    @POST
    @Produces(MediaType.WILDCARD)
    public Gift helloPost(CreateRequest request) {
        final var gift = Gift.withName(request.getName());
        santaClausService.create(gift);

        return gift;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.WILDCARD)
    public Gift helloGet(Long id) {
        return santaClausService.get(id);
    }
}
