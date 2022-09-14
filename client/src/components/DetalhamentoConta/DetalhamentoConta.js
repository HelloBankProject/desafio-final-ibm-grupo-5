import React from 'react';
import axios from 'axios'
import styles from './DetalhamentoConta.module.scss';
import { useParams } from 'react-router-dom';

function DetalhamentoConta() {
    const [conta, setConta] = React.useState({
        tipo:"",
        saldo:"",
        credito:"",
        primeiroTitular:"",
        segundoTitular:"",
    })

    const { id } = useParams();

    useEffect(() => {
        loadConta();
    }, []);
    
      const loadConta = async () => {
        const result = await axios.get(`http://localhost:8080/contas/${id}`);
        setConta(result.data);
    };

    return (
        <>
            <div className={styles.detalhamentoContainer}>
                <h3 className={styles.clienteTitulo}>Detalhamento da Conta</h3>
                <hr />
                <div className={styles.detalhamentoClienteContainer}>
                    <div className={styles.subInfo}>
                        <p>Tipo: {conta.tipo}</p>
                        <p>Saldo : {conta.saldo}</p>
                        <p>Crédito: {conta.credito}</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Primeiro Títular: {conta.primeiroTitular.id}</p>
                        <p>Segundo Títular: {conta.segundoTitular.id}</p>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoConta