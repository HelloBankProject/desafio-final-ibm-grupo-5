import * as React from "react";
import styles from "./Footer.module.scss";

function Footer() {
  return (
    <div className="footer">
      <div className="footer-content">
        <div className="footer-content-logo"></div>
        <div className={styles.footerContainer}>
          <div className={styles.textContainer}>
            <h3 className={styles.textContent}>Desenvolvido pelos Jovens IBMers - Gama Academy</h3>
          </div>
          <div className={styles.contentGroup}>
            <div className={styles.grupoContainer}>
              <img
                src="https://avatars.githubusercontent.com/u/78062867?v=4"
                alt="Foto pessoal do Andre Silva"
                className={styles.foto}
              />
              <h3 className={styles.littleTitle}>Andre Silva</h3>
              <div>
              <a href="https://github.com/WhoisAndreoli">
                <img
                  src="https://img.icons8.com/ios-glyphs/40/FFFFFF/github.png"
                  alt="Ícone do github"
                />
              </a>
              <a href="https://www.linkedin.com/in/andre-silva-de-oliveira-a59a25175/">
              <img src="https://img.icons8.com/sf-ultralight-filled/50/FFFFFF/linkedin.png"
                alt="Ícone do linkedin"
              />
              </a>
              
              </div>
            </div>
            <div className={styles.grupoContainer}>
              <img
                src="https://avatars.githubusercontent.com/u/92460525?v=4"
                alt="Foto pessoal do Carlos Tavares"
                className={styles.foto}
              />
              <h3 className={styles.littleTitle}>Carlos Tavares</h3>
              <div>
              <a href="https://github.com/carlostsa10">
                <img
                  src="https://img.icons8.com/ios-glyphs/40/FFFFFF/github.png"
                  alt="Ícone do github"
                />
              </a>
              <a href="https://www.linkedin.com/in/carlostsa/">
                <img src="https://img.icons8.com/sf-ultralight-filled/50/FFFFFF/linkedin.png"
                    alt="Ícone do linkedin"
                />
              </a>
              </div>
              
            </div>
            <div className={styles.grupoContainer}>
              <img
                src="https://avatars.githubusercontent.com/u/102531994?v=4"
                alt="Foto pessoal do Luis Eduardo"
                className={styles.foto}
              />
              <h3 className={styles.littleTitle}>Luis Eduardo</h3>
              <div>
              <a href="https://github.com/TCLxEdu17">
                <img
                  src="https://img.icons8.com/ios-glyphs/40/FFFFFF/github.png"
                  alt="Ícone do github"
                />
              </a>
              <a href="https://www.linkedin.com/in/luiseduardo193/">
                <img src="https://img.icons8.com/sf-ultralight-filled/50/FFFFFF/linkedin.png"
                    alt="Ícone do linkedin"
                />
              </a>
              </div>
              
            </div>
            <div className={styles.grupoContainer}>
              <img
                src="https://avatars.githubusercontent.com/u/72449972?v=4"
                alt="Foto pessoal do Juan Carvalho"
                className={styles.foto}
              />
                <h3 className={styles.littleTitle}>Juan Carvalho</h3>
                <div>
                <a href="https://github.com/jsuisjuan">
                    <img
                        src="https://img.icons8.com/ios-glyphs/40/FFFFFF/github.png"
                        alt="Ícone do github"
                    />
                </a>
                <a href="https://www.linkedin.com/in/juan-carvalho-01310023b/">
                    <img src="https://img.icons8.com/sf-ultralight-filled/50/FFFFFF/linkedin.png"
                        alt="Ícone do linkedin"
                    />
                </a>
                </div>
              
            </div>
            <div className={styles.grupoContainer}>
              <img
                src="https://avatars.githubusercontent.com/u/103943543?v=4"
                alt="Foto pessoal do Maria Manuele"
                className={styles.foto}
              />
              <h3 className={styles.littleTitle}>Maria Manuele</h3>
              <div>
                <a href="https://github.com/ManueleLima">
                <img
                  src="https://img.icons8.com/ios-glyphs/40/FFFFFF/github.png"
                  alt="Ícone do github"
                />
              </a>
              <a href="https://www.linkedin.com/in/manuele-lima-6a954816b/">
                    <img src="https://img.icons8.com/sf-ultralight-filled/50/FFFFFF/linkedin.png"
                        alt="Ícone do linkedin"
                    />
                </a>
              </div>
        
            </div>
            <div className={styles.grupoContainer}>
              <img
                src="https://avatars.githubusercontent.com/u/86272926?v=4"
                alt="Foto pessoal do Evaldo Fonseca"
                className={styles.foto}
              />
              <h3 className={styles.littleTitle}>Evaldo Fonseca</h3>
              <div>
                <a href="https://github.com/evaldovisk">
                    <img
                        src="https://img.icons8.com/ios-glyphs/40/FFFFFF/github.png"
                        alt="Ícone do github"
                    />
                </a>
                <a href="https://www.linkedin.com/in/evaldofs/">
                    <img src="https://img.icons8.com/sf-ultralight-filled/50/FFFFFF/linkedin.png"
                        alt="Ícone do linkedin"
                    />
                </a>
              </div>
              
            </div>
          </div>

          <div className="footer-links"></div>
        </div>
      </div>
    </div>
  );
}

export default Footer;