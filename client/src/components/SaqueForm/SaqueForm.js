<<<<<<< HEAD
import React from 'react'
import styles from './SaqueForm.module.scss'

function SaqueForm() {
    return (
        <>
            <div className={styles.depositoFormContainer}>
=======
import React, {useState} from 'react'
import { useNavigate, useParams } from 'react-router'
import axios from 'axios'
import styles from './SaqueForm.module.scss'

function SaqueForm() {

    let navigate = useNavigate()

    const {id} = useParams()

    const [saque, setSaque] = useState({
        valor:"",
        modo:"saque",
        contaId:id,
    })
  
    const { valor } = saque
  
    const handleChange = (e) => {
      setSaque({...saque, [e.target.name]: e.target.value})
    }
    
    

    const onSubmit = async (e) => {
      e.preventDefault()
      await axios.post("http://localhost:8080/transacoes/saque", saque)
      navigate("/")
    }

    return (
        <>
            <div className={styles.depositoFormContainer} >
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                <div className={styles.depositoFormTitule}>
                    <h3 className={styles.theH3}>Saque</h3>
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
                        />
                        <input 
                            name='id'
                            type={'hidden'}
                            className="form-control"
                            placeholder="id"
=======
                            onChange={(e) => handleChange(e)}
                        />
                        <input 
                            name='contaId'
                            type={'hidden'}
                            className="form-control"
                            placeholder="id"
                            value={id}
                            onChange={(e) => handleChange(e)}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                        />

                        <div className={styles.buttonContainer}>
                            <button type="submit" className={`btn btn-primary ${styles.theButton}`}>
                                Sacar
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

export default SaqueForm