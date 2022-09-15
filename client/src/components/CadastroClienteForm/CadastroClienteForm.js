import React, {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import styles from './CadastroClienteForm.module.scss';
import { Link, useNavigate } from 'react-router-dom';

function CadastroClienteForm() {

  let navigate = useNavigate()

  const [cliente, setCliente] = useState({
      nome:"",
      cpf:"",
      email:"",
      senha:"",
      endereco:"",
      estado:"",
      cidade:"",
      bairro:"",
      complemento:"",
      telefone:"",
  })

  const { nome,cpf,email,senha,endereco,estado,cidade,bairro,complemento,telefone} = cliente

  const handleChange = (e) => {
    setCliente({...cliente, [e.target.name]: e.target.value})
    console.log(cliente.nome)
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.post("http://localhost:8080/clientes", cliente)
    navigate("/")
  }


  return (
    <>

        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Cadastrar Cliente</h3>
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
              label="Nome Completo"
              name='nome'
              value={nome}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="CPF"
              name='cpf'
              value={cpf}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Email"
              name='email'
              value={email}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-password-input"
              label="Senha"
              type="password"
              name='senha'
              value={senha}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Endereço"
              name='endereco'
              value={endereco}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Estado"
              name='estado'
              value={estado}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Cidade"
              name='cidade'
              value={cidade}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              required
              id="outlined-required"
              label="Bairro"
              name='bairro'
              value={bairro}
              onChange={(e) => handleChange(e)}
            />
            <TextField
              id="outlined-required"
              label="Complemento"
              name='complemento'
              value={complemento}
              onChange={(e) => handleChange(e)}
              />
              <TextField
                required
                id="outlined-required"
                label="Telefone"
                name='telefone'
                value={telefone}
                onChange={(e) => handleChange(e)}
              />
            </div>
            <div className={styles.buttonContainer}>
              <button className={`btn btn-outline-primary ${styles.cadastrarButton}`} variant="contained" type='submit' >Cadastrar</button>
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

export default CadastroClienteForm