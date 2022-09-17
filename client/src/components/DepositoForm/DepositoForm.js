import React, {useState} from 'react'
import { useNavigate, useParams } from 'react-router'
import axios from 'axios'
import styles from './DepositoForm.module.scss'

function DepositoForm() {

    let navigate = useNavigate()

    const {id} = useParams()

    const [deposito, setDeposito] = useState({
        valor:"",
        modo:"deposito",
        contaId:id,
    })
  
    const { valor } = deposito
  
    const handleChange = (e) => {
      setDeposito({...deposito, [e.target.name]: e.target.value})
    }
    
    

    const onSubmit = async (e) => {
      e.preventDefault()
      await axios.post("http://localhost:8080/transacoes/deposito", deposito)
      navigate("/")
    }

    

    return (
        <>
            <div className={styles.depositoFormContainer}>
                <div className={styles.depositoFormTitule}>
                    <h3 className={styles.theH3}>Depósito</h3>
                </div>
                <hr />

                <div>
                    <form className={styles.formContainer} onSubmit={(e) => onSubmit(e)}>
                        <input 
                            name='valor'
                            type={'number'}
                            className="form-control"
                            placeholder="Inserir valor"
                            value={valor}
                            onChange={(e) => handleChange(e)}
                        />
                        <input 
                            name='modo'
                            type={'hidden'}
                            className="form-control"
                            placeholder="Modo de Envio"
                            onChange={(e) => handleChange(e)}
                        />
                        <input 
                            name='contaId'
                            type={'hidden'}
                            className="form-control"
                            placeholder="id"
                            value={id}
                            onChange={(e) => handleChange(e)}
                        />

                        <div className={styles.buttonContainer}>
                            <button type="submit" className={`btn btn-primary ${styles.theButton}`}>
                                Depositar
                            </button>
                            <button type="submit" className={`btn btn-danger ${styles.theButtonCancelar}`}>
                                Cancelar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}

export default DepositoForm