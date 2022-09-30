package com.tcc.apitcc.controladores;


import com.tcc.apitcc.entidades.Mercancia;
import com.tcc.apitcc.servicios.MercanciaServicio;
import com.tcc.apitcc.servicios.MercanciaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/tcc/mercancias")
@CrossOrigin(origins = "*")
public class MercanciaControlador {

    @Autowired
    MercanciaServicio mercanciaServicio;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Mercancia mercancia){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(mercanciaServicio.guardarMercancia(mercancia));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{error:"+error+"}");
        }
    }

    @GetMapping
    public List<Mercancia> buscarTodos(){
        List<Mercancia> usuarios = StreamSupport
                .stream(mercanciaServicio.buscarMercancias().spliterator(),false)
                .collect(Collectors.toList());
        return usuarios;

    }

    @GetMapping("/{iup}")
    public ResponseEntity<?> buscarMercancia(@PathVariable Integer iup){

        Optional<Mercancia> usuario= mercanciaServicio.buscarMercanciasPorId(iup);

        if(usuario.isPresent()){

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuario);
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{error: mercancia no encontrada en BD}");
        }
    }





}
