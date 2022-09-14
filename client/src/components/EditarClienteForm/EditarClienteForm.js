import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import styles from './EditarClienteForm.module.scss';
import axios from 'axios'
import { useParams } from 'react-router-dom';

function EditarClienteForm() {
  let navigate = React.useNavigate()

  const {id} = useParams()

  const [cliente, setCliente] = React.useState({
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

  React.useEffect(() => {
    loadCliente()
  }, [])

  const onSubmit = async (e) => {
    e.preventDefault()
    await axios.put(`http://localhost:8080/clientes/${id}`, cliente)
    navigate("/")
  }

  const loadCliente = async () => {
    const result = await axios.get(`http://localhost:8080/clientes/${id}`)
    setCliente(result.data)
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Atualizar Cliente</h3>
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
              <Button className={styles.cadastrarButton} variant="contained" type='submit' >Atualizar</Button>
            </div>
            
          </Box>
          </form>
        </div>
        
    </>
  );
}

export default EditarClienteForm