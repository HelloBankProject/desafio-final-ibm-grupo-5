import React from 'react';
import styles from './DetalhamentoTransacao.module.scss';

function DetalhamentoTransacao() {
    return (
        <>
            <div className={styles.detalhamentoContainer}>
                <h3 className={styles.clienteTitulo}>Detalhamento da Transação</h3>
                <hr />
                <div className={styles.detalhamentoClienteContainer}>
                    <div className={styles.subInfo}>
                        <p>Modo de Envio: pix</p>
                        <p>Recebedor: Flavio Silva</p>
                        <p>Valor: 230.90</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Data: 13/09/2022</p>
                        <p>Fornecedor: Juan Carvalho</p>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoTransacao