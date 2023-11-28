package com.example.servicio;

import java.util.List;

import com.example.domain.Metas;

public interface MetaService {

    public List<Metas> listarMetas();

    public void guardar(Metas meta);

    public void eliminar(Metas meta);

    public Metas encontrarMetas(Metas meta);

}
