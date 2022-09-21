import React from 'react'
import NavbarConta from '../../components/Navbar/NavBarConta'
import EditarTransacaoForm from '../../components/EditarTransacaoForm/EditarTransacaoForm'
import Footer from '../../components/Footer/Footer'

function EditTransacao() {
    return (
        <>
            <NavbarConta />
            <EditarTransacaoForm />
            <Footer />
        </>
    )
}

export default EditTransacao