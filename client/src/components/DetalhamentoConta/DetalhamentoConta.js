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
<<<<<<< HEAD
                        <p>Saldo : {conta.saldo}</p>
=======
                        <p>Saldo : R$ {Intl.NumberFormat('pt-BR').format(conta.saldo)}</p>
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                       
                        {
                            conta.credito === null ? 
                                <p>Crédito: null</p>
                            :
<<<<<<< HEAD
                                <p>Crédito: {conta.credito}</p>
=======
                                <p>Crédito: R$ {Intl.NumberFormat('pt-BR').format(conta.credito)}</p>
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                            
                        }
                    </div>
                    <div className={styles.subInfo}>
<<<<<<< HEAD
                        <p>Primeiro Títular: {`${conta.primeiroTitular.nome}`}</p>
                        <div>
                        {
                            conta.segundoTitular === null ? 
                                <p>Segundo Títular: null</p>
                            :
                                <p>Segundo Títular: {`${conta.segundoTitular.nome}`}</p>
=======
                        <p>Primeiro Titular: {`${conta.primeiroTitular.nome}`}</p>
                        <div>
                        {
                            conta.segundoTitular === null ? 
                                <p>Segundo Titular: null</p>
                            :
                                <p>Segundo Titular: {`${conta.segundoTitular.nome}`}</p>
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                            
                        }
                        </div>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoConta