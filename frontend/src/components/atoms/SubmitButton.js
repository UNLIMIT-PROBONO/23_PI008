import React from 'react';
import '../css/SubmitButton.css';

const SubmitButton = (props) => {
    return (
        <div>
            <button
                class="btn-outline-primary"
                type='submit'
                onClick={props.onClick}>
                <span>{props.label}</span>
            </button>
        </div>
    );
}

export default SubmitButton;