import React, {useState, useEffect} from 'react';
import styles from './EditarClienteForm.module.scss';
import axios from 'axios'
import { Link, useParams, useNavigate } from 'react-router-dom';

function EditarClienteForm() {
  let navigate = useNavigate()

  const {id} = useParams()

  const [cliente, setCliente] = useState({
      id:"",
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
<<<<<<< HEAD
    const {name, value} = e.target
    setCliente(prevState => ({
      ...prevState, [name]: value
    }))
=======
    setCliente({...cliente, [e.target.name]: e.target.value})
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
    console.log(cliente)
  }

  useEffect(() => {
    loadCliente()
  }, [])

  const onSubmit = async (e) => {
    e.preventDefault()
    console.log(cliente)
    await axios.put("http://localhost:8080/clientes", cliente)
    navigate("/")
  }

  const loadCliente = async () => {
    const result = await axios.get(`http://localhost:8080/clientes/${id}`)
    setCliente(result.data)
    console.log(result.data)
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Atualizar Cliente</h3>
          </div>
          <form onSubmit={(e) => onSubmit(e)}>

          <div className={styles.cadastroForm}>

          <input
              name="id"
              type="hidden"
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Tipo"
              value={id}
              onChange={(e) => handleChange(e)}
            />

            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Nome Completo"
              name='nome'
              value={nome}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="CPF"
              name='cpf'
              value={cpf}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Email"
              name='email'
              value={email}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"password"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Senha"
              name='senha'
              value={senha}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Endereço"
              name='endereco'
              value={endereco}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Estado"
              name='estado'
              value={estado}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Cidade"
              name='cidade'
              value={cidade}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Bairro"
              name='bairro'
              value={bairro}
              onChange={(e) => handleChange(e)}
            />
            <input
              type={"text"}
<<<<<<< HEAD
              className="form-control"
=======
              className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
              placeholder="Complemento"
              name='complemento'
              value={complemento}
              onChange={(e) => handleChange(e)}
              />
              <input
                type={"text"}
<<<<<<< HEAD
                className="form-control"
=======
                className={`form-control ${styles.contenteField}`}
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                placeholder="Telefone"
                name='telefone'
                value={telefone}
                onChange={(e) => handleChange(e)}
              />
            </div>

            <div className={styles.buttonContainer}>
<<<<<<< HEAD
              <button type="submit" className={`btn btn-outline-primary ${styles.cadastrarButton}`}  >
                Atualizar
              </button>
              <Link className="btn btn-outline-danger mx-2" to="/">
=======
              <button type="submit" className={`btn btn-primary ${styles.cadastrarButton}`}  >
                Atualizar
              </button>
              <Link className={`btn btn-danger mx-2 ${styles.cadastrarButtonCancelar}`} to="/">
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                Cancel
              </Link>
            </div>

        </form>
        </div>
        
    </>
  );
}

export default EditarClienteForm