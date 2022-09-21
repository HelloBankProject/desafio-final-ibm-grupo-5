import React from 'react'
import Article from '../../components/Article/Article'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/NavBar'
import TabelaInfo from '../../components/TabelaInfo/TabelaInfo'
import styles from './Home.module.scss'

function Home() {
    return (
        <>
            <Navbar />
            <Article />
            <h3 className={styles.theTitule}>Lista de Clientes</h3>
            <TabelaInfo />
            <Footer />
        </>
    )
}

export default Home