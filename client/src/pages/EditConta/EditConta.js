import React from 'react'
import NavbarCliente from '../../components/Navbar/NavBarClinte'
import EditarContaForm from '../../components/EditarContaForm/EditarContaForm'
import Footer from '../../components/Footer/Footer'

function EditCliente() {
    return (
        <>
            <NavbarCliente />
            <EditarContaForm />
            <Footer />
        </>
    )
}

export default EditCliente