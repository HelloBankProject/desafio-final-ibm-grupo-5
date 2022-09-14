import * as React from 'react';
import styles from './TabelaInfoTransacao.module.scss';


function TabelaInfoTransacao() {
  return (
    <>
      <table class={`table ${styles.tabelaContainer}`}>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Valor</th>
      <th scope="col">Data Transação</th>
      <th scope="col">Modo de Envio</th>
      <th scope="col">Recebedor</th>
      <th scope="col">Fornecedor</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>2500.00</td>
      <td>12/09/2022</td>
      <td>pix</td>
      <td>Juan Carvalho</td>
      <td>Ana Claudia</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>2500.00</td>
      <td>12/09/2022</td>
      <td>pix</td>
      <td>Juan Carvalho</td>
      <td>Ana Claudia</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>2500.00</td>
      <td>12/09/2022</td>
      <td>pix</td>
      <td>Juan Carvalho</td>
      <td>Ana Claudia</td>
    </tr>
  </tbody>
</table>
    </>
  
  );
}

export default TabelaInfoTransacao