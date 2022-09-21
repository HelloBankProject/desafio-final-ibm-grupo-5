<<<<<<< HEAD
import React from 'react'
import styles from './TransferenciaForm.module.scss'

function TransferenciaForm() {
=======
import React, {useState} from 'react'
import { useNavigate, useParams } from 'react-router'
import axios from 'axios'
import styles from './TransferenciaForm.module.scss'

function TransferenciaForm() {

    let navigate = useNavigate()

    const {id} = useParams()

    const [transferencia, setTransferencia] = useState({
        valor:"",
        modo:"transferencia",
        recebedor:"",
        fornecedor:id,
    })
  
    const { valor, recebedor } = transferencia
  
    const handleChange = (e) => {
      setTransferencia({...transferencia, [e.target.name]: e.target.value})
      console.log(transferencia)
    }
     

    const onSubmit = async (e) => {
      e.preventDefault()
      console.log(transferencia)
      await axios.post("http://localhost:8080/transacoes/transferencia", transferencia)
      navigate("/")
    }

>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
    return (
        <>
            <div className={styles.depositoFormContainer}>
                <div className={styles.depositoFormTitule}>
                    <h3 className={styles.theH3}>Transferência</h3>
                </div>

                <hr /> 

                <div>
<<<<<<< HEAD
                    <form className={styles.formContainer}>
=======
                    <form className={styles.formContainer} onSubmit={(e) => onSubmit(e)}>
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                        <input 
                            name='valor'
                            type={'number'}
                            className="form-control"
                            placeholder="Inserir valor"
<<<<<<< HEAD
=======
                            value={valor}
                            onChange={(e) => handleChange(e)}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                        />
                        <input 
                            name='modo'
                            type={'hidden'}
                            className="form-control"
                            placeholder="Modo de Envio"
<<<<<<< HEAD
=======
                            onChange={(e) => handleChange(e)}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                        />
                        <input 
                            name='recebedor'
                            type={'text'}
                            className={`form-control ${styles.inputField}`}
                            placeholder="Inserir recebedor"
<<<<<<< HEAD
                        />
                        <input 
                            name='id'
                            type={'hidden'}
                            className="form-control"
                            placeholder="id"
=======
                            value={recebedor}
                            onChange={(e) => handleChange(e)}
                        />
                        <input 
                            name='fornecedor'
                            type={'hidden'}
                            className="form-control"
                            placeholder="id"
                            value={id}
                            onChange={(e) => handleChange(e)}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                        />

                        <div className={styles.buttonContainer}>
                            <button type="submit" className={`btn btn-primary ${styles.theButton}`}>
                                Transferir
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

export default TransferenciaForm