import React, {useEffect} from 'react';
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
        const result = await axios.get(`http://localhost:8081/contas/${id}`);
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
                        <p>Saldo : R$ {Intl.NumberFormat('pt-BR').format(conta.saldo)}</p>
                       
                        {
                            conta.credito === null ? 
                                <p>Crédito: null</p>
                            :
                                <p>Crédito: R$ {Intl.NumberFormat('pt-BR').format(conta.credito)}</p>
                            
                        }
                    </div>
                    <div className={styles.subInfo}>
                        <p>Primeiro Titular: {`${conta.primeiroTitular.nome}`}</p>
                        <div>
                        {
                            conta.segundoTitular === null ? 
                                <p>Segundo Titular: null</p>
                            :
                                <p>Segundo Titular: {`${conta.segundoTitular.nome}`}</p>
                            
                        }
                        </div>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoConta