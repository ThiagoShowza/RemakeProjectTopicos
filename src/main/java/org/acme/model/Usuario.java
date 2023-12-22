package org.acme.model;

public class Usuario extends DefaultEntity {

    private String nome;
    private String userName;
    private String senha;
    private Perfil perfil;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil(){
        return perfil;
    }

    public void setPerfil(Perfil perfil){
        this.perfil = perfil;
    }
}
