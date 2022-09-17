import React, {useState} from 'react'
import axios from 'axios'
import styles from './CadastroClienteForm.module.scss'
import { Link, useNavigate } from 'react-router-dom'

function CadastroClienteForm() {

  let navigate = useNavigate()

  const [cliente, setCliente] = useState({
      nome:"",
      cpf:"",
      email:"",
      senha:"",
      endereco:"",
      estado:"",
      cidade:"",
      bairro:"",
      complemento:"",
      telefone:"",
  })

  const { nome,cpf,email,senha,endereco,estado,cidade,bairro,complemento,telefone} = cliente

  const handleChange = (e) => {
    setCliente({...cliente, [e.target.name]: e.target.value})
    console.log(cliente.nome)
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.post("http://localhost:8080/clientes", cliente)
    navigate("/")
  }

  return (
    <>
      <div className={styles.cadastroFormContainer}>

        <div className={styles.tituloContainer}>
          <h3>Cadastrar Cliente</h3>
        </div>

        <form onSubmit={(e) => onSubmit(e)}>

          <div className={styles.cadastroForm}>
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Nome Completo"
              name='nome'
              value={nome}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="CPF"
              name='cpf'
              value={cpf}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Email"
              name='email'
              value={email}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"password"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Senha"
              name='senha'
              value={senha}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Endereço"
              name='endereco'
              value={endereco}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Estado"
              name='estado'
              value={estado}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Cidade"
              name='cidade'
              value={cidade}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Bairro"
              name='bairro'
              value={bairro}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
              className={`form-control ${styles.contenteField}`}
              placeholder="Complemento"
              name='complemento'
              value={complemento}
              onChange={(e) => handleChange(e)}
              />
              <input
                type={"text"}
                className={`form-control ${styles.contenteField}`}
                placeholder="Telefone"
                name='telefone'
                value={telefone}
                onChange={(e) => handleChange(e)}
              />
            </div>

            <div className={styles.buttonContainer}>
              <button type="submit" className={`btn btn-primary ${styles.cadastrarButton}`}  >
                Cadastrar
              </button>
              <Link className={`btn btn-danger mx-2 ${styles.cadastrarButtonCancelar}`} to="/">
                Cancel
              </Link>
            </div>

        </form>
      
      </div>
    </>
  )
}

export default CadastroClienteForm