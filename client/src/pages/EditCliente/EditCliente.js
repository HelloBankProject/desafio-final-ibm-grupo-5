import React from 'react'
import Navbar from '../../components/Navbar/NavBar'
import EditarClienteForm from '../../components/EditarClienteForm/EditarClienteForm'
import Footer from '../../components/Footer/Footer'

function EditCliente() {
    return (
        <>
            <Navbar />
            <EditarClienteForm />
            <Footer />
        </>
    )
}

export default EditCliente