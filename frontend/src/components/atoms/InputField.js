import React, { useState } from "react";

function InputField({inputType, holder}) {
    const [inputValue, setInputValue] = useState("");

    return (
        <div>
            <input 
                class="inputField"
                style={{paddingLeft: '15px', paddingRight : '15px'}}
                type={inputType}
                placeholder={holder}
                value={inputValue}
                onChange={(e)=> setInputValue(e.target.value)}
                />
        </div>
    );
}

InputField.defaultProps = {
    inputType: "text",
    holder: ""
}

export default InputField;