import React from 'react';
import styles from './DetalhamentoConta.module.scss';

function DetalhamentoConta() {
    return (
        <>
            <div className={styles.detalhamentoContainer}>
                <h3 className={styles.clienteTitulo}>Área da Conta</h3>
                <hr />
                <div className={styles.detalhamentoClienteContainer}>
                    <div className={styles.subInfo}>
                        <p>Tipo: Corrente</p>
                        <p>Saldo : 1500.00</p>
                        <p>Crédito: 500.90</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Primeiro Títular: 1</p>
                        <p>Segundo Títular: null</p>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoConta