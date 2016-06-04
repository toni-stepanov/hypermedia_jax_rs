package hypermedia.jax_rs.resource;


import hypermedia.jax_rs.dao.LaptopDao;
import hypermedia.jax_rs.entity.Laptop;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Stateless
@Path("laptops")
@Produces("application/json")
public class LaptopResource {

    @Inject
    private LaptopDao laptopDao;

    @Context
    private UriInfo uriInfo;

    @GET
    public List<Laptop> getLaptops() {
        List<Laptop> laptops = laptopDao.getLaptops();
        laptops.forEach(laptop -> {
            URI self = uriInfo.getBaseUriBuilder().path(LaptopResource.class).path(LaptopResource.class, "getLaptop")
                    .build(laptop.getId());
            laptop.getLinks().put("_link", self);
        });
        return laptops;
    }

    @GET
    @Path("{id}")
    public Laptop getLaptop(@PathParam("id") long id) {
        Laptop laptop = laptopDao.getLaptop(id);
        URI toAll = uriInfo.getBaseUriBuilder().path(LaptopResource.class).build();
        laptop.getLinks().put("_to_all", toAll);
        return laptop;
    }


}
