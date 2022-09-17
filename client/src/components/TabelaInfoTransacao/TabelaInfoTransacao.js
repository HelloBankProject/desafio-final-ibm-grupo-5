import * as React from 'react';
import axios from 'axios';
import styles from './TabelaInfoTransacao.module.scss';
import { Link, useParams } from 'react-router-dom';

function TabelaInfoTransacao() {
  const [transacao, setTransacao] = React.useState([])
  const {id} = useParams()

  React.useEffect(() => {
    loadTransacao()
  },[])

  const loadTransacao = async () => {
    const resultado = await axios.get("http://localhost:8080/transacoes")
    setTransacao(resultado.data)
  }

  const deleteTransacao = async (id) => {
    await axios.delete(`http://localhost:8080/transacoes/${id}`)
    loadTransacao()
  }

  return (
    <>
      <table class={`table ${styles.tabelaContainer}`}>
  <thead>
    <tr className={styles.tabelaTitulos}>
      <th scope="col">Código</th>
      <th scope="col">Valor (R$)</th>
      <th scope="col">Data Transação</th>
      <th scope="col">Modo de Envio</th>
      <th scope="col">Recebedor</th>
      <th scope="col">Fornecedor</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
    {
      transacao.map((transacao, index) => (
        <tr className={styles.tabelaTitulos}>
          {
            transacao.recebedor == id ?
            <>
            <th scope="row" key={index}>{transacao.id}</th>
            <td>{Intl.NumberFormat('pt-BR').format(transacao.valor)}</td>
            <td>{transacao.data}</td>
            <td>{transacao.modo}</td>
            <td>{transacao.recebedor}</td>
            <td>{transacao.fornecedor}</td>
            <td>
              <Link className='btn btn-primary mx-2'
                to={`/viewtransacao/${transacao.id}`}
              >Vizualizar</Link>
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

export default TabelaInfoTransacao