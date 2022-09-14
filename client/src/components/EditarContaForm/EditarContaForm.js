import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './EditarContaForm.module.scss';

function EditarContaForm() {
  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Atualizar Conta</h3>
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
              label="Saldo"
            />
            <TextField
              required
              id="outlined-required"
              label="Crédito"
            />
            <TextField
              required
              id="outlined-required"
              label="Primeiro Títular"
            />
            <TextField
              required
              id="outlined-password-input"
              label="Segundo Títular"
            />
            <TextField
              required
              id="outlined-required"
              label="Tipo"
            />
            </div>
            <Button className={styles.cadastrarButton} variant="contained">Atualizar</Button>
          </Box>
        </div>
        
    </>
  );
}

export default EditarContaForm