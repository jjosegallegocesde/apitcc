package com.tcc.apitcc.servicios;


import com.tcc.apitcc.entidades.Mercancia;
import com.tcc.apitcc.repositorios.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class MercanciaServicioImpl implements MercanciaServicio {

    @Autowired
    private MercanciaRepositorio mercanciaRepositorio;

    @Transactional(readOnly = true)
    @Override
    public Iterable<Mercancia> buscarMercancias() {
        return mercanciaRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Mercancia> buscarMercanciasPorId(Integer id) {
        return mercanciaRepositorio.findById(id);
    }

    @Transactional
    @Override
    public Mercancia guardarMercancia(Mercancia mercancia) {
        return mercanciaRepositorio.save(mercancia);
    }

    @Transactional
    @Override
    public void eliminarMercanciaPorId(Integer id) {
        mercanciaRepositorio.deleteById(id);
    }
}
