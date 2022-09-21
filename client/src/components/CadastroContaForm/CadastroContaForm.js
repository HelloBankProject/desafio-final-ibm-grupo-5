import React, {useState} from 'react'
import styles from './CadastroContaForm.module.scss'
import axios from 'axios'
import { Link, useNavigate, useParams } from 'react-router-dom'

function CadastroContaForm() {

  let navigate = useNavigate()
  const {id} = useParams()
  var codigoCliente = sessionStorage.getItem('id')

  const [conta, setConta] = useState({
      tipo:"",
      saldo: 0,
      credito: 0,
      idPrimeiroTitular: codigoCliente,
      idSegundoTitular:"",
  })

  const { tipo, saldo, credito, idPrimeiroTitular, idSegundoTitular } = conta
 
  const [tipoSelectionado, setTipoSelecionado] = useState()

  const handleChange = (e) => {
    console.log(tipoSelectionado)
    setTipoSelecionado(e.target.value)
    setConta({
      ...conta, [e.target.name]: e.target.value
    })
    
  
  }

  var options = React.createCla
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
    console.log(tipoSelectionado)
    conta.tipo = tipoSelectionado
    console.log(conta)
    await axios.post("http://localhost:8081/contas", conta)
    console.log("passei")
    navigate(`/viewcliente/${codigoCliente}`)
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
              type="hidden"
              className={`form-control ${styles.contenteField}`}
              placeholder="Saldo"
              step="any"
              value={saldo}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='credito'
              type="hidden"
              className={`form-control ${styles.contenteField}`}
              placeholder="Crédito"
              step="any"
              value={credito}
              onChange={(e) => handleChange(e)}
            />
            <select class="form-select" aria-label="Default select example" value={tipoSelectionado} onChange={e => setTipoSelecionado(e.target.value)}>
              <option selected>Selecione tipo de conta: </option>
              <option value={"corrente"}>corrente</option>
              <option value={"poupanca"}>poupança</option>
              <option value={"salario"}>salário</option> 
            </select>
            <input
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
              onChange={(e) => handleChange(e)}
            />
            
            {/* <input
              name='tipo'
              type="text"
              className={`form-control ${styles.contenteField}`}
              placeholder="Tipo"
              
              value={tipo}
              onChange={(e) => handleChange(e)}
            /> */}
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