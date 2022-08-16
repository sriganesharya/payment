import axios from 'axios';
//import { ProgressSpinner } from "primereact/progressspinner";
import { useEffect, useState } from "react";
import './HomePage.css'


export function Receiver() {

    const [error, setError] = useState(true);
    const [bic, setBic] = useState();
    const [bank, setBank] = useState();
    const [bankName, setBankName] = useState();
    const [BicNotFound, setBicNotFound] = useState(false);
    const [checkName, setCheckName] = useState(false);


    const handleChange = (e) => {
        setBic(e.target.value);
    };

    useEffect(()=>{
            axios.get("http://localhost:8081/bank/" +  bic)
            .then(res => {
                setError(false)
                setBank(res.data)
                setBicNotFound(false)
                setBankName(bank.bankname);
            }).catch(err => {
                setBic(null);
                setBicNotFound(true);
                setError("Couldn't fetch bank: " + err)
            });
        }
        , [bic])

    const searchName = e =>{
        fetch("/assets/text-files/sdnlist.txt")
        .then(r => r.text())
        .then(text => {
            if(text.indexOf(e.target.value)>-1) {
                setCheckName(true);
                setError("The given name is blocked for transactions. Please enter another name");
            }
        });
    }

    return(
        <div>
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="" htmlFor="eid">Receiver BIC:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="bic" id="bic" onKeyUp={handleChange} placeholder="Receiver BIC" required/>
                </div>
                <div className="col-lg-2"></div>
            </div>
            {/* {loading && <ProgressSpinner />} */}
            {error && BicNotFound && <div classNameName="errorDiv">{error}</div>}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="" htmlFor="eid">Institution Name:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="instname" id="instname" value={bankName} placeholder="Institution Name" disabled />
                </div>
                <div className="col-lg-2"></div>
            </div>
            {/* {error &&  nameFound && <div classNameName="errorDiv">{error}</div>} */}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="" htmlFor="eid" >Account Holder Name:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="ahname" id="ahname" onChange={searchName} placeholder="Account Holder Name" />
                </div>
                <div className="col-lg-2"></div>
            </div>
            {error && checkName && <div classNameName="errorDiv">{error}</div>}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="" htmlFor="eid">Account Holder Number:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="ahnum" id="ahnum" placeholder="Account Holder Number" />
                </div>
                <div className="col-lg-2"></div>
            </div>
        </div>
    );
}