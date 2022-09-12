import Home from './pages/Home'
import CadastroCliente from './pages/CadastroCliente'
import CadastroConta from './pages/CadastroConta'
import DetalhamentoCliente from './pages/DetalhamentoCliente'
import DetalhamentoConta from './pages/DetalhamentoConta'

import React from 'react'
import { BrowserRouter as Router, Routes, Route, Navegate } from 'react-router-dom'

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/cadastro-cliente' element={<CadastroCliente />} />
          <Route path='/cadastro-conta' element={<CadastroConta />} />
          <Route path='/detalhamento-cliente' element={<DetalhamentoCliente />} />
          <Route path='/detalhamento-conta' element={<DetalhamentoConta />} />
        </Routes>
      </Router>
    </>
  );
}

export default App
