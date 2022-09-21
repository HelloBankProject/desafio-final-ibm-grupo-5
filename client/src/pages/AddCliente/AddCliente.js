import React from 'react'
import Navbar from '../../components/Navbar/NavBar'
import CadastroClienteForm from '../../components/CadastroClienteForm/CadastroClienteForm'
import Footer from '../../components/Footer/Footer'

function AddCliente() {
    return (
        <>
            <Navbar />
            <CadastroClienteForm />
            <Footer />
        </>
    )
}

export default AddCliente