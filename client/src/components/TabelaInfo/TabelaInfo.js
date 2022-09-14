import * as React from 'react';
import axios from 'axios';
import styles from './TabelaInfo.module.scss';
import { Link, useParams } from 'react-router-dom';


function TabelaInfo() {

  const [cliente, setCliente] = React.useState([])
  const {id} = useParams()

  React.useEffect(() => {
    loadCliente()
  },[])

  const loadCliente = async () => {
    const resultado = await axios.get("http://localhost:8080/clientes")
    setCliente(resultado.data)
  }

  const deleteCliente = async (id) => {
    await axios.delete(`http://localhost:8080/clientes/${id}`)
    loadCliente()
  }

  return (
    <>
      
    <table class={`table ${styles.tabelaContainer}`}>
  <thead>
    <tr className={styles.tabelaTitulos}>
      <th scope="col">Código</th>
      <th scope="col">Nome</th>
      <th scope="col">CPF</th>
      <th scope="col">Email</th>
      <th scope="col">Endereço</th>
      <th scope="col">Estado</th>
      <th scope="col">Telefone</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
    {
      cliente.map((cliente,index) => (
        <tr>
        <th scope="row" key={index}>{cliente.id}</th>
        <td>{cliente.nome}</td>
        <td>{cliente.cpf}</td>
        <td>{cliente.email}</td>
        <td>{cliente.endereco}</td>
        <td>{cliente.estado}</td>
        <td>{cliente.telefone}</td>
        <td>
          <button className='btn btn-primary mx-2'>Vizualizar</button>
          <Link className='btn btn-outline-primary mx-2'
          to={`/editcliente/${cliente.id}`}
          >Atualizar</Link>
          <Link className='btn btn-danger mx-2'
          onClick={() => deleteCliente(cliente.id)}
          >Deletar</Link>
        </td>
    </tr>
      ))
    }
    
  </tbody>
</table>
    </>
    
  );
}

export default TabelaInfo