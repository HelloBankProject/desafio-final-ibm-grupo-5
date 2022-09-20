import * as React from "react";
import styles from "./Footer.module.scss";

function Footer() {
  return (
    <div className="footer">
      <div className="footer-content">
        <div className="footer-content-logo"></div>
        <div className="footer-content-text">
          <div className="text-content">
            <p>Desenvolvido pelos integrates do grupo 5 - Gama Academy.</p>
          </div>
          <div className="content-group">
            <div>
              Andre Silva
              <img
                src="https://uploaddeimagens.com.br/imagens/yqZuOq0"
                alt="Foto pessoal do Andre Silva"
              />
              <a href="https://github.com/WhoisAndreoli">
                <img
                  src="https://img.icons8.com/material-outlined/24/000000/github.png"
                  alt="Ícone do github"
                />
              </a>
            </div>
            <div>
              Carlos Tavares
              <img
                src="https://avatars.githubusercontent.com/u/92460525?v=4"
                alt="Foto pessoal do Carlos Tavares"
              />
              <a href="https://github.com/carlostsa10">
                <img
                  src="https://img.icons8.com/material-outlined/24/000000/github.png"
                  alt="Ícone do github"
                />
              </a>
            </div>
            <div>
              Luis Eduardo
              <img
                src="https://avatars.githubusercontent.com/u/102531994?v=4"
                alt="Foto pessoal do Luis Eduardo"
              />
              <a href="https://github.com/TCLxEdu17">
                <img
                  src="https://img.icons8.com/material-outlined/24/000000/github.png"
                  alt="Ícone do github"
                />
              </a>
            </div>
            <div>
              Juan Carvalho
              <img
                src="https://avatars.githubusercontent.com/u/72449972?v=4"
                alt="Foto pessoal do Juan Carvalho"
              />
              <a href="https://github.com/jsuisjuan">
                <img
                  src="https://img.icons8.com/material-outlined/24/000000/github.png"
                  alt="Ícone do github"
                />
              </a>
            </div>
            <div>
              Maria Manuele
              <img
                src="https://avatars.githubusercontent.com/u/103943543?v=4"
                alt="Foto pessoal do Maria Manuele"
              />
              <a href="https://github.com/ManueleLima">
                <img
                  src="https://img.icons8.com/material-outlined/24/000000/github.png"
                  alt="Ícone do github"
                />
              </a>
            </div>
            <div>
              Evaldo Fonseca
              <img
                src="https://avatars.githubusercontent.com/u/86272926?v=4"
                alt="Foto pessoal do Evaldo Fonseca"
              />
              <a href="https://github.com/evaldovisk">
                <img
                  src="https://img.icons8.com/material-outlined/24/000000/github.png"
                  alt="Ícone do github"
                />
              </a>
            </div>
          </div>

          <div className="footer-links"></div>
        </div>
      </div>
    </div>
  );
}

export default Footer;
