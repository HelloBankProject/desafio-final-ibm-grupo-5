import React from 'react'
import DetalhamentoCliente from '../../components/DetalhamentoCliente/DetalhamentoCliente'
import Footer from '../../components/Footer/Footer'
import NavBarCliente from '../../components/Navbar/NavBarClinte'
import TabelaInfoConta from '../../components/TabelaInfoConta/TabelaInfoConta'
import styles from './ViewCliente.module.scss'

function ViewCliente() {
    return (
        <>
            <NavBarCliente />
            <DetalhamentoCliente />
            <h3 className={styles.theTitule}>Lista de Contas</h3>
            <TabelaInfoConta />
            <Footer />
        </>
    )
}

export default ViewCliente