import React, {useState} from 'react'
import styles from './CadastroContaForm.module.scss'
import axios from 'axios'
<<<<<<< HEAD
import { Link, useNavigate } from 'react-router-dom'
=======
import { Link, useNavigate, useParams } from 'react-router-dom'
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429

function CadastroContaForm() {

  let navigate = useNavigate()
<<<<<<< HEAD

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
=======
  const {id} = useParams()
  
  const [conta, setConta] = useState({
      tipo:"",
      saldo: 0,
      credito: 0,
      idPrimeiroTitular: "",
      idSegundoTitular:"",
  })

  const { tipo, saldo, credito, idPrimeiroTitular, idSegundoTitular } = conta

  const handleChange = (e) => {
    
    setConta({
      ...conta, [e.target.name]: e.target.value
    })
    
    console.log(conta)
  }
  /**
   * const handleChange = (e) => {
   *    const {name, value} = e.target
   *    setConta((prevState) => ({
   *        ...prevState, 
   * }))
   * }
   */

  const onSubmit = async (e) => {
    e.preventDefault()
    console.log(conta)
    await axios.post("http://localhost:8080/contas", conta)
    console.log("passei")
    navigate(`/viewcliente/${id}`)
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
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
<<<<<<< HEAD
  
=======
              step="any"
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              value={saldo}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='credito'
              type="number"
              className={`form-control ${styles.contenteField}`}
              placeholder="Crédito"
<<<<<<< HEAD
              
=======
              step="any"
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              value={credito}
              onChange={(e) => handleChange(e)}
            />
            <input
<<<<<<< HEAD
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
=======
              name='idPrimeiroTitular'
              type="number"
              className={`form-control ${styles.contenteField}`}
              placeholder="Primeiro Titular"
              
              value={idPrimeiroTitular}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='idSegundoTitular'
              type="number"
              className={`form-control ${styles.contenteField}`}
              placeholder="SegundoTitular"
              
              value={idSegundoTitular}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
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