import axios from "axios"
import { Panel } from "primereact/panel"
import { useParams } from "react-router";
import { useState, useEffect } from "react";
import { ProgressSpinner } from "primereact/progressspinner";

export function CustDetails(){
    const [customer, setCustomer] = useState(null);
    const params = useParams();
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(true)

    useEffect(()=>{
        axios.get("http://localhost:8081/customers/" + params.id )
            .then(res => {
                setLoading(false)
                setError(false)
                setCustomer(res.data)
            }).catch(err => {
                setLoading(false)
                setError("Couldn't fetch customer : " + err)
            })
    }, [params])
    return(
        <div>
            { customer && 
                <Panel header={"Customer: "+customer.customerid} style = {{"width": "50%"}}>
                    <p>Name : {customer.accountholdername}</p>
                    <p>OverDraft : {customer.overdraftflag === false ? "no" : "yes"}</p>
                    <p>Balance : {customer.clearbalance}</p>
                    <p>Address : {customer.customeraddress}</p>
                    <p>City : {customer.customercity}</p>
                    <p>Type : {customer.customertype}</p>
                </Panel>
            }
            {loading && <ProgressSpinner />}
            {error && <div className="errorDiv">{error}</div>}
        </div>
        
    );
}