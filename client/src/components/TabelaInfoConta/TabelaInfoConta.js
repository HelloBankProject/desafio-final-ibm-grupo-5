import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from 'axios';
import styles from './TabelaInfoConta.module.scss';
import { Link, useParams } from 'react-router-dom';

function TabelaInfoConta() {
  const [conta, setConta] = React.useState([])
  const {id} = useParams()

  React.useEffect(() => {
    loadCliente()
  },[])

  const loadConta = async () => {
    const resultado = await axios.get("http://localhost:8080/contas")
    setConta(resultado.data)
  }

  const deleteConta = async (id) => {
    await axios.delete(`http://localhost:8080/contas/${id}`)
    loadConta()
  }

  return (
    <>

      <table class={`table ${styles.tabelaContainer}`}>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Tipo</th>
      <th scope="col">Saldo</th>
      <th scope="col">Credito</th>
      <th scope="col">Primeiro Titular</th>
      <th scope="col">Segundo Titular</th>
      
    </tr>
  </thead>
  <tbody>
    {
      conta.map((conta, index) => {
        <tr>
          <th scope="row" key={index}>{conta.id}</th>
          <td>{conta.tipo}</td>
          <td>{conta.saldo}</td>
          <td>{conta.credito}</td>
          <td>{conta.primeiroTitular.id}</td>
          <td>{conta.segundoTitular.id}</td>
          <td>
          <button className='btn btn-primary mx-2'>Vizualizar</button>
          <Link className='btn btn-outline-primary mx-2'
          to={`/editconta/${conta.id}`}
          >Atualizar</Link>
          <Link className='btn btn-danger mx-2'
          onClick={() => deleteCliente(conta.id)}
          >Deletar</Link>
        </td>
        </tr>
      })
    }
  </tbody>
</table>
    </>

  );
}

export default TabelaInfoConta