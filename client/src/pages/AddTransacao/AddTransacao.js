import React from 'react'
import NavBarConta from '../../components/Navbar/NavBarConta'
import CadastroTransacaoForm from '../../components/CadastroTransacaoForm/CadastroTransacaoForm'
import Footer from '../../components/Footer/Footer'

function AddTransacao() {
    return (
        <>
            <NavBarConta />
            <CadastroTransacaoForm />
            <Footer />
        </>
    )
}

export default AddTransacao