import React from 'react'
import styles from './TransferenciaForm.module.scss'

function TransferenciaForm() {
    return (
        <>
            <div className={styles.depositoFormContainer}>
                <div className={styles.depositoFormTitule}>
                    <h3 className={styles.theH3}>Transferência</h3>
                </div>

                <hr /> 

                <div>
                    <form className={styles.formContainer}>
                        <input 
                            name='valor'
                            type={'number'}
                            className="form-control"
                            placeholder="Inserir valor"
                        />
                        <input 
                            name='modo'
                            type={'hidden'}
                            className="form-control"
                            placeholder="Modo de Envio"
                        />
                        <input 
                            name='recebedor'
                            type={'text'}
                            className={`form-control ${styles.inputField}`}
                            placeholder="Inserir recebedor"
                        />
                        <input 
                            name='id'
                            type={'hidden'}
                            className="form-control"
                            placeholder="id"
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