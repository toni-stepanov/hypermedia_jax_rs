package hypermedia.jax_rs.dao;

import hypermedia.jax_rs.entity.Laptop;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class LaptopDao {

    public List<Laptop> getLaptops(){
        return Arrays.asList(new Laptop(1, "model1", 4,500,300),new Laptop(2, "model2", 8,1000,400));
    }

    public Laptop getLaptop(long id){
        List<Laptop> laptops = getLaptops();
        return laptops.stream().filter(l -> l.getId() == id).findFirst().get();
    }

}

