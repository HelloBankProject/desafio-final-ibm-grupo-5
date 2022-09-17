import React, {useState} from 'react'
import styles from './CadastroContaForm.module.scss'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'

function CadastroContaForm() {

  let navigate = useNavigate()

  const [conta, setConta] = useState({
      tipo:"",
      saldo:"",
      credito:"",
      primeiroTitular: {
        id: "",
      },
      segundoTitular:{
        id: "",
      },
  })

  const { tipo, saldo, credito, primeiroTitular, segundoTitular } = conta

  const handleChange = (e) => {
    const {name, value} = e.target
    setConta(prevState => ({
      ...prevState, tipo: value,
      ...prevState, saldo: value,
      ...prevState, credito: value,
        primeiroTitular: {id: value},
        segundoTitular: {id: value}
    }))
    console.log(conta)
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.post("http://localhost:8080/contas", conta)
    navigate("/")
  }

  return (
    <>
      <div className={styles.cadastroFormContainer}>

        <div className={styles.tituloContainer}>
          <h3>Cadastrar Conta</h3>
        </div>

        <form onSubmit={(e) => onSubmit(e)}>
          
          <div className={styles.cadastroForm}>
            <input
              name='saldo'
              type="number"
              className={`form-control ${styles.contenteField}`}
              placeholder="Saldo"
  
              value={saldo}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='credito'
              type="number"
              className={`form-control ${styles.contenteField}`}
              placeholder="Crédito"
              
              value={credito}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='primeiroTitular'
              type="text"
              className={`form-control ${styles.contenteField}`}
              placeholder="Primeiro Titular"
              
              value={primeiroTitular.id}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='segundoTitular'
              type="texte"
              className={`form-control ${styles.contenteField}`}
              placeholder="SegundoTitular"
              
              value={segundoTitular.id}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='tipo'
              type="text"
              className={`form-control ${styles.contenteField}`}
              placeholder="Tipo"
              
              value={tipo}
              onChange={(e) => handleChange(e)}
            />
          </div>

          <div className={styles.buttonContainer} >
            <button type="submit" className={`btn btn-primary ${styles.cadastrarButton}`}>
              Cadastrar
            </button>
            <Link className={`btn btn-danger mx-2 ${styles.cadastrarButtonCancelar}`} to="/">
              Cancel
            </Link>
          </div>
            
        </form>
      </div>
        
    </>
  );
}

export default CadastroContaForm