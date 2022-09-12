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
    <div className={styles.tabelaContainer} style={{ height: 465, width: '60%' }}>
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
}

export default TabelaInfoConta