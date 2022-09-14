import React from 'react'
import NavBarConta from '../../components/Navbar/NavBarConta'
import TabelaInfoTransacao from '../../components/TabelaInfoTransacao/TabelaInfoTransacao'
import DetalhamentoConta from '../../components/DetalhamentoConta/DetalhamentoConta'

function Conta() {
    return (
        <>
            <NavBarConta />
            <DetalhamentoConta />
            <TabelaInfoTransacao />
        </>
    )
}

export default Conta