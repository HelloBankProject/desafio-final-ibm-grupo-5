import * as React from 'react';
import axios from 'axios';
import styles from './TabelaInfoConta.module.scss';
import { Link, useParams } from 'react-router-dom';


function TabelaInfoConta() {

  const [conta, setConta] = React.useState([])
  const {id} = useParams()

  React.useEffect(() => {
    loadConta()
  },[])

  const loadConta = async () => {
    const resultado = await axios.get("http://localhost:8080/contas")
    setConta(resultado.data)
    console.log(resultado.data)
    console.log(id)
  }

  const deleteConta = async (id) => {
    await axios.delete(`http://localhost:8080/contas/${id}`)
    console.log("passei por aqui " + id)
    loadConta()
  }

  
  return (
    <>

      <table className={`table ${styles.tabelaContainer}`}>
  <thead>
    <tr className={styles.tabelaTitulos}>
      <th scope="col">Código</th>
      <th scope="col">Tipo</th>
      <th scope="col">Saldo (R$)</th>
      <th scope="col">Crédito (R$)</th>
      <th scope="col">Primeiro Titular</th>
      <th scope="col">Segundo Titular</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
    {
      conta.map((conta, index) => (
        <tr className={styles.tabelaTitulos} key={index}>
        {
          conta.primeiroTitular.id == id ?
          <>
            <th scope="row" >{conta.id}</th>
            <td>{conta.tipo}</td>
            <td>{Intl.NumberFormat('pt-BR').format(conta.saldo)}</td>
            
              {
                conta.credito === null ? 
                  <td>null</td>
                :
                  <td>{Intl.NumberFormat('pt-BR').format(conta.credito)}</td>       
              }

            <td>{conta.primeiroTitular.id}</td>
            
              {
                conta.segundoTitular === null ? 
                  <td>null</td>
                :
                  <td>{conta.segundoTitular.id}</td>       
              }
            
            <td>
              <Link className='btn btn-primary mx-2'
              to={`/viewconta/${conta.id}`}
              >Vizualizar</Link>
              <button className='btn btn-danger mx-2'
                onClick={() => deleteConta(conta.id)}
              >Deletar</button>
            </td>
          </>
           : null
        }
          
        </tr>
      ))
    }
  </tbody>
</table>
    </>

  );
}

export default TabelaInfoConta