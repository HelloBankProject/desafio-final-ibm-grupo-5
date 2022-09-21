import React from 'react'
import NavBarCliente from '../../components/Navbar/NavBarClinte'
import CadastroContaForm from '../../components/CadastroContaForm/CadastroContaForm'
import Footer from '../../components/Footer/Footer'
import styles from './AddConta.module.scss'

function AddConta() {
    return (
        <>
            <NavBarCliente />
            
            <div className={styles.cadastroConta}>
                <CadastroContaForm />
            </div>
            
            <Footer />
        </>
    )
}

export default AddConta