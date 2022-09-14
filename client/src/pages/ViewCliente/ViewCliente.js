import React from 'react'
import DetalhamentoCliente from '../../components/DetalhamentoCliente/DetalhamentoCliente'
import NavBarCliente from '../../components/Navbar/NavBarClinte'
import TabelaInfoConta from '../../components/TabelaInfoConta/TabelaInfoConta'

function ViewCliente() {
    return (
        <>
            <NavBarCliente />
            <DetalhamentoCliente />
            <TabelaInfoConta />
        </>
    )
}

export default ViewCliente