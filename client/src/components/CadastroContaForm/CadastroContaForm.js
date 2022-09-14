import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './CadastroContaForm.module.scss';

function CadastroContaForm() {
  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Cadastrar Conta</h3>
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
            <div className={styles.buttonContainer} >
              <Button className={styles.cadastrarButton} variant="contained">Cadastrar</Button>
            </div>
            
          </Box>
        </div>
        
    </>
  );
}

export default CadastroContaForm