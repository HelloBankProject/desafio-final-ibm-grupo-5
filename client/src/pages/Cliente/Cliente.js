import React from 'react'
import CadastroContaForm from '../../components/CadastroContaForm/CadastroContaForm'
import DetalhamentoCliente from '../../components/DetalhamentoCliente/DetalhamentoCliente'
import NavBar from '../../components/NavBar'
import TabelaInfoConta from '../../components/TabelaInfoConta/TabelaInfoConta'

function Cliente() {
    return (
        <>
            <NavBar />
            <DetalhamentoCliente />
            <CadastroContaForm />
            <TabelaInfoConta />
        </>
    )
}

export default Cliente