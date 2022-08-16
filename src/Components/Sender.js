import axios from 'axios';
import './HomePage.css';
import {  useEffect, useState } from 'react';
import { Receiver } from './Receiver';



export function Sender() {

    const [customer, setCustomer] = useState(); 
    const [customerId, setCustomerId]  = useState();
    const [error, setError] = useState(true);
    const [transferType, setTransferType] = useState();
    const [amount, setAmount] = useState();
    const [transferFee, setTransferFee] = useState();
    const [newBalance, setNewBalance] = useState();

    useEffect(
        ()=>{
            async function getCustomerDetais(){
                await axios.get("http://localhost:8081/customers/" + customerId)
                .then(
                    res => {
                        console.log(res.data)
                        setError(false);
                        setCustomer(res.data)
                        if(res.data.accountholdername.includes("HDFC")) setTransferType({
                            transfercode : "banks Transfer",
                            transferdescription : "Transfer to banks"
                        })
                        else{
                            setTransferType({
                                transfercode : "customers Transfer",
                                transferdescription : "Transfer to customers"
                            })
                        }
                    }
                )
                .catch(
                    err=>{
                        setError(true)
                        setCustomer(null)
                    }
                )
            }
            getCustomerDetais()
        },[customerId])

    const handleChange = (e) => {
        e.key = "Enter";
        console.log(e)
        setCustomerId(e.target.value);
        
    };

    const calAmount = e => {
        e.key = "Enter";
        setAmount(e.target.value);
        setTransferFee(amount*0.025);
        setNewBalance(customer.clearbalance - amount - transferFee);
    }



    return(
        <div className="container1">
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">

                    <div className="Custo">
                        <label className="cus" htmlFor="eid">Customer ID:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="in" type="text" name="cid" id="cid" onKeyPress={handleChange} placeholder="Customer ID:" required/>
                </div>
                <div className="col-lg-2"></div>
            </div>
            {/* {loading && <ProgressSpinner />} */}
            {error && <div className="errorDiv">{error}</div>}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="cus" htmlFor="eid">Account Holder Name:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    {
                        customer && <p className='in'>{customer.accountholdername }</p>
                    }
			    </div>

                <div className="col-lg-2"></div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Over Drafting:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                    {
                        customer && <p className='in'>{customer.overdraftflag ? "Yes" : "No"}</p>
                    }
                    </div>
                    <div className="col-lg-2"></div>
                </div>

                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">                        
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Clear Balance:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                    {
                        customer && <p className='in'>{customer.clearbalance}</p>
                    }
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Customer Address:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                    {
                        customer && <p className='in'>{customer.customeraddress}</p>
                    }
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Customer City:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        {
                            customer && <p className='in'>{customer.customercity}</p>
                        }
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">                        
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Customer Type:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                    {
                        customer && <p className='in'>{customer.customertype}</p>
                    }
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <Receiver />
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Transfer Type:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        {
                            transferType && <p className='in'>{transferType.transfercode}</p>
                        }
                    </div>
                    <div className="col-lg-2"></div>
                </div>
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">

                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Message Code:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <select className="in" id="cid">
                            <option default>Select an option</option>
                            <option value="CHQB">CHQB</option>
                            <option value="CORT">CORT</option>
                            <option value="HOLD">HOLD</option>
                            <option value="INTC">INTC</option>
                            <option value="PHOB">PHOB</option>
                            <option value="PHOI">PHOI</option>
                            <option value="PHON">PHON</option>
                            <option value="REPA">REPA</option>
                            <option value="SDVA">SDVA</option>
                        </select>
                    </div>
                    <div className="col-lg-2"></div>
                </div>

                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">

                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Amount:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <input className="in" type="text" name="cid" id="cid" onKeyPress={calAmount} placeholder="Amount" required/>
                    </div>
                    <div className="col-lg-2"></div>
                </div>

                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">Transfer Fee:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        {
                            amount && <p className='in'>{transferFee}</p>
                        }
                    </div>
                    <div className="col-lg-2"></div>
                </div>    
                
                <div className="row mt-5">
                    <div className="col-lg-2"></div>
                    <div className="col-lg-2">
                        <div className="Custo">
                            <label className="cus" htmlFor="eid">New Balance:</label>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        {
                            customer && customer.clearbalance && <p className='in'>{newBalance}</p>
                        }
                    </div>
                    <div className="col-lg-2"></div>
                </div>

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