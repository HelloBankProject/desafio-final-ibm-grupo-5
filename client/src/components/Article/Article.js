import React from 'react'
import styles from './Article.module.scss'

function Article() {
    return (
        <>
            <div>
                <div className={styles.articleContainer}>
                    <div>
                        <h1>Bem-vindo ao HELLOBANK API!</h1>
                    </div>
                    <div>
                        <p>Um banco digital inteligente para suas transações</p>
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default Article