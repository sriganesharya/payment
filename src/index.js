import App from "./App";
import React from "react";
import './index.css';
import  ReactDOM  from "react-dom/client";
//import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from "react-router-dom";

import "primereact/resources/themes/mdc-light-indigo/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>
);