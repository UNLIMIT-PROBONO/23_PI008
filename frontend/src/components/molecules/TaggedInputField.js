import React, { useState } from 'react';
import InputField from '../atoms/InputField';
import "../css/InputField.css";

const TaggedInputField=(props) => {
    return (
        <div class="signUp">
            <div class="tag">
                <label >{props.label}</label>
            </div>
            <div class="row">
                <InputField
                    inputType={props.inputType} 
                    holder={props.holder}/>
            </div>
        </div>
    );
}

export default TaggedInputField;