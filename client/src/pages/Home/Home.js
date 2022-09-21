<<<<<<< HEAD
import React from "react";
import Navbar from "../../components/Navbar/NavBar";
import TabelaInfo from "../../components/TabelaInfo/TabelaInfo";
import Footer from "../../components/Footer/Footer";

function Home() {
  return (
    <>
      <Navbar />
      <TabelaInfo />
      <Footer />
    </>
  );
}

export default Home;
=======
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
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
