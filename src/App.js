import './App.css';
import React from "react";
// import { Button } from 'primereact/button';
//import { Routes, Route } from "react-router-dom";
import { HomePage } from './Components/HomePage';
//import { Navbar } from './Navbar';

const App = () =>{

  return(
    <div className = "App">
      <HomePage />
      
      {/* <Routes>
        <Route path="/home" element={<HomePage />}/>
        <Route path="/about" element={<AboutPage />} />
        <Route path="/customers" element={<CustomerPage />} />
        <Route path="/customers/:id" element={<CustDetails />} />
      </Routes> */}
    </div>
  );

}

export default App;