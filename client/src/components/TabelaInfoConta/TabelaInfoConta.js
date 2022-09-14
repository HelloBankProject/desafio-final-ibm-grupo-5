import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import styles from './TabelaInfoConta.module.scss';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'tipo', headerName: 'Tipo', width: 130 },
  { field: 'saldo', headerName: 'Saldo', type: 'number',width: 130 },
  { field: 'credito', headerName: 'Crédito', type: 'number', width: 130},
  { field: 'id_cliente', headerName: 'Primeiro Titular', width: 130},
  { field: 'id_outro_cliente', headerName: 'Segundo Titular', width: 130},
];

const rows = [
  { id: 1, tipo: 'corrente', saldo: 1500.00, credito: 500.90, id_cliente: 1, id_outro_cliente: 'null'},
];

function TabelaInfoConta() {
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
    <tr>
      <th scope="row">1</th>
      <td>corrente</td>
      <td>1500.00</td>
      <td>500.90</td>
      <td>Juan Carvalho</td>
      <td>Ana Claudia</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>corrente</td>
      <td>1500.00</td>
      <td>500.90</td>
      <td>Juan Carvalho</td>
      <td>Ana Claudia</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>corrente</td>
      <td>1500.00</td>
      <td>500.90</td>
      <td>Juan Carvalho</td>
      <td>Ana Claudia</td>
    </tr>
  </tbody>
</table>
    </>

  );
}

export default TabelaInfoConta