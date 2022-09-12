import React from 'react'
import CadastroClienteForm from '../../components/CadastroClienteForm/CadastroClienteForm'
import Navbar from '../../components/NavBar'
import TabelaInfo from '../../components/TabelaInfo/TabelaInfo'

function Home() {
    return (
        <>
            <Navbar />
            <CadastroClienteForm />
            <TabelaInfo />
        </>
    )
}

export default Home