package com.oauthservice.model.service;


import com.oauthservice.model.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
