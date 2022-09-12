import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import styles from './TabelaInfo.module.scss';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'nome', headerName: 'Nome', width: 130 },
  { field: 'cpf', headerName: 'CPF', width: 130 },
  { field: 'email', headerName: 'Email', width: 130},
  { field: 'senha', headerName: 'Senha', type: 'password', width: 130},
  { field: 'endereco', headerName: 'Endereço', width: 130 },
  { field: 'estado', headerName: 'Estado', width: 130 },
  { field: 'cidade', headerName: 'Cidade', width: 130 },
  { field: 'bairro', headerName: 'Bairro', width: 130 },
  { field: 'complemento', headerName: 'Complemento', width: 130 },
  { field: 'telefone', headerName: 'Telefone', width: 130 },
  /*
  {
    field: 'fullName',
    headerName: 'Full name',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
    valueGetter: (params) =>
      `${params.row.firstName || ''} ${params.row.lastName || ''}`,
  },
  */
];

const rows = [
  { id: 1, nome: 'Juan Carvalho', cpf: '174.774.077-29', email: 'juanc.s.delima@gmail.com', senha: 'feveva3aer', endereco: 'Rua José Saly, 185', estado: 'Rio de Janeiro', cidade: 'São Gonçalo', bairro: 'Porto Novo', complemento: 'Sobrado', telefone: '21989447785' },

  //{ id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65 },
];

function TabelaInfo() {
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

export default TabelaInfo