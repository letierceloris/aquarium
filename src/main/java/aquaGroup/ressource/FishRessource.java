package aquaGroup.ressource;

import aquaGroup.dto.FishDTO;
import aquaGroup.service.FishEJB;
import aquaGroup.model.Fish;
import javax.inject.Inject;
import javax.ws.rs.*;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import java.util.List;
//import java.util.logging.Logger;

@Path("fish")
public class FishRessource {

    @Inject
    private FishEJB fishEJB;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFishById(@PathParam("id") Long id) {

        return fishEJB.getFishById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFishs() {

        return fishEJB.getFishs();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMember(FishDTO fish) {
        
        //System.out.println("#########################"+fish.getName() + fish.getSpecies());
        return fishEJB.addFish(fish);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMember(@PathParam("id") Long id) {
        return fishEJB.deleteFish(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMember(@PathParam("id") Long id, FishDTO fish) {
  
        return fishEJB.updateFish(id, fish);
    }

}
