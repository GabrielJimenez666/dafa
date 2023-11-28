package com.example.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.MetaDao;
import com.example.domain.Metas;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDao metaDao;

    @Override
    public List<Metas> listarMetas() {
        return (List<Metas>) metaDao.findAll();
    }

    @Override
    public void guardar(Metas meta) {
        metaDao.save(meta);
    }

    @Override
    public void eliminar(Metas meta) {
        metaDao.delete(meta);
    }

    @Override
    public Metas encontrarMetas(Metas meta) {
        return metaDao.findById(meta.getId()).orElse(null);
    }

}
