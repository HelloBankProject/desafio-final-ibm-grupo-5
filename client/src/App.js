import Home from './pages/Home/Home'
import ViewCliente from './pages/ViewCliente/ViewCliente'
import ViewConta from './pages/ViewConta/ViewConta'
import ViewTransacao from './pages/ViewTransacao/ViewTransacao'
import AddCliente from './pages/AddCliente/AddCliente'
import AddConta from './pages/AddConta/AddConta'
import AddTransacao from './pages/AddTransacao/AddTransacao'
import EditCliente from './pages/EditCliente/EditCliente'
import EditConta from './pages/EditConta/EditConta'
import EditTransacao from './pages/EditTransacao/EditTransacao'


import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/viewcliente/:id' element={<ViewCliente />} />
          <Route path='/viewconta/:id' element={<ViewConta />} />
          <Route path='/viewtransacao/:id' element={<ViewTransacao />} />

          <Route path='/addcliente' element={<AddCliente />} />
          <Route path='/addconta' element={<AddConta />} />
          <Route path='/addtransacao' element={<AddTransacao />} />

          <Route path='/editcliente/:id' element={<EditCliente />} />
          <Route path='/editconta/:id' element={<EditConta />} />
          <Route path='/edittransacao/:id' element={<EditTransacao />} />
        </Routes>
      </Router>
    </>
  );
}

export default App
