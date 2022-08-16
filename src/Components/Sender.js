import axios from 'axios';
import './HomePage.css';
import {  useEffect, useState } from 'react';
import { Receiver } from './Receiver';
import Select from "react-select/dist/declarations/src/Select";


export function Sender() {

    const[customer, setCustomer] = useState(); 
    const [customerId, setCustomerId]  = useState();
    const [error, setError] = useState(true);
    const [name, setName] = useState();
    const [od, setOd] = useState();
    const [balance, setBalance] = useState();
    const [city, setCity] = useState();
    const [address, setAddress] = useState();
    const [type, setType] = useState();
    const [transferType, setTransferType] = useState();
    const transferOptions = [
        { value:transferType, label: transferType }
      ]
    const messageOptions = [
        {value : 'CHQB', label : 'CHBQ'},
        {value : 'CORT', label : 'CORT'},
        {value : 'HOLD', label : 'HOLD'},
        {value : 'INTC', label : 'INTC'},
        {value : 'PHOB', label : 'PHOB'},
        {value : 'PHOI', label : 'PHOI'},
        {value : 'PHON', label : 'PHON'},
        {value : 'REPA', label : 'REPA'},
        {value : 'SDVA', label : 'CHBQ'}
    ]


    const handleChange = (e) => {

        setCustomerId(e.target.value);
        
        axios.get("http://localhost:8081/customers/" + customerId )
            .then(res => {
                setError(false)
                setCustomer(res.data)
                setName(customer.accountholdername);
                setOd(customer.overdraftflag);
                setBalance(customer.clearbalance);
                setAddress(customer.customeraddress);
                setCity(customer.customercity);
                setType(customer.customercity);
                
            }).catch(err => {
                setCustomer(null);
                setError("Couldn't fetch customer : " + err)
            })

        if(name.length()!==0 && name.contains('HDFC'))
        {
            setTransferType("Banks transfer");
        }
        else{
            setTransferType("Customers transfer");
        }
    };


    return(
        <div className="container1">
            
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">

                    <div className="Custo">
                        <label className="" htmlFor="eid">Customer ID:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="cid" id="cid" onKeyUp={handleChange} placeholder="Customer ID:" required/>
                </div>
                <div className="col-lg-2"></div>
            </div>
            {/* {loading && <ProgressSpinner />} */}
            {error && <div className="errorDiv">{error}</div>}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="" htmlFor="eid">Account Holder Name:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="Ah" id="Ah" value={name} placeholder="Account Holder Name:" disabled />
			    </div>

                <div className="col-lg-2"></div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="" htmlFor="eid">Over Drafting:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <input className="" type="text" name="Od" id="Od" value={od} placeholder="Over Drafting" disabled />
                    </div>
                    <div className="col-lg-2"></div>
                </div>

                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">                        
                        <div className="Custo">
                            <label className="" htmlFor="eid">Clear Balance:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <input className="" type="text" name="Cb" id="Cb" value={balance} placeholder="Clear Balance" disabled />
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="" htmlFor="eid">Customer Address:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <input className="" type="text" name="Ca" id="Ca" value={address} placeholder="Customer Address" disabled />
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="" htmlFor="eid">Customer City:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <input className="" type="text" name="Cc" id="Cc" value={city} placeholder="Customer City" disabled />
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">                        
                        <div className="Custo">
                            <label className="" htmlFor="eid">Customer Type:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <input className="" type="text" name="Ct" id="Ct" value={type} placeholder="Customer Type" disabled />
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <Receiver />


                <div className="row mt-5 text-center">
                    <div className="col-lg-4"></div>
                    <div className="col-lg-4">
                        <button className="btn btn-success" type="button" >Submit</button>
                    </div>
                </div>
        </div>
		<div className="col-lg-4"></div>
        
        
    </div>
        
    );
}