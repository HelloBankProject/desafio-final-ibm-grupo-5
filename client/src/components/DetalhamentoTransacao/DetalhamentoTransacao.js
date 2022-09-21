import React, {useEffect} from 'react';
import axios from 'axios'
import styles from './DetalhamentoTransacao.module.scss';
import { useParams } from 'react-router-dom';

function DetalhamentoTransacao() {
    const [transacao, setTransacao] = React.useState({
        valor:"",
        data:"",
        modo:"",
        recebedor:"",
        fornecedor:"",
    })

    const { id } = useParams();

    useEffect(() => {
        loadTransacao();
    }, []);
    
    const loadTransacao = async () => {
        const result = await axios.get(`http://localhost:8080/transacoes/${id}`);
        setTransacao(result.data);
    };

    return (
        <>
            <div className={styles.detalhamentoContainer}>
                <h3 className={styles.clienteTitulo}>Detalhamento da Transação</h3>
                <hr />
                <div className={styles.detalhamentoClienteContainer}>
                    <div className={styles.subInfo}>
                        <p>Modo de Envio: {transacao.modo}</p>
<<<<<<< HEAD
                        <p>Recebedor: {transacao.recebedor.id}</p>
                        <p>Valor: {transacao.valor}</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Data: {transacao.data}</p>
                        <p>Fornecedor: {transacao.fornecedor.id}</p>
=======
                        <p>Recebedor: {transacao.recebedor}</p>
                        <p>Valor: R$ {Intl.NumberFormat('pt-BR').format(transacao.valor)}</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Data: {transacao.data}</p>
                        <p>Fornecedor: {transacao.fornecedor}</p>
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoTransacao