import React from 'react'
import NavBar from '../../components/NavBar'
import CadastroTransacaoForm from '../../components/CadastraTransacaoForm/CadastroTransacaoForm'
import TabelaInfoTransacao from '../../components/TabelaInfoTransacao/TabelaInfoTransacao'
import DetalhamentoConta from '../../components/DetalhamentoConta/DetalhamentoConta'
import styles from './Conta.module.scss'

function Conta() {
    return (
        <>
            <NavBar />
            <DetalhamentoConta />
            <CadastroTransacaoForm />
            <div className={styles.tabelaInfoTransacaoContainer} >
                <TabelaInfoTransacao />
            </div>
            
        </>
    )
}

export default Conta