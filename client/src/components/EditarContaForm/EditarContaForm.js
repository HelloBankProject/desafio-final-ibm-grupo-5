import * as React from 'react';
import styles from './EditarContaForm.module.scss';
import axios from 'axios'
import { Link, useParams, useNavigate } from 'react-router-dom';

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
    const {name, value} = e.target
    setConta(prevState => ({
      ...prevState, [name]: value
    }))
    console.log(conta)
  }

  React.useEffect(() => {
    loadConta()
  }, [])

  const onSubmit = async (e) => {
    e.preventDefault()
    console.log(conta)
    await axios.put("http://localhost:8080/contas", conta)
<<<<<<< HEAD
    navigate("/")
=======
    navigate(`/viewcliente/${id}`)
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
  }

  const loadConta = async () => {
    const result = await axios.get(`http://localhost:8080/contas/${id}`)
    setConta(result.data)
    console.log(result.data)
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Atualizar Conta</h3>
          </div>
          <form onSubmit={(e) => onSubmit(e)}>
          
          <div className={styles.cadastroForm}>
            
            <input
              name="id"
              type="hidden"
              className="form-control"
              placeholder="Tipo"
              value={id}
              onChange={(e) => handleChange(e)}
            />
             
              
            <input
              name='saldo'
              type="number"
              className="form-control"
              placeholder="Saldo"
              value={saldo}
              onChange={(e) => handleChange(e)}
            />
            

{
                conta.credito === null ?
                <input
                  name='credito'
                  type="text"
                  className="form-control"
                  placeholder="Crédito"
                  value="null"
                  onChange={(e) => handleChange(e)}
                />
                :
                <input
                  name='credito'
                  type="number"
                  className="form-control"
                  placeholder="Crédito"
                  value={credito}
                  onChange={(e) => handleChange(e)}
                />
              }

            <input
              name='primeiroTitular'
              type="number"
              className="form-control"
              placeholder="Primeiro Titular"
              
              value={primeiroTitular.id}
              onChange={(e) => handleChange(e)}
            />
            {
                conta.segundoTitular === null ?
                <input
                  name='segundoTitular'
                  type="text"
                  className="form-control"
                  placeholder="Segundo Titular"
                  value="null"
                  onChange={(e) => handleChange(e)}
                />
                :
                <input
                  name='segundoTitular'
                  type="number"
                  className="form-control"
                  placeholder="Segundo Titular"
                  value={segundoTitular.id}
                  onChange={(e) => handleChange(e)}
                />
              }
            <input
              name='tipo'
              type="text"
              className="form-control"
              placeholder="Tipo"
              
              value={tipo}
              onChange={(e) => handleChange(e)}
            />
          </div>

          <div className={styles.buttonContainer} >
            <button type="submit" className={`btn btn-outline-primary ${styles.cadastrarButton}`}>
              Atualizar
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </div>
            
        </form>
        </div>
        
    </>
  );
}

export default EditarContaForm