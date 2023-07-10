import React from "react";

function InputField(props) {
    return (
        <div>
            <input
                class="inputField"
                style={{ paddingLeft: '15px', paddingRight: '15px' }}
                type={props.inputType}
                placeholder={props.holder}
                value={props.value}
                onChange={props.onChange}
            />
        </div>
    );
}

InputField.defaultProps = {
    inputType: "text",
    holder: ""
}

export default InputField;