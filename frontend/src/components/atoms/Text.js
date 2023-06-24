import React from 'react';
import '../css/Text.css'

export function Text(props) {
    return (
        <div>
            {props.label}
        </div>
    )
}

export function HrefText(props) {
    return (
        <div class="text-href">
            <a href="#"> {props.label} </a>
        </div>
    )   
}