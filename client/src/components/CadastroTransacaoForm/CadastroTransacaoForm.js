import React, {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import styles from './CadastroTransacaoForm.module.scss';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

function CadastroTransacaoForm() {

  let navigate = useNavigate()

  const [transacao, setTransacao] = useState({
      valor:"",
      data:"",
      modo:"",
      recebedor:"",
      fornecedor:"",
  })

  const { valor, data, modo, recebedor, fornecedor } = transacao
  var contaId = sessionStorage.getItem('chaveConta')

  const handleChange = (e) => {
    setTransacao({...transacao, [e.target.name]: e.target.value})
    console.log(transacao.nome)
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.post("http://localhost:8081/transacoes", transacao)
    navigate(`/viewconta/${contaId}`)
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Cadastrar Transação</h3>
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
              label="Modo de Envio"
              name='modo'
              value={modo}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Data"
              name='data'
              value={data}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Recebedor"
              name='recebedor'
              value={recebedor}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-password-input"
              label="Fornecedor"
              name='fornecedor'
              value={fornecedor}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              className={styles.finalTextField}
              required
              id="outlined-required"
              label="Valor"
              name='valor'
              value={valor}
              onChange={(e) => handleChange(e)}
            />
            
            </div>
            <div className={styles.buttonContainer} >
              <button className={`btn btn-outline-primary ${styles.cadastrarButton}`} variant="contained" type='submit'>Cadastrar</button>
              <Link className="btn btn-outline-danger mx-2" to="/">
                Cancel
              </Link>
            </div>
          </Box>
          </form>
        </div>
        
    </>
  );
}

export default CadastroTransacaoForm