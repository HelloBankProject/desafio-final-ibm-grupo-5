import * as React from 'react';
import styles from './EditarTransacaoForm.module.scss';
import axios from 'axios'
import { Link, useParams, useNavigate } from 'react-router-dom';

function EditarTransacaoForm() {
  let navigate = useNavigate()

  const {id} = useParams()
  
  const [transacao, setTransacao] = React.useState({
      id:"",
      valor:"",
      data:"",
      modo:"",
      recebedor:{
        id:"",
      },
      fornecedor:{
        id:"",
      }
  })

  const { valor, data, modo, recebedor, fornecedor } = transacao

  const handleChange = (e) => {
    const {name, value} = e.target
    setTransacao(prevState => ({
      ...prevState, [name]: value
    }))
    console.log(transacao)
  }

  React.useEffect(() => {
    loadTransacao()
  }, [])

  const onSubmit = async (e) => {
    e.preventDefault()
    console.log(transacao)
    await axios.put("http://localhost:8081/transacoes", transacao)
    navigate("/")
  }

  const loadTransacao = async () => {
    const result = await axios.get(`http://localhost:8081/transacoes/${id}`)
    setTransacao(result.data)
    console.log(result.data)
  }

  return (
    <>
        
        
        <div className={styles.cadastroFormContainer}>
          <div className={styles.tituloContainer}>
            <h3>Atualizar Transaçao</h3>
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
              name='modo'
              type="text"
              placeholder='Modo de Envio'
              value={modo}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='data'
              type="date"
              placeholder='Data'
              value={data}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='recebedor'
              type="text"
              placeholder='Recebedor'
              value={recebedor.id}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='fornecedor'
              type="text"
              placeholder='Fornecedor'
              value={fornecedor.id}
              onChange={(e) => handleChange(e)}
            />
            <input
              name='valor'
              type="number"
              placeholder='Valor'
              value={valor}
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

export default EditarTransacaoForm