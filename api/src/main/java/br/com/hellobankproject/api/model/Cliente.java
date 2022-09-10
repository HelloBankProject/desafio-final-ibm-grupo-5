package br.com.hellobankproject.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "cidade", length = 80, nullable = false)
    private String cidade;

    @Column(name = "bairro", length = 80, nullable = false)
    private String bairro;

    @Column(name = "complemento", length = 50, nullable = true)
    private String complemento;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    /*
     * OBS.: Não está conseguindo puxar a lista de contas
     * Entretanto, não acredito que seja necessário, mas se alguém conseguir
     * vai ser melhor...Assista o vídeo do Isidro [Semana 4]
     * Aula 5. Relações 1:N - Inserção
     * Nesse vídeo ele ensina a lógica, mas de alguma forma não estou conseguindo
     * 
     * @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
     * 
     * @JsonIgnoreProperties({"cliente", "outroCliente"})
     * private List<Conta> contas;
     * 
     * 
     * public List<Conta> getContas() {
     * return contas;
     * }
     * 
     * public void setContas(List<Conta> contas) {
     * this.contas = contas;
     * }
     */

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
}
