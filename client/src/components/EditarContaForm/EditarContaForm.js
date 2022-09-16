import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './EditarContaForm.module.scss';
import axios from 'axios'
import { useParams, useNavigate } from 'react-router-dom';

function EditarContaForm() {
  let navigate = useNavigate()

  const {id} = useParams()

  const [conta, setConta] = React.useState({
      id:"",
      tipo:"",
      saldo:"",
      credito:"",
      primeiroTitular:{
        id:"",
      },
      segundoTitular:{
        id:"",
      },
  })

  const { tipo, saldo, credito, primeiroTitular, segundoTitular } = conta

  const handleChange = (e) => {
    setConta({...conta, [e.target.name]: e.target.value})
    console.log(conta.nome)
  }

  React.useEffect(() => {
    loadConta()
  }, [])

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.put("http://localhost:8080/contas/${id}", conta)
    navigate("/")
  }

  const loadConta = async () => {
    const result = await axios.get(`http://localhost:8080/contas/${id}`)
    setConta(result.data)
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Atualizar Conta</h3>
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
              value={primeiroTitular.id}
              onChange={(e) => handleChange(e)}
            />
            
              {
                conta.segundoTitular === null ?
                <TextField
                  required
                  id="outlined-required"
                  label="Segundo Títular"
                  name='segundoTitular'
                  value="null"
                  onChange={(e) => handleChange(e)}
                />
                :
                <TextField
                  required
                  id="outlined-required"
                  label="Segundo Títular"
                  name='segundoTitular'
                  value={segundoTitular.id}
                  onChange={(e) => handleChange(e)}
                />
              }
              
             
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
              <Button className={styles.cadastrarButton} variant="contained" type='submit'>Atualizar</Button>
            </div>
            
          </Box>
          </form>
        </div>
        
    </>
  );
}

export default EditarContaForm