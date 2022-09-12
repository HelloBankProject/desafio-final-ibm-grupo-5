import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import styles from './TabelaInfoTransacao.module.scss';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'valor', headerName: 'Valor', type: 'number', width: 130 },
  { field: 'data_transacao', headerName: 'Data', type: 'number',width: 130 },
  { field: 'modo_envio', headerName: 'Modo de Envio', width: 130},
  { field: 'id_recebedor', headerName: 'Recebedor', width: 130},
  { field: 'id_fornecedor', headerName: 'Fornecedor', width: 130},
];

const rows = [
  { id: 1, valor: 2500.00, data_transacao: '12/09/2022', modo_envio: 'pix', id_recebedor: 1, id_fornecedor: 5},
];

function TabelaInfoTransacao() {
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

export default TabelaInfoTransacao