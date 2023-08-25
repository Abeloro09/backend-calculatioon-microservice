package com.api_calculation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/liquidacion")
public class LiquidacionController {

// No expongo ningun Endpoint para esta entidad porque no se debe crear ninguna liquidacion sin haber cread0 un movimiento, se crean al crear un movimiento.



}
