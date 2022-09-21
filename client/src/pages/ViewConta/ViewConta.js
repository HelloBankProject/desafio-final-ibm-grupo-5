import React from 'react'
import NavBarConta from '../../components/Navbar/NavBarConta'
import TabelaInfoTransacao from '../../components/TabelaInfoTransacao/TabelaInfoTransacao'
import DetalhamentoConta from '../../components/DetalhamentoConta/DetalhamentoConta'
import DepositoForm from '../../components/DepositoForm/DepositoForm'
import SaqueForm from '../../components/SaqueForm/SaqueForm'
import TransferenciaForm from '../../components/TransferenciaForm/TransferenciaForm'
import styles from './ViewConta.module.scss'

function Conta() {
    return (
        <>
            <NavBarConta />
            <div className={styles.detalhamentoAtividadeContainer}>
                <DetalhamentoConta />
                <div className={styles.atividadeContainer}>
                    <DepositoForm />
                    <SaqueForm />
                    <TransferenciaForm />
                </div>
            </div>
<<<<<<< HEAD
=======
            <h3 className={styles.theTitule}>Histórico de Transações</h3>
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
            <TabelaInfoTransacao />
        </>
    )
}

export default Conta