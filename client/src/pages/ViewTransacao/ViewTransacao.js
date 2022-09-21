import React from 'react'
import NavBarConta from '../../components/Navbar/NavBarConta'
import DetalhamentoTransacao from '../../components/DetalhamentoTransacao/DetalhamentoTransacao'
import Footer from '../../components/Footer/Footer'
import styles from './ViewTransacao.module.scss'

function ViewTransacao() {
    return (
        <>
            <NavBarConta />
            <div className={styles.detalhamentoContainer}>
            <DetalhamentoTransacao />
            </div>
            
            <Footer />
        </>
    )
}

export default ViewTransacao