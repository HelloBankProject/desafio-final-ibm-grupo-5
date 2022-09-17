import * as React from "react";
import Footer from "./Footer.module.scss";

export default function Footer() {
  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-content-logo"></div>
        <div className="footer-content-text">
          <p>Desenvolvido pelos integrates do grupo 5 - Gama Academy.</p>{" "}
          <p>
            - Andre Silva - Carlos Tavares - Luis Eduardo - Juan Carvalho -
            Evaldo Fonseca -
          </p>
          <div className="footer-links"></div>
        </div>
      </div>
    </footer>
  );
}
