package com.tcc.apitcc.servicios;

import com.tcc.apitcc.entidades.Mercancia;

import java.util.Optional;

public interface MercanciaServicio {

    public Iterable<Mercancia> buscarMercancias();

    public Optional<Mercancia> buscarMercanciasPorId(Integer id);

    public Mercancia guardarMercancia(Mercancia mercancia);

    public void eliminarMercanciaPorId(Integer id);


}
