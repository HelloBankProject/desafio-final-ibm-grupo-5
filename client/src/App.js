import Home from './pages/Home/Home'
import Cliente from './pages/Cliente/Cliente'
import Conta from './pages/Conta/Conta'

import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/detalhamento-cliente' element={<Cliente />} />
          <Route path='/detalhamento-conta' element={<Conta />} />
        </Routes>
      </Router>
    </>
  );
}

export default App
