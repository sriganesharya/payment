import axios from 'axios';
//import { ProgressSpinner } from "primereact/progressspinner";
import { useEffect, useState } from "react";
import './HomePage.css'


export function Receiver() {

    const [error, setError] = useState(true);
    const [bic, setBic] = useState();
    const [bank, setBank] = useState();
    const [name, setName] = useState();
    const [BicNotFound, setBicNotFound] = useState(false);
    const [checkName, setCheckName] = useState(false);
    const [blocked,isBlocked]=useState(false);

    const handleChange = (e) => {
        e.key = "Enter";
        setBic(e.target.value);
    };

    useEffect(()=>{
        async function getBankDetais(){
            await axios.get("http://localhost:8081/bank/" +  bic)
            .then(res => {
                setError(false)
                setBank(res.data)
                setBicNotFound(false)
            }).catch(err => {
                console.log(err);
                setBic(null);
                setBicNotFound(true);
                setError("Couldn't fetch bank: " + err)
            });
        }
        getBankDetais()
}, [bic])
useEffect(
    ()=>{
        async function checkUser(){
            await axios.get("http://localhost:8081/accountholdername/"+name)
            .then(
                res=>{
                    //console.log(res.data)
                    if(res.data==="Transaction Blocked")
                        isBlocked(true)
                    else
                        isBlocked(false);    
                }
            )
            .catch(err=>{
                console.log(err)
                isBlocked(false);
            })
        }
        checkUser()
    },[name])
    async function searchName (e){
        e.key = "Enter";
        await setName(e.target.value);
        //alert("Transaction Blocked. Please enter another name")
        if(!blocked) 
        {
            setCheckName(true);
            setError("Transaction Blocked. Please enter another name");
        }
        //console.log(blocked)
    }
    // const handleClick = ()=>{
    //     if(blocked)
    //         alert("User Blocked")
    // }
    return(
        <div>
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="cus" htmlFor="eid">Receiver BIC:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="" type="text" name="bic" id="bic" onKeyPress={handleChange} placeholder="Receiver BIC" required/>
                </div>
                <div className="col-lg-2"></div>
            </div>
            {/* {loading && <ProgressSpinner />} */}
            {error && BicNotFound && <div classNameName="errorDiv">{error}</div>}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="cus" htmlFor="eid">Institution Name:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    {
                        bic && <p className='in'>{bank.bankname}</p>
                    }
                </div>
                <div className="col-lg-2"></div>
            </div>
            {/* {error &&  nameFound && <div classNameName="errorDiv">{error}</div>} */}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="cus" htmlFor="eid" >Account Holder Name:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="in" type="text" name="ahname" id="ahname" onKeyPress={searchName} placeholder="Account Holder Name" />
                </div>
                {/* <div>
                    <br />
                </div>
                <div >
                    <button type='button' onClick={handleClick}>Check</button>
                </div> */}
                <div className="col-lg-2"></div>
            </div>
            {error && checkName && <div classNameName="errorDiv">{error}</div>}
            <div className="row mt-5">
                <div className="col-lg-2"></div>
                <div className="col-lg-2">
                    <div className="Custo">
                        <label className="cus" htmlFor="eid">Account Holder Number:</label>
                    </div>
                </div>
                <div className="col-lg-4">
                    <input className="in" type="text" name="ahnum" id="ahnum" placeholder="Account Holder Number" />
                </div>
                <div className="col-lg-2"></div>
            </div>
        </div>
    );
}