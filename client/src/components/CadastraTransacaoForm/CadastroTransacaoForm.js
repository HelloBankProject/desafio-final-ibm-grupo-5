import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './CadastroTransacaoForm.module.scss';

function CadastroTransacaoForm() {
  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Cadastrar Transaçao</h3>
          </div>
          <Box
            component="form"
            sx={{
              '& .MuiTextField-root': { m: 1, width: '25ch' },
            }}
            noValidate
            autoComplete="off"
          >
          <div className={styles.cadastroForm}>
            <TextField
              required
              id="outlined-required"
              label="Modo de Envio"
            />
            <TextField
              required
              id="outlined-required"
              label="Data"
            />
            <TextField
              required
              id="outlined-required"
              label="Recebedor"
            />
            <TextField
              required
              id="outlined-password-input"
              label="Fornecedor"
            />
            <TextField
              className={styles.finalTextField}
              required
              id="outlined-required"
              label="Valor"
            />
            
            </div>
            <Button className={styles.cadastrarButton} variant="contained">Cadastrar</Button>
          </Box>
        </div>
        
    </>
  );
}

export default CadastroTransacaoForm