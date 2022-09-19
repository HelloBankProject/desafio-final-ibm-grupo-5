package br.com.hellobankproject.api.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "cliente")
@JsonSerialize
public class Cliente {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CPF(message = "Campo Invalido")
    @NotBlank(message = "Campo não informado")
    @Column(name = "cpf", length = 14)
    private String cpf;

    @NotBlank(message = "Campo não informado")
    @Column(name = "nome", length = 50)
    private String nome;

    @Email(message = "Campo Invalido")
    @NotBlank(message = "Campo não informado")
    @Column(name = "email", length = 80)
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Senha Invalida")
    @NotBlank(message = "Campo não informado")
    @Column(name = "senha", length = 20)
    private String senha;

    @NotBlank(message = "Campo não informado")
    @Column(name = "endereco", length = 50)
    private String endereco;

    @NotBlank(message = "Campo não informado")
    @Column(name = "estado", length = 50)
    private String estado;

    @NotBlank(message = "Campo não informado")
    @Column(name = "cidade", length = 80)
    private String cidade;

    @NotBlank(message = "Campo não informado")
    @Column(name = "bairro", length = 80)
    private String bairro;

    @Column(name = "complemento", length = 5)
    private String complemento;

    @Pattern(regexp = "^[0-9]+$", message = "telefone invalido")
    @NotBlank(message = "Campo não informado")
    @Column(name = "telefone", length = 11)
    private String telefone;

    /*
     * OBS.: Não está conseguindo puxar a lista de contas
     * Entretanto, não acredito que seja necessário, mas se alguém conseguir
     * vai ser melhor...Assista o vídeo do Isidro [Semana 4]
     * Aula 5. Relações 1:N - Inserção
     * Nesse vídeo ele ensina a lógica, mas de alguma forma não estou conseguindo
     */

    @OneToMany(mappedBy = "primeiroTitular", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "primeiroTitular", "segundoTitular" })
    private List<Conta> listaPrimeiroTitular;

    @OneToMany(mappedBy = "segundoTitular", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "primeiroTitular", "segundoTitular" })
    private List<Conta> listaSegundoTitular;

    public List<Conta> getListaSegundoTitular() {
        return listaSegundoTitular;
    }

    public void setListaSegundoTitular(List<Conta> listaSegundoTitular) {
        this.listaSegundoTitular = listaSegundoTitular;
    }

    public List<Conta> getListaPrimeiroTitular() {
        return listaPrimeiroTitular;
    }

    public void setListaPrimeiroTitular(List<Conta> listaPrimeiroTitular) {
        this.listaPrimeiroTitular = listaPrimeiroTitular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
