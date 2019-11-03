package com.salesianostriana.dam.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.repos.VentaRepositorio;
import com.salesianostriana.dam.service.base.BaseService;

@Service
public class VentaServicio extends BaseService<Venta, Long, VentaRepositorio>{

}
