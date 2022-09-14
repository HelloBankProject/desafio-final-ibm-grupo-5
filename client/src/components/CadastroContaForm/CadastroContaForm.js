import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './CadastroContaForm.module.scss';
import { TipsAndUpdatesTwoTone } from '@mui/icons-material';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function CadastroContaForm() {

  let navigate = useNavigate()

  const [conta, setConta] = React.useState({
      tipo:"",
      saldo:"",
      credito:"",
      primeiroTitular:"",
      segundoTitular:"",
  })

  const { tipo, saldo, credito, primeiroTitular, segundoTitular } = conta

  const handleChange = (e) => {
    setConta({...conta, [e.target.name]: e.target.value})
    console.log(conta.nome)
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.post("http://localhost:8080/contas", conta)
    navigate("/")
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Cadastrar Conta</h3>
          </div>
          <form onSubmit={(e) => onSubmit(e)}>
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
              name='saldo'
              value={saldo}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Crédito"
              name='credito'
              value={credito}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Primeiro Títular"
              name='primeiroTitular'
              value={primeiroTitular}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-password-input"
              label="Segundo Títular"
              name='segundoTitular'
              value={segundoTitular}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Tipo"
              name='tipo'
              value={tipo}
              onChange={(e) => handleChange(e)}
            />
            </div>
            <div className={styles.buttonContainer} >
              <Button className={styles.cadastrarButton} variant="contained" type='submit'>Cadastrar</Button>
            </div>
            
          </Box>
          </form>
        </div>
        
    </>
  );
}

export default CadastroContaForm