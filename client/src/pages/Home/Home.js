import React from 'react'
import Navbar from '../../components/Navbar/NavBar'
import TabelaInfo from '../../components/TabelaInfo/TabelaInfo'
import styles from './Home.module.scss'

function Home() {
    return (
        <>
            <Navbar />
            <h3 className={styles.theTitule}>Lista de Clientes</h3>
            <TabelaInfo />
        </>
    )
}

export default Home