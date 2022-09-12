import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './CadastroClienteForm.module.scss';

function CadastroClienteForm() {
  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Cadastrar Cliente</h3>
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
              label="Nome Completo"
            />
            <TextField
              required
              id="outlined-required"
              label="CPF"
            />
            <TextField
              required
              id="outlined-required"
              label="Email"
            />
            <TextField
              required
              id="outlined-password-input"
              label="Senha"
              type="password"
            />
            <TextField
              required
              id="outlined-required"
              label="Endereço"
            />
            <TextField
              required
              id="outlined-required"
              label="Estado"
            />
            <TextField
              required
              id="outlined-required"
              label="Cidade"
            />
            <TextField
              required
              id="outlined-required"
              label="Bairro"
            />
            <TextField
              id="outlined-required"
              label="Complemento"
              />
              <TextField
                required
                id="outlined-required"
                label="Telefone"
              />
            </div>
            <Button className={styles.cadastrarButton} variant="contained">Cadastrar</Button>
          </Box>
        </div>
        
    </>
  );
}

export default CadastroClienteForm