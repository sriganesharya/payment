import Select from "react-select/dist/declarations/src/Select";


export function Transaction(props) {

    const [transferType] = props;
    

    return(
        <div>
            <Select options={transferOptions}/>
        </div>
    );
}