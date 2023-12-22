package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {

    USER(1, "User"),
    ADMIN(2, "Admin");

    private final Integer id;
    private final String label;

    Perfil(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    // NÃO PRECISA CRIAR SET, JA QUE TEMOS UM ATRIBUTO CONSTANTE
    public String getLabel() {
        return label;
    }

    //USADO PARA QUE SEJA POSSIVEL SELECIONAR O PERFIL PELO ID
    //VALIDA 
    public static Perfil valueOf(Integer id) throws IllegalArgumentException{
        if (id == null)
            return null;

            for(Perfil perfil : Perfil.values()){
                if(perfil.getId().equals(id))
                return perfil;
            }
            throw new IllegalArgumentException("Id invalido" + id);
    }

    



}
