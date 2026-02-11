package com.repartos.demo.helpers;

import java.util.ArrayList;
import java.util.List;

import com.repartos.demo.entities.Conductor;
import com.repartos.demo.entities.Distribuidora;
import com.repartos.demo.entities.Producto;
import com.repartos.demo.repositories.ConductorRepository;
import com.repartos.demo.repositories.DistribuidoraRepository;
import com.repartos.demo.repositories.ProductoRepository;

public class SeederDB {
    public SeederDB(ConductorRepository condRepo, ProductoRepository prodRepo, DistribuidoraRepository distRepo){
        condRepo.save(new Conductor("Arturo"));
        condRepo.save(new Conductor("Paco"));
        condRepo.save(new Conductor("Marta"));
        condRepo.save(new Conductor("Loli"));
        condRepo.save(new Conductor("Juan"));

        prodRepo.save(new Producto("Cocacola", 12));
        prodRepo.save(new Producto("Cerveza", 30));
        prodRepo.save(new Producto("Agua", 32));
        prodRepo.save(new Producto("Vino", 10));
        prodRepo.save(new Producto("Fanta", 45));
        prodRepo.save(new Producto("Batido",24));
        prodRepo.save(new Producto("Leche", 8));
        prodRepo.save(new Producto("Licor", 14));
        
        distRepo.save(new Distribuidora(condRepo.findAll(), prodRepo.findAll()));
        List <Conductor> conductores = new ArrayList<>();
        conductores.add(new Conductor("Pepe"));
        conductores.add(new Conductor("Juan"));
        conductores.add(new Conductor("Antonio"));
        conductores.stream().forEach(c -> condRepo.save(c));
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("CocaCola", 12));
        productos.add(new Producto("Pan", 2));
        productos.add(new Producto("Fanta", 5));
        productos.stream().forEach(p -> prodRepo.save(p));
        
        distRepo.save(new Distribuidora(conductores, productos));
    }
}
