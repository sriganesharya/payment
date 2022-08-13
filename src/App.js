import './App.css';
import React from "react";
// import { Button } from 'primereact/button';
import { Routes, Route } from "react-router-dom";
import { HomePage } from './pages/HomePage';
import { AboutPage } from './pages/AboutPage';
import { CustomerPage } from './pages/CustomerPage';
import { Navbar } from './Navbar';
// import { CustTable } from './Components/customers/CustTable';
import { CustDetails } from './Components/customers/CustDetails';

const App = () =>{

  return(
    <div className = "App">
      <Navbar />
      <h3>DBS React Training</h3>
      <Routes>
        <Route path="/home" element={<HomePage />}/>
        <Route path="/about" element={<AboutPage />} />
        <Route path="/customers" element={<CustomerPage />} />
        <Route path="/customers/:id" element={<CustDetails />} />
      </Routes>
    </div>
  );

}

export default App;