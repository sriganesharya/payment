import axios from "axios"
import { useState, useEffect } from "react"
import "./CustTable.css"
import shortid from "shortid";
import { Link } from "react-router-dom"

export function CustTable() {
    const [customers, setCustomers] = useState([])
    //const [page, setPage] = useState(0)

    useEffect(() => {
        axios.get("http://localhost:8081/customers" )
            .then(res => {
                setCustomers(res.data)
            }).catch(err => {
                console.log("Error occured")
            })
    }, [])

    const deleteCustomer = (e,id) =>{
        axios.delete("http://localhost:8081/customers/" +id)
        .then(res=>{
            const modified = customers.filter(c => c.id !== id)
            setCustomers(modified)
        }).catch(err => {
            console.log("Couldn't delete the customer")
        })
    }

    const getRowTags = () => {
        const rowTags = customers.map(c => {
            return <tr key={shortid.generate()}>
                <td>{c.customerid}</td>
                <td>
                    <Link to={"/customers/" + c.customerid}>{c.accountholdername}</Link>
                </td>
                <td>{c.overdraftflag === false ? "no" : "yes"}</td>
                <td>{c.clearbalance}</td>
                <td>{c.customeraddress}</td>
                <td>{c.customercity}</td>
                <td>{c.customertype}</td>
                <td>
                    <Link to="" className="pageLink" style = {{"width": "30%"}}>Show</Link>
                    <br></br>
                    <Link to="" className="pageLink" onClick={(e) =>deleteCustomer(e,c.customerid)}>Delete</Link>
                </td>
            </tr>
        })

        return rowTags
    }

    return (
        <div>
            <br></br>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>OverDraft</th>
                        <th>Balance</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Type</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    { getRowTags() }
                </tbody>
            </table>
        </div>
    );

}