import React, { useState } from 'react';
import '../css/InputField.css'

const IdInputField = (props) => {

    return (
        <div style={{margin: "10px"}}>
            <span>{props.label}</span>
            <div>
                <input 
                class="inputField"
                style={{
                    width: "220px",
                    height: "40px",
                    marginRight: "20px"
                }}
                onChange={(e)=>{setValue(e.target.value)}}
                />
                <button
                    class="btn-outline-primary"
                    style={{
                        width:"90px",
                        height: "45px",
                        fontSize: "14px",
                    }}
                    onClick={clickEvent}
                    >
                    <span>중복 확인</span>
                </button>
            </div>
        </div>
    )
}

export default IdInputField;