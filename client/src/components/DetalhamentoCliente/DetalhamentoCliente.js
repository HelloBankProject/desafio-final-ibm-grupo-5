import React from 'react';
import styles from './DetalhamentoCliente.module.scss';

function DetalhamentoCliente() {
    return (
        <>
            <div className={styles.detalhamentoContainer}>
                <h3 className={styles.clienteTitulo}>Área do Cliente</h3>
                <hr />
                <div className={styles.detalhamentoClienteContainer}>
                    <div className={styles.subInfo}>
                        <p>Nome: Juan Carvalho</p>
                        <p>CPF: 174.785.077-28</p>
                        <p>Email: juanc.s.delima@gmail.com</p>
                        <p>Senha: vevoisvsf</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Endereço: Rua José Saly, 185</p>
                        <p>Estado: Rio de Janeiro</p>
                        <p>Cidade: São Gonçalo</p>
                        <p>Bairro: Porto Novo</p>
                    </div>
                    <div className={styles.subInfo}>
                        <p>Complemento: Sobrado</p>
                        <p>Telefone: 21989447785</p>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default DetalhamentoCliente