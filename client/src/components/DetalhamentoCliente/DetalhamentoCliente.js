import React, { useEffect} from 'react';
import axios from 'axios'
import styles from './DetalhamentoCliente.module.scss';
import { useParams } from 'react-router-dom';

function DetalhamentoCliente() {
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

    const { id } = useParams();
    sessionStorage.setItem('id', id)
    useEffect(() => {
        loadCliente();
    }, []);
    
      const loadCliente = async () => {
        const result = await axios.get(`http://localhost:8081/clientes/${id}`);
        setCliente(result.data);
    };

    return (
        <>
            <div className={styles.detalhamentoContainer}>
                <h3 className={styles.clienteTitulo}>Detalhamento do Cliente</h3>
                <hr />
                <div className={styles.detalhamentoClienteContainer}>
                    <div className={styles.subInfo}>
                        <p>Nome: {cliente.nome}</p>
                        <p>CPF: {cliente.cpf}</p>
                        <p>Email: {cliente.email}</p>
                        <p>Telefone: {cliente.telefone}</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Endereço: {cliente.endereco}</p>
                        <p>Estado: {cliente.estado}</p>
                        <p>Cidade: {cliente.cidade}</p>
                        <p>Bairro: {cliente.bairro}</p>
                    </div>
                    
                </div>
               
            </div>
        </>
    )
}

export default DetalhamentoCliente